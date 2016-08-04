package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class MainClass extends JComponent implements MouseMotionListener,MouseListener{
	
	private Dimension preferredDimension;
	
	protected GraphicsHandler graphicsHandler;
	
	protected static boolean shouldChangePreferredSize = false;
	protected static boolean isCreatioMode = true;
	protected static boolean hasGoldenDragonBeenPlaced  = false;
	protected static boolean hasSilverDragonBeenPlaced = false;
	
	protected static JFrame frame;
	
	public MainClass(){
		addMouseListener(this);
		addMouseMotionListener(this);
		graphicsHandler = new GraphicsHandler();
		preferredDimension = new Dimension();
		
		graphicsHandler.resetPreferredDimension(preferredDimension);
		setPreferredSize(preferredDimension);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setPaint(Color.BLUE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		graphicsHandler.resetGameMenuBar();
		graphicsHandler.paintGameElements(g2d);
		if(shouldChangePreferredSize){
			graphicsHandler.resetPreferredDimension(preferredDimension);
			setPreferredSize(preferredDimension);
			revalidate();
			shouldChangePreferredSize = false;
		}
	}

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame("Cute Planet Editor");
		frame.setBackground(Color.blue);
		MainClass mc = new MainClass();
		frame.setJMenuBar(new GameMenuBar(mc.graphicsHandler));
		JScrollPane scrollpane= new JScrollPane(mc,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(scrollpane);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void onMouseMovedOrDragged(MouseEvent e){
		BlockStack.resetSelectorPoint(graphicsHandler.blockStackGraph,graphicsHandler.levelDimension,graphicsHandler.selectorPoint,graphicsHandler.selectorLevelPoint, e);
		repaint();
	}
	
	private void onMousePressedOrDragged(MouseEvent e){
		char charCode = graphicsHandler.getCurrentSelectedBlockCharCode();
		if(charCode != ' ' && !SwingUtilities.isRightMouseButton(e)){
			if(graphicsHandler.blockStackGraph[graphicsHandler.selectorLevelPoint.x][graphicsHandler.selectorLevelPoint.y].addBlockWithCharCode(charCode)){
				graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y - BlockStack.heightShift;
				if(Character.isDigit(charCode)){
					if(Integer.parseInt(""+charCode)<5)
						hasGoldenDragonBeenPlaced = true;
					else
						hasSilverDragonBeenPlaced = true;
				}
			}
			if(Character.isUpperCase(charCode))
				graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y - BlockStack.heightShift;
		}
		else{
			char removedCharCode = graphicsHandler.blockStackGraph[graphicsHandler.selectorLevelPoint.x][graphicsHandler.selectorLevelPoint.y].getBlockStackTopChar();
			if(Character.isDigit(removedCharCode)){
				System.out.println("Yes");
				if(Integer.parseInt(""+removedCharCode)<5)
					hasGoldenDragonBeenPlaced = false;
				else
					hasSilverDragonBeenPlaced = false;
			}
			if(graphicsHandler.blockStackGraph[graphicsHandler.selectorLevelPoint.x][graphicsHandler.selectorLevelPoint.y].removeTopBlock())
				graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y + BlockStack.heightShift;
			if(Character.isUpperCase(removedCharCode))
				graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y + BlockStack.heightShift;
		}
		while(graphicsHandler.shouldIncreaseSpan()){
			GraphicsHandler.shiftPoint.y = GraphicsHandler.shiftPoint.y + BlockStack.heightShift;
			graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y + BlockStack.heightShift;
			graphicsHandler.changeAllBlockSpan(true);
			graphicsHandler.currentBlockLevel++;
			shouldChangePreferredSize = true;
		}
		while(graphicsHandler.shouldDecreseSpan()){
			GraphicsHandler.shiftPoint.y = GraphicsHandler.shiftPoint.y - BlockStack.heightShift;
			graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y - BlockStack.heightShift;
			graphicsHandler.changeAllBlockSpan(false);
			graphicsHandler.currentBlockLevel--;
			shouldChangePreferredSize = true;
		}
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		onMouseMovedOrDragged(e);
		onMousePressedOrDragged(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		onMouseMovedOrDragged(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		onMousePressedOrDragged(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		graphicsHandler.blockStackGraph[graphicsHandler.selectorLevelPoint.x][graphicsHandler.selectorLevelPoint.y].setIsReadyToBeModified(true);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

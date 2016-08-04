package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar implements ActionListener{
	
	private GraphicsHandler graphicsHandler;
	
	protected static JMenuItem removeRightGrid = new JMenuItem("Remove Right Grid");
	protected static JMenuItem removeBottomGrid = new JMenuItem("Remove Bottom Grid");
	protected static JMenuItem removeLeftGrid = new JMenuItem("Remove Left Grid");
	protected static JMenuItem removeTopGrid = new JMenuItem("Remove Top Grid");
	
	JMenuItem shadowSwitch = (GraphicsHandler.shadowsEnabled)?new JMenuItem("Disable Shadows"):new JMenuItem("Enable Shadows");
	
	public GameMenuBar(GraphicsHandler graphicsHandler){
		this.graphicsHandler = graphicsHandler;
		
		JMenu fileMenu = new JMenu("File");
		JMenu blockMenu = new JMenu("Block");
		JMenu dragonMenu = new JMenu("Dragon");
		JMenu eraserMenu = new JMenu("Eraser");
		JMenu gridMenu = new JMenu("Grid");
		JMenu shadowMenu = new JMenu("Shadow");
		
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem plainBlock = new JMenuItem("Plain Block");
		JMenuItem brownBlock = new JMenuItem("Brown Block");
		JMenuItem dirtBlock = new JMenuItem("Dirt Block");
		JMenuItem waterBlock = new JMenuItem("Water Block");
		JMenuItem grassBlock = new JMenuItem("Grass Block");
		JMenuItem stoneBlock = new JMenuItem("Stone Block");
		JMenuItem stoneTallBlock = new JMenuItem("Stone Tall Block");
		JMenuItem woodBlock = new JMenuItem("Wood Block");
		JMenuItem wallBlock = new JMenuItem("Wall Block");
		JMenuItem wallTallBlock = new JMenuItem("Wall Tall Block");
		JMenuItem windowBlock = new JMenuItem("Window");
		JMenuItem doorClosedBlock = new JMenuItem("Door(Closed)");
		JMenuItem doorOpenBlock = new JMenuItem("Door(Open)");
		JMenuItem roofEastBlock = new JMenuItem("Roof East");
		JMenuItem roofWestBlock = new JMenuItem("Roof West");
		JMenuItem rampEastBlock = new JMenuItem("Ramp East");
		JMenuItem rampNorthBlock = new JMenuItem("Ramp North");
		JMenuItem rampSouthBlock = new JMenuItem("Ramp South");
		JMenuItem rampWestBlock = new JMenuItem("Ramp West");
		JMenuItem keyBlock = new JMenuItem("Key");
		JMenuItem chestBlock = new JMenuItem("Chest");
		JMenuItem rockBlock = new JMenuItem("Rock");
		JMenuItem treeShortBlock = new JMenuItem("Tree(Short)");
		JMenuItem treeUglyBlock = new JMenuItem("Tree(Ugly)");
		JMenuItem treeTallBlock = new JMenuItem("Tree(Tall)");
		JMenuItem dragon1 = new JMenuItem("Place Golden Dragon (Front)");
		JMenuItem dragon2 = new JMenuItem("Place Golden Dragon (Back)");
		JMenuItem dragon3 = new JMenuItem("Place Golden Dragon (Left)");
		JMenuItem dragon4 = new JMenuItem("Place Golden Dragon (Right)");
		JMenuItem dragon5 = new JMenuItem("Place Silver Dragon (Front)");
		JMenuItem dragon6 = new JMenuItem("Place Silver Dragon (Back)");
		JMenuItem dragon7 = new JMenuItem("Place Silver Dragon (Left)");
		JMenuItem dragon8 = new JMenuItem("Place Silver Dragon (Right)");
		JMenuItem eraser = new JMenuItem("Eraser");
		JMenuItem rightGrid = new JMenuItem("Add Right Grid");
		JMenuItem bottomGrid = new JMenuItem("Add Bottom Grid");
		JMenuItem leftGrid = new JMenuItem("Add Left Grid");
		JMenuItem topGird = new JMenuItem("Add Top Gird");
		
		save.setActionCommand("Save");
		load.setActionCommand("Load");
		plainBlock.setActionCommand("Plain Block");
		brownBlock.setActionCommand("Brown Block");
		dirtBlock.setActionCommand("Dirt Block");
		waterBlock.setActionCommand("Water Block");
		grassBlock.setActionCommand("Grass Block");
		stoneBlock.setActionCommand("Stone Block");
		stoneTallBlock.setActionCommand("Stone Tall Block");
		woodBlock.setActionCommand("Wood Block");
		wallBlock.setActionCommand("Wall Block");
		wallTallBlock.setActionCommand("Wall Tall Block");
		windowBlock.setActionCommand("Window");
		doorClosedBlock.setActionCommand("Door(Closed)");
		doorOpenBlock.setActionCommand("Door(Open)");
		roofEastBlock.setActionCommand("Roof East");
		roofWestBlock.setActionCommand("Roof West");
		rampEastBlock.setActionCommand("Ramp East");
		rampNorthBlock.setActionCommand("Ramp North");
		rampSouthBlock.setActionCommand("Ramp South");
		rampWestBlock.setActionCommand("Ramp West");
		keyBlock.setActionCommand("Key");
		chestBlock.setActionCommand("Chest");
		rockBlock.setActionCommand("Rock");
		treeShortBlock.setActionCommand("Tree(Short)");
		treeUglyBlock.setActionCommand("Tree(Ugly)");
		treeTallBlock.setActionCommand("Tree(Tall)");
		dragon1.setActionCommand("Place Golden Dragon (Front)");
		dragon2.setActionCommand("Place Golden Dragon (Back)");
		dragon3.setActionCommand("Place Golden Dragon (Left)");
		dragon4.setActionCommand("Place Golden Dragon (Right)");
		dragon5.setActionCommand("Place Silver Dragon (Front)");
		dragon6.setActionCommand("Place Silver Dragon (Back)");
		dragon7.setActionCommand("Place Silver Dragon (Left)");
		dragon8.setActionCommand("Place Silver Dragon (Right)");
		eraser.setActionCommand("Eraser");
		rightGrid.setActionCommand("Add Right Grid");
		bottomGrid.setActionCommand("Add Bottom Grid");
		leftGrid.setActionCommand("Add Left Grid");
		topGird.setActionCommand("Add Up Grid");
		removeRightGrid.setActionCommand("Remove Right Grid");
		removeBottomGrid.setActionCommand("Remove Bottom Grid");
		removeLeftGrid.setActionCommand("Remove Left Grid");
		removeTopGrid.setActionCommand("Remove Top Grid");
		shadowSwitch.setActionCommand("Change Shadow Config");
		
		save.addActionListener(this);
		load.addActionListener(this);
		plainBlock.addActionListener(this);
		brownBlock.addActionListener(this);
		dirtBlock.addActionListener(this);
		waterBlock.addActionListener(this);
		grassBlock.addActionListener(this);
		stoneBlock.addActionListener(this);
		stoneTallBlock.addActionListener(this);
		woodBlock.addActionListener(this);
		wallBlock.addActionListener(this);
		wallTallBlock.addActionListener(this);
		windowBlock.addActionListener(this);
		doorClosedBlock.addActionListener(this);
		doorOpenBlock.addActionListener(this);
		roofEastBlock.addActionListener(this);
		roofWestBlock.addActionListener(this);
		rampEastBlock.addActionListener(this);
		rampNorthBlock.addActionListener(this);
		rampSouthBlock.addActionListener(this);
		rampWestBlock.addActionListener(this);
		keyBlock.addActionListener(this);
		chestBlock.addActionListener(this);
		rockBlock.addActionListener(this);
		treeShortBlock.addActionListener(this);
		treeUglyBlock.addActionListener(this);
		treeTallBlock.addActionListener(this);
		dragon1.addActionListener(this);
		dragon2.addActionListener(this);
		dragon3.addActionListener(this);
		dragon4.addActionListener(this);
		dragon5.addActionListener(this);
		dragon6.addActionListener(this);
		dragon7.addActionListener(this);
		dragon8.addActionListener(this);
		eraser.addActionListener(this);
		rightGrid.addActionListener(this);
		bottomGrid.addActionListener(this);
		leftGrid.addActionListener(this);
		topGird.addActionListener(this);
		removeRightGrid.addActionListener(this);
		removeBottomGrid.addActionListener(this);
		removeLeftGrid.addActionListener(this);
		removeTopGrid.addActionListener(this);
		shadowSwitch.addActionListener(this);
		
		fileMenu.add(save);
		fileMenu.add(load);
		
		blockMenu.add(plainBlock);
		blockMenu.add(brownBlock);
		blockMenu.add(dirtBlock);
		blockMenu.add(waterBlock);
		blockMenu.add(grassBlock);
		blockMenu.add(stoneBlock);
		blockMenu.add(stoneTallBlock);
		blockMenu.add(woodBlock);
		blockMenu.add(wallBlock);
		blockMenu.add(wallTallBlock);
		blockMenu.add(windowBlock);
		blockMenu.add(doorClosedBlock);
		blockMenu.add(doorOpenBlock);
		blockMenu.add(roofEastBlock);
		blockMenu.add(roofWestBlock);
		blockMenu.add(rampEastBlock);
		blockMenu.add(rampNorthBlock);
		blockMenu.add(rampSouthBlock);
		blockMenu.add(rampWestBlock);
		blockMenu.add(keyBlock);
		blockMenu.add(chestBlock);
		blockMenu.add(rockBlock);
		blockMenu.add(treeShortBlock);
		blockMenu.add(treeUglyBlock);
		blockMenu.add(treeTallBlock);
		
		dragonMenu.add(dragon1);
		dragonMenu.add(dragon2);
		dragonMenu.add(dragon3);
		dragonMenu.add(dragon4);
		dragonMenu.add(dragon5);
		dragonMenu.add(dragon6);
		dragonMenu.add(dragon7);
		dragonMenu.add(dragon8);
		
		eraserMenu.add(eraser);
		
		gridMenu.add(rightGrid);
		gridMenu.add(bottomGrid);
		gridMenu.add(leftGrid);
		gridMenu.add(topGird);
		gridMenu.add(removeRightGrid);
		gridMenu.add(removeBottomGrid);
		gridMenu.add(removeLeftGrid);
		gridMenu.add(removeTopGrid);
		
		shadowMenu.add(shadowSwitch);
		
		add(fileMenu);
		add(blockMenu);
		add(dragonMenu);
		add(eraserMenu);
		add(gridMenu);
		add(shadowMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Save")){
			try{
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Save File");
				if(chooser.showSaveDialog(MainClass.frame) == JFileChooser.APPROVE_OPTION){
					File fileToSave = chooser.getSelectedFile();
					FileWriter fw = new FileWriter(fileToSave);
					BlockStack[][] blockStackGraph = graphicsHandler.blockStackGraph;
					Dimension levelDimension = graphicsHandler.levelDimension;
					String dataString = "";
					for(int i=0;i<levelDimension.height;i++){
						for(int j=0;j<levelDimension.width;j++){
							dataString = dataString + "[";
							for(int k=0;k<blockStackGraph[i][j].getBlockStackSize();k++){
								dataString = dataString + blockStackGraph[i][j].getBlockStackCharCode(k);
								if(k==blockStackGraph[i][j].getBlockStackSize()-1)
									dataString = dataString + "]";
							}
							if(blockStackGraph[i][j].getBlockStackSize()==0)
								dataString=dataString+"]";
						}
						if(i!=levelDimension.height-1)
							dataString = dataString +"\n";
					}
					fw.write(dataString);
					if(!fileToSave.exists())
						fileToSave.createNewFile();
					fw.flush();
					fw.close();
				}
			}catch(IOException ex){}
		}
		else if(e.getActionCommand().equals("Load")){
			JFileChooser chooser = new JFileChooser("Load File");
			if(chooser.showOpenDialog(MainClass.frame) == JFileChooser.APPROVE_OPTION){
				File selectedFile = chooser.getSelectedFile();
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile)));
					MainClass.hasGoldenDragonBeenPlaced = false;
					MainClass.hasSilverDragonBeenPlaced = false;
					String line = null;
					int width = 0;
					int height = 0;
					String dataString ="";
					boolean firstLine = true;
					while((line=br.readLine())!=null){
						if(!dataString.equals(""))
							dataString = dataString +"\n";
						if(firstLine){
							for(char c:line.toCharArray()){
								if(c=='[')
									width++;
							}
							firstLine = false;
						}
						dataString = dataString + line;
						height++;
					}
					br.close();
					graphicsHandler.levelDimension.height = height;
					graphicsHandler.levelDimension.width = width;
					graphicsHandler.blockStackGraph = new BlockStack[height][width];
					int i = 0;
					int j = -1;
					for(char character: dataString.toCharArray()){
						if(character == '['){
							j = j + 1;
							graphicsHandler.blockStackGraph[i][j] = new BlockStack(i, j);
						}
						else if(character != ']' && character != '\n'){
							graphicsHandler.blockStackGraph[i][j].addBlockWithCharCode(character);
							graphicsHandler.blockStackGraph[i][j].setIsReadyToBeModified(true);
							if(Character.isDigit(character)){
								if(Integer.parseInt(""+character)<5)
									MainClass.hasGoldenDragonBeenPlaced = true;
								else
									MainClass.hasSilverDragonBeenPlaced = true;
							}
						}
						else if(character == '\n'){
							i = i + 1;
							j = -1;
						}
							
					}
					while(graphicsHandler.shouldIncreaseSpan()){
						GraphicsHandler.shiftPoint.y = GraphicsHandler.shiftPoint.y + BlockStack.heightShift;
						graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y + BlockStack.heightShift;
						graphicsHandler.changeAllBlockSpan(true);
						graphicsHandler.currentBlockLevel++;
						MainClass.shouldChangePreferredSize = true;
					}
					while(graphicsHandler.shouldDecreseSpan()){
						GraphicsHandler.shiftPoint.y = GraphicsHandler.shiftPoint.y - BlockStack.heightShift;
						graphicsHandler.selectorPoint.y = graphicsHandler.selectorPoint.y - BlockStack.heightShift;
						graphicsHandler.changeAllBlockSpan(false);
						graphicsHandler.currentBlockLevel--;
						MainClass.shouldChangePreferredSize = true;
					}
				}catch(IOException ex){}
			}
		}
		else if(e.getActionCommand().equals("Plain Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.plainBlockImage);
		else if(e.getActionCommand().equals("Brown Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.brownBlockImage);
		else if(e.getActionCommand().equals("Dirt Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dirtBlockImage);
		else if(e.getActionCommand().equals("Water Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.waterBlockImage);
		else if(e.getActionCommand().equals("Grass Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.grassBlockImage);
		else if(e.getActionCommand().equals("Stone Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.stoneBlockImage);
		else if(e.getActionCommand().equals("Stone Tall Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.stoneTallBlockImage);
		else if(e.getActionCommand().equals("Wood Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.woodBlockImage);
		else if(e.getActionCommand().equals("Wall Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.wallBlockImage);
		else if(e.getActionCommand().equals("Wall Tall Block"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.wallTallBlockImage);
		else if(e.getActionCommand().equals("Window"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.windowImage);
		else if(e.getActionCommand().equals("Door(Closed)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.doorClosedImage);
		else if(e.getActionCommand().equals("Door(Open)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.doorOpenImage);
		else if(e.getActionCommand().equals("Roof East"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.roofEastImage);
		else if(e.getActionCommand().equals("Roof West"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.roofWestImage);
		else if(e.getActionCommand().equals("Ramp East"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.rampEastImage);
		else if(e.getActionCommand().equals("Ramp North"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.rampNorthImage);
		else if(e.getActionCommand().equals("Ramp South"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.rampSouthImage);
		else if(e.getActionCommand().equals("Ramp West"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.rampWestImage);
		else if(e.getActionCommand().equals("Key"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.keyImage);
		else if(e.getActionCommand().equals("Chest"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.chestImage);
		else if(e.getActionCommand().equals("Rock"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.rockImage);
		else if(e.getActionCommand().equals("Tree(Short)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.treeShortImage);
		else if(e.getActionCommand().equals("Tree(Ugly)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.treeUglyImage);
		else if(e.getActionCommand().equals("Tree(Tall)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.treeTallImage);
		else if(e.getActionCommand().equals("Place Golden Dragon (Front)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages0[0]);
		else if(e.getActionCommand().equals("Place Golden Dragon (Back)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages0[12]);
		else if(e.getActionCommand().equals("Place Golden Dragon (Left)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages0[4]);
		else if(e.getActionCommand().equals("Place Golden Dragon (Right)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages0[8]);
		else if(e.getActionCommand().equals("Place Silver Dragon (Front)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages1[0]);
		else if(e.getActionCommand().equals("Place Silver Dragon (Back)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages1[12]);
		else if(e.getActionCommand().equals("Place Silver Dragon (Left)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages1[4]);
		else if(e.getActionCommand().equals("Place Silver Dragon (Right)"))
			GraphicsHandler.setCurrentSelectedBlockImage(GraphicsHandler.dragonImages1[8]);
		else if(e.getActionCommand().equals("Eraser"))
			GraphicsHandler.setCurrentSelectedBlockImage(null);
		else if(e.getActionCommand().equals("Add Right Grid"))
			GraphicsHandler.gridChangeCode = 1;
		else if(e.getActionCommand().equals("Add Bottom Grid"))
			GraphicsHandler.gridChangeCode = 2;
		else if(e.getActionCommand().equals("Add Left Grid"))
			GraphicsHandler.gridChangeCode = 3;
		if(e.getActionCommand().equals("Add Up Grid"))
			GraphicsHandler.gridChangeCode = 4;
		else if(e.getActionCommand().equals("Remove Right Grid"))
			GraphicsHandler.gridChangeCode = 5;
		else if(e.getActionCommand().equals("Remove Bottom Grid"))
			GraphicsHandler.gridChangeCode = 6;
		else if(e.getActionCommand().equals("Remove Left Grid"))
			GraphicsHandler.gridChangeCode = 7;
		else if(e.getActionCommand().equals("Remove Top Grid"))
			GraphicsHandler.gridChangeCode = 8;
		else if(e.getActionCommand().equals("Change Shadow Config")){
			GraphicsHandler.shadowsEnabled = !GraphicsHandler.shadowsEnabled;
			shadowSwitch.setText((GraphicsHandler.shadowsEnabled)?"Disable Shadows":"Enable Shadows");
		}
	}
	
}

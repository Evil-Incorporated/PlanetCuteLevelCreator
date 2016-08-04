package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicsHandler {
	
	protected Image selectorImage;
	
	protected static Image plainBlockImage;
	protected static Image brownBlockImage;
	protected static Image dirtBlockImage;
	protected static Image grassBlockImage;
	protected static Image waterBlockImage;
	protected static Image stoneBlockImage;
	protected static Image stoneTallBlockImage;
	protected static Image woodBlockImage;
	protected static Image wallBlockImage;
	protected static Image wallTallBlockImage;
	protected static Image windowImage;
	protected static Image doorClosedImage;
	protected static Image doorOpenImage;
	protected static Image roofWestImage;
	protected static Image roofEastImage;
	protected static Image rampEastImage;
	protected static Image rampNorthImage;
	protected static Image rampSouthImage;
	protected static Image rampWestImage;
	protected static Image keyImage;
	protected static Image chestImage;
	protected static Image rockImage;
	protected static Image treeShortImage;
	protected static Image treeUglyImage;
	protected static Image treeTallImage;
	
	protected static Image[] dragonImages0;
	protected static Image[] dragonImages1;
	
	private static Image currentSelectedBlockImage;
	
	private Image shadowEastImage;
	private Image shadowNorthEastImage;
	private Image shadowNorthWestImage;
	private Image shadowNorthImage;
	private Image shadowSideWestImage;
	private Image shadowSouthEastImage;
	private Image shadowSouthWestImage;
	private Image shadowSouthImage;
	private Image shadowWestImage;
	
	protected Point selectorPoint;
	protected Point selectorLevelPoint;
	
	protected Point dragonPoint = new Point(0,0);
	
	protected static Point shiftPoint = new Point(100,100);
	
	protected int currentBlockLevel = 0;
	
	protected Dimension levelDimension = new Dimension(7,5);
	
	protected BlockStack[][] blockStackGraph;
	
	protected static boolean shadowsEnabled = true;
	
	protected static int gridChangeCode = -1;
	
	public  GraphicsHandler(){
		try {
			selectorImage = ImageIO.read(GraphicsHandler.class.getResource("/Selector.png"));
			plainBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Plain Block.png"));
			brownBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Brown Block.png"));
			dirtBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Dirt Block.png"));
			grassBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Grass Block.png"));
			waterBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Water Block.png"));
			stoneBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Stone Block.png"));
			stoneTallBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Stone Block Tall.png"));
			woodBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Wood Block.png"));
			wallBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Wall Block.png"));
			wallTallBlockImage = ImageIO.read(GraphicsHandler.class.getResource("/Wall Block Tall.png"));
			windowImage = ImageIO.read(GraphicsHandler.class.getResource("/Window Tall.png"));
			doorClosedImage = ImageIO.read(GraphicsHandler.class.getResource("/Door Tall Closed.png"));
			doorOpenImage = ImageIO.read(GraphicsHandler.class.getResource("/Door Tall Open.png"));
			roofEastImage = ImageIO.read(GraphicsHandler.class.getResource("/Roof East.png"));
			roofWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Roof West.png"));
			rampEastImage = ImageIO.read(GraphicsHandler.class.getResource("/Ramp East.png"));
			rampNorthImage = ImageIO.read(GraphicsHandler.class.getResource("/Ramp North.png"));
			rampSouthImage = ImageIO.read(GraphicsHandler.class.getResource("/Ramp South.png"));
			rampWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Ramp West.png"));
			keyImage = ImageIO.read(GraphicsHandler.class.getResource("/Key.png"));
			chestImage = ImageIO.read(GraphicsHandler.class.getResource("/Chest Closed.png"));
			rockImage = ImageIO.read(GraphicsHandler.class.getResource("/Rock.png"));
			treeShortImage = ImageIO.read(GraphicsHandler.class.getResource("/Tree Short.png"));
			treeUglyImage = ImageIO.read(GraphicsHandler.class.getResource("/Tree Ugly.png"));
			treeTallImage = ImageIO.read(GraphicsHandler.class.getResource("/Tree Tall.png"));
			dragonImages0 = SpriteSheet.getSpriteImages("bahamut.png", 4, 4,selectorImage.getHeight(null),true);
			dragonImages1 = SpriteSheet.getSpriteImages("bahamut.png", 4, 4,selectorImage.getHeight(null),false);
			shadowEastImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow East.png"));
			shadowNorthEastImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow North East.png"));
			shadowNorthWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow North West.png"));
			shadowNorthImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow North.png"));
			shadowSideWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow Side West.png"));
			shadowSouthEastImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow South East.png"));
			shadowSouthWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow South West.png"));
			shadowSouthImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow South.png"));
			shadowWestImage = ImageIO.read(GraphicsHandler.class.getResource("/Shadow West.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentSelectedBlockImage = plainBlockImage;
		selectorPoint = new Point(0,0);
		selectorLevelPoint = new Point(0,0);
		BlockStack.setBlockImageDimension(new Dimension(selectorImage.getWidth(null),selectorImage.getHeight(null)));
		blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width];
		for(int i=0;i<levelDimension.height;i++){
			for(int j=0;j<levelDimension.width;j++)
				blockStackGraph[i][j] = new BlockStack(i,j);
		}
	}
	protected Dimension getLevelDimension(){
		return levelDimension;
	}
	protected void resetGameMenuBar(){
		if(levelDimension.width == 1){
			GameMenuBar.removeLeftGrid.setEnabled(false);
			GameMenuBar.removeRightGrid.setEnabled(false);
		}
		else{
			GameMenuBar.removeLeftGrid.setEnabled(true);
			GameMenuBar.removeRightGrid.setEnabled(true);
		}
		if(levelDimension.height == 1){
			GameMenuBar.removeTopGrid.setEnabled(false);
			GameMenuBar.removeBottomGrid.setEnabled(false);
		}
		else{
			GameMenuBar.removeTopGrid.setEnabled(true);
			GameMenuBar.removeBottomGrid.setEnabled(true);
		}
	}
	protected void resetPreferredDimension(Dimension preferredDimension){
		Dimension blockDimension = BlockStack.getBlockBaseDimension();
		preferredDimension.width = shiftPoint.x + (levelDimension.width+1)*blockDimension.width;
		preferredDimension.height = shiftPoint.y + (levelDimension.height+1)*blockDimension.height;
	}
	protected void paintGameElements(Graphics2D g2d){
		if(gridChangeCode!=-1)
			changeGrid();
		g2d.setPaint(Color.black);
		drawGameBase(g2d);
	}
	private void drawGameBase(Graphics2D g2d, Void ...extras){
		for(int i = 0;i<levelDimension.height;i++){
			for(int j = 0;j<levelDimension.width;j++){
				if(blockStackGraph[i][j]==null)
					blockStackGraph[i][j] = new BlockStack(i, j);
				if(blockStackGraph[i][j].isBlockStackEmpty())
					g2d.draw(blockStackGraph[i][j].getPositionRectangle());
				else{
					int height = 0;
					boolean shouldDrawTallBlocks = false;
					for(int k=0;k<blockStackGraph[i][j].getBlockStackSize();k++){
						char charCode = blockStackGraph[i][j].getBlockStackCharCode(k);
						if(shouldDrawBlock(i, j, k)){
							if(!Character.isUpperCase(charCode) || shouldDrawTallBlocks){
								Point blockBasePoint = blockStackGraph[i][j].blockBasePoint;
								g2d.drawImage(getBlockImage(blockStackGraph[i][j], k),blockBasePoint.x,blockBasePoint.y - height,null);
								if(shadowsEnabled && !shouldDrawTallBlocks)
									ShadowLayerer.addShadow(g2d, blockBasePoint.x, blockBasePoint.y - height, blockStackGraph, levelDimension, i, j, k, shadowEastImage, shadowNorthEastImage, shadowNorthWestImage, shadowNorthImage, shadowSideWestImage, shadowSouthEastImage, shadowSouthWestImage, shadowSouthImage, shadowWestImage);
								else if(shadowsEnabled && shouldDrawTallBlocks)
									ShadowLayerer.addShadow(g2d, blockBasePoint.x, blockBasePoint.y - height - BlockStack.heightShift, blockStackGraph, levelDimension, i, j, k, shadowEastImage, shadowNorthEastImage, shadowNorthWestImage, shadowNorthImage, shadowSideWestImage, shadowSouthEastImage, shadowSouthWestImage, shadowSouthImage, shadowWestImage);
							}
						}
						if(!Character.isUpperCase(charCode) || shouldDrawTallBlocks)
							height = blockStackGraph[i][j].getNextBlockHeight(k, height);
						if(Character.isUpperCase(charCode) && !shouldDrawTallBlocks)
							shouldDrawTallBlocks = true;
						else if(Character.isUpperCase(charCode) && shouldDrawTallBlocks)
							shouldDrawTallBlocks = false;
					}
				}
			}
			drawSelector(g2d, i);
		}
	}
	private void drawSelector(Graphics2D g2d, int i){
		if(i==selectorLevelPoint.x){
			g2d.drawImage(selectorImage, selectorPoint.x,selectorPoint.y,null);
			if(currentSelectedBlockImage!=null)
				g2d.drawImage(currentSelectedBlockImage,selectorPoint.x, selectorPoint.y - 3*BlockStack.heightShift,null);
		}
	}
	protected boolean shouldDecreseSpan(){
		for(int i=0;i<levelDimension.height;i++){
			for(int j=0;j<levelDimension.width;j++){
				if(blockStackGraph[i][j].getBlockStackLevel(i)>=currentBlockLevel)
					return false;
			}
		}
		return true;
	}
	
	private boolean shouldDrawBlock(int i,int j,int k){
		try{
			if(blockStackGraph[i+1][j].isBlockAvailable(k) && blockStackGraph[i][j].isBlockAvailable(k+1) && blockStackGraph[i+1][j].isBlockAvailable(k+1))
				return false;
		}catch(Exception e){}
		
		return true;
	}
	
	protected boolean shouldIncreaseSpan(){
		for(int i=0;i<levelDimension.height;i++){
			for(int j=0;j<levelDimension.width;j++){
				if(blockStackGraph[i][j].getBlockStackLevel(i)>currentBlockLevel)
					return true;
			}
		}
		return false;
	}
	
	protected void changeAllBlockSpan(boolean increase){
		for(int i=0;i<levelDimension.height;i++){
			for(int j=0;j<levelDimension.width;j++){
				if(increase)
					blockStackGraph[i][j].increaseSpan();
				else
					blockStackGraph[i][j].decreaseSpan();
			}
		}
	}
	
	private void changeGrid(){
		BlockStack[][] tempBlockStack = new BlockStack[levelDimension.height][levelDimension.width];
		copyBlockStack(blockStackGraph,tempBlockStack,0);
		switch(gridChangeCode){
		case 1:
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width+1];
			copyBlockStack(tempBlockStack,blockStackGraph,0);
			levelDimension.width = levelDimension.width + 1;
			break;
		case 2:
			blockStackGraph = new BlockStack[levelDimension.height+1][levelDimension.width];
			copyBlockStack(tempBlockStack,blockStackGraph,0);
			levelDimension.height = levelDimension.height + 1;
			break;
		case 3:
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width+1];
			copyBlockStack(tempBlockStack,blockStackGraph,1);
			levelDimension.width = levelDimension.width + 1;
			break;
		case 4:
			blockStackGraph = new BlockStack[levelDimension.height+1][levelDimension.width];
			copyBlockStack(tempBlockStack,blockStackGraph,2);
			levelDimension.height = levelDimension.height + 1;
			break;
		case 5:
			levelDimension.width = levelDimension.width - 1;
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width];
			copyBlockStack(tempBlockStack, blockStackGraph, 0);
			break;
		case 6:
			levelDimension.height = levelDimension.height - 1;
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width];
			copyBlockStack(tempBlockStack, blockStackGraph, 0);
			break;
		case 7:
			levelDimension.width = levelDimension.width - 1;
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width];
			copyBlockStack(tempBlockStack, blockStackGraph, 3);
			break;
		case 8:
			levelDimension.height = levelDimension.height - 1;
			blockStackGraph = new BlockStack[levelDimension.height][levelDimension.width];
			copyBlockStack(tempBlockStack, blockStackGraph, 4);
			break;
		}
		MainClass.shouldChangePreferredSize = true;
		gridChangeCode = -1;
		resetGameMenuBar();
	}
	private void copyBlockStack(BlockStack[][] original,BlockStack[][] copy,int mode){
		for(int i=0;i<levelDimension.height;i++){
			for(int j=0;j<levelDimension.width;j++){
				if(mode==0)
					copy[i][j] = original[i][j];
				else if(mode == 1){
					copy[i][j+1] = original[i][j];
					copy[i][j+1].shiftHorizontally(true);
				}
				else if(mode == 2){
					copy[i+1][j] = original[i][j];
					copy[i+1][j].shiftVerically(true);
				}
				else if(mode == 3){
					copy[i][j] = original[i][j+1];
					copy[i][j].shiftHorizontally(false);
				}
				else if(mode == 4){
					copy[i][j] = original[i+1][j];
					copy[i][j].shiftVerically(false);
				}
			}
		}
	}
	private Image getBlockImage(BlockStack bs, int k){
		switch(bs.getBlockStackCharCode(k)){
		case 'p':
			return plainBlockImage;
		case 'b':
			return brownBlockImage;
		case 'd':
			return dirtBlockImage;
		case 'w':
			return waterBlockImage;
		case 'g':
			return grassBlockImage;
		case 's':
			return stoneBlockImage;
		case 'S':
			return stoneTallBlockImage;
		case 'o':
			return woodBlockImage;
		case 'l':
			return wallBlockImage;
		case 'L':
			return wallTallBlockImage;
		case 'h':
			return chestImage;
		case 't':
			return roofWestImage;
		case 'e':
			return roofEastImage;
		case 'a':
			return rampEastImage;
		case 'n':
			return rampNorthImage;
		case 'u':
			return rampSouthImage;
		case 'm':
			return rampWestImage;
		case 'k':
			return keyImage;
		case 'r':
			return rockImage;
		case 'i':
			return treeShortImage;
		case 'y':
			return treeUglyImage;
		case 'I':
			return treeTallImage;
		case 'W':
			return windowImage;
		case 'C':
			return doorClosedImage;
		case 'O':
			return doorOpenImage;
		case '1':
			return dragonImages0[0];
		case '2':
			return dragonImages0[12];
		case '3':
			return dragonImages0[4];
		case '4':
			return dragonImages0[8];
		case '5':
			return dragonImages1[0];
		case '6':
			return dragonImages1[12];
		case '7':
			return dragonImages1[4];
		case '8':
			return dragonImages1[8];
		}
		return null;
	}
	protected char getCurrentSelectedBlockCharCode(){
		if(currentSelectedBlockImage == plainBlockImage)
			return 'p';
		else if(currentSelectedBlockImage == brownBlockImage)
			return 'b';
		else if(currentSelectedBlockImage == dirtBlockImage)
			return 'd';
		else if(currentSelectedBlockImage == waterBlockImage)
			return 'w';
		else if(currentSelectedBlockImage == grassBlockImage)
			return 'g';
		else if(currentSelectedBlockImage == stoneBlockImage)
			return 's';
		else if(currentSelectedBlockImage == stoneTallBlockImage)
			return 'S';
		else if(currentSelectedBlockImage == woodBlockImage)
			return 'o';
		else if(currentSelectedBlockImage == roofWestImage)
			return 't';
		else if(currentSelectedBlockImage == wallBlockImage)
			return 'l';
		else if(currentSelectedBlockImage == wallTallBlockImage)
			return 'L';
		else if(currentSelectedBlockImage == chestImage)
			return 'h';
		else if(currentSelectedBlockImage == roofEastImage)
			return 'e';
		else if(currentSelectedBlockImage == windowImage)
			return 'W';
		else if(currentSelectedBlockImage == rampEastImage)
			return 'a';
		else if(currentSelectedBlockImage == rampNorthImage)
			return 'n';
		else if(currentSelectedBlockImage == rampSouthImage)
			return 'u';
		else if(currentSelectedBlockImage == rampWestImage)
			return 'm';
		else if(currentSelectedBlockImage == keyImage)
			return 'k';
		else if(currentSelectedBlockImage == rockImage)
			return 'r';
		else if(currentSelectedBlockImage == treeShortImage)
			return 'i';
		else if(currentSelectedBlockImage == treeUglyImage)
			return 'y';
		else if(currentSelectedBlockImage == treeTallImage)
			return 'I';
		else if(currentSelectedBlockImage == doorClosedImage)
			return 'C';
		else if(currentSelectedBlockImage == doorOpenImage)
			return 'O';
		else if(currentSelectedBlockImage == dragonImages0[0])
			return '1';
		else if(currentSelectedBlockImage == dragonImages0[12])
			return '2';
		else if(currentSelectedBlockImage == dragonImages0[4])
			return '3';
		else if(currentSelectedBlockImage == dragonImages0[8])
			return '4';
		else if(currentSelectedBlockImage == dragonImages1[0])
			return '5';
		else if(currentSelectedBlockImage == dragonImages1[12])
			return '6';
		else if(currentSelectedBlockImage == dragonImages1[4])
			return '7';
		else if(currentSelectedBlockImage == dragonImages1[8])
			return '8';
		else
			return ' ';
	}
	protected static void setCurrentSelectedBlockImage(Image blockImage){
		currentSelectedBlockImage = blockImage;
	}
}

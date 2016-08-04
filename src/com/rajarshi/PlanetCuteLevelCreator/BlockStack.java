package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class BlockStack{
	
	private List<Character> blockCharArrayList;
	
	protected Point blockBasePoint;
	
	private Rectangle positionRectangle;
	
	private boolean isReadyToBeModified = true;
	private boolean isStackRestricted = false;
	
	private static Dimension blockImageDimension;
	private static Dimension blockBaseDimension;
	
	protected static int heightShift;
	
	public BlockStack(int i, int j){
		blockCharArrayList = new ArrayList<Character>();
		positionRectangle = new Rectangle(GraphicsHandler.shiftPoint.x + j*blockBaseDimension.width,GraphicsHandler.shiftPoint.y + i*blockBaseDimension.height, blockBaseDimension.width, blockBaseDimension.height);
		blockBasePoint = new Point(GraphicsHandler.shiftPoint.x + j*blockBaseDimension.width,GraphicsHandler.shiftPoint.y - (113*blockBaseDimension.height)/100 + i*blockBaseDimension.height);
	}
	
	protected void shiftHorizontally(boolean toLeft){
		if(toLeft){
			positionRectangle.x = positionRectangle.x + blockBaseDimension.width;
			blockBasePoint.x = blockBasePoint.x + blockBaseDimension.width;
		}
		else{
			positionRectangle.x = positionRectangle.x - blockBaseDimension.width;
			blockBasePoint.x = blockBasePoint.x - blockBaseDimension.width;
		}
	}
	
	protected void shiftVerically(boolean toBottom){
		if(toBottom){
			positionRectangle.y = positionRectangle.y + blockBaseDimension.height;
			blockBasePoint.y = blockBasePoint.y + blockBaseDimension.height;
		}
		else{
			positionRectangle.y = positionRectangle.y - blockBaseDimension.height;
			blockBasePoint.y = blockBasePoint.y - blockBaseDimension.height;
		}
	}
	
	protected void increaseSpan(){
		positionRectangle.y = positionRectangle.y + heightShift;
		blockBasePoint.y = blockBasePoint.y + heightShift;
	}
	
	protected void decreaseSpan(){
		positionRectangle.y = positionRectangle.y - heightShift;
		blockBasePoint.y = blockBasePoint.y - heightShift;
	}
	
	protected static void setBlockImageDimension(Dimension blockImageDimension){
		BlockStack.blockImageDimension = blockImageDimension;
		blockBaseDimension = new Dimension();
		blockBaseDimension.width = blockImageDimension.width;
		blockBaseDimension.height = (47*blockImageDimension.height)/100;
		heightShift = blockBaseDimension.height/2;
	}
	
	protected int getNextBlockHeight(int k, int prevHeight){
		char charCode = blockCharArrayList.get(k);
		if(Character.isUpperCase(charCode))
			prevHeight = prevHeight + 2*heightShift;
		else
			prevHeight = prevHeight + heightShift;
		return prevHeight;	
	}
	
	protected int getBlockStackLevel(int i){
		return blockCharArrayList.size() - 2*i;
	}
	
	protected boolean addBlockWithCharCode(char characterCode){
		boolean changeOccured = false;
		if(isReadyToBeModified && !isStackRestricted && isBlockSupported(characterCode)){
			boolean decider = false;
			if(!Character.isDigit(characterCode))
				decider = true;
			else{
				int val = Integer.parseInt(""+characterCode);
				if(val<5 && !MainClass.hasGoldenDragonBeenPlaced)
					decider = true;
				else if(val>=5 && !MainClass.hasSilverDragonBeenPlaced)
					decider = true;
			}
			if(decider){
				blockCharArrayList.add(characterCode);
				if(Character.isUpperCase(characterCode)){
					positionRectangle.y =positionRectangle.y - 2*heightShift;
					blockCharArrayList.add(characterCode);
				}
				else
					positionRectangle.y =positionRectangle.y - heightShift;
				changeOccured = true;
				if(characterCode == 't' || characterCode == 'e' || characterCode == 'a' || characterCode == 'n' || characterCode == 'u' || characterCode == 'm' || characterCode =='k' || characterCode == 'r' || characterCode == 'i' || characterCode=='y' || characterCode == 'I' || characterCode =='h' || characterCode=='1' || characterCode=='2' || characterCode=='3' || characterCode=='4' || characterCode=='5' || characterCode=='6' || characterCode=='7' || characterCode=='8')
					isStackRestricted = true;
			}
		}
		isReadyToBeModified = false;
		return changeOccured;
	}
	
	private boolean isBlockSupported(char blockCharCode){
		if(blockCharArrayList.isEmpty()){
			if(blockCharCode=='C' || blockCharCode =='O' || blockCharCode == 'k' || blockCharCode == 'r' || blockCharCode == 'i' || blockCharCode =='y' || blockCharCode == 'I' || blockCharCode== 'h' || blockCharCode =='1' || blockCharCode=='2' || blockCharCode=='3' || blockCharCode=='4' || blockCharCode =='5' || blockCharCode=='6' || blockCharCode=='7' || blockCharCode=='8')
				return false;
		}
		return true;
	}
	
	protected boolean removeTopBlock(){
		boolean changeOccured = false;
		if(isReadyToBeModified){
			if(!blockCharArrayList.isEmpty()){
				char charCode = blockCharArrayList.get(blockCharArrayList.size()-1);
				blockCharArrayList.remove(blockCharArrayList.size() - 1);
				if(Character.isUpperCase(charCode)){
					positionRectangle.y = positionRectangle.y + 2*heightShift;
					blockCharArrayList.remove(blockCharArrayList.size()-1);
				}
				else
					positionRectangle.y = positionRectangle.y + heightShift;
				isStackRestricted = false;
				changeOccured = true;
			}
		}
		isReadyToBeModified = false;
		return changeOccured;
	}
	
	protected char getBlockStackCharCode(int k){
		return blockCharArrayList.get(k);
	}
	
	protected char getBlockStackTopChar(){
		if(!blockCharArrayList.isEmpty()){
			return blockCharArrayList.get(blockCharArrayList.size()-1);
		}
		return ' ';
	}
	
	protected boolean isBlockStackEmpty(){
		return blockCharArrayList.isEmpty();
	}
	
	protected boolean isBlockAvailable(int k){
		if(blockCharArrayList.size()>k){
			char c = blockCharArrayList.get(k);
			if(c=='a' || c=='n' || c=='u' || c=='m' || c=='k' || c=='r' || c=='i' || c=='y' || c=='I' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8')
				return false;
			else
				return true;
		}
		else
			return false;
	}
	
	protected int getBlockStackSize(){
		return blockCharArrayList.size();
	}
	
	protected static Dimension getBlockImageDimension(){
		return blockImageDimension;
	}
	
	protected static Dimension getBlockBaseDimension(){
		return blockBaseDimension;
	}
	
	protected Rectangle getPositionRectangle(){
		return positionRectangle;
	}
	
	protected void setIsReadyToBeModified(boolean isReadyToBeModified){
		this.isReadyToBeModified = isReadyToBeModified;
	}
	protected static Void resetSelectorPoint(BlockStack[][] blockStackGraph,Dimension levelDimension,Point selectorPoint,Point selectorLevelPoint, MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		for(int i=levelDimension.height-1;i>=0;i--){
			for(int j=levelDimension.width-1;j>=0;j--){
				Rectangle positionRectangle = blockStackGraph[i][j].getPositionRectangle();
				if(positionRectangle.contains(x, y)){
					selectorPoint.x = positionRectangle.x;
					selectorPoint.y = positionRectangle.y - 53*BlockStack.getBlockImageDimension().height/100;
					if(selectorLevelPoint.x!=i || selectorLevelPoint.y!=j)
						blockStackGraph[selectorLevelPoint.x][selectorLevelPoint.y].isReadyToBeModified = true;
					selectorLevelPoint.x = i;
					selectorLevelPoint.y = j;
					return null;
				}
			}
		}
		return null;
	}
}

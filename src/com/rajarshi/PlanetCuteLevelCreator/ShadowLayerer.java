package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public class ShadowLayerer {
	protected static void addShadow(Graphics2D g2d,int x, int y,BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k,Image shadowEastImage,Image shadowNorthEastImage,Image shadowNorthWestImage,Image shadowNorthImage,Image shadowSideWestImage,Image shadowSouthEastImage,Image shadowSouthWestImage,Image shadowSouthImage,Image shadowWestImage){
		char charCode = BlockStackIndex[i][j].getBlockStackCharCode(k);
		if(charCode != 't' && charCode!= 'e' && charCode!= 'C' && charCode!= 'O' && charCode!='a' && charCode!='n' && charCode!='u' && charCode!='m' && charCode!='k' && charCode!='r' && charCode!='i' && charCode!='y' && charCode!='I' && charCode!='H' && charCode!='1' && charCode!='2' && charCode!='3' && charCode!='4' && charCode!='5' && charCode!='6' && charCode!='7' && charCode!='8')
		try{
			if(shouldAddShadowSouthEast(BlockStackIndex,levelDimension,i,j,k))
				g2d.drawImage(shadowSouthEastImage,x,y,null);
			if(shouldAddShadowSouth(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowSouthImage, x,y,null);
			if(shouldAddShadowSouthWest(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowSouthWestImage, x,y,null);
			if(shouldAddShadowEast(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowEastImage, x,y,null);
			if(shouldAddShadowWest(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowWestImage, x,y,null);
			if(shouldAddShadowNorthEast(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowNorthEastImage, x,y,null);
			if(shouldAddShadowNorth(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowNorthImage, x,y,null);
			if(shouldAddShadowNorthWest(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowNorthWestImage, x,y,null);
			if(shouldAddShadowSideWest(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowSideWestImage, x,y,null);
			if(shouldAddTopShadow(BlockStackIndex, levelDimension, i, j, k))
				g2d.drawImage(shadowSouthImage,x,y+BlockStack.heightShift,null);
		}catch(Exception e){}
	}
	private static boolean shouldAddShadowSouthEast(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=levelDimension.width-1 && i!=levelDimension.height-1)
			if(BlockStackIndex[i+1][j+1].isBlockAvailable(k+1) && !BlockStackIndex[i][j+1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowSouth(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(i!=levelDimension.height-1)
			if(BlockStackIndex[i+1][j].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowSouthWest(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=0 && i!=levelDimension.height-1)
			if(BlockStackIndex[i+1][j-1].isBlockAvailable(k+1) && !BlockStackIndex[i][j-1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowEast(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=levelDimension.width-1)
			if(BlockStackIndex[i][j+1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowWest(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=0)
			if(BlockStackIndex[i][j-1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowNorthEast(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=levelDimension.width-1 && i!=0)
			if(BlockStackIndex[i-1][j+1].isBlockAvailable(k+1) && !BlockStackIndex[i-1][j].isBlockAvailable(k+1) && !BlockStackIndex[i][j+1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowNorth(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(i!=0)
			if(BlockStackIndex[i-1][j].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowNorthWest(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=0 && i!=0)
			if(BlockStackIndex[i-1][j-1].isBlockAvailable(k+1) && !BlockStackIndex[i-1][j].isBlockAvailable(k+1) && !BlockStackIndex[i][j-1].isBlockAvailable(k+1))
				return true;
		return false;
	}
	private static boolean shouldAddShadowSideWest(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(j!=0 && i!=levelDimension.height-1)
			if(BlockStackIndex[i+1][j-1].isBlockAvailable(k))
				return true;
		return false;
	}
	private static boolean shouldAddTopShadow(BlockStack[][] BlockStackIndex,Dimension levelDimension,int i,int j,int k){
		if(i!=0){
			if(!BlockStackIndex[i][j].isBlockAvailable(k+1) && !BlockStackIndex[i-1][j].isBlockAvailable(k))
				return true;
		}
		else{
			if(!BlockStackIndex[i][j].isBlockAvailable(k+1))
				return true;
		}
		return false;
	}
}

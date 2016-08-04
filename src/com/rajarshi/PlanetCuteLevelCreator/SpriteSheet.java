package com.rajarshi.PlanetCuteLevelCreator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	protected static Image[] getSpriteImages(String filePath, int imagesInRow, int imagesInColumb, int desiredHeight, boolean goldenDragon){
		BufferedImage spriteSheet0 = null;
		try {
			spriteSheet0 = ImageIO.read(SpriteSheet.class.getResource("/"+filePath));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Image[] spriteImages = new Image[imagesInRow*imagesInColumb];
		int spriteSheetWidth = spriteSheet0.getWidth(null);
		int spriteSheetHeight = spriteSheet0.getHeight(null);
		int spriteWidth = spriteSheetWidth/imagesInColumb;
		int spriteHeight = spriteSheetHeight/imagesInRow;
		BufferedImage spriteSheet = new BufferedImage(spriteSheetWidth,spriteSheetHeight,BufferedImage.TRANSLUCENT);
		Graphics2D renderGraphics2D = (Graphics2D)spriteSheet.getGraphics();
		renderGraphics2D.drawImage(spriteSheet0, 0, 0, null);
		Color tintColor = new Color(0,0,255,50);
		renderGraphics2D.setPaint(tintColor);
		for(int i=0;i<spriteSheetWidth;i++){
			for(int j=0;j<spriteSheetHeight;j++){
				Color imagePixelColor = new Color(spriteSheet.getRGB(i, j),true);
				if(imagePixelColor.getAlpha() != 0){
					int r = imagePixelColor.getRed();
					int b = imagePixelColor.getBlue();
					int g = imagePixelColor.getGreen();
					if(goldenDragon)
						r = r + 50;
					else
						b = b + 50;
					g = g + 50;
					if(r>255)
						r= 255;
					if(b>255)
						b=255;
					if(g>255)
						g = 255;
					renderGraphics2D.setPaint(new Color(r,g,b));
					renderGraphics2D.drawLine(i, j, i, j);
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<imagesInRow;i++){
			for(int j=0;j<imagesInColumb;j++){
				spriteImages[count] = new BufferedImage(spriteWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);
				Graphics g = spriteImages[count].getGraphics();
				Graphics2D g2d = (Graphics2D)g.create();
				Color[] colors = {new Color(0, 0, 0, 255), new Color(0,0,0,0)};
				float[] fractions = {0.0f,1.0f};
				RadialGradientPaint rgp = new RadialGradientPaint(spriteWidth/2, desiredHeight - (spriteWidth/2) , spriteWidth/2, fractions, colors);
				g2d.setPaint(rgp);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.fillOval(0, desiredHeight-spriteWidth, spriteWidth, spriteWidth);
				g2d.drawImage(spriteSheet,0,desiredHeight-spriteHeight-20,spriteWidth,desiredHeight-20,j*spriteWidth,i*spriteHeight,(j+1)*spriteWidth,(i+1)*spriteHeight,null);
				count++;
			}
		}
		return spriteImages;
	}
}

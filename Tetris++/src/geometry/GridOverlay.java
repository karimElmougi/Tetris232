package geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class GridOverlay {
	int squareSize;
	int width;
	int height;
	
	public GridOverlay(int s, int w, int h){
		squareSize = s;
		width = w;
		height = h;
	}
	
	public void draw(Graphics2D g2d){
		AffineTransform matBackup = new AffineTransform(g2d.getTransform());
		g2d.setColor(Color.DARK_GRAY);
		for(int i = 1; i<=width; i++){
			g2d.drawLine(i*squareSize, 0, i*squareSize, height*squareSize);
		}
		
		for(int i = 1; i<=height; i++){
			g2d.drawLine(0, i*squareSize, width*squareSize, i*squareSize);
		}
		g2d.setTransform(matBackup);
	}
}

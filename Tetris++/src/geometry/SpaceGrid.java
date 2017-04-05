package geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SpaceGrid {
	SpaceNode[][] grid;
	
	public SpaceGrid(int columns, int lines, int size){
		grid = new SpaceNode[columns][lines];
		for(int i = 0; i<lines;  i++){
			for(int j = 0; j<columns; j++){
				grid[j][i] = new SpaceNode(size, j, i);
			}
		}
		
		for(int i = 0; i<lines;  i++){
			for(int j = 0; j<columns; j++){
				if(j != 0){
					grid[j][i].setLeft(grid[j-1][i]);	
				}
				if(j != columns-1){
					grid[j][i].setRight(grid[j+1][i]);
				}
				if(i != 0){
					grid[j][i].setUp(grid[j][i-1]);
				}
				if(i != lines-1){
					grid[j][i].setDown(grid[j][i+1]);
				}
			}
		}
	}
	
	public SpaceNode at(int columns, int lines){
		return grid[columns][lines];
	}
	
	public void draw(Graphics2D g2d) { // 
	    AffineTransform matBackup = new AffineTransform(g2d.getTransform());
        g2d.setColor(Color.YELLOW);
        for(SpaceNode[] squares : grid) // dessine toutes les pieces continuellement
            for(SpaceNode square : squares){
            	square.drawSquare(g2d);
            }
        g2d.setTransform(matBackup);
	}
}

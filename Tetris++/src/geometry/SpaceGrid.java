package geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import gameShapes.FalseTetromino;

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
        for(SpaceNode[] squares : grid){ // dessine toutes les pieces continuellement
        	for(SpaceNode square : squares){
            	Color c = square.getColor();
            	g2d.setColor(c);
            	square.drawSquare(g2d);
            }
        }
        g2d.setTransform(matBackup);
	}
	
	public void checkFill(){
		for(int ligne = grid[0].length-1; ligne>=0; ligne--){
			boolean isFull = true;
			for(int colonne = 0; colonne < grid.length; colonne++){
				isFull = isFull && grid[colonne][ligne].getOccupied();
			}
			if(isFull){
				for(int colonne = 0; colonne < grid.length; colonne++){
					grid[colonne][ligne].setOccupied(false);
				}
				for(int ligneD = ligne-1; ligneD>=0; ligneD--){
					FalseTetromino fTetromino = new FalseTetromino(grid[0][ligneD]);
					fTetromino.goDown();
				}
			}
		}
	}
}

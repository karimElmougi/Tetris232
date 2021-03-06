package geometry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import gameShapes.FalseTetromino;

public class SpaceGrid {
	private SpaceNode[][] grid;
	private SpaceNode[][] ghostGrid;
	private int lines;
	private int columns;
	private int size;
	private int Points;
	
	public SpaceGrid(int columns, int lines, int size) {
		this.size = size;
		this.columns = columns;
		this.lines = lines;
		grid = new SpaceNode[columns][lines];
		ghostGrid = new SpaceNode[columns][2];
		
		initializeGrid(); 
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < columns; j++){
				ghostGrid[j][i] = new SpaceNode(size, j, i - 2);
			}
		}
		
		for(int i = 0; i<2;  i++){
			for(int j = 0; j<columns; j++){
				if(j != 0){
					ghostGrid[j][i].setLeft(ghostGrid[j-1][i]);	
				}
				if(j != columns-1){
					ghostGrid[j][i].setRight(ghostGrid[j+1][i]);
				}
				if(i != 0){
					ghostGrid[j][i].setUp(ghostGrid[j][i-1]);
				}
				if(i != 1){
					ghostGrid[j][i].setDown(ghostGrid[j][i+1]);
				}
				else{
					ghostGrid[j][i].setDown(grid[j][0]);
				}
			}
		}
	}
	
	public SpaceNode at(int columns, int lines){
		if(lines < 0){
			return ghostGrid[columns][lines+2];
		}
		else return grid[columns][lines];
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
	
	public boolean checkFill(){
		int pts = 0;
		for(int ligne = grid[0].length-1; ligne>=0; ligne--){
			boolean isFull = true;
			for(int colonne = 0; colonne < grid.length; colonne++){
				isFull = isFull && grid[colonne][ligne].getOccupied();
			}
			if(isFull){
				pts++;
				for(int colonne = 0; colonne < grid.length; colonne++){
					grid[colonne][ligne].setOccupied(false);
				}
				for(int ligneD = ligne-1; ligneD>=0; ligneD--){
					FalseTetromino fTetromino = new FalseTetromino(grid[0][ligneD]);
					fTetromino.goDown();
				}
				ligne++;
			}
		}
		
		setPoints(pts);
		 
		 if (pts != 0) return true;
		 else return false;
	}
	
	public SpaceNode[][] getGrid() {
		return grid;
	}
	
	public void initializeGrid() {
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
				else{
					grid[j][i].setUp(ghostGrid[j][1]);
				}
				if(i != lines-1){
					grid[j][i].setDown(grid[j][i+1]);
				}
			}
		}
	}

	private void setPoints(int a)
	{   int bonus = 0;
	    if(a==2) bonus = 10;
	    else if(a>=3) bonus = 50;
		this.Points += (a*10 + bonus);
	}
	
	
	
	public int getPoints()
	{
		return this.Points;
	}
}

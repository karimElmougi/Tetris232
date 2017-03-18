package gameShapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import geometry.SquareSpace;

public class Tetromino {
	private Square square1;
	private Square square2;
	private Square square3;
	private Square square4;
	
	public Tetromino(SquareSpace[][] grid, int line, int column){
		square1 = new Square(grid[column][line]);
		square2 = new Square(grid[column+1][line]);
		square3 = new Square(grid[column][line+1]);
		square4 = new Square(grid[column+1][line+1]);
	}

	public void draw(Graphics2D g2d){
		AffineTransform matBackup = new AffineTransform(g2d.getTransform());
		g2d.setColor(Color.YELLOW);
		
		square1.draw(g2d);
		square2.draw(g2d);
		square3.draw(g2d);
		square4.draw(g2d);
		
		g2d.setTransform(matBackup);
	}
	
	public void down(SquareSpace[][] grid){
		square1.down(grid);
		square2.down(grid);
		square3.down(grid);
		square4.down(grid);
	}
	
	public void left(SquareSpace[][] grid){
		square1.left(grid);
		square2.left(grid);
		square3.left(grid);
		square4.left(grid);
	}
	
	public void right(SquareSpace[][] grid){
		square1.right(grid);
		square2.right(grid);
		square3.right(grid);
		square4.right(grid);
	}
}

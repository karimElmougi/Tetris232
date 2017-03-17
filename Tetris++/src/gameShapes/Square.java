package gameShapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import geometry.SquareSpace;

public class Square {
	private SquareSpace space = null;
	
	public Square(SquareSpace s){
		space = s;
	}
	
	public void draw(Graphics2D g2d){
		AffineTransform matBackup = new AffineTransform(g2d.getTransform());
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(space.getX(), space.getY(), space.getDim(), space.getDim());
		g2d.setTransform(matBackup);
	}
	
	public void down(SquareSpace[][] grid){
		space = grid[space.getColumn()][space.getLine()+1];
	}
}

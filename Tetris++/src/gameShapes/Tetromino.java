package gameShapes;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import component.GamePanel;
import geometry.SpaceNode;

public abstract class Tetromino {
	protected SpaceNode square1;
	protected SpaceNode square2;
	protected SpaceNode square3;
	protected SpaceNode square4;
	
	protected boolean active; // va servir a savoir quand spwaner les autre pieces
	//protected GamePanel game; // Pour pouvoir spawner des nouveaux tetrominos! LOL
	protected Tetromino(){
		
	}
	
	public Tetromino(SpaceNode space){
	    //game = fame; // Rock'n'roll baby! LOL  -Lolicon 
	    active = true;
	    square1 = space;
	}
	public void Occupied(){
		square1.setOccupied(true);
		square2.setOccupied(true);
		square3.setOccupied(true);
		square4.setOccupied(true);
	}

	public void draw(Graphics2D g2d){
		AffineTransform matBackup = new AffineTransform(g2d.getTransform());
		square1.drawSquare(g2d);
		square2.drawSquare(g2d);
		square3.drawSquare(g2d);
		square4.drawSquare(g2d);
		
		g2d.setTransform(matBackup);
	}
	
	public abstract boolean goDown();
	
	public abstract void goLeft();
	
	public abstract void goRight();
	
	public abstract void setTheColor();
}

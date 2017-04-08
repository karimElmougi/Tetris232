package gameShapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import geometry.SpaceNode;

public abstract class Tetromino {
	protected ArrayList<SpaceNode> squares;
	protected ArrayList<SpaceNode> squaresToCheckDown;
	protected ArrayList<SpaceNode> squaresToCheckLeft;
	protected ArrayList<SpaceNode> squaresToCheckRight;
	protected Color color;
	
	protected boolean active; // va servir a savoir quand spawner les autre pieces
	
	protected Tetromino(){	
	}
	
	public Tetromino(SpaceNode space){
	    active = true;
	    squares = new ArrayList<SpaceNode>();
	    squaresToCheckDown = new ArrayList<SpaceNode>();
	    squaresToCheckLeft = new ArrayList<SpaceNode>();
	    squaresToCheckRight = new ArrayList<SpaceNode>();
	}
	
	protected void setSquaresOccupied(boolean b) {
		for (SpaceNode square : squares) {
			square.setOccupied(b);
		}
	}
	
	private boolean checkDown() {
		for (SpaceNode square : squaresToCheckDown) {
			if (square.getDown() == null || square.getDown().getOccupied()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkLeft() {
		for (SpaceNode square : squaresToCheckLeft) {
			if (square.getLeft() == null || square.getLeft().getOccupied()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkRight() {
		for (SpaceNode square : squaresToCheckRight) {
			if (square.getRight() == null || square.getRight().getOccupied()) {
				return false;
			}
		}
		return true;
	}
	
	protected void setTheColor() {
		for (SpaceNode square : squares) {
			square.setNodeColor(color);
		}
	}
	
	public boolean goDown() {
		if(checkDown()) {
			setSquaresOccupied(false);
			
			for(int i = 0; i < squares.size(); i++){
				squares.set(i, squares.get(i).getDown());
			}
			
			for(int i = 0; i < squaresToCheckDown.size(); i++){
				squaresToCheckDown.set(i, squaresToCheckDown.get(i).getDown());
			}
			
			for(int i = 0; i < squaresToCheckLeft.size(); i++){
				squaresToCheckLeft.set(i, squaresToCheckLeft.get(i).getDown());
			}
			
			for(int i = 0; i < squaresToCheckRight.size(); i++){
				squaresToCheckRight.set(i, squaresToCheckRight.get(i).getDown());
			}
			
			setSquaresOccupied(true);
			setTheColor();
			return true;
		}
		return false;
	}
	
	public void goLeft() {
		if(checkLeft()) {
			setSquaresOccupied(false);
			
			for(int i = 0; i < squares.size(); i++){
				squares.set(i, squares.get(i).getLeft());
			}
			
			for(int i = 0; i < squaresToCheckDown.size(); i++){
				squaresToCheckDown.set(i, squaresToCheckDown.get(i).getLeft());
			}
			
			for(int i = 0; i < squaresToCheckLeft.size(); i++){
				squaresToCheckLeft.set(i, squaresToCheckLeft.get(i).getLeft());
			}
			
			for(int i = 0; i < squaresToCheckRight.size(); i++){
				squaresToCheckRight.set(i, squaresToCheckRight.get(i).getLeft());
			}

			setSquaresOccupied(true);
			setTheColor();
		}
	}
	
	public void goRight() {
		if(checkRight()) {
setSquaresOccupied(false);
			
			for(int i = 0; i < squares.size(); i++){
				squares.set(i, squares.get(i).getRight());
			}
			
			for(int i = 0; i < squaresToCheckDown.size(); i++){
				squaresToCheckDown.set(i, squaresToCheckDown.get(i).getRight());
			}
			
			for(int i = 0; i < squaresToCheckLeft.size(); i++){
				squaresToCheckLeft.set(i, squaresToCheckLeft.get(i).getRight());
			}
			
			for(int i = 0; i < squaresToCheckRight.size(); i++){
				squaresToCheckRight.set(i, squaresToCheckRight.get(i).getRight());
			}

			setSquaresOccupied(true);
			setTheColor();
		}
	}
	
	public void draw(Graphics2D g2d){
		AffineTransform matBackup = new AffineTransform(g2d.getTransform());
		for (SpaceNode square : squares) {
			square.drawSquare(g2d);
		}
		g2d.setTransform(matBackup);
	}
	
	//public abstract void rotateClockwise();
}

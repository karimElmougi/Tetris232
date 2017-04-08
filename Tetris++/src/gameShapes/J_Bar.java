package gameShapes;

import java.awt.Color;

import component.GamePanel;
import geometry.SpaceNode;

public class J_Bar extends Tetromino{

	public J_Bar(SpaceNode space){
		super(space);
		square1 = space;
		square2 = space.getUp();
		square3 = space.getDown();
		square4 = space.getDown().getLeft();
		Occupied();
	}
	
	public boolean goDown(){
		if(square4.getDown() == null || square4.getDown().getOccupied() || square3.getDown().getOccupied()){ //permet de detecter la collision par en-bas
		    active = false; // qd active est faux on transfet le controle aux  enfants (autre pieces)
		    //game.spawnTetromino(4, 2); //(spawn la nouvelle piece)
			return false;
		}
		if(active) {
		    square2.setOccupied(false);
		    square4.setOccupied(false);
	        square4 = square4.getDown();
	        square3 = square3.getDown();
	        square2 = square2.getDown();
	        square1 = square1.getDown();
	        square4.setOccupied(true);
	        square3.setOccupied(true);
	        setTheColor();
		}
		return true;
	}
	
	public void goLeft(){
		if(square2.getLeft().getOccupied() || square1.getLeft().getOccupied() || square4.getLeft() == null || square4.getLeft().getOccupied()){
			return;
		}
		if(active) {
			square1.setOccupied(false);
		    square2.setOccupied(false);
		    square3.setOccupied(false);
		    square1 = square1.getLeft();
		    square3 = square3.getLeft();
		    square2 = square2.getLeft();
		    square4 = square4.getLeft();
			square1.setOccupied(true);
		    square2.setOccupied(true);
		    square4.setOccupied(true);			
		    setTheColor();
		}
	}
	
	public void goRight(){
		if(square1.getRight() == null || square1.getRight().getOccupied() || square2.getRight().getOccupied() || square3.getRight().getOccupied()){
			return;
		}
		if(active) {

			square1.setOccupied(false);
		    square2.setOccupied(false);
		    square4.setOccupied(false);
		    square1 = square1.getRight();
		    square3 = square3.getRight();
		    square2 = square2.getRight();
		    square4 = square4.getRight();
			square1.setOccupied(true);
		    square2.setOccupied(true);
		    square3.setOccupied(true);
		    setTheColor();
		}
	}
	
	public void setTheColor(){
		square1.setNodeColor(Color.PINK);
		square2.setNodeColor(Color.PINK);
		square3.setNodeColor(Color.PINK);
		square4.setNodeColor(Color.PINK);
	}
}

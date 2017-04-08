package gameShapes;

import java.awt.Color;

import component.GamePanel;
import geometry.SpaceNode;

public class Z_Bar extends Tetromino{
	
	public Z_Bar(SpaceNode space, GamePanel fame){
		super(space, fame);
		square2 = space.getUp();
		square3 = space.getLeft();
		square4 = space.getLeft().getDown();
		Occupied();
	}
	
	public void goDown(){
		if(square4.getDown() == null || square4.getDown().getOccupied() || square1.getDown().getOccupied()){ //permet de detecter la collision par en-bas
		    active = false; // qd active est faux on transfet le controle aux  enfants (autre pieces)
		    game.spawnTetromino(); //(spawn la nouvelle piece)
			return;
		}
		if(active) {
		    square2.setOccupied(false);
		    square3.setOccupied(false);
	        square4 = square4.getDown();
	        square3 = square3.getDown();
	        square2 = square2.getDown();
	        square1 = square1.getDown();
	        square1.setOccupied(true);
	        square4.setOccupied(true);
	        setTheColor();
		}
	}
	
	public void goLeft(){
		if(square4.getLeft() == null || square2.getLeft().getOccupied() ||  square3.getLeft().getOccupied() ||  square4.getLeft().getOccupied()){
			return;
		}
		if(active) {
			square2.setOccupied(false);
		    square1.setOccupied(false);
		    square4.setOccupied(false);
		    square1 = square1.getLeft();
		    square3 = square3.getLeft();
		    square2 = square2.getLeft();
		    square4 = square4.getLeft();
			square3.setOccupied(true);
		    square2.setOccupied(true);
		    square4.setOccupied(true);
		    setTheColor();
		}
	}
	
	public void goRight(){
		if(square2.getRight() == null || square1.getRight().getOccupied() ||  square2.getRight().getOccupied() ||  square4.getRight().getOccupied()){
			return;
		}
		if(active) {
			square2.setOccupied(false);
		    square3.setOccupied(false);
		    square4.setOccupied(false);
		    square1 = square1.getRight();
		    square3 = square3.getRight();
		    square2 = square2.getRight();
		    square4 = square4.getRight();
		    square1.setOccupied(true);
		    square2.setOccupied(true);
		    square4.setOccupied(true);
		    setTheColor();
		}
	}

	public void setTheColor(){
		square1.setNodeColor(Color.RED);
		square2.setNodeColor(Color.RED);
		square3.setNodeColor(Color.RED);
		square4.setNodeColor(Color.RED);
	}
}


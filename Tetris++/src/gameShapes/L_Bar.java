package gameShapes;

import component.GamePanel;
import geometry.SpaceNode;

public class L_Bar extends Tetromino{

	public L_Bar(SpaceNode space, GamePanel fame){
		super(space, fame);
		square2 = space.getUp();
		square3 = space.getDown();
		square4 = space.getDown().getRight();
		Occupied();
	}
	
	public void goDown(){
		if(square4.getDown() == null || square4.getDown().getOccupied() || square3.getDown().getOccupied()){ //permet de detecter la collision par en-bas
		    active = false; // qd active est faux on transfet le controle aux  enfants (autre pieces)
		    game.spawnTetromino(4, 2); //(spawn la nouvelle piece)
			return;
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
		}
	}
	
	public void goLeft(){
		if(square1.getLeft() == null || square2.getLeft().getOccupied() || square3.getLeft().getOccupied()){
			return;
		}
		if(active) {
			square1.setOccupied(false);
		    square2.setOccupied(false);
		    square4.setOccupied(false);
		    square1 = square1.getLeft();
		    square3 = square3.getLeft();
		    square2 = square2.getLeft();
		    square4 = square4.getLeft();
			square1.setOccupied(true);
		    square2.setOccupied(true);
		    square3.setOccupied(true);
		}
	}
	
	public void goRight(){
		if(square4.getRight() == null || square4.getRight().getOccupied() || square1.getRight().getOccupied()){
			return;
		}
		if(active) {
			square1.setOccupied(false);
		    square2.setOccupied(false);
		    square3.setOccupied(false);
		    square1 = square1.getRight();
		    square3 = square3.getRight();
		    square2 = square2.getRight();
		    square4 = square4.getRight();
			square1.setOccupied(true);
		    square2.setOccupied(true);
		    square4.setOccupied(true);
		}
	}
}

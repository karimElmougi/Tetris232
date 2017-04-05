package gameShapes;

import component.GamePanel;
import geometry.SpaceNode;

public class T_Bar extends Tetromino{

	public T_Bar(SpaceNode space, GamePanel fame){
		super(space, fame);
		square2 = space.getDown();
		square3 = space.getDown().getLeft();
		square4 = space.getDown().getRight();
		Occupied();
	}
	
	public void goDown(){
		if(square4.getDown() == null || square4.getDown().getOccupied() || square3.getDown().getOccupied()  || square2.getDown().getOccupied()){ //permet de detecter la collision par en-bas
		    active = false; // qd active est faux on transfet le controle aux  enfants (autre pieces)
		    game.spawnTetromino(4, 2); //(spawn la nouvelle piece)
			return;
		}
		if(active) {
		    square1.setOccupied(false);
		    square3.setOccupied(false);
		    square4.setOccupied(false);
	        square4 = square4.getDown();
	        square3 = square3.getDown();
	        square2 = square2.getDown();
	        square1 = square1.getDown();
		    square2.setOccupied(true);
		    square3.setOccupied(true);
		    square4.setOccupied(true);
		}
	}
	
	public void goLeft(){
		if(square3.getLeft() == null || square3.getLeft().getOccupied() || square1.getLeft().getOccupied()){
			return;
		}
		if(active) {
			square1.setOccupied(false);
		    square4.setOccupied(false);
		    square1 = square1.getLeft();
		    square3 = square3.getLeft();
		    square2 = square2.getLeft();
		    square4 = square4.getLeft();
			square1.setOccupied(true);
		    square3.setOccupied(true);
		}
	}
	
	public void goRight(){
		if(square4.getRight() == null || square1.getRight().getOccupied() || square4.getRight().getOccupied()){
			return;
		}
		if(active) {
			square1.setOccupied(false);
		    square3.setOccupied(false);
		    square1 = square1.getRight();
		    square3 = square3.getRight();
		    square2 = square2.getRight();
		    square4 = square4.getRight();
			square1.setOccupied(true);
		    square4.setOccupied(true);
		}
	}
}

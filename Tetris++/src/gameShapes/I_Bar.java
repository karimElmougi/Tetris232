package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class I_Bar extends Tetromino{
	
	public I_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getRight());
		squares.add(squares.get(1).getRight());
		squares.add(squares.get(2).getRight());
		
		squaresToCheckDown.addAll(squares);
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);
		color = Color.CYAN;
		setTheColor();
	}
	
	/*public void rotateClockwise() {
		square2.setOccupied(false);
		square3.setOccupied(false);
		square4.setOccupied(false);
		
		if(square1.getUp() == square2) { // Rotation à partir de l'état initial
			square2 = square1.getRight();
			square3 = square1.getLeft();
			square4 = square3.getLeft();
		}
		
		square2.setOccupied(true);
		square3.setOccupied(true);
		square4.setOccupied(true);
	}*/
}

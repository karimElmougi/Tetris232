package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class L_Bar extends Tetromino{

	public L_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getDown());
		squares.add(squares.get(1).getLeft());
		squares.add(squares.get(2).getLeft());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(1));
		
		setSquaresOccupied(true);
		color = Color.ORANGE;
	}
	
	public void rotateClockwise() {
		
	}
}

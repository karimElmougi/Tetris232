package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class T_Bar extends Tetromino{

	public T_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getDown());
		squares.add(squares.get(1).getLeft());
		squares.add(squares.get(1).getRight());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);
		color = Color.MAGENTA;
	}
	
	public void rotateClockwise() {
		
	}
}

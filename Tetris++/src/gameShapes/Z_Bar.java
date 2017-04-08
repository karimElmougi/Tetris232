package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class Z_Bar extends Tetromino{
	
	public Z_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getRight());
		squares.add(squares.get(1).getDown());
		squares.add(squares.get(2).getRight());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);
		color = Color.RED;
	}
	
	public void rotateClockwise() {
		
	}
}


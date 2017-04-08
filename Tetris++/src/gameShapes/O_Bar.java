package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class O_Bar extends Tetromino{
	
	public O_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getRight());
		squares.add(space.getDown());
		squares.add(space.getDown().getRight());
		
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);
		color = Color.YELLOW;
		setTheColor();
	}
	
	public void rotateClockwise() {
		
	}
}

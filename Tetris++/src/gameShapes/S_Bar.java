package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class S_Bar extends Tetromino{
	
	public S_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getRight());
		squares.add(space.getDown());
		squares.add(squares.get(2).getLeft());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(2));
		
		setSquaresOccupied(true);
		color = Color.GREEN;
	}
	
	public void rotateClockwise() {
		
	}
}

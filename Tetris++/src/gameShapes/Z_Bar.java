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

	@Override
	public void setRotationStateOne() {
		if(rotationState == 4 && (squares.get(1).getLeft() == null || squares.get(1).getLeft().getOccupied() 
				|| squares.get(1).getDown().getRight() == null || squares.get(1).getDown().getRight().getOccupied())){
			return ;
		}
		if(rotationState == 2 && (squares.get(1).getDown() == null ||squares.get(1).getDown().getOccupied() ||
				squares.get(1).getDown().getRight() == null || squares.get(1).getDown().getRight().getOccupied())){
			return ;
		}
		rotationState = 1;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(1).getLeft());
		squares.set(2, squares.get(1).getDown());
		squares.set(3, squares.get(1).getDown().getRight());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);	
		
	}

	@Override
	public void setRotationStateTwo() {
		if(rotationState == 1 && (squares.get(1).getUp() == null || squares.get(1).getUp().getOccupied() 
				|| squares.get(1).getLeft().getDown() == null || squares.get(1).getLeft().getDown().getOccupied())){
			return ;
		}
		if(rotationState == 3 && (squares.get(1).getLeft() == null ||squares.get(1).getLeft().getOccupied() 
				|| squares.get(1).getLeft().getDown() == null || squares.get(1).getLeft().getDown().getOccupied())){
			return ;
		}
		rotationState = 2;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(1).getUp());
		squares.set(2, squares.get(1).getLeft());
		squares.set(3, squares.get(1).getLeft().getDown());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);	
		
	}

	@Override
	public void setRotationStateThree() {
		if(rotationState == 2 && (squares.get(1).getRight() == null || squares.get(1).getRight().getOccupied() 
				|| squares.get(1).getUp().getLeft() == null || squares.get(1).getUp().getLeft().getOccupied())){
			return ;
		}
		if(rotationState == 4 && (squares.get(1).getUp() == null ||squares.get(1).getUp().getOccupied() 
				|| squares.get(1).getUp().getLeft() == null || squares.get(1).getUp().getLeft().getOccupied())){
			return ;
		}
		rotationState = 3;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(1).getRight());
		squares.set(2, squares.get(1).getUp());
		squares.set(3, squares.get(1).getUp().getLeft());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(2));
		setSquaresOccupied(true);	
		
	}

	@Override
	public void setRotationStateFour() {
		if(rotationState == 1 && (squares.get(1).getRight() == null || squares.get(1).getRight().getOccupied() 
				|| squares.get(1).getRight().getUp() == null || squares.get(1).getRight().getUp().getOccupied())){
			return ;
		}
		if(rotationState == 3 && (squares.get(1).getDown() == null ||squares.get(1).getDown().getOccupied() 
				|| squares.get(1).getRight().getUp() == null || squares.get(1).getRight().getUp().getOccupied())){
			return ;
		}
		rotationState = 4;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(1).getDown());
		squares.set(2, squares.get(1).getRight());
		squares.set(3, squares.get(1).getRight().getUp());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(2));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(2));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);
	}
		
	
}


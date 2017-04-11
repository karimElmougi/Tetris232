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

	@Override
	public void setRotationStateOne() {
		if(rotationState == 4 && (squares.get(0).getDown() == null || squares.get(0).getDown().getOccupied() 
				|| squares.get(0).getDown().getLeft() == null || squares.get(0).getDown().getLeft().getOccupied())){
			return ;
		}
		if(rotationState == 2 && (squares.get(0).getRight() == null ||squares.get(0).getRight().getOccupied() ||
				squares.get(0).getDown().getLeft() == null || squares.get(0).getDown().getLeft().getOccupied())){
			return ;
		}
		rotationState = 1;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(0).getRight());
		squares.set(1, squares.get(0).getRight());
		squares.set(2, squares.get(0).getDown());
		squares.set(3, squares.get(2).getLeft());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(2));
		setSquaresOccupied(true);	
	}

	@Override
	public void setRotationStateTwo() {
		if(rotationState == 1 && (squares.get(0).getLeft() == null || squares.get(0).getLeft().getOccupied() 
				|| squares.get(0).getLeft().getUp() == null || squares.get(0).getLeft().getUp().getOccupied())){
			return ;
		}
		if(rotationState == 3 && (squares.get(0).getDown() == null ||squares.get(0).getDown().getOccupied() 
				|| squares.get(0).getLeft().getUp() == null || squares.get(0).getLeft().getUp().getOccupied())){
			return ;
		}
		rotationState = 2;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(1, squares.get(0).getDown());
		squares.set(2, squares.get(0).getLeft());
		squares.set(3, squares.get(0).getLeft().getUp());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(2));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);	
	}

	@Override
	public void setRotationStateThree() {
		if(rotationState == 2 && (squares.get(0).getUp() == null || squares.get(0).getUp().getOccupied() 
				|| squares.get(0).getUp().getRight() == null || squares.get(0).getUp().getRight().getOccupied())){
			return ;
		}
		if(rotationState == 4 && (squares.get(0).getLeft() == null ||squares.get(0).getLeft().getOccupied() 
				|| squares.get(0).getUp().getRight() == null || squares.get(0).getUp().getRight().getOccupied())){
			return ;
		}
		rotationState = 3;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(1, squares.get(0).getLeft());
		squares.set(2, squares.get(0).getUp());
		squares.set(3, squares.get(0).getUp().getRight());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(2));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);	
	}

	@Override
	public void setRotationStateFour() {
		if(rotationState == 1 && (squares.get(0).getUp() == null || squares.get(0).getUp().getOccupied() 
				|| squares.get(0).getRight().getDown() == null || squares.get(0).getRight().getDown().getOccupied())){
			return ;
		}
		if(rotationState == 3 && (squares.get(0).getRight() == null ||squares.get(0).getRight().getOccupied() 
				|| squares.get(0).getRight().getDown() == null || squares.get(0).getRight().getDown().getOccupied())){
			return ;
		}
		rotationState = 4;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(1, squares.get(0).getUp());
		squares.set(2, squares.get(0).getRight());
		squares.set(3, squares.get(0).getRight().getDown());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(2));
		squaresToCheckRight.add(squares.get(3));
		setSquaresOccupied(true);
	}

}

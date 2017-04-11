package gameShapes;

import java.awt.Color;

import geometry.SpaceNode;

public class J_Bar extends Tetromino{

	public J_Bar(SpaceNode space){
		super(space);
		squares.add(space);
		squares.add(space.getDown());
		squares.add(squares.get(1).getRight());
		squares.add(squares.get(2).getRight());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(1));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);
		color = Color.BLUE;
		setTheColor();
	}

	@Override
	public void setRotationStateOne() {
		if((squares.get(2).getRight() == null || squares.get(2).getRight().getOccupied()  
				|| squares.get(2).getLeft().getUp() == null || squares.get(2).getLeft().getUp().getOccupied()
				||  squares.get(2).getLeft() == null || squares.get(2).getLeft().getOccupied())){
			return ;
		}
		rotationState = 1;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(2).getLeft().getUp());
		squares.set(1, squares.get(2).getLeft());
		squares.set(3, squares.get(2).getRight());
		
		squaresToCheckDown.add(squares.get(1));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(1));
		
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);	
		
		
	}

	@Override
	public void setRotationStateTwo() {
		if((squares.get(2).getDown() == null || squares.get(2).getDown().getOccupied()  
				|| squares.get(2).getUp() == null || squares.get(2).getUp().getOccupied()
				||  squares.get(2).getUp().getRight() == null || squares.get(2).getUp().getRight().getOccupied())){
			return ;
		}
		rotationState = 2;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(2).getUp().getRight());
		squares.set(1, squares.get(2).getUp());
		squares.set(3, squares.get(2).getDown());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(1));
		squaresToCheckLeft.add(squares.get(2));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(2));
		squaresToCheckRight.add(squares.get(3));
		
		setSquaresOccupied(true);	
		
	}

	@Override
	public void setRotationStateThree() {
		if((squares.get(2).getRight() == null || squares.get(2).getRight().getOccupied()  
				|| squares.get(2).getLeft() == null || squares.get(2).getLeft().getOccupied()
				||  squares.get(2).getRight().getDown() == null || squares.get(2).getRight().getDown().getOccupied())){
			return ;
		}
		rotationState = 3;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(2).getRight().getDown());
		squares.set(1, squares.get(2).getRight());
		squares.set(3, squares.get(2).getLeft());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(2));
		squaresToCheckDown.add(squares.get(3));
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(0));
		squaresToCheckRight.add(squares.get(1));

		
		setSquaresOccupied(true);	
		
		
	}

	@Override
	public void setRotationStateFour() {
		if((squares.get(2).getUp() == null || squares.get(2).getUp().getOccupied()  
				|| squares.get(2).getDown() == null || squares.get(2).getDown().getOccupied()
				||  squares.get(2).getDown().getLeft() == null || squares.get(2).getDown().getLeft().getOccupied())){
			return ;
		}
		rotationState = 4;
		squaresToCheckDown.clear();
		squaresToCheckLeft.clear();
		squaresToCheckRight.clear();
		setSquaresOccupied(false);
		
		squares.set(0, squares.get(2).getDown().getLeft());
		squares.set(1, squares.get(2).getDown());
		squares.set(3, squares.get(2).getUp());
		
		squaresToCheckDown.add(squares.get(0));
		squaresToCheckDown.add(squares.get(1));
		
		
		squaresToCheckLeft.add(squares.get(0));
		squaresToCheckLeft.add(squares.get(2));
		squaresToCheckLeft.add(squares.get(3));
		
		squaresToCheckRight.add(squares.get(1));
		squaresToCheckRight.add(squares.get(2));
		squaresToCheckRight.add(squares.get(3));

		
		setSquaresOccupied(true);	
		
		
			
	}
}

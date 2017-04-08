package gameShapes;

import java.util.ArrayList;

import geometry.SpaceNode;

public class FalseTetromino extends Tetromino{
	private ArrayList<SpaceNode> list = new ArrayList<SpaceNode>();

	public FalseTetromino(SpaceNode space) {
		super();
		list.add(space);
		while(space.getRight() != null){
			space = space.getRight();
			list.add(space);
		}
	}

	@Override
	public boolean goDown() {
		for(SpaceNode space : list){
			space.getDown().setOccupied(space.getOccupied());
			space.setOccupied(false);
			space.getDown().setNodeColor(space.getColor());
		}
		return true;
	}
	
	public void rotateClockwise() {
	}

}
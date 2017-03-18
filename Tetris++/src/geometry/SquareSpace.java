package geometry;

import gameShapes.Square;

public class SquareSpace {
	private int x;
	private int y;
	private int dimension;
	private int column;
	private int line;
	
	public SquareSpace(int dim, int column, int line){
		this.x = column*dim;
		this.y = line*dim;
		dimension = dim;
		this.column = column;
		this.line = line;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDim() {
		return dimension;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
}

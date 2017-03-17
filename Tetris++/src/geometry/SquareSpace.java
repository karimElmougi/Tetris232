package geometry;

public class SquareSpace {
	private int x;
	private int y;
	private int dimension;
	private int column;
	private int line;
	
	public SquareSpace(int x, int y, int dim, int column, int line){
		this.x = x;
		this.y = y;
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

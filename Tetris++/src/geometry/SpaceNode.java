package geometry;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceNode {
	protected Color color;
	private SpaceNode right;
	private SpaceNode left;
	private SpaceNode up;
	private SpaceNode down;
	//private Square square = null;
	private int size;
	private int column;
	private int line;
	boolean isOccupied = false;
	
	public SpaceNode(int size, int columns, int line){
		this.size = size;
		this.column = columns;
		this.line = line;
		right = null;
		left = null;
		up = null;
		down = null;
	}
	
	public void drawSquare(Graphics2D g2d){
		if(isOccupied){
			g2d.fillRect(getX(), getY(), getSize(), getSize());
		}
	}
	
	public int getSize() {
		return size;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public SpaceNode getRight() {
		return right;
	}

	public void setRight(SpaceNode right) {
		this.right = right;
	}

	public SpaceNode getLeft() {
		return left;
	}

	public void setLeft(SpaceNode left) {
		this.left = left;
	}

	public SpaceNode getUp() {
		return up;
	}

	public void setUp(SpaceNode up) {
		this.up = up;
	}

	public SpaceNode getDown() {
		return down;
	}

	public void setDown(SpaceNode down) {
		this.down = down;
	}
	
	public int getX(){
		return column*size;
	}
	
	public int getY(){
		return line*size;
	}

	public void setOccupied(boolean b) {
		isOccupied = b;
	}
	
	public boolean getOccupied() {
	    return isOccupied;
	}
	
	public void setNodeColor(Color c){
		color = c;
	}
	
	public Color getColor(){
		return color;
	}
}

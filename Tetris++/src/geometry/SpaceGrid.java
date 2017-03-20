package geometry;

public class SpaceGrid {
	SpaceNode[][] grid;
	
	public SpaceGrid(int columns, int lines, int size){
		grid = new SpaceNode[columns][lines];
		for(int i = 0; i<lines;  i++){
			for(int j = 0; j<columns; j++){
				grid[j][i] = new SpaceNode(size, j, i);
			}
		}
		
		for(int i = 0; i<lines;  i++){
			for(int j = 0; j<columns; j++){
				if(j != 0){
					grid[j][i].setLeft(grid[j-1][i]);	
				}
				if(j != columns-1){
					grid[j][i].setRight(grid[j+1][i]);
				}
				if(i != 0){
					grid[j][i].setUp(grid[j][i-1]);
				}
				if(i != lines-1){
					grid[j][i].setDown(grid[j][i+1]);
				}
			}
		}
	}
	
	public SpaceNode at(int columns, int lines){
		return grid[columns][lines];
	}
}

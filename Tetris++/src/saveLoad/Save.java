package saveLoad;

import java.io.IOException;
import java.io.PrintWriter;


import geometry.SpaceGrid;

public class Save {
	
	private  SpaceGrid space = new SpaceGrid(0, 0, 0);
	
	public Save(SpaceGrid spaceG){	
		space = spaceG;
		
		
	}
	
	public void writeToFile(String FileName){
		
		int x = 0;
		int y = 0;
		int R,G,B;
		
		
		try {
			PrintWriter printer = new PrintWriter(FileName,"UTF-8");
			
			for(int ligne = 0  ; ligne<space.getGrid()[0].length;ligne++){
				
				for(int colonne = 0; colonne <space.getGrid().length; colonne++){
				
					if(space.getGrid()[colonne][ligne].getOccupied()){
						
					 x = space.getGrid()[colonne][ligne].getX()/ space.getGrid()[colonne][ligne].getSize();
					 y = space.getGrid()[colonne][ligne].getY()/ space.getGrid()[colonne][ligne].getSize();
					 R = space.getGrid()[colonne][ligne].getColor().getRed();
					 G = space.getGrid()[colonne][ligne].getColor().getGreen();
					 B = space.getGrid()[colonne][ligne].getColor().getBlue();
					 
					 printer.println(x+ " " + y +" "+" "+ R + " " + G + " "+ B);
					 
					}
				}
				
			}
			printer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

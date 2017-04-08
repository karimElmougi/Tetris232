package saveLoad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import geometry.SpaceGrid;

public class Load {
	private File saveFileCopy;
	private SpaceGrid grille;
	

	Load(File file) {
		saveFileCopy = file;
	}

	public SpaceGrid loadFile()
	{
		
		
		try(BufferedReader breader = new BufferedReader(new FileReader(saveFileCopy)))
		{
			String line = null;
			while((line = breader.readLine()) != null)
			{
				String [] tokens = line.split("\\s+");
		        String x = tokens[0];
		        String y = tokens[1];
		        String r = tokens[2];
		        String g = tokens[3];
		        String b = tokens[4];
		        
		        
		        
			}
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return grille;
	}

}

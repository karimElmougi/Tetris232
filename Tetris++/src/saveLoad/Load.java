package saveLoad;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import geometry.SpaceGrid;
import geometry.SpaceNode;

public class Load {
	private File saveFileCopy;
	private SpaceGrid grille;

	public Load(File file, SpaceGrid grille) {
		saveFileCopy = file;
		this.grille = grille;
	}

	public SpaceGrid loadFile() {
		try (BufferedReader breader = new BufferedReader(new FileReader(saveFileCopy))) {
			grille.initializeGrid();
			String line = null;
			while ((line = breader.readLine()) != null) {
				String[] tokens = line.split("\\s+");
				String x = tokens[0];
				String y = tokens[1];
				String r = tokens[2];
				String g = tokens[3];
				String b = tokens[4];
				
				setNode(grille.at(Integer.parseInt(x), Integer.parseInt(y)),r ,g ,b);
				
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return grille;
	}

	public void setNode(SpaceNode node, String r, String g, String b) {
		node.setOccupied(true);
		node.setNodeColor(new Color(Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b)));
	}
}

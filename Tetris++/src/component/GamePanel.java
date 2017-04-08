package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

import gameShapes.I_Bar;
import gameShapes.J_Bar;
import gameShapes.L_Bar;
import gameShapes.O_Bar;
import gameShapes.S_Bar;
import gameShapes.T_Bar;
import gameShapes.Tetromino;
import gameShapes.Z_Bar;
import geometry.GridOverlay;
import geometry.SpaceGrid;
import saveLoad.Save;

public class GamePanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 5090151066867436213L;
	private GridOverlay overlay;
	private boolean initialized = false;
	private SpaceGrid gameGrid;
	
	private Tetromino activePiece;


	public GamePanel(){
		setPreferredSize(new Dimension(250, 500));
		setBackground(Color.BLACK);
		setFocusable(true);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					activePiece.goDown();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					activePiece.goRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					activePiece.goLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					//activePiece.rotateClockwise();
				}
				if( (e.getKeyCode() == KeyEvent.VK_S) && (e.getModifiers()&KeyEvent.CTRL_MASK) !=0) {
					Save savefile = new Save(gameGrid);
					savefile.writeToFile("Fichier.txt");
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
	}
	
	/********************************************************************/
	/* ICI ON A DE TR�S TR�S BELLES POSSIBILIT�S DE FAIRE DU REFACTORING*/
	/********************************************************************/

	public void spawnTetromino() {
		Random generator = new Random();
		int position = generator.nextInt(7);
	    switch(position){
	    	case 0:
	    		activePiece = new O_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 1:
	    		activePiece = new J_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 2:
	    		activePiece = new L_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 3:
	    		activePiece = new T_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 4:
	    		activePiece = new I_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 5:
	    		activePiece = new S_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 6:
	    		activePiece = new Z_Bar(gameGrid.at(4, -2));
	    		break;
	    }
	}
	
	private void initialize(){
		if(!initialized){
			int squareSize = getWidth()/10;
			
			setSize(10*squareSize, 20*squareSize);
			overlay = new GridOverlay(squareSize, 10, 20);
			
			gameGrid = new SpaceGrid(10, 20, squareSize);

			spawnTetromino();
			initialized = true;
			
			start();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;	
		initialize();
		gameGrid.draw(g2d);  // on dessine toutes les cases du tableau
		overlay.draw(g2d);	
	}
	
	@Override
	public void run() {
		boolean testb = true;
		while(testb){
			if(!activePiece.goDown()){
				gameGrid.checkFill();
				spawnTetromino();
			}
			repaint();
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				System.out.println("Error during the animation");
			}
		}
	}
	
	public void start(){
		Thread proc = new Thread(GamePanel.this);
		proc.start();
	}

}

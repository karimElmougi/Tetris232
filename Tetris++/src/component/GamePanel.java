package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import gameShapes.Tetromino;
import geometry.GridOverlay;
import geometry.SpaceGrid;

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
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
	}
	
	public void spawnTetromino(int y, int x) {
	    activePiece = new Tetromino(gameGrid.at(y, x), this);
	}
	
	private void initialize(){
		if(!initialized){
			int squareSize = getWidth()/10;
			
			setSize(10*squareSize, 20*squareSize);
			overlay = new GridOverlay(squareSize, 10, 20);
			
			gameGrid = new SpaceGrid(10, 20, squareSize);

			activePiece = new Tetromino(gameGrid.at(4, 2) , this);
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
			activePiece.goDown();
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

package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameShapes.Square;
import geometry.GridOverlay;
import geometry.SquareSpace;

public class GamePanel extends JPanel implements Runnable{
	private GridOverlay overlay;
	private boolean initialized = false;
	private SquareSpace[][] gameGrid = new SquareSpace[10][20];
	private Square test;

	public GamePanel(){
		setPreferredSize(new Dimension(250, 500));
		setBackground(Color.BLACK);
		setFocusable(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				test.down(gameGrid);
				System.out.println("TEST");
				repaint();

			}
		});
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 40){
					test.down(gameGrid);
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
	}
	
	private void initialize(){
		if(!initialized){
			int squareSize = getWidth()/10;
			
			setSize(10*squareSize, 20*squareSize);
			overlay = new GridOverlay(squareSize, 10, 20);

			for(int i = 0; i<10; i++){
				for(int j = 0; j<20; j++){
					gameGrid[i][j] = new SquareSpace(i*squareSize, j*squareSize, squareSize, i, j);
				}
			}
			
			
			test = new Square(gameGrid[4][2]);
			initialized = true;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		initialize();
		overlay.draw(g2d);
		test.draw(g2d);
	}
	
	@Override
	public void run() {
		
	}

}

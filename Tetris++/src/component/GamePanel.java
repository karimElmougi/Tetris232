package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Observers.Observer;
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
import saveLoad.Load;
import saveLoad.Save;

public class GamePanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 5090151066867436213L;
	private GridOverlay overlay;
	private boolean initialized = false;
	private SpaceGrid gameGrid;
	private boolean running;
	private JLabel gameOverLabel;
	
	private Tetromino activePiece;
	

	// observer thing
	   private ArrayList<Observer> observers = new ArrayList<Observer>();
	   

	   public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update();
	      }
	   } 

	
	private int Thepoints;
	
	public void setThepoints()
	{
		this.Thepoints = gameGrid.getPoints();
		notifyAllObservers();
	}
	
	public int getThepoints()
	{
		return this.Thepoints;
	}
	
  // fin du observer

	public GamePanel(){
		setPreferredSize(new Dimension(250, 500));
		setBackground(Color.BLACK);
		setFocusable(true);
		running = true;
		
		gameOverLabel = new JLabel("Game Over");
		gameOverLabel.setVisible(false);
		gameOverLabel.setForeground(Color.WHITE);
		gameOverLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		this.add(gameOverLabel);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					if (running) {
						activePiece.goDown();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					if (running) {
						activePiece.goRight();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					if (running) {
						activePiece.goLeft();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_D){
					activePiece.rotateClockwise();
				}
				if(e.getKeyCode() == KeyEvent.VK_A){
					activePiece.rotateCounterClockwise();

					if (running) {
						//activePiece.rotateClockwise();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_P){
					running = !running;
				}
				if( (e.getKeyCode() == KeyEvent.VK_S) && (e.getModifiers()&KeyEvent.CTRL_MASK) !=0) {
					Save savefile = new Save(gameGrid);
					savefile.writeToFile("Fichier.txt");
				}
				if(e.getKeyCode() == KeyEvent.VK_L){
					/*String filePath = System.getProperty("user.home");
					File mainDirectory = new File(filePath);
				    if (!mainDirectory.exists()) {
				      mainDirectory.mkdir();
				    }
				    JFileChooser openFile = new JFileChooser(mainDirectory);
				    
				    FileFilter fileTypeFilter = new FileFilter() {
				      public boolean accept(File file) {
				        if (file.isDirectory()) {
				          return true;
				        }
				        String path = file.getAbsolutePath();
				        if (path.endsWith(".txt")) {
				          return true;
				        }
				        return false;
				      }
				      
				      public String getDescription() {
				        return ".txt";
				      }
				    };
				    openFile.addChoosableFileFilter((javax.swing.filechooser.FileFilter) fileTypeFilter);
				    openFile.setFileFilter((javax.swing.filechooser.FileFilter) fileTypeFilter);
				    openFile.showOpenDialog(null);
				    File fileToLoad = openFile.getSelectedFile();
				    if ((fileToLoad == null) || (!fileToLoad.getName().endsWith(".txt"))) {
				      return;
				    }
				    //.read(fileToLoad); // loader le fichier
				    */
					Load loader = new Load(new File("fichier.txt"), gameGrid);
					gameGrid = loader.loadFile();
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
		//position=6;
	    switch(position){
	    	case 0:
	    		activePiece = new O_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 1:
	    		activePiece = new J_Bar(gameGrid.at(3, -2));
	    		break;
	    		
	    	case 2:
	    		activePiece = new L_Bar(gameGrid.at(5, -2));
	    		break;
	    		
	    	case 3:
	    		activePiece = new T_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 4:
	    		activePiece = new I_Bar(gameGrid.at(3, -2));
	    		break;
	    		
	    	case 5:
	    		activePiece = new S_Bar(gameGrid.at(4, -2));
	    		break;
	    		
	    	case 6:
	    		activePiece = new Z_Bar(gameGrid.at(3, -2));
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
			if (running) {
				if(!activePiece.goDown()) {
					if(gameGrid.checkFill()) this.setThepoints();
					if (activePiece.isOutsideGrid()) {
						running = false;
						gameOverLabel.setVisible(true);
					}
					spawnTetromino();
				}
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
	
	public SpaceGrid getGrid() {
		return gameGrid;
	}
}

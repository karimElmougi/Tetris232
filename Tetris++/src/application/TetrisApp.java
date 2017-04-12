package application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Comptage;
import component.GamePanel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TetrisApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TetrisApp window = new TetrisApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TetrisApp() {
		initialize();
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tetris++");
		frame.setBounds(100, 100, 460, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*JPanel panel = new JPanel();
		panel.setBounds(251, 11, 175, 399);
		frame.getContentPane().add(panel);*/
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setBounds(10, 11, 230, 500);
		frame.getContentPane().add(gamePanel);
		gamePanel.requestFocusInWindow();
		
		// comptage
				JTextField tf = new JTextField(); 
				JLabel lb = new JLabel();
				
				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				
				lb.setBounds(270, 11, 80, 40);
				lb.setText("Score");
				lb.setFont(font1);
				
				tf.setBounds(350, 11, 80, 40);
				tf.setBackground(Color.BLACK);
				tf.setForeground(Color.CYAN);
				tf.setText("0");
				tf.setFont(font1);
				tf.setEditable(false);
				//tf.setVisible(true); 
				tf.setHorizontalAlignment(JTextField.CENTER);
			    frame.getContentPane().add(tf);
			    frame.getContentPane().add(lb);
				  
	// observer de etat de gamepanel
	Comptage cm = new Comptage(tf,gamePanel);
		
	}
}

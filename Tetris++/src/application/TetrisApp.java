package application;

import java.awt.EventQueue;

import javax.swing.JFrame;

import component.GamePanel;
import javax.swing.JPanel;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(251, 11, 175, 399);
		frame.getContentPane().add(panel);
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setBounds(10, 11, 230, 500);
		frame.getContentPane().add(gamePanel);
		gamePanel.requestFocusInWindow();
	}
}

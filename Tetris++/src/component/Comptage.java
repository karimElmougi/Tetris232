package component;
import javax.swing.JTextField;

import Observers.Observer;


public class Comptage extends Observer {
	
	JTextField tf;
	public Comptage(JTextField tf,GamePanel subject)
	{
		super();
		this.tf = tf;
	    this.subject = subject;
	    this.subject.attach(this);
	}

	@Override
	   public void update() {
		int a = subject.getThepoints();
	    this.tf.setText(Integer.toString(a)); 
	   }
	
}

package Observers;

import component.GamePanel;

public abstract class Observer {
		   protected GamePanel subject;
		   public abstract void update();
		}



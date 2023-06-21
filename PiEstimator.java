

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PiEstimator{
	//the following code is just to jog your memory about how labels and buttons work!
	//implement your Pi Estimator as described in the project. You may do it all in main below or you 
	//may implement additional functions if you feel it necessary.
	
	public static void sendBack(double estimate, int trialCount) {
		estimatedPi.setText("Estimated PI: " + String.valueOf(estimate));
		trialsCount.setText(String.valueOf(trialCount) + " trials have been run");
	}
	static JLabel estimatedPi = new JLabel();
	static JLabel trialsCount = new JLabel();
	static boolean started = true;
	public static void main(String[] args) {
			PiEstimatorThread thread = new PiEstimatorThread();
		    
		    thread.start();
			
			JFrame frame = new JFrame("Pi Estimator");
		    JPanel listPane = new JPanel();
		    listPane.setLayout(new GridLayout(4, 1));
		    JLabel actualPi = new JLabel();
		    actualPi.setText("Actual PI: " + String.valueOf(Math.PI));
		    listPane.add(actualPi);
		    
		    estimatedPi.setText("N/A");
		    listPane.add(estimatedPi);
		    
		    trialsCount.setText("0 trials have been run");
		    listPane.add(trialsCount);
		    
		    JButton toggleButton = new JButton();
		    toggleButton.setText("Pause");
		    toggleButton.addActionListener(new ActionListener() { 
		    	  public void actionPerformed(ActionEvent e) { 
		    	    if (started == true) {
		    	    	thread.setStarted(false);
		    	    	toggleButton.setText("Start");
		    	    } else {
		    	    	thread.setStarted(true);
		    	    	synchronized (thread) {
		        	    	thread.notify();
		    	    	}
		
		    	    	toggleButton.setText("Pause");
		    	    }
		    	    started = !started;
		    	  }
		    	});
		    
		    listPane.add(toggleButton);
		    frame.add(listPane);
		    frame.setSize(1000,1000);  

		    frame.pack();
		    frame.setVisible(true);
		    
		}  
	
	public static class PiEstimatorThread extends Thread {
		int steps = 0;
		int count = 0;
		boolean started = true;
		
		public void setStarted(boolean newVal) {
			started = newVal;
		}
		public void run() {
			
	     	while (true) {
	     		if (started == false) {
	     			 synchronized (this) {
	     				try {
	     					wait();
	     				} catch (InterruptedException e1) {
	     					// TODO Auto-generated catch block
	     					e1.printStackTrace();
	     				}
	     			}
	     		}
	     		steps++;
	     		count += estimatePi();
	     		if (steps % 10000000 == 0) {
	     			double piEstimate = (double) (4 * count) / steps;

	     			sendBack(piEstimate, steps);
	     		}
	     	}
	     	
	    }
		
		
		private int estimatePi() {
			double x = Math.random();
			double y = Math.random();
			
			if (((x*x) + (y*y)) < 1) {
				return 1;
			}
			
			return 0;
		}
		
	}
	
	

	
	}


package Views;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Controllers.BaseballManagerController;

public class FrameRunner {
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(runner);
	}
	
	static Runnable runner = new Runnable() {
		@Override
		public void run() {
			BaseballManagerFrame frame = new BaseballManagerFrame("Baseball Manager");
			new BaseballManagerController(frame);
			createAndShowGUI(frame);
		}
    };
	
    private static void createAndShowGUI(BaseballManagerFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.setVisible(true);
        frame.setVisibility();
        frame.pack();
    }
}

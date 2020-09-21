package views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class BaseballManagerFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try {
		 * BaseballManagerFrame frame = new BaseballManagerFrame();
		 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
		 */
	}

	/**
	 * Create the frame.
	 */
	    JPanel mainPanel;
	    JPanel manageBullpen;
	    JPanel manageHitting;
	    JPanel manageField;
	    
	    public BaseballManagerFrame(String name) {
	        super(name);
	        setResizable(false);
	        setMainPanel();
	        setHittingPanel();
	        mainPanel.setVisible(false);
	        manageHitting.setVisible(true);
	    }
	    
	    private void setMainPanel() {
	        
	    	mainPanel = new JPanel();
	    	mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	        GridBagLayout gridbag = new GridBagLayout();
	        GridBagConstraints c = new GridBagConstraints();
	        mainPanel.setLayout(gridbag);
	        
	        JLabel label = new JLabel("Team Manager");
	        c.fill = GridBagConstraints.CENTER;
	        c.gridx = 1;
	        c.gridy = 0;
	        c.weightx = 1;
	        c.insets = new Insets(5,5,5,5);
	        mainPanel.add(label, c);

	    	createbutton("Manage Bullpen", gridbag, c, mainPanel, 0, 1);
	    	createbutton("Manage Hitting", gridbag, c, mainPanel, 1, 1);
	    	createbutton("Manage Defense", gridbag, c, mainPanel, 2, 1);
	    	 
	        add(mainPanel);
	    }
	    
	    private void setHittingPanel() {
	    	manageHitting = new JPanel();
	    	manageHitting.setBorder(new EmptyBorder(10, 10, 10, 10));
	        GridBagLayout gridbag = new GridBagLayout();
	        GridBagConstraints c = new GridBagConstraints();
	        manageHitting.setLayout(gridbag);
	        
	        
	        JLabel label = new JLabel("Manage Hitting Line-Up");
	        c.fill = GridBagConstraints.CENTER;
	        c.gridx = 1;
	        c.gridy = 0;
	        c.weightx = 1;
	        c.insets = new Insets(5,5,5,5);
	        manageHitting.add(label, c);
	        
	        createTextField("add player", gridbag, c, manageHitting, 0, 1);
	        createTextField("add player", gridbag, c, manageHitting, 0, 2);
	        createTextField("add player", gridbag, c, manageHitting, 0, 3);
	        createTextField("add player", gridbag, c, manageHitting, 0, 4);
	        createTextField("add player", gridbag, c, manageHitting, 0, 5);
	        createTextField("add player", gridbag, c, manageHitting, 0, 6);
	        createTextField("add player", gridbag, c, manageHitting, 0, 7);
	        createTextField("add player", gridbag, c, manageHitting, 0, 8);
	        createTextField("add player", gridbag, c, manageHitting, 0, 9);
	        createTextField("add player", gridbag, c, manageHitting, 0, 10);
	        
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 1);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 2);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 3);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 4);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 5);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 6);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 7);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 8);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 9);
	    	createbutton("Edit", gridbag, c, manageHitting, 1, 10);
	    	
	        
	        JLabel label2 = new JLabel("Bench");
	        c.fill = GridBagConstraints.CENTER;
	        c.gridx = 2;
	        c.gridy = 1;
	        c.weightx = 1;
	        c.insets = new Insets(5,5,5,5);
	        manageHitting.add(label2, c);
	    	
	    	add(manageHitting);
	    }
	    
	     protected void createbutton(String name, GridBagLayout gridbag,  GridBagConstraints c, JPanel p, int x, int y) {
	         c.gridwidth = 1; //next-to-last in row
	         c.gridx = x;
	         c.gridy = y;
	         c.insets = new Insets(5,5,5,5);
	    	 Button button1 = new Button(name);
	    	 gridbag.setConstraints(button1, c);
	    	 p.add(button1);
	     }
	     
		    
	     protected void createTextField(String text, GridBagLayout gridbag,  GridBagConstraints c, JPanel p, int x, int y) {
	         c.gridx = x;
	         c.gridy = y;
	         c.insets = new Insets(5,5,5,5);
	    	 JTextField field = new JTextField(text, 20);
	    	 field.setEnabled(false);
	    	 gridbag.setConstraints(field, c);
	    	 p.add(field);
	     }
	    
	     
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method is invoked from the
	     * event dispatch thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	    	BaseballManagerFrame frame = new BaseballManagerFrame("GridLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	}

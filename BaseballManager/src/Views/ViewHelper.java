package Views;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewHelper {
	

    protected static void createButton(String name, GridBagLayout gridbag,  GridBagConstraints c, JPanel p, int x, int y, ActionListener action) {
	     c.gridx = x;
	     c.gridy = y;
	     c.insets = new Insets(5,5,5,5);
	   	 Button button = new Button(name);
	     button.addActionListener(action);
	   	 gridbag.setConstraints(button, c);
	   	 p.add(button);
    }
    
    protected static void createTextField(String text, GridBagLayout gridbag,  GridBagConstraints c, JPanel p, int x, int y) {
	     c.gridx = x;
	     c.gridy = y;
	     c.insets = new Insets(5,5,5,5);
	   	 JTextField field = new JTextField(text, 20);
	   	 field.setEnabled(false);
	   	 gridbag.setConstraints(field, c);
	   	 p.add(field);
    }
    
}

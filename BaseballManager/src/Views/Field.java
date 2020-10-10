package Views;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Field {
	JPanel panel;
	
    public JPanel getField() {
    	if(panel == null) {
    		panel = new FieldPanel();
    		panel.setPreferredSize(new Dimension(400,400));
    	}
    	return panel;
    }
}

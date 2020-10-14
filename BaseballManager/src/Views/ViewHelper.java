package Views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Models.PlayerModel;

public class ViewHelper {
	

    protected static void createButton(String name, GridBagConstraints c, JPanel p, int x, int y, ActionListener action) {
	     c.gridx = x;
	     c.gridy = y;
	   	 Button button = new Button(name);
	     button.addActionListener(action);
	   	 p.add(button, c);
    }
    

    protected static void createSizedButton(String name, GridBagConstraints c, JPanel p, int x, int y, ActionListener action, Dimension dim) {
	     c.gridx = x;
	     c.gridy = y;
	   	 Button button = new Button(name);
	   	 button.setPreferredSize(dim);
	     button.addActionListener(action);
	   	 p.add(button, c);
    }
    
    protected static void createTextField(String text, GridBagConstraints c, JPanel p, int x, int y) {
	     c.gridx = x;
	     c.gridy = y;
	   	 JTextField field = new JTextField(text, 20);
	   	 field.setEnabled(false);
	   	 p.add(field, c);
    }
    
    protected static void createFieldLabel(String name, GridBagConstraints c, JPanel p, int x, int y, String player) {
    	 JPanel panel = new JPanel();
    	 panel.setBackground(new Color(Color.TRANSLUCENT));
    	 panel.setOpaque(false);
	   	 GridLayout layout = new GridLayout(2,0);
	   	 panel.setLayout(layout);
	   	 panel.add(getPosition(name + ":"));
	   	 panel.add(getPlayer(player));
	   	 c.gridx = x;
	   	 c.gridy = y;
	   	 p.add(panel, c);
    }

    private static JTextField getPlayer(String name) {
	   	 JTextField field = new JTextField(name) {
		   	    @Override public void setBorder(Border border) {
		 }};
		 field.setHorizontalAlignment(JLabel.CENTER);
		 field.setBackground(new Color(Color.TRANSLUCENT));
		 field.setOpaque(false);
		 field.setEditable(false);
		 field.setFont(getBoldFont());
		 return field;
    }
    
    private static JLabel getPosition(String pos) {
   	   	 JLabel label = new JLabel(pos);
   	   	 label.setHorizontalAlignment(JLabel.CENTER);
	   	 label.setBackground(new Color(Color.TRANSLUCENT));
	   	 label.setOpaque(false);
	   	 label.setFont(getBoldFont());
	   	 return label;
    }
    
    private static Font getBoldFont() {
    	Map<TextAttribute, Object> attributes = new HashMap<>();

    	attributes.put(TextAttribute.FAMILY, Font.DIALOG);
    	attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
    	attributes.put(TextAttribute.SIZE, 14);

   	 	return Font.getFont(attributes);
    }
   
    protected static GridBagConstraints GridBagConstraints() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.insets = new Insets(5,5,5,5);
        return c;
    }
    
    protected static JPanel getGridbagPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        return panel;
    }
}

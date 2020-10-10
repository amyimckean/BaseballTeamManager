package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Models.PlayerModel;

public class Lineup {
	JPanel panel;
	JList list;
	
    @SuppressWarnings("unchecked")
	public JPanel getLineup() {
    	if(panel == null) {
    		panel = new JPanel();
    		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
	        GridBagLayout gridbag = new GridBagLayout();
	        GridBagConstraints c = new GridBagConstraints();
	        panel.setLayout(gridbag);
	        
	        JTable table = new JTable();
	        JLabel label = new JLabel("Manage Hitting Line-Up");
	        panel.add(label);

	        panel.add(table);
	    	 
	        JLabel label2 = new JLabel("Bench");
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx = 2;
	        c.gridy = 1;
	        c.weightx = 1;
	        c.insets = new Insets(5,5,5,5);
	        panel.add(label2, c);
	        
	        list = new JList();
	        c.fill = GridBagConstraints.BOTH;
	        c.gridx = 2;
	        c.gridy = 2;
	        c.weightx = 1;
	        c.insets = new Insets(5,5,5,5);
	        panel.add(list, c);
    	}
    	return panel;
    }
    
    public void setNonPlayingPlayers(ListModel players) {
    	list.setModel(players);
    	list.updateUI();
    }
      
	ActionListener setMain = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
       }
   };
 
}

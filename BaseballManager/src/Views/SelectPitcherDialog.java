package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Pair;
import Models.PitcherModel;
import Models.PlayerModel;

public class SelectPitcherDialog {
	private JDialog dialog;
	private JPanel panel;
	private JComboBox availablePitchers;
	
	
	public JDialog getDialog() {
		if(dialog == null) {
			dialog = new JDialog();
			dialog.setBackground(Color.WHITE);
    		panel = ViewHelper.getGridbagPanel();
    		dialog.add(panel);
    		GridBagConstraints c = ViewHelper.GridBagConstraints();

	        JLabel label = new JLabel("Select Pitcher");
	        c.gridx = 1;
	        c.gridy = 1;
	        panel.add(label, c);
	                
    		availablePitchers = new JComboBox();
    		availablePitchers.setPreferredSize(new Dimension(150, 30));
	        c.gridx = 2;
	        c.gridy = 2;
    		panel.add(availablePitchers, c); 
		}
		
		dialog.pack();
		return dialog;
	}
	
	public void setActionListener(ActionListener listen) {
		GridBagConstraints c = ViewHelper.GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;
        c.anchor = c.SOUTHEAST;
        ViewHelper.createButton("Save", c, panel, 2, 3, listen);
		dialog.pack();
	}
	
	
	public PitcherModel getCurrentPitcher(){
		return (PitcherModel)availablePitchers.getSelectedItem();
	}
	
	public void updateData(DefaultListModel players) {
		DefaultComboBoxModel model = new DefaultComboBoxModel(players.toArray());
		availablePitchers.setModel(model);
	}
}

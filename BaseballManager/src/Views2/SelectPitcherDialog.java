package Views2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import javax.swing.*;
import Models.PitcherModel;


public class SelectPitcherDialog {
	private JDialog dialog;
	private JPanel panel;
	@SuppressWarnings("rawtypes")
	private JComboBox availablePitchers;
	
	
	@SuppressWarnings("rawtypes")
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
        c.anchor = GridBagConstraints.SOUTHEAST;
        ViewHelper.createButton("Save", c, panel, 2, 3, listen);
		dialog.pack();
	}
	
	
	public PitcherModel getCurrentPitcher(){
		return (PitcherModel)availablePitchers.getSelectedItem();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateViewData(DefaultListModel players) {
		DefaultComboBoxModel model = new DefaultComboBoxModel(players.toArray());
		availablePitchers.setModel(model);
	}
}

package Views2;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import Models.Pair;
import Models.PlayerModel;

@SuppressWarnings("rawtypes")
public class EditLineupDialog {
	private JDialog dialog;
	private JPanel panel;
	private JComboBox availablePlayers;
	private JComboBox lineupNumber;
	
	@SuppressWarnings("unchecked")
	public JDialog getDialog() {
		if(dialog == null) {
			dialog = new JDialog();
			dialog.setBackground(Color.WHITE);
    		panel = ViewHelper.getGridbagPanel();
    		dialog.add(panel);
    		GridBagConstraints c = ViewHelper.GridBagConstraints();

	        JLabel label = new JLabel("Update Lineup");
	        c.gridx = 1;
	        c.gridy = 1;
	        c.gridwidth=2;
	        panel.add(label, c);
	                
    		String Lineup[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
    		lineupNumber = new JComboBox(Lineup);
	        c.gridx = 1;
	        c.gridy = 2;
	        c.gridwidth=1;
    		panel.add(lineupNumber, c);  
    		availablePlayers = new JComboBox();
    		availablePlayers.setPreferredSize(new Dimension(150, lineupNumber.getPreferredSize().height));
	        c.gridx = 2;
	        c.gridy = 2;
    		panel.add(availablePlayers, c); 
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
	
	public Pair getCurrentPlayer(){
		return new Pair((PlayerModel)availablePlayers.getSelectedItem(), (String)lineupNumber.getSelectedItem());
	}
	
	@SuppressWarnings("unchecked")
	public void updateViewData(DefaultListModel players) {
			DefaultComboBoxModel model = new DefaultComboBoxModel(players.toArray());
			availablePlayers.setModel(model);
	}
}
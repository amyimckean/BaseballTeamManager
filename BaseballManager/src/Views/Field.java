package Views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import DataProviders.LineupDataProvider;
import Enums.LeftRightEnum;
import Enums.PositionEnum;
import Models.PlayerModel;

public class Field {
	JPanel panel;
	List<PlayerModel> players;
	
    public JPanel getField() {
    	if(panel == null) {
    		panel = new FieldPanel();
    		panel.setPreferredSize(new Dimension(600,500));
    	}
    	return panel;
    }
    
    public void updateData(List<PlayerModel> players) {
    	this.players = players;
    	setField();
    	panel.updateUI();
    }
    
    private void setField() {
    	panel.removeAll();
		JPanel internalPanel = new JPanel();
		internalPanel.setBackground(new Color(Color.TRANSLUCENT));
		internalPanel.setOpaque(false);
        GridBagLayout gridbag = new GridBagLayout();
        internalPanel.setLayout(gridbag);
        GridBagConstraints c = ViewHelper.GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        internalPanel.add(getTopPanel(), c);
        c.gridy = 1;
        internalPanel.add(getBottomPanel(), c);  		
		panel.add(internalPanel);
    }
    
    private JPanel getTopPanel() {
    	JPanel topPanel = getTransparentPanel();
		GridBagConstraints c = ViewHelper.GridBagConstraints();
	    c.insets = new Insets(20,10,20,10);
		ViewHelper.createFieldLabel(PositionEnum.centerfield.toString(), c, topPanel, 3, 0, getPlayer(PositionEnum.centerfield)); 	
		ViewHelper.createFieldLabel(PositionEnum.leftfield.toString(), c, topPanel, 1, 1, getPlayer(PositionEnum.leftfield)); 	  
		ViewHelper.createFieldLabel(PositionEnum.rightfield.toString(), c, topPanel, 5, 1, getPlayer(PositionEnum.rightfield)); 	    		
		ViewHelper.createFieldLabel(PositionEnum.shortstop.toString(), c, topPanel, 2, 2, getPlayer(PositionEnum.shortstop)); 	    		
		ViewHelper.createFieldLabel(PositionEnum.second.toString(), c, topPanel, 4, 2, getPlayer(PositionEnum.second)); 	   
		return topPanel;
    }
    
    private String getPlayer(PositionEnum pos) {
    	if(players != null) {
    		if(players.stream().anyMatch(x -> x.getPosition() == pos)) {
    			return players.stream().filter(x -> x.getPosition() == pos).findFirst().get().getName();
    		}
    		return "None";
    	}
    	return "None";
    }
    
    private JPanel getBottomPanel() {
    	JPanel bottomPanel = getTransparentPanel();
		GridBagConstraints c = ViewHelper.GridBagConstraints();
	    c.insets = new Insets(10,10,10,10);
		ViewHelper.createFieldLabel(PositionEnum.third.toString(), c, bottomPanel, 0, 0, getPlayer(PositionEnum.third)); 	
		ViewHelper.createFieldLabel(PositionEnum.pitcher.toString(), c, bottomPanel, 1, 0, getPlayer(PositionEnum.pitcher)); 	
		ViewHelper.createFieldLabel(PositionEnum.first.toString(), c, bottomPanel, 2, 0, getPlayer(PositionEnum.first)); 	
	    c.insets = new Insets(75,20,20,20);
		ViewHelper.createFieldLabel(PositionEnum.catcher.toString(), c, bottomPanel, 1, 1, getPlayer(PositionEnum.catcher)); 	  
		return bottomPanel;
    }
    
    private JPanel getTransparentPanel() {
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(Color.TRANSLUCENT));
    	panel.setOpaque(false);
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
    	panel.setBorder(new EmptyBorder(25,10,0,0));
    	return panel;
    }
}

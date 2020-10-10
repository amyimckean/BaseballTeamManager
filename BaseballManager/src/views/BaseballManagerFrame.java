package Views;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Models.*;
import java.util.List;
import Enums.ViewEnum;

@SuppressWarnings("serial")
public class BaseballManagerFrame extends JFrame implements Observer {
		MainPanel mainPanel;
		Lineup lineup;
	    JPanel manageBullpen;
	    Field field;
	    
	    public BaseballManagerFrame(String name) {
	        super(name);
	        setResizable(true);
	        mainPanel = new MainPanel();
	        mainPanel.addObserver(this);
	        lineup = new Lineup();
	        field = new Field();
	        setFrame();
	    } 
	    
	    boolean first = true;
	    public void setVisibility() {
	    	if(!first) {mainPanel.getTeamLabel().setVisible(false);}
	    	lineup.getLineup().setVisible(mainPanel.getView() == ViewEnum.Lineup ? true : false);
	       // manageBullpen.setVisible(mainPanel.getView() == ViewEnum.Bullpen ? true : false);
	    	field.getField().setVisible(mainPanel.getView() == ViewEnum.Field ? true : false);
	    	first = false;
	    }
	    
	    public void setData(ListModel players) {
	    	lineup.setNonPlayingPlayers(players);
	    }
	    
		public void update(Observable o, Object arg) {
			setVisibility();
	        pack();
		}
		
	     protected void setFrame() {
	        GridBagLayout gridbag = new GridBagLayout();
	        GridBagConstraints c = new GridBagConstraints();
	        setLayout(gridbag);
	        c.insets = new Insets(5,5,5,5);
	        c.weightx = 1.0;
	        c.weighty = 1.0;
	        c.gridx = 0;
	        c.gridy = 1;
	    	gridbag.setConstraints(mainPanel.getMainPanel(), c);
	    	this.add(mainPanel.getMainPanel());
	        c.gridy = 0;
	    	gridbag.setConstraints(lineup.getLineup(), c);
	    	this.add(lineup.getLineup());
	    	gridbag.setConstraints(field.getField(), c);
	    	this.add(field.getField());
	     }
	}

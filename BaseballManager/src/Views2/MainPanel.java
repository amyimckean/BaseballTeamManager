package Views2;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enums.ViewEnum;

public class MainPanel extends Observable {
	JLabel teamLabel;
	ViewEnum view  = ViewEnum.Main;
	JPanel panel;
	
    public JPanel getMainPanel() {
        if(panel == null) {
        	panel = ViewHelper.getGridbagPanel();
        	panel.setBorder(new EmptyBorder(5, 50, 5, 50));
	        GridBagConstraints c = ViewHelper.GridBagConstraints();

		    teamLabel = new JLabel("Team Manager");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.gridx = 1;
		    c.gridy = 0;
		    c.weightx = 1;
		    c.insets = new Insets(5,5,5,5);
		    panel.add(teamLabel, c);
			ViewHelper.createButton("Manage Bullpen", c, panel, 0, 2, setBullpen);
			ViewHelper.createButton("Manage Hitting", c, panel, 1, 2, setHitting);
			ViewHelper.createButton("Manage Defense", c, panel, 2, 2, setFielding);
        }
        return panel;
    }
        
	public JLabel getTeamLabel() {
		return teamLabel;
	}
	
	public ViewEnum getView() {
		return view;
	}
	
   
	ActionListener setMain = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
	        view = ViewEnum.Main;
	        ViewChanged();
       }
   };
 
     ActionListener setBullpen = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	        view = ViewEnum.Bullpen;
	        ViewChanged();
        }
    };
     
     ActionListener setHitting = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	        view = ViewEnum.Lineup;
	        ViewChanged();
        }
    };
     
     ActionListener setFielding = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
	        view = ViewEnum.Field;
	        ViewChanged();
        }
    };
    
    public void ViewChanged() {
    	setChanged();
    	notifyObservers();
    }
 
}

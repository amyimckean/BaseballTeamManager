package Views;

import java.awt.*;
import javax.swing.*;
import Controllers.BaseballManagerController;
import Enums.ViewEnum;
import Models.*;
import Observer.*;

@SuppressWarnings("serial")
public class BaseballManagerFrame extends JFrame implements MainObserver {
		MainPanel mainPanel;
		Lineup lineup;
	    Bullpen bullpen;
	    Field field;
	    JPanel internalPanel;
		EditLineupDialog editDialog;
	    
	    public BaseballManagerFrame(String name) {
	        super(name);
	        setResizable(true);
	        internalPanel = new JPanel();
	        internalPanel.setBackground(Color.white);
	        mainPanel = new MainPanel();
	        mainPanel.registerObserver(this);
	        lineup = new Lineup();
	        field = new Field();
	        bullpen = new Bullpen();
	        editDialog = new EditLineupDialog();
	        setFrame();
	        
	    } 
	    
	    public void setObservers(BaseballManagerController controller) {
	    	bullpen.registerObserver(controller);
	    	editDialog.registerObserver(controller);
	    	
	    }
	    
	    boolean first = true;
	    public void setVisibility(ViewEnum view) {
	    	if(!first) {mainPanel.getTeamLabel().setVisible(false);}
	    	lineup.getLineup().setVisible(view == ViewEnum.Lineup ? true : false);
	        bullpen.getBullpen().setVisible(view == ViewEnum.Bullpen ? true : false);
	    	field.getField().setVisible(view == ViewEnum.Field ? true : false);
	    	first = false;
	    }
	    
	    public void setData(DefaultListModel<PlayerModel> players, PlayerTableModel lineupPlayers, PitcherTableModel pitchers, DefaultListModel<PitcherModel> allPitchers) {
	    	editDialog.updateViewData(players);
	    	lineup.updateViewData(players, lineupPlayers);
	    	field.updateViewData(lineupPlayers.getDataModel());
	    	bullpen.updateViewData(pitchers);
	    }

		public void Update(ViewEnum view) {
			setVisibility(view);
	        pack();	
		}

	     protected void setFrame() {
	    	add(internalPanel);
	        GridBagLayout gridbag = new GridBagLayout();
	        internalPanel.setLayout(gridbag);
	        GridBagConstraints c = ViewHelper.GridBagConstraints();
	        c.gridx = 0;
	        c.gridy = 1;
	        internalPanel.add(mainPanel.getMainPanel(), c);
	        c.gridy = 0;
	        lineup.setLineupEditor(editDialog.getDialog());
	        internalPanel.add(lineup.getLineup(), c);
	        internalPanel.add(field.getField(), c);
	        internalPanel.add(bullpen.getBullpen(), c);
	     }
	}

package Views;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import Models.*;
import java.util.List;
import Enums.ViewEnum;

@SuppressWarnings("serial")
public class BaseballManagerFrame extends JFrame implements Observer {
		MainPanel mainPanel;
		Lineup lineup;
	    Bullpen bullpen;
	    Field field;
	    JPanel internalPanel;
		EditLineupDialog editDialog;
		SelectPitcherDialog selectDialog;
	    
	    public BaseballManagerFrame(String name) {
	        super(name);
	        setResizable(true);
	        internalPanel = new JPanel();
	        internalPanel.setBackground(Color.white);
	        mainPanel = new MainPanel();
	        mainPanel.addObserver(this);
	        lineup = new Lineup();
	        field = new Field();
	        bullpen = new Bullpen();
	        editDialog = new EditLineupDialog();
	        selectDialog = new SelectPitcherDialog();
	        setFrame();
	        
	    } 
	    
	    boolean first = true;
	    public void setVisibility() {
	    	if(!first) {mainPanel.getTeamLabel().setVisible(false);}
	    	lineup.getLineup().setVisible(mainPanel.getView() == ViewEnum.Lineup ? true : false);
	        bullpen.getBullpen().setVisible(mainPanel.getView() == ViewEnum.Bullpen ? true : false);
	    	field.getField().setVisible(mainPanel.getView() == ViewEnum.Field ? true : false);
	    	first = false;
	    }
	    
	    public void setData(DefaultListModel<PlayerModel> players, PlayerTableModel lineupPlayers, PitcherTableModel pitchers, DefaultListModel<PitcherModel> allPitchers) {
	    	editDialog.updateData(players);
	    	lineup.updateData(players, lineupPlayers);
	    	field.updateData(lineupPlayers.getDataModel());
	    	bullpen.updateData(pitchers);
	    	selectDialog.updateData(allPitchers);
	    }
	    
		public void update(Observable o, Object arg) {
			setVisibility();
	        pack();
		}
		
		public Pair getUpdatedPlayer() {
			return editDialog.getCurrentPlayer();
		}
		
		public PitcherModel getUpdatedPitcher() {
			return selectDialog.getCurrentPitcher();
		}
		
		public void setPlayerUpdateAction(ActionListener listen) {
			editDialog.setActionListener(listen);
		}
		
		public void setPitcherUpdateAction(ActionListener listen) {
			selectDialog.setActionListener(listen);
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
	        bullpen.setPitcherSelection(selectDialog.getDialog());
	        internalPanel.add(lineup.getLineup(), c);
	        internalPanel.add(field.getField(), c);
	        internalPanel.add(bullpen.getBullpen(), c);
	     }
	}

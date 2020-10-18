package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import Enums.PositionEnum;
import Models.*;
import Observer.PlayerNotifier;

public class Bullpen  extends PlayerNotifier {
	private JPanel panel;
	private JTable pitchTable;
	private JTable playerTable;
	private PitcherTableModel pitcherModel;
	private JTextField currentPitcher;
	
	public JPanel getBullpen() {
    	if(panel == null) {
    		panel = ViewHelper.getGridbagPanel();
    		GridBagConstraints c = ViewHelper.GridBagConstraints();

	        JLabel label = ViewHelper.getLabel("Bullpen");
	        c.gridx = 0;
	        c.gridy = 0;
	        panel.add(label, c);

	        c.gridy = 1;
	        playerTable = getTableControl(true);
	        JPanel tablePanel = getTablePanel(playerTable, new Dimension(300, 105));
	        ViewHelper.createSizedButton("Select Pitcher", c, tablePanel, 0, 1, setPlayer, new Dimension(300, 30));
			c.anchor = c.NORTH;
	        panel.add(tablePanel, c);

	        c.gridy = 2;
	        JPanel pitcherLabel = getCurrentPitcherPanel();
	        panel.add(pitcherLabel, c);
	        
	        JLabel label2 = ViewHelper.getLabel("Pitches");
	        c.gridx = 1;
	        c.gridy = 0;
	        panel.add(label2, c);
	        
	        pitchTable = getTableControl(false);
	        JPanel pitchTablePanel = getTablePanel(pitchTable, new Dimension(130, 90));
	        c.gridy = 1;
	        panel.add(pitchTablePanel, c);     
    	}
    	return panel;
    }
    
    private JTable getTableControl(boolean addListener) {     
        JTable table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(addListener) {
        	table.getSelectionModel().addListSelectionListener(selectionChangedListener);
        }
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        return table;
 
    }
    
    private JPanel getTablePanel(JTable table, Dimension dim) {
        JPanel tablePanel = ViewHelper.getGridbagPanel();
		GridBagConstraints c = ViewHelper.GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(dim);
        tablePanel.add(scrollPane, c);
    	return tablePanel;
    }

    private JPanel getCurrentPitcherPanel() {
   	 	JPanel panel = new JPanel();
   	 	panel.setBackground(new Color(Color.TRANSLUCENT));
   	 	panel.setOpaque(false);
	   	GridLayout layout = new GridLayout(0, 2);
	   	panel.setLayout(layout);
	   	panel.add(ViewHelper.getLabel("Current Pitcher: "));
	   	currentPitcher = ViewHelper.getPlayer("None");
	   	panel.add(currentPitcher);
	   	return panel;
	   
    }
    
    private ListSelectionListener selectionChangedListener = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent lse) {
        	int index = playerTable.getSelectedRow() >= 0 ? playerTable.getSelectedRow() : 0;
        	PitcherModel pitch = pitcherModel.getCurrentModel(index);
        	pitchTable.setModel(new PitchTableModel(pitch.pitches));
        }
    };
    
    public void updateViewData(PitcherTableModel pitchers, List<PlayerModel> players) {
    	pitcherModel = pitchers;
    	playerTable.clearSelection();
    	playerTable.setModel(pitchers);
    	playerTable.getColumnModel().getColumn(0).setPreferredWidth(20);
    	playerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
    	playerTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        for(int i = 0; i < 3; ++i) {
        	playerTable.getColumnModel().getColumn(i).setCellRenderer(centerData());
        }
        
        pitchTable.setModel(new PitchTableModel(pitcherModel.getCurrentModel(0).pitches));
        pitchTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        pitchTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        playerTable.setRowSelectionInterval(0, 0);
        
		if(players.stream().anyMatch(x -> x.getPosition() == PositionEnum.pitcher)) {
			currentPitcher.setText(players.stream().filter(x -> x.getPosition() == PositionEnum.pitcher).findFirst().get().getName());
		}
    }
    
    ActionListener setPlayer = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
       		int index = playerTable.getSelectedRow() >= 0 ? playerTable.getSelectedRow() : 0;
       		PitcherModel pitcher = pitcherModel.getCurrentModel(index);
       		if(pitcher != null) {
       			setNotifierValue(9, pitcher, true);
	    		notifyObservers();
       		}
       }
   };
    
   public DefaultTableCellRenderer centerData() {
	   DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	   centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	   return centerRenderer;
   }

}
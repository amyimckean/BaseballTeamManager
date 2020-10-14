package Views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import Models.PitchTableModel;
import Models.PitcherModel;
import Models.PitcherTableModel;
import Models.PlayerTableModel;

public class Bullpen {
	private JPanel panel;
	private JTable pitchTable;
	private JTable playerTable;
	private JDialog dialog;
	private PitcherTableModel pitcherModel;
	private PitchTableModel pitchModel;
	
	public JPanel getBullpen() {
    	if(panel == null) {
    		panel = ViewHelper.getGridbagPanel();
    		GridBagConstraints c = ViewHelper.GridBagConstraints();

	        JLabel label = new JLabel("Bullpen");
	        c.gridx = 1;
	        c.gridy = 1;
	        panel.add(label, c);

	        c.gridx = 1;
	        c.gridy = 2;
	        c.anchor = c.NORTH;
	        panel.add(getTableControl(), c);
	        JLabel label2 = new JLabel("Pitches");
	        c.anchor = c.CENTER;
	        c.gridx = 2;
	        c.gridy = 1;
	        panel.add(label2, c);
	        
	        pitchTable = new JTable();
	        c.fill = GridBagConstraints.BOTH;
	        c.gridx = 2;
	        c.gridy = 2;
	        panel.add(pitchTable, c);
    	}
    	return panel;
    }
    
    private JPanel getTableControl() {     
        JPanel tablePanel = ViewHelper.getGridbagPanel();
		GridBagConstraints c = ViewHelper.GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        playerTable = new JTable();
        playerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playerTable.getSelectionModel().addListSelectionListener(selectionChangedListener);
        playerTable.setShowGrid(false);
        playerTable.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(playerTable);
        scrollPane.setPreferredSize(new Dimension(300, 105));
        tablePanel.add(scrollPane, c);
        ViewHelper.createSizedButton("Select Pitcher", c, tablePanel, 0, 1, editLineup, new Dimension(300, 30));
    	return tablePanel;
    }
    
    private ListSelectionListener selectionChangedListener = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent lse) {
        	int index = playerTable.getSelectedRow() >= 0 ? playerTable.getSelectedRow() : 0;
        	PitcherModel pitch = pitcherModel.getCurrentModel(index);
        	pitchTable.setModel(new PitchTableModel(pitch.pitches));
        }
    };
    
    public void updateData(PitcherTableModel pitchers) {
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
    }
    
    
    public void setPitcherSelection(JDialog dialog) {
    	this.dialog = dialog;
    }
      

	ActionListener editLineup = new ActionListener() {
       public void actionPerformed(ActionEvent e) {
    	   dialog.setVisible(true);
       }
   };
   
   public DefaultTableCellRenderer centerData() {
	   DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	   centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	   return centerRenderer;
   }

}
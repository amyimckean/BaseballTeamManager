package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Lineup {
	private JPanel panel;
	private JList list;
	private JTable table;
	private JDialog dialog;
	
	public JPanel getLineup() {
    	if(panel == null) {
    		panel = ViewHelper.getGridbagPanel();
    		GridBagConstraints c = ViewHelper.GridBagConstraints();

	        JLabel label = ViewHelper.getLabel("Manage Hitting Line-Up");
	        c.gridx = 1;
	        c.gridy = 1;
	        panel.add(label, c);

	        c.gridx = 1;
	        c.gridy = 2;
	        panel.add(getTableControl(), c);
	        JLabel label2 = ViewHelper.getLabel("Bench");
	        c.anchor = GridBagConstraints.CENTER;
	        c.gridx = 2;
	        c.gridy = 1;
	        panel.add(label2, c);
	        
	        list = new JList();
	        c.insets = new Insets(15,5,5,5);
	        c.fill = GridBagConstraints.BOTH;
	        c.gridx = 2;
	        c.gridy = 2;
	        panel.add(list, c);
    	}
    	return panel;
    }
    
    private JPanel getTableControl() {     
        JPanel tablePanel = ViewHelper.getGridbagPanel();
		GridBagConstraints c = ViewHelper.GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        table = new JTable();
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(400, 170));
        tablePanel.add(scrollPane, c);
        ViewHelper.createSizedButton("Edit Line-Up", c, tablePanel, 0, 1, editLineup, new Dimension(400, 30));
    	return tablePanel;
    }
    
    public void updateViewData(ListModel<?> players, TableModel tplayers) {
    	list.setModel((ListModel<?>) players);
    	table.setModel(tplayers);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(40);
        for(int i = 0; i < 4; ++i) {
        	table.getColumnModel().getColumn(i).setCellRenderer(centerData());
        }
    }
    
    public void setLineupEditor(JDialog dialog) {
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

package Models1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

public class PitcherTableModel extends AbstractTableModel  {
	List<PlayerModel> pitchers;
    private static final String[] columns = new String[] {"Number", "Player", "Bats/Throws"};
    private static final Class<?>[] ctypes = new Class<?>[] {String.class, String.class, String.class};
	
	public PitcherTableModel(List<PlayerModel> pitcher) {
		this.pitchers = pitcher;
		
	}
	
	public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
	
	@Override
	public Class<?> getColumnClass(int index) {
	    return ctypes[index];
	}

	@Override
	public int getRowCount() {
		return pitchers.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return pitchers.get(rowIndex).getNumber();
			case 1: return pitchers.get(rowIndex).getName();
			case 2: return pitchers.get(rowIndex).getBats() + "/" + pitchers.get(rowIndex).getThrows();
			default: return "";
		}
	}
	
	public PitcherModel getCurrentModel(int i) {
		return (PitcherModel)pitchers.get(i);
	}
}

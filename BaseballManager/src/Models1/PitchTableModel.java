package Models1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

public class PitchTableModel extends AbstractTableModel  {
	List<PitchModel> pitches;
    private static final String[] columns = new String[] {"Pitch", "Speed"};
    private static final Class<?>[] ctypes = new Class<?>[] {String.class, String.class};
	
	public PitchTableModel(List<PitchModel> pitches) {
		this.pitches = pitches;
		
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
		return pitches.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		pitches.get(rowIndex);
		switch(columnIndex) {
			case 0: return pitches.get(rowIndex).pitch.toString();
			case 1: return pitches.get(rowIndex).speed;
			default: return "";
		}
	}

}

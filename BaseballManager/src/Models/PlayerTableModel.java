package Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class PlayerTableModel extends AbstractTableModel  {
	List<PlayerModel> players;
    private static final String[] columns = new String[] {"Line-Up", "Number", "Player", "Bats/Throws"};
    private static final Class<?>[] ctypes = new Class<?>[] {String.class, String.class, String.class, String.class};
	
	public PlayerTableModel(List<PlayerModel> players) {
		this.players = players;
		
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
		return 9;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PlayerModel player;
		Optional<PlayerModel> playerTemp = null;
		try {
			playerTemp = players.stream().filter(x -> x.getLineupPos() == rowIndex+ 1).findFirst();
		}
		catch(Exception e) {
			player = null;
		}

		player = playerTemp.isPresent() ? playerTemp.get() : null;
		switch(columnIndex) {
			case 0: return rowIndex + 1;
			case 1: return player == null ? "Empty" : "#" + player.getNumber();
			case 2: return player == null ? "" : player.getName();
			case 3: return player == null ? "" : player.getBats().toString() + "/" + player.getThrows();
			default: return "";
		}
	}
	
	public List<PlayerModel> getDataModel(){
		return players.stream().filter(x -> x.getInTheGame()).collect(Collectors.toList());
	}
}

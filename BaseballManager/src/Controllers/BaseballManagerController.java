package Controllers;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Enums.PlayerTypeEnum;
import Factories.CurrentTeam;
import Models.*;
import Views.BaseballManagerFrame;

public class BaseballManagerController {

	BaseballManagerFrame frame;
	List<PlayerModel> players;
	List<PitcherModel> pitchers;
	TableModel currentLineUpModel;
	DefaultListModel<PlayerModel> nonLineUpPlayers;
	
	public BaseballManagerController(BaseballManagerFrame frame) {
		this.frame = frame;
		CurrentTeam team = new CurrentTeam();
		this.players = team.GetPlayers(PlayerTypeEnum.Position);
	}
	
	public TableModel getPlayerTableModel() {
		return currentLineUpModel;
	}
	
	public ListModel<PlayerModel> getNonLineUpPositionPlayers() {
		nonLineUpPlayers = new DefaultListModel<PlayerModel>();
		for(int i = 0; i < players.size(); ++i){
			nonLineUpPlayers.addElement(players.get(i));
		}
		return nonLineUpPlayers;
	}
		
	public TableModel getLineUpPositionPlayers() {
		currentLineUpModel = new DefaultTableModel();
		for(int i = 0; i < players.size(); ++i){
			nonLineUpPlayers.add(i, players.get(i));
		}
		return currentLineUpModel;
	}
	
	
}

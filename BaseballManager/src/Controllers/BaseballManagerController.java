package Controllers;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import Enums.PlayerTypeEnum;
import Factories.CurrentTeam;
import Models.*;
import Observer.PlayerObserver;
import Views.BaseballManagerFrame;

public class BaseballManagerController implements PlayerObserver {

	BaseballManagerFrame frame;
	List<PlayerModel> players;
	List<PlayerModel> pitchers;
	PlayerTableModel currentLineUpModel;
	PitcherTableModel bullpenLineupModel;
	DefaultListModel<PlayerModel> nonLineUpPlayers;
	DefaultListModel<PitcherModel> allPitchers;
	
	public BaseballManagerController(BaseballManagerFrame frame) {
		this.frame = frame;
		CurrentTeam team = new CurrentTeam();
		this.players = team.GetPlayers(PlayerTypeEnum.Position);
		this.pitchers = team.GetPlayers(PlayerTypeEnum.Pitcher); 
		frame.setObservers(this);
		frame.setData(getNonLineUpPositionPlayers(), getLineUpPositionPlayers(), getBullpenPitchers(), getPitchers());
	}

	public DefaultListModel<PlayerModel> getNonLineUpPositionPlayers() {
		nonLineUpPlayers = new DefaultListModel<PlayerModel>();
		List<PlayerModel> nonPlayingPlayers = players.stream().filter(x -> x.getInTheGame() == false).collect(Collectors.toList());
		for(int i = 0; i < nonPlayingPlayers.size(); ++i){
			nonLineUpPlayers.addElement(nonPlayingPlayers.get(i));
		}
		return nonLineUpPlayers;
	}
	
	public DefaultListModel<PitcherModel> getPitchers() {
		allPitchers = new DefaultListModel<PitcherModel>();
		for(int i = 0; i < pitchers.size(); ++i){
			allPitchers.addElement((PitcherModel) pitchers.get(i));
		}
		return allPitchers;
	}		
		
	public PlayerTableModel getLineUpPositionPlayers() {
		return new PlayerTableModel(players);
	}
	
	public PitcherTableModel getBullpenPitchers() {
		return new PitcherTableModel(pitchers);
	}
	
	@Override
	public void Update(int index, PlayerModel player, boolean remove) {
		if(remove) {
			updatePitcher(index, player);
		}
		else {
			updatePlayer(index, player);
		}
		 frame.setData(getNonLineUpPositionPlayers(), getLineUpPositionPlayers(), getBullpenPitchers(), getPitchers());
	}
	
	private void updatePlayer(int index, PlayerModel player) {
   	 if(players.stream().anyMatch(x -> x.getLineupPos() == index && x.getInTheGame())) {
   		 players.stream().filter(x -> x.getLineupPos() == index).findFirst().get().setInTheGame(false);
   		 players.stream().filter(x -> x.getLineupPos() == index).findFirst().get().setLineupPos(0);
   	 }
		 players.stream().filter(x -> x.getNumber() == player.getNumber()).findFirst().get().setInTheGame(true);
		 players.stream().filter(x -> x.getNumber() == player.getNumber()).findFirst().get().setLineupPos(index);
	}
	
	private void updatePitcher(int index, PlayerModel player) {
	 	 if(players.stream().anyMatch(x -> x.getLineupPos() == index)) {
	 		 players.get(index).setInTheGame(true);
	 		 players.get(index).setLineupPos(0);
	 		 players.remove(index);
	 	 }
	 	 player.setInTheGame(true);
	 	 player.setLineupPos(index);
	     players.add(index, player);
	}
}


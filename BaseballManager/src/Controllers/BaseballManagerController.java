package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

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
		frame.setData(getNonLineUpPositionPlayers(), getLineUpPositionPlayers(), getBullpenPitchers(), getPitchers());
		frame.setPlayerUpdateAction(saveLineup);
		frame.setPitcherUpdateAction(savePitcher);
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
	
	 ActionListener saveLineup = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
    	 int index = frame.getUpdatedPlayer().getIndex();
    	 PlayerModel newPlayer = frame.getUpdatedPlayer().getPlayer();
    	 if(players.stream().anyMatch(x -> x.getLineupPos() == index && x.getInTheGame())) {
    		 players.stream().filter(x -> x.getLineupPos() == index).findFirst().get().setInTheGame(false);
    		 players.stream().filter(x -> x.getLineupPos() == index).findFirst().get().setLineupPos(0);
    	 }
		 players.stream().filter(x -> x.getNumber() == newPlayer.getNumber()).findFirst().get().setInTheGame(true);
		 players.stream().filter(x -> x.getNumber() == newPlayer.getNumber()).findFirst().get().setLineupPos(index);
		 frame.setData(getNonLineUpPositionPlayers(), getLineUpPositionPlayers(), getBullpenPitchers(), getPitchers());
     }
	};
 
	  ActionListener savePitcher = new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		 int index = 9; //Index for the pitcher
	 	 PitcherModel newPitcher = frame.getUpdatedPitcher();
	 	 if(players.stream().anyMatch(x -> x.getLineupPos() == index)) {
	 		 players.get(index).setInTheGame(true);
	 		 players.get(index).setLineupPos(0);
	 		 players.remove(index);
	 	 }
	 	 newPitcher.setInTheGame(true);
	 	 newPitcher.setLineupPos(index);
	     players.add(8, newPitcher);
		 frame.setData(getNonLineUpPositionPlayers(), getLineUpPositionPlayers(), getBullpenPitchers(), getPitchers());
	  }
	};
}


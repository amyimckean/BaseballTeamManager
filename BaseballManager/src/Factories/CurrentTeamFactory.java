package Factories;

import java.util.ArrayList;
import java.util.List;

import DataProviders.LineupDataProvider;
import Models.*;

public class CurrentTeamFactory implements PlayerFactory {

	public List<? extends PlayerModel> GetPitchers() {
		ArrayList<PitcherModel> pitchers = new ArrayList<PitcherModel>();
		pitchers.add(LineupDataProvider.GetPitcher1());
		pitchers.add(LineupDataProvider.GetPitcher2());
		pitchers.add(LineupDataProvider.GetPitcher3());
		pitchers.add(LineupDataProvider.GetPitcher4());
		pitchers.add(LineupDataProvider.GetPitcher5());
		for(int i = 0; i < pitchers.size(); ++i){
			pitchers.get(i).setNumber(i);
		}
		return pitchers;
	}

	public List<PlayerModel> GetPlayers() {
		ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
		players.add(LineupDataProvider.GetPlayer1());
		players.add(LineupDataProvider.GetPlayer2());
		players.add(LineupDataProvider.GetPlayer3());
		players.add(LineupDataProvider.GetPlayer4());
		players.add(LineupDataProvider.GetPlayer5());
		players.add(LineupDataProvider.GetPlayer6());
		players.add(LineupDataProvider.GetPlayer7());
		players.add(LineupDataProvider.GetPlayer8());
		players.add(LineupDataProvider.GetPlayer9());
		players.add(LineupDataProvider.GetPlayer10());
		players.add(LineupDataProvider.GetPlayer11());
		players.add(LineupDataProvider.GetPlayer12());
		for(int i = 0; i < players.size(); ++i){
			players.get(i).setNumber(i+10);
		}
		return players;
	}
}

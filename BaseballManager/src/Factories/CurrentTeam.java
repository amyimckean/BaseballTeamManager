package Factories;

import java.util.List;

import Enums.PlayerType;
import models.PlayerModel;
public class CurrentTeam {
	
	public List<PlayerModel> GetPlayers(PlayerType type){
		CurrentTeamFactory factory = new CurrentTeamFactory();
		switch(type) {
		case Pitcher:
			return (List<PlayerModel>) factory.GetPitchers();
		case Position:
			return factory.GetPlayers();
		}
		return null;
	}

}

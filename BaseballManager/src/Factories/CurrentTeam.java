package Factories;

import java.util.List;

import Enums.PlayerTypeEnum;
import models.PlayerModel;
public class CurrentTeam {
	
	@SuppressWarnings("unchecked")
	public List<PlayerModel> GetPlayers(PlayerTypeEnum type){
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

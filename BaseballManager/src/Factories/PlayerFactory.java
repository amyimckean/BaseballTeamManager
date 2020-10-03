package Factories;

import java.util.List;

import models.PlayerModel;

public interface PlayerFactory<T> {
	
	public List<PlayerModel> GetPitchers();	
	public List<PlayerModel> GetPlayers();
}

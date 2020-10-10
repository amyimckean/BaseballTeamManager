package Factories;

import java.util.List;

import Models.PlayerModel;

public interface PlayerFactory<T> {
	
	public List<PlayerModel> GetPitchers();	
	public List<PlayerModel> GetPlayers();
}

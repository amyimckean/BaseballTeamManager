package Observer;

import java.util.ArrayList;
import java.util.List;
import Models.PlayerModel;

public class PlayerNotifier {
	private List<PlayerObserver> observers;
	private PlayerModel player;
	private int index;
	private boolean remove;
	
	public PlayerNotifier() {
		observers = new ArrayList<PlayerObserver>();
	}
	
	public void registerObserver(PlayerObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(PlayerObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (PlayerObserver observer : observers) {
			observer.Update(index, player, remove);
		}
	}
	
	public void setNotifierValue(int index, PlayerModel player, boolean remove) {
		this.index = index;
		this.player = player;
		this.remove = remove;
	}
	
}

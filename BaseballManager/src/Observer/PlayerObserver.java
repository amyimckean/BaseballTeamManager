package Observer;

import Models.PlayerModel;

public interface PlayerObserver {
	public void Update(int index, PlayerModel player, boolean remove);

}

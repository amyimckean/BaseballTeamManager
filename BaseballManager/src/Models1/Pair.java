package Models1;

public class Pair {
	private PlayerModel value;
	private int index;
	
	public Pair(PlayerModel playerModel, String i) {
		value = playerModel;
		index = Integer.parseInt(i);
	}
	
	public int getIndex() {
		return index;
	}
	
	public PlayerModel getPlayer() {
		return value;
	}
}
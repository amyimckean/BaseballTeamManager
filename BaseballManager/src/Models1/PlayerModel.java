package Models1;

import Enums.*;

public class PlayerModel{
	private PositionEnum position;
	private String name;
	private LeftRightEnum bats;
	private LeftRightEnum throwing;
	private boolean inTheGame;
	private int number;
	private int lineupPos;
	
	public PlayerModel(LeftRightEnum bats, LeftRightEnum throwing, String name, PositionEnum pos) {
		this.bats = bats;
		this.throwing = throwing;
		this.name = name;
		this.position = pos;
		inTheGame = false;
	}
	
	public PositionEnum getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	public LeftRightEnum getBats() {
		return bats;
	}
	
	public LeftRightEnum getThrows() {
		return throwing;
	}
	
	public boolean getInTheGame() {
		return inTheGame;
	}
	
	public void setInTheGame(boolean in) {
		inTheGame = in;
	}
	public int getNumber() {
		return number;
	}
	
	public int getLineupPos() {
		return lineupPos;
	}
	
	public void setNumber(int num) {
		number = num;
	}
	
	public void setLineupPos(int pos) {
		lineupPos = pos;
	}
	
	public String toString() {
		return name + " #" + number;
	}
}

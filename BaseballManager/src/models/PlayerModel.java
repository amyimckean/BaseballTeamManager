package Models;

import Enums.*;

public class PlayerModel{
	PositionEnum position;
	String name;
	LeftRightEnum bats;
	LeftRightEnum throwing;
	int throwingSpeed;
	double homeToFirst;
	boolean inTheGame;
	int number;
	
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
	
	public int getThrowingSpeed() {
		return throwingSpeed;
	}
	
	public double getHomeToFirst() {
		return homeToFirst;
	}
	
	public boolean getInTheGame() {
		return inTheGame;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int num) {
		number = num;
	}
	
	public String toString() {
		return name + " #" + number;
	}
}

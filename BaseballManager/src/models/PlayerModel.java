package models;

import Enums.*;

public class PlayerModel{
	public PositionEnum position;
	public String name;
	public LeftRightEnum bats;
	public LeftRightEnum throwing;
	public int throwingSpeed;
	public double homeToFirst;
	
	public PlayerModel(LeftRightEnum bats, LeftRightEnum throwing, String name, PositionEnum pos) {
		this.bats = bats;
		this.throwing = throwing;
		this.name = name;
		this.position = pos;
	}
}

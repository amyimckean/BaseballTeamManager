package Models;

import Enums.PitchTypeEnum;

public class PitchModel {
	int speed = 0;
	PitchTypeEnum pitch;
	
	public int getSpeed() {
		return speed;
	}
	
	public PitchTypeEnum getPitch() {
		return pitch;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setPitch(PitchTypeEnum pitch) {
		this.pitch = pitch;
	}
}

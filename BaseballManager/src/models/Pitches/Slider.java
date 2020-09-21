package models.Pitches;

public class Slider extends Pitch {
	
	public void ThrowPitch() {
		speed = 90;
		pitch = PitchTypes.Slider;
		pitched = true;
	}
}
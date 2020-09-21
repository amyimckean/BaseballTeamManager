package models.Pitches;

public class Fastball extends Pitch {

	public void ThrowPitch() {
		speed = 95;
		pitch = PitchTypes.Fastball;
		pitched = true;
	}
}

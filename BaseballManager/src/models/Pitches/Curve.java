package models.Pitches;

public class Curve extends Pitch {
	
	public void ThrowPitch() {
		speed = 85;
		pitch = PitchTypes.Curve;
		pitched = true;
	}
}

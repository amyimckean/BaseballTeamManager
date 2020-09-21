package models.Pitches;


public class Change extends Pitch {

	public void ThrowPitch() {
		speed = 75;
		pitch = PitchTypes.Change;
		pitched = true;
	}
}
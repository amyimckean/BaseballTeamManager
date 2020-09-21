package models.Pitches;

public class NoPitch extends Pitch {

	public void ThrowPitch() {
		speed = 0;
		pitch = PitchTypes.None;
		pitched = true;
	}

}

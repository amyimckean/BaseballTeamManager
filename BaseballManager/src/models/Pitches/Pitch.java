package models.Pitches;

public abstract class Pitch {
	public int speed = 0;
	public PitchTypes pitch;
	public boolean pitched = false;
	
	public abstract void ThrowPitch();
	
	public String GetThrownPitch() {
		if(pitched) {
			return String.format("The last pitch thrown was a %1$s thrown at %2$smph.", pitch, speed);
		}
		else {
			return String.format("The %1$s hasn't been thrown", pitch);
		}
	}
}

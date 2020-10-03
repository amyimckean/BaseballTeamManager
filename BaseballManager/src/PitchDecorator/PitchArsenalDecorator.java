package PitchDecorator;

public abstract class PitchArsenalDecorator extends PitchArsenal {
	
	PitchArsenalDecorator(PitchArsenal arsenal){
		this.pitches = arsenal.pitches;
	}
	
	public abstract void Decorate();
}

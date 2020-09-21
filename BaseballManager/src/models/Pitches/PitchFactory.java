package models.Pitches;

public class PitchFactory {
	private static PitchFactory factory;
	
	private PitchFactory() { }
	
	public static PitchFactory getInstance() {
		if(factory == null) {
			factory = new PitchFactory();
		}
		return factory;
	}

	public Pitch getPitch(PitchTypes pitch) {
		switch(pitch) {
			case Change:
				return new Change();
			case Curve:
				return new Curve();
			case Fastball:
				return new Fastball();
			case Slider:
				return new Slider();
			default:
				return new NoPitch();
		}
	}
}

package Factories;

import java.util.List;

import Enums.PitchTypeEnum;
import PitchDecorator.*;
import models.PitchModel;

public class PitchFactory {
	private static PitchFactory factory;
	
	private PitchFactory() { }
	
	public static PitchFactory getInstance() {
		if(factory == null) {
			factory = new PitchFactory();
		}
		return factory;
	}

	public List<PitchModel> getPitches(List<PitchTypeEnum> pitches) {
		PitchArsenal pitchesArsenal = new Pitches();
		
		for(PitchTypeEnum pitch : pitches) {
			switch(pitch) {
				case Change:
					pitchesArsenal = new ChangeDecorator(pitchesArsenal);
					break;
				case Curve:
					pitchesArsenal = new CurveDecorator(pitchesArsenal);
					break;
				case Fastball:
					pitchesArsenal = new FastballDecorator(pitchesArsenal);
					break;
				case Slider:
					pitchesArsenal = new SliderDecorator(pitchesArsenal);
					break;
			default:
				break;
			}
		}
		return pitchesArsenal.GetPitches();
	}
}
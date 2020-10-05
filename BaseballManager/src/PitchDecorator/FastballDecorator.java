package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class FastballDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;
	
	public FastballDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;
	}
		
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 95;
		pitch.pitch = PitchTypeEnum.Fastball;
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}

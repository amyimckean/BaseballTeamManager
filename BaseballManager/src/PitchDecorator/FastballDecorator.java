package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import Models.PitchModel;

public class FastballDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;
	
	public FastballDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;
	}
		
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.setSpeed(95);
		pitch.setPitch( PitchTypeEnum.Fastball);
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}

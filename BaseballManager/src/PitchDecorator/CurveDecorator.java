package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import Models1.PitchModel;

public class CurveDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;
	
	public CurveDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;
	}
		
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.setSpeed(85);
		pitch.setPitch(PitchTypeEnum.Curve);
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}

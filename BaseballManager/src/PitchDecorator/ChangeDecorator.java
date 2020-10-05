package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class ChangeDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;

	public ChangeDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;
	}
	
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 75;
		pitch.pitch = PitchTypeEnum.Change;
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}
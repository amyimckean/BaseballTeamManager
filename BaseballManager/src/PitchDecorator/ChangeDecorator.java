package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import Models1.PitchModel;

public class ChangeDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;

	public ChangeDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;
	}
	
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.setSpeed(75);
		pitch.setPitch(PitchTypeEnum.Change);
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}
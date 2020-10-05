package PitchDecorator;

import java.util.List;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class SliderDecorator extends PitchArsenalDecorator {
	PitchArsenal arsenal;
	
	public SliderDecorator(PitchArsenal arsenal) {
		this.arsenal = arsenal;

	}
	
	public List<PitchModel> GetPitches() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 90;
		pitch.pitch = PitchTypeEnum.Slider;
		List<PitchModel> pitches = arsenal.GetPitches();
		pitches.add(pitch);
		
		return pitches;
	}
}
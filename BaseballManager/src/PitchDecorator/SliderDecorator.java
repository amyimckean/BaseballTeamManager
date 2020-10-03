package PitchDecorator;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class SliderDecorator extends PitchArsenalDecorator {

	public SliderDecorator(PitchArsenal arsenal) {
		super(arsenal);
	}
	
	public void Decorate() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 90;
		pitch.pitch = PitchTypeEnum.Slider;
		pitches.add(pitch);
	}
}
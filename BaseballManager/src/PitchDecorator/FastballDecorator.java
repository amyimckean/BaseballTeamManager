package PitchDecorator;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class FastballDecorator extends PitchArsenalDecorator {

	public FastballDecorator(PitchArsenal arsenal) {
		super(arsenal);
	}
		
	public void Decorate() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 95;
		pitch.pitch = PitchTypeEnum.Fastball;
		
		pitches.add(pitch);
	}
}

package PitchDecorator;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class CurveDecorator extends PitchArsenalDecorator {

	public CurveDecorator(PitchArsenal arsenal) {
		super(arsenal);
	}
		
	public void Decorate() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 85;
		pitch.pitch = PitchTypeEnum.Curve;
		
		pitches.add(pitch);
	}
}

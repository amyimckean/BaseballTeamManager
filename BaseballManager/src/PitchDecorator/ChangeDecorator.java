package PitchDecorator;

import Enums.PitchTypeEnum;
import models.PitchModel;

public class ChangeDecorator extends PitchArsenalDecorator {

	public ChangeDecorator(PitchArsenal arsenal) {
		super(arsenal);
	}
	
	public void Decorate() {
		PitchModel pitch = new PitchModel();
		pitch.speed = 75;
		pitch.pitch = PitchTypeEnum.Change;
		
		pitches.add(pitch);
	}
}
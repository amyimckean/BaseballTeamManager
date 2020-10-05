package PitchDecorator;

import java.util.List;

import models.PitchModel;

public abstract class PitchArsenalDecorator extends PitchArsenal {
	public abstract List<PitchModel> GetPitches();
}

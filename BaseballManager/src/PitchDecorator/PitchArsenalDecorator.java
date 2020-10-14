package PitchDecorator;

import java.util.List;

import Models1.PitchModel;

public abstract class PitchArsenalDecorator extends PitchArsenal {
	public abstract List<PitchModel> GetPitches();
}

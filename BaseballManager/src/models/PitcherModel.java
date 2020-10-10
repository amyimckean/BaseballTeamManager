package Models;

import java.util.List;
import Enums.*;

public class PitcherModel extends PlayerModel {
	public List<PitchModel> pitches;
	
	public PitcherModel(LeftRightEnum bats, LeftRightEnum throwing, String name, PositionEnum pos) {
		super(bats, throwing, name, pos);
	}

	public void setPitches(List<PitchModel> pitches) {
		this.pitches = pitches;
	}
}

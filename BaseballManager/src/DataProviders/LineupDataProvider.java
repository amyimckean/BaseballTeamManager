package DataProviders;

import java.util.ArrayList;

import Enums.*;
import Factories.*;
import models.*;

public class LineupDataProvider {
	public static PitcherModel GetPitcher1(){
		PitcherModel model = new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Left, "Randy Johnson", PositionEnum.pitcher);
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Change);
		pitches.add(PitchTypeEnum.Curve);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Slider);
		model.setPitches(PitchFactory.getInstance().getPitches(pitches));
		return model;
	}
	
	public static PitcherModel GetPitcher2(){
		PitcherModel model = new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Chris Bosio", PositionEnum.pitcher);
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Change);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Curve);
		model.setPitches(PitchFactory.getInstance().getPitches(pitches));
		return model;
	}
	
	public static PitcherModel GetPitcher3(){
		PitcherModel model = new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Right, "Bobby Ayala", PositionEnum.pitcher);
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Change);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Slider);
		model.setPitches(PitchFactory.getInstance().getPitches(pitches));
		return model;
	}
	
	public static PitcherModel GetPitcher4(){
		PitcherModel model = new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Left, "Norm Charlton", PositionEnum.pitcher);
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Change);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Slider);
		pitches.add(PitchTypeEnum.Curve);
		model.setPitches(PitchFactory.getInstance().getPitches(pitches));
		return model;
	}
	
	public static PitcherModel GetPitcher5(){
		PitcherModel model = new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Left, "Bob Wolcott", PositionEnum.pitcher);
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Curve);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Slider);
		model.setPitches(PitchFactory.getInstance().getPitches(pitches));
		return model;
	}
	
	public static PlayerModel GetPlayer1(){
		return new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Left, "Ken Griffey Jr.", PositionEnum.centerfield);
	}
	
	public static PlayerModel GetPlayer2(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Alex Rodriguez", PositionEnum.shortstop);
	}
	
	public static PlayerModel GetPlayer3(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Joey Cora", PositionEnum.second);
	}	
	
	public static PlayerModel GetPlayer4(){
		return new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Right, "Tino Martinez", PositionEnum.first);
	}
	
	public static PlayerModel GetPlayer5(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Mike Blowers", PositionEnum.third);
	}
	
	public static PlayerModel GetPlayer6(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Dan Wilson", PositionEnum.catcher);
	}
	
	public static PlayerModel GetPlayer7(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Jay Buhner", PositionEnum.rightfield);
	}
	
	public static PlayerModel GetPlayer8(){
		return new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Right, "Jose Cruz Jr.", PositionEnum.leftfield);
	}
	
	public static PlayerModel GetPlayer9(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Rich Amaral", PositionEnum.shortstop);
	}
	
	public static PlayerModel GetPlayer10(){
		return new PitcherModel(LeftRightEnum.Left, LeftRightEnum.Left, "John Olerud", PositionEnum.first);
	}
	
	public static PlayerModel GetPlayer11(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Edgar Martinez", PositionEnum.third);
	}
	
	public static PlayerModel GetPlayer12(){
		return new PitcherModel(LeftRightEnum.Right, LeftRightEnum.Right, "Mike Cameron", PositionEnum.centerfield);
	}
}

package Tests;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Enums.*;
import Factories.*;
import Models.PitchModel;

class PitchDecoratorTests {

	@Test
	void GetPitchesCFS() {
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Curve);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Slider);
		List<PitchModel> list = PitchFactory.getInstance().getPitches(pitches);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Curve));
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Fastball));
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Slider));
		Assert.assertTrue(!list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Change));
	}


	@Test
	void GetPitchesNoC() {
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Curve);
		pitches.add(PitchTypeEnum.Fastball);
		List<PitchModel> list = PitchFactory.getInstance().getPitches(pitches);
		
		Assert.assertTrue(!list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Change));
		Assert.assertTrue(!list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Slider));
	}
	
	@Test
	void GetPitchesCFC() {
		ArrayList<PitchTypeEnum> pitches = new ArrayList<PitchTypeEnum>();
		pitches.add(PitchTypeEnum.Curve);
		pitches.add(PitchTypeEnum.Fastball);
		pitches.add(PitchTypeEnum.Change);
		List<PitchModel> list = PitchFactory.getInstance().getPitches(pitches);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Curve));
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Fastball));
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Change));
	}


}

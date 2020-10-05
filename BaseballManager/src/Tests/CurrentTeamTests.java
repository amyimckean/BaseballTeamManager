package Tests;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Enums.*;
import Factories.*;
import models.PitcherModel;
import models.PlayerModel;

class CurrentTeamTests {

	@Test
	void GetPitcherRandyJohnsonTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.name == "Randy Johnson"));
	}

	@Test
	void GetPitcherRandyJohnsonThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.throwing == LeftRightEnum.Left && x.name == "Randy Johnson"));
	}

	@Test
	void GetPitcherRandyJohnsonPitchTests() {
		CurrentTeam team = new CurrentTeam();
		PitcherModel pitcher = (PitcherModel) team.GetPlayers(PlayerTypeEnum.Pitcher).stream()
				.filter(x -> x.name == "Randy Johnson")
	            .findFirst()
	            .get();
		System.out.print(pitcher);
		Assert.assertTrue(pitcher.pitches.stream().anyMatch((x) -> x.pitch == PitchTypeEnum.Slider));
	}

	@Test
	void GetPitcherNormCharltonTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.name == "Norm Charlton"));
	}

	@Test
	void GetPitcherNormCharltonThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.throwing == LeftRightEnum.Left && x.name == "Randy Johnson"));
	}

	@Test
	void GetPlayerGriffeyTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.name == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherGriffeyThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.throwing == LeftRightEnum.Left && x.name == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherGriffeyBatsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.bats == LeftRightEnum.Left && x.name == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherEdgarMartinezTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.name == "Edgar Martinez"));
	}

	@Test
	void GetPitcherEdgarMartinezThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.throwing == LeftRightEnum.Right && x.name == "Edgar Martinez"));
	}

	@Test
	void GetPitcherEdgarMartinezBatsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.bats == LeftRightEnum.Right && x.name == "Edgar Martinez"));
	}
}

package Tests;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Enums.*;
import Factories.*;
import Models.PitcherModel;
import Models.PlayerModel;

class TeamFactoryTests {

	@Test
	void GetPitcherRandyJohnsonTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getName() == "Randy Johnson"));
	}

	@Test
	void GetPitcherRandyJohnsonThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getThrows() == LeftRightEnum.Left && x.getName() == "Randy Johnson"));
	}

	@Test
	void GetPitcherRandyJohnsonPitchTests() {
		CurrentTeam team = new CurrentTeam();
		PitcherModel pitcher = (PitcherModel) team.GetPlayers(PlayerTypeEnum.Pitcher).stream()
				.filter(x -> x.getName() == "Randy Johnson")
	            .findFirst()
	            .get();
		System.out.print(pitcher);
		Assert.assertTrue(pitcher.pitches.stream().anyMatch((x) -> x.getPitch() == PitchTypeEnum.Slider));
	}

	@Test
	void GetPitcherNormCharltonTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getName() == "Norm Charlton"));
	}

	@Test
	void GetPitcherNormCharltonThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Pitcher);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getThrows() == LeftRightEnum.Left && x.getName() == "Randy Johnson"));
	}

	@Test
	void GetPlayerGriffeyTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getName() == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherGriffeyThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getThrows() == LeftRightEnum.Left && x.getName() == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherGriffeyBatsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getBats() == LeftRightEnum.Left && x.getName() == "Ken Griffey Jr."));
	}

	@Test
	void GetPitcherEdgarMartinezTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getName() == "Edgar Martinez"));
	}

	@Test
	void GetPitcherEdgarMartinezThrowsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getThrows() == LeftRightEnum.Right && x.getName() == "Edgar Martinez"));
	}

	@Test
	void GetPitcherEdgarMartinezBatsTests() {
		CurrentTeam team = new CurrentTeam();
		List<PlayerModel> list = team.GetPlayers(PlayerTypeEnum.Position);
		
		Assert.assertTrue(list.stream().anyMatch((x) -> x.getBats() == LeftRightEnum.Right && x.getName() == "Edgar Martinez"));
	}
}

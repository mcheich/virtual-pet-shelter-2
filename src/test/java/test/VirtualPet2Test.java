package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.VirtualPet2;

class VirtualPet2Test {

	// Arrange
	VirtualPet2 underTest = new VirtualPet2();

	@Test
	public void HungerShouldBe0AtStart() {
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void ThirstShouldBe0AtStart() {
		// Act
		int result = underTest.getThirst();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void BoredomShouldBe0AtStart() {
		// Act
		int result = underTest.getBoredom();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void hungerShouldDecreaseBy1AfterEat() {
		// Act
		underTest.setHunger(1);
		int beforeEat = underTest.getHunger(); // 1
		underTest.feed();
		int result = underTest.getHunger();
		// Assert
		assertEquals(beforeEat - 1, result);
	}

	@Test
	public void thirstShouldDecreaseBy1AfterDrink() {
		// Act
		underTest.setThirst(1);
		int beforeDrink = underTest.getThirst();
		underTest.drink();
		int result = underTest.getThirst();
		// Assert
		assertEquals(beforeDrink - 1, result);
	}

	@Test
	public void boredomShouldDecreaseBy1AfterPlay() {
		// Act
		underTest.setBoredom(1);
		int beforePlay = underTest.getBoredom();
		underTest.play();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(beforePlay - 1, result);
	}

	@Test
	public void hungerShouldNotDecreaseBelow0() {
		// Act
		int result = underTest.getHunger();
		underTest.feed();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void thirstShouldNotDecreaseBelow0() {
		// Act
		int result = underTest.getThirst();
		underTest.drink();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void boredomShouldNotDecreaseBelow0() {
		// Act
		underTest.play();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void tickShouldIncreaseHungerBy1() {
		// Act
		int beforeTick = underTest.getHunger();
		underTest.tick();
		int afterTick = underTest.getHunger();
		// Assert
		assertEquals(beforeTick, afterTick - 1);
	}

	@Test
	public void tickShouldIncreaseThirstBy1() {
		// Act
		int beforeTick = underTest.getThirst();
		underTest.tick();
		int afterTick = underTest.getThirst();
		// Assert
		assertEquals(beforeTick, afterTick - 1);
	}

	@Test
	public void tickShouldIncreaseBoredomBy1() {
		// Act
		int beforeTick = underTest.getBoredom();
		underTest.tick();
		int afterTick = underTest.getBoredom();
		// Assert
		assertEquals(beforeTick, afterTick - 1);
	}

	@Test
	public void ConstructorCreatesHungerAt1() {
		// Arrange
		VirtualPet2 underTestConstructor = new VirtualPet2(1, 0, 0);
		// Act
		int result = underTestConstructor.getHunger();
		// Assert
		assertEquals(1, result);
	}

	@Test
	public void ConstructorCreatesThirstAt1() {
		// Arrange
		VirtualPet2 underTestConstructor = new VirtualPet2(0, 1, 0);
		// Act
		int result = underTestConstructor.getThirst();
		// Assert
		assertEquals(1, result);
	}

	@Test
	public void ConstructorCreatesBoredomAt1() {
		// Arrange
		VirtualPet2 underTestConstructor = new VirtualPet2(0, 0, 1);
		// Act
		int result = underTestConstructor.getBoredom();
		// Assert
		assertEquals(1, result);
	}

	@Test
	public void ConstructorCreatesNameMike() {
		// Arrange
		VirtualPet2 underTestConstructor = new VirtualPet2("mike", "");
		// Act
		String result = underTestConstructor.getName();
		// Assert
		assertTrue(result.equals("mike"));
	}

	@Test
	public void ConstructorCreatesDescriptionCrazyCat() {
		// Arrange
		VirtualPet2 underTestConstructor = new VirtualPet2("", "Crazy Cat");
		// Act
		String result = underTestConstructor.getDescription();
		// Assert
		assertTrue(result.equals("Crazy Cat"));
	}

	@Test
	public void AConstructorWithAdditionalParameterNameEqualFifi() {
		// Arrange
		VirtualPet2 underTest = new VirtualPet2("fifi", "", 1, 2, 3);
		//Assert
		assertEquals("fifi", underTest.getName());
	}
	
	@Test
	public void AConstructorWithAdditionalParameterDecsriptionEqualCat() {
		// Arrange
		VirtualPet2 underTest = new VirtualPet2("", "cat", 1, 2, 3);
		//Assert
		assertEquals("cat", underTest.getDescription());
	}
	
	@Test
	public void AConstructorWithAdditionalParameterHungerEqual1() {
		// Arrange
		VirtualPet2 underTest = new VirtualPet2("", "cat", 1, 0, 0);
		//Assert
		assertEquals(1, underTest.getHunger());
	}
	
	@Test
	public void AConstructorWithAdditionalParameterThirstEqual1() {
		// Arrange
		VirtualPet2 underTest = new VirtualPet2("", "cat", 0, 1, 0);
		//Assert
		assertEquals(1, underTest.getThirst());
	}
	
	@Test
	public void AConstructorWithAdditionalParameterBoredomEqual1() {
		// Arrange
		VirtualPet2 underTest = new VirtualPet2("", "cat", 0, 0, 1);
		//Assert
		assertEquals(1, underTest.getBoredom());
	}
	
}
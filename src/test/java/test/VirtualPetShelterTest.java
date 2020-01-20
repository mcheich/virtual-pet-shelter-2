package test;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import main.VirtualPetShelter;
import main.VirtualPet2;

public class VirtualPetShelterTest {

	@Test
	public void intakeAdds1PetToTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("", "");
		// Assert
		assertEquals(1, underTest.getShelter().size());
	}

	@Test
	public void intakeAdds2PetToTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("", "");
		underTest.intake("", "");
		// Assert
		assertEquals(2, underTest.getShelter().size());
	}

	@Test
	public void intakeAdds1PetToTheShelterNamedTest() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("test", "");
		Integer key = 1;
		String result = underTest.getShelter().get(key).getName();
		// Assert
		assertEquals("test", result);
	}

	@Test
	public void adoptOutRemoves1PetFromTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("test", "");
		underTest.adoptOut("test");
		// Assert
		assertEquals(0, underTest.getShelter().size());
	}

	@Test
	public void adoptOutRemoves2PetFromTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("test", "");
		underTest.intake("test1", "");
		underTest.intake("test2", "");
		underTest.adoptOut("test");
		underTest.adoptOut("test2");
		// Assert
		assertEquals(1, underTest.getShelter().size());
	}

	@Test
	public void feedAllDecreasesHungerBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("TestName", "TestDescription");
		underTest.getShelter().get(1).tick();
		// Act
		underTest.feedAll();
		int result = underTest.getShelter().get(1).getHunger();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void waterAllDecreasesThirstBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("TestName", "TestDescription");
		underTest.getShelter().get(1).tick();
		// Act
		underTest.waterAll();
		int result = underTest.getShelter().get(1).getThirst();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void playAllDecreasesBoredomBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("TestName", "TestDescription");
		underTest.getShelter().get(1).tick();
		// Act
		underTest.playAll();
		int result = underTest.getShelter().get(1).getBoredom();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void tickAllincreasesHungerBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("TestName", "TestDescription");
		// Act
		underTest.tickAll();
		int result = underTest.getShelter().get(1).getHunger();
		// Assert
		assertEquals(1, result);
	}

	/**
	 * :MIKEQ: 
	 *  I want to test getRoster, just not sure the appropriate
	 *  test, so i went with this.
	 */
	@Test
	public void getRosterReturnsCollectionOfSize3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		// Act
		underTest.intake("Rhino", "horns");
		underTest.intake("Panda", "fat");
		underTest.intake("Bear", "huge");
		Collection<VirtualPet2> result = underTest.getRoster();
		// Assert
		assertEquals(3, result.size());
	}
	
	@Test
	public void playWithPetDecreasesBoredomBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("TestName", "TestDescription");
		// Act
		underTest.tickAll();
		underTest.playWithPet("TestName");
		int result = underTest.getShelter().get(1).getBoredom();
		//Assert
		assertEquals(0, result);
	}

	@Test
	public void playWithPetReturnsFalseIfPetNameIsNotPresent() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("firstTest", "TestDescription");
		underTest.intake("TestName", "TestDescription");
		// Act
		underTest.tickAll();
		boolean result = underTest.playWithPet("Test");
		//Assert
		assertFalse(result);
	}

	@Test
	public void playWithPetReturnsTrueIfPetNameIsPresent() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("firstTest", "TestDescription");
		underTest.intake("TestName", "TestDescription");
		// Act
		underTest.tickAll();
		boolean result = underTest.playWithPet("TestName");
		//Assert
		assertTrue(result);
	}

	@Test
	public void adoptOutReturnsFalseIfPetNameIsNotPresent() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("firstTest", "TestDescription");
		underTest.intake("TestName", "TestDescription");
		// Act
		boolean result = underTest.adoptOut("Test");;
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void adoptOutReturnsTrueIfPetNameIsPresent() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("firstTest", "TestDescription");
		underTest.intake("TestName", "TestDescription");
		// Act
		boolean result = underTest.adoptOut("TestName");;
		//Assert
		assertTrue(result);
	}
}
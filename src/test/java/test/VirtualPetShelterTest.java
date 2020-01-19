package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.VirtualPetShelter;

public class VirtualPetShelterTest {

	@Test
	public void intakeAdds1PetToTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.getShelter().clear();
		// Act
		underTest.intake("", "");
		System.out.println("TEST1: Shelter: " + underTest.getShelter());
		// Assert
		assertEquals(1, underTest.getShelter().size());
	}

	@Test
	public void intakeAdds2PetToTheShelter() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.getShelter().clear();
		// Act
		underTest.intake("", "");
		underTest.intake("", "");
		System.out.println("TEST2: Shelter: " + underTest.getShelter());
		// Assert
		assertEquals(2, underTest.getShelter().size());
	}
	
	@Test
	public void intakeAdds1PetToTheShelterNamedTest(){
		//Arrange
		 VirtualPetShelter underTest = new VirtualPetShelter();
		 underTest.getShelter().clear();
		//Act
		underTest.intake("test", "");
		Integer key = 1;
		String result = underTest.getShelter().get(key).getName();
		//Assert
		assertEquals("test",result);
	}
}
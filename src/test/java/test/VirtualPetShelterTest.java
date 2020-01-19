package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.VirtualPetShelter;

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
	public void intakeAdds1PetToTheShelterNamedTest(){
		//Arrange
		 VirtualPetShelter underTest = new VirtualPetShelter();
		//Act
		underTest.intake("test", "");
		Integer key = 1;
		String result = underTest.getShelter().get(key).getName();
		//Assert
		assertEquals("test",result);
	}
	
	@Test
	public void adoptOutRemoves1PetFromTheShelter(){
		//Arrange
		 VirtualPetShelter underTest = new VirtualPetShelter();
		//Act
		underTest.intake("test", "");
		underTest.adoptOut(1);
		//Assert
		assertEquals(0,underTest.getShelter().size());
	}
	
	@Test
	public void adoptOutRemoves2PetFromTheShelter(){
		//Arrange
		 VirtualPetShelter underTest = new VirtualPetShelter();
		//Act
		underTest.intake("test", "");
		underTest.intake("test", "");
		underTest.intake("test", "");
		underTest.adoptOut(1);
		underTest.adoptOut(2);
		//Assert
		assertEquals(1,underTest.getShelter().size());
	}
}
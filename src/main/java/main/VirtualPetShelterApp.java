package main;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		VirtualPetShelter shelter = new VirtualPetShelter();

		// Add 3 VirtualPets to shelter
		shelter.intake("Maxie", "A nice dog");
		shelter.intake("Bailey", "A lazy dog");
		shelter.intake("Fifi", "A nice kitty");

		// Show Welcome Message
		showWelcomeMessage();

		Scanner input = new Scanner(System.in);

		String selection = "6";
		do {
			showRosterAndStats(shelter);

			switch (selection) {
			case "1":
				shelter.feedAll();
				System.out.println("** You fed all the pets! **\n");
				break;
			case "2":
				shelter.waterAll();
				System.out.println("** You watered all the pets! **\n");
				break;
			case "3":
				playWithSinglePet(shelter, input);
				break;
			case "4":
				intakePet(shelter, input);
				break;
			case "5":
				adoptOut(shelter, input);
				break;
			case "6":
				showOptions();
				break;

			}

			// Time Passes
			shelter.tickAll();

			// Update user selection
			selection = input.nextLine();

		} while (!selection.equals("6"));

		input.close();

	}

	private static void adoptOut(VirtualPetShelter shelter, Scanner input) {
		System.out.println("** What is the name of the animal that is being adopted? **/n");
		String adoptee = input.nextLine();
		shelter.adoptOut(adoptee);
		

	}

	/**
	 * Adds VirtualPet to Shelter
	 * 
	 * @param shelter
	 * @param input
	 */
	private static void intakePet(VirtualPetShelter shelter, Scanner input) {

		// User Input Name and Description
		System.out.println("** Enter the name of the pet you are intaking: **");
		String petName = input.nextLine();
		System.out.println("** Give a descripion of the pet you are intaking: **");
		String petDescription = input.nextLine();

		// Add pet to shelter
		shelter.intake(petName, petDescription);

		// User Output
		System.out.println("You have added " + petName + " to the pet shelter.\n");

	}

	private static void playWithSinglePet(VirtualPetShelter shelterPara, Scanner input) {
		System.out.println("** Ok, so you'd like to play with a pet. Please choose one: **\n");

		// Find the pet
		Map<Integer, VirtualPet2> animals = shelterPara.getShelter();
		for (Entry<Integer, VirtualPet2> animal : animals.entrySet()) {
			System.out.println(
					String.format("[%1$s] %2$s", animal.getValue().getName(), animal.getValue().getDescription()));
		}

		// User make selection
		System.out.println();
		System.out.println("** Type the name of the animal you'd like to play with: **\n");
		String petName = input.next(); // Tried nextLine() here, but wouldn't work

		// Play with selected animal
		boolean match = shelterPara.playWithPet(petName);

		// User Output
		if (match) {
			System.out.println("** You played with " + petName + "**\n");
		} else {
			System.out.println("########################################");
			System.out.println(petName + " does not match an option!");
			System.out.println("########################################\n");
		}

	}

	private static void showOptions() {
		System.out.println("** What would you like to do with your pets? **\n");
		System.out.println("1. Feed the pets\n" + "2. Water the pets\n" + "3. Play with a pet\n" + "4. Adopt a pet\n"
				+ "5. Admit a pet\n" + "6. Quit");

	}

	private static void showRosterAndStats(VirtualPetShelter shelterPara) {
		System.out.println("** This is the status of the pets in the shelter: **\n");
		System.out.println("Name        |Hunger |Thirst |Boredom");
		System.out.println("------------|-------|-------|-------");

		Map<Integer, VirtualPet2> animals = shelterPara.getShelter();

		for (Entry<Integer, VirtualPet2> animal : animals.entrySet()) {
			System.out.println(String.format("%1$-12s|%2$-7s|%3$-7s|%4$-7s", animal.getValue().getName(),
					animal.getValue().getHunger(), animal.getValue().getThirst(), animal.getValue().getBoredom()));
		}

		// Add Spacing for next element
		System.out.println();

	}

	private static void showWelcomeMessage() {
		System.out.println("###########################################");
		System.out.println("##   Welcome to your local Pet Shelter   ##");
		System.out.println("###########################################");
		System.out.println();
	}

}

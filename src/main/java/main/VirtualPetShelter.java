package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VirtualPetShelter {

	private Map<Integer, VirtualPet2> shelter = new HashMap<Integer, VirtualPet2>();

	public void intake(String namePara, String descriptionPara) {
		/**
		 * Key is the next size in the Map Value is the VirtualPet object
		 */
		Integer petKey = this.shelter.size() + 1;
		VirtualPet2 newPet = new VirtualPet2(namePara, descriptionPara);
		this.shelter.put(petKey, newPet);
	}

	/**
	 * @return the shelter
	 */
	public Map<Integer, VirtualPet2> getShelter() {
		return this.shelter;
	}

	/**
	 * Remove VirtualPet Object from Map
	 * 
	 * @param keyPara
	 */
	public boolean adoptOut(String namePara) {

		Set<Entry<Integer, VirtualPet2>> animals = shelter.entrySet();

		for (Entry<Integer, VirtualPet2> animal : animals) {
			if (animal.getValue().getName().equals(namePara)) {
				animals.remove(animal);
				return true;
			}
		}
		// No Virtual Pet by that name found
		return false;
	}

	/**
	 * Call the feed() method for all Virtual Pets in the the shelter
	 */
	public void feedAll() {

		for (Entry<Integer, VirtualPet2> pet : shelter.entrySet()) {

			pet.getValue().feed();
		}
	}

	/**
	 * Call the water() method for all Virtual Pets in the shelter
	 */
	public void waterAll() {

		for (Entry<Integer, VirtualPet2> pet : shelter.entrySet()) {
			pet.getValue().drink();
		}

	}

	/**
	 * Call the play() method for all Virtual Pets in the shelter
	 */
	public void playAll() {

		for (Entry<Integer, VirtualPet2> pet : shelter.entrySet()) {
			pet.getValue().play();
		}

	}

	/**
	 * Call the tick() method for all Virtual pets in the shelter
	 */
	public void tickAll() {

		for (Entry<Integer, VirtualPet2> pet : shelter.entrySet()) {
			pet.getValue().tick();
		}
	}

	/**
	 * Returns a Collection of VirtualPet objects
	 * 
	 * @return Collection of VirtualPets
	 */
	public Collection<VirtualPet2> getRoster() {
		return this.shelter.values();
	}

	/**
	 * Finds pet by name. KNOW ISSUE: If duplicate pet names exist, only one will be
	 * fed.
	 * 
	 * Suggested fix - change the parameter to the Key, instead of the Value.name
	 * 
	 * @param namePara
	 * @return true is pet name found false if pet name note found
	 */

	public boolean playWithPet(String namePara) {

		Set<Entry<Integer, VirtualPet2>> animals = shelter.entrySet();

		for (Entry<Integer, VirtualPet2> animal : animals) {

			if (animal.getValue().getName().equals(namePara)) {
				animal.getValue().play();
				return true;
			}

		}

		// No Virtual Pet by that name found
		return false;

	}

}

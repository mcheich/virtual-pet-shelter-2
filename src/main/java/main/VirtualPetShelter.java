package main;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<Integer, VirtualPet2> shelter = new HashMap<Integer, VirtualPet2>();
	
	public void intake(String namePara, String descriptionPara) {
		/**
		 *  Key is the next size in the Map
		 *  Value is the VirtualPet object
		 */
		Integer petKey = shelter.size() + 1;
		VirtualPet2 newPet = new VirtualPet2(namePara, descriptionPara);
		shelter.put(petKey, newPet);
	}

	/**
	 * @return the shelter
	 */
	public Map<Integer, VirtualPet2> getShelter() {
		return shelter;
	}

	/**
	 * Remove VirtualPet Object from Map
	 * @param keyPara
	 */
	public void adoptOut(int keyPara) {
		shelter.remove(keyPara);		
	}

}

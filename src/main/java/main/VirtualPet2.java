package main;

public class VirtualPet2 {

	private int hunger = 0;
	private int thirst = 0;
	private int boredom = 0;
	private String name;
	private String description;

	public VirtualPet2() {

	}

	/**
	 * Constructor for Name and Description
	 * 
	 * @param name
	 * @param description
	 */
	public VirtualPet2(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Constructor for Virtual Pet Stats
	 * 
	 * @param hunger
	 * @param thirst
	 * @param boredom
	 */
	public VirtualPet2(int hunger, int thirst, int boredom) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	/**
	 * Constructor for all Virtual Pet Attributes
	 * 
	 * @param namePara
	 * @param descriptionPara
	 * @param hungerPara
	 * @param thirstPara
	 * @param boredomPara
	 */
	public VirtualPet2(String namePara, String descriptionPara, int hungerPara, int thirstPara, int boredomPara) {
		this.name = namePara;
		this.description = descriptionPara;
		this.hunger = hungerPara;
		this.thirst = thirstPara;
		this.boredom = boredomPara;
	}

	/**
	 * Getter function for hunger.
	 * 
	 * @return
	 */
	public int getHunger() {
		return this.hunger;
	}

	/**
	 * Getter method for thirst.
	 * 
	 * @return
	 */
	public int getThirst() {
		return this.thirst;
	}

	/**
	 * Getter method for boredom.
	 * 
	 * @return
	 */
	public int getBoredom() {
		return this.boredom;
	}

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter method for Description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Decreases hunger by 1 Does not allow hunger to decrease below 0
	 */
	public void feed() {

		this.hunger--;

		if (this.hunger < 0) {
			this.hunger = 0;
		}

	}

	/**
	 * Decreases thirst by 1 Does not allow thirst
	 */
	public void drink() {
		this.thirst--;

		if (this.thirst < 0) {
			this.thirst = 0;
		}
	}

	/**
	 * Decrease boredom by 1 Does not allow boredom below 0
	 */
	public void play() {
		this.boredom--;
		if (this.boredom < 0) {
			this.boredom = 0;
		}
	}

	/**
	 * Increases hunger,thirst, and boredom by 1 Does not allow these values above
	 * 10.
	 */
	public void tick() {

		this.hunger++;
		this.thirst++;
		this.boredom++;

		// Limit to 10
		if (this.hunger > 10) {
			this.hunger = 10;
		}
		if (this.thirst > 10) {
			this.thirst = 10;
		}
		if (this.boredom > 10) {
			this.boredom = 10;
		}

	}

}

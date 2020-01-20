# Virtual Pet Shelter

This console application allows a user to care for virtual pets that are in a Virtual Pet Shelter.

Users can feed and water all the pets, or individually play with a pet.

They can take new animals into the shelter and allow for animals to be adopted as well. 

The main feature of the Virtual Pet Shelter is the use of a HashMap to store each VirtualPet object. 

## Biggest Challenges
The unique ID for each key in the HashMap is generated by the VirtualPetShelter object and is not stored with each individual VirtualPet Object.  Therefore, to call an  individual VirtualPet, I found myself searching the HashMap for Entry values.

In retrospect, it may have been better to add a field to the VirtualPet object for account ID, and use that as the Key. I would have gone this route, however, the project spec required playing with an animal BY NAME, and so I would have had to look up Entry data regardless.

## Points of Confusion
If I want to validate user data, where do I do it?  

For example, I am tempted to create setters for private field values, and add the validation logic there.  For example, if hunger must be between 0 and 10, then any time the value hunger needs adjusted, a method would call the setHunger, and the validation logic would be applied.  This could include the constructor - that is, the field values set in the constructor would use setHunger(value) - this could ensure any object constructed met the restrictions.  

I didn't go this route.  I got the inkling that setters undermined the privacy of field values of the class...

If I add the validation at the setter, could this limit the potential reuse of the class? 

Maybe someone wants a VirtualPet whose hunger can go up to 100 and less than 0...  If this is the case, the upper and lower limits could also be field values of the VirtualPet and set by an overloaded constructor...but, I guess the setter could use those same field values...





package shelter;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static String outputMessageFromPreviousCycle = "";
    public static boolean gameLoopState = true;;
    public static String recentlyUpdatedDoNotChange = "";

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String choice = "";
        int inputTestForNonIntInput = 0;
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();

        theVirtualPetShelter.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        theVirtualPetShelter.intake(new VirtualPet("Spot", "dog", "125497658254861", "Rhodesian Ridgeback"));
        theVirtualPetShelter.intake(new VirtualPet("Rover", "dog", "879794511131519", "Afghan hound"));
        theVirtualPetShelter.intake(new VirtualPet("Nemo", "fish", "834875937450054", "clown fish"));
        theVirtualPetShelter.intake(new VirtualPet("Clive", "dog", "948473594703456", "ugly pug"));
        theVirtualPetShelter.intake(new VirtualPet("Leo", "lion", "883987527723345", "very dangerous"));

        while (gameLoopState) {
            System.out.println("\n=========================================================================================");
            System.out.println("CLEVELAND PET SHELTER");
            System.out.println("These are the current pets in the building: ");
            System.out.println("  Type    |\t Microchip # \t|  Food\t| Water\t| Happiness  |   Name \t|Description");
            System.out.println("----------|-----------------|-------|-------|------------|----------|-------------------");
            System.out.println(theVirtualPetShelter.listOfAllPets());

            System.out.println("Welcome to the Cleveland Pet Shelter \n" +
                    "What would you like to do?\n" +
                    "\t1. Feed all pets\n" +
                    "\t2. Water all pets\n" +
                    "\t3. Play with a specific pet\n" +
                    "\t4. Adopt a pet\n" +
                    "\t5. Take an animal into the shelter\n" +
                    "\t6. Do nothing.\n" +
                    "\t7. Quit\n");

            System.out.println(outputMessageFromPreviousCycle);

            choice = input.nextLine();
            try {
                inputTestForNonIntInput = Integer.parseInt(choice);

            }catch(NumberFormatException e) {

            }

            switch (inputTestForNonIntInput) {
                    case 1:
                        theVirtualPetShelter.feedAllPets();
                        recentlyUpdatedDoNotChange = "foodLevel";
                        break;
                    case 2:
                        theVirtualPetShelter.waterAllPets();
                        recentlyUpdatedDoNotChange = "waterLevel";
                        break;
                    case 3:
                        System.out.println("Which pet would you like to play with? [Type the name from column 6 and it is case sensitive]");
                        String petToPlayWithStr = input.nextLine();
                        theVirtualPetShelter.playWithPet(petToPlayWithStr);
                        recentlyUpdatedDoNotChange = "happyLevel";
                        break;
                    case 4:
                        System.out.println("Which pet would you like to adopt? [Type the name from the 6th column (case sensitive)]");
                        String petToAdopt = input.nextLine();
                        theVirtualPetShelter.adopt(petToAdopt);
                        break;
                    case 5:
                        String newPetToIntake = "theVirtualPetShelter.intake(new \"";
                        System.out.println("What type of animal is it?");
                        String newPetType = input.nextLine();
                        newPetToIntake +=newPetType +"\"(\"";
                        System.out.println("What is the pet's name? (must be unique from the others)");
                        String newPetName = input.nextLine();
                        newPetToIntake +=newPetName +"\", \""+newPetType +"\", \"";
                        System.out.println("Please enter a description (such as breed or other information).");
                        String newPetDescription = input.nextLine();
                        newPetToIntake +="\", \""+newPetDescription +"\"))";
                        theVirtualPetShelter.intake(new VirtualPet(newPetName, newPetType, VirtualPetShelter.newMicroChipIDNumber(),newPetDescription));
                        VirtualPetShelterApp.outputMessageFromPreviousCycle = newPetName +" has been added to the shelter.";
                        break;
                    case 6:
                        outputMessageFromPreviousCycle = "We did nothing and the animals' levels have changed. ";
                        break;
                    case 7:
                        gameLoopState = false;
                        break;
                    default:
                        outputMessageFromPreviousCycle = "Sorry, that was not one of the options. Please try again. ";
                        break;
                }
            VirtualPetShelter.tick(recentlyUpdatedDoNotChange);
            }

    }
}

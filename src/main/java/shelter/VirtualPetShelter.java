package shelter;
import java.util.*;

import static java.lang.Integer.parseInt;

public class VirtualPetShelter {
    protected static Map<String, VirtualPet> allPetRecordsForTheShelter = new HashMap<>();
    Scanner input = new Scanner(System.in);

    public static void tick(String recentlyUpdatedDoNotChange) {
        for (VirtualPet i : allPetRecordsForTheShelter.values()) {
            int[] petLevelsInputInt = {parseInt(i.foodLevel), parseInt(i.waterLevel), parseInt(i.happyLevel)};
            String[] petLevelsOutputString = {"", "", ""};

            for (int j = 0; j < 3; j++) {
                if (recentlyUpdatedDoNotChange.equals("foodLevel") && j == 0) {continue;}
                if (recentlyUpdatedDoNotChange.equals("waterLevel") && j == 1) {continue;}
                if (recentlyUpdatedDoNotChange.equals("happyLevel") && j == 2) {continue;}
                petLevelsInputInt[j] -= ((int)(15*Math.random()));
                if (petLevelsInputInt[j] < 0) {petLevelsInputInt[j] = 0;}
            }

            for (int k = 0; k < petLevelsInputInt.length; k++) {
                petLevelsOutputString[k] = String.valueOf(petLevelsInputInt[k]);
            }

            i.foodLevel = petLevelsOutputString[0];
            i.waterLevel = petLevelsOutputString[1];
            i.happyLevel =  petLevelsOutputString[2];

            if (parseInt(i.foodLevel) <= 0 || parseInt(i.waterLevel) <= 0 || parseInt(i.happyLevel) <= 0) {
                System.out.println(
                                "==============================\n" +
                                "     Sorry, " + i.petName + " died. \n" +
                                "         Game Over\n" +
                                "==============================");
                VirtualPetShelterApp.gameLoopState = false;
            }
        }
        recentlyUpdatedDoNotChange = "";
    }



    public void feedAllPets() {
        for (VirtualPet i : allPetRecordsForTheShelter.values()) {
            int newFoodLevelInt = parseInt(i.foodLevel) + (int) (25 + 30 * Math.random());
            if (newFoodLevelInt >= 100) {
                newFoodLevelInt = 100;
            }
            String newFoodLevelStr = String.valueOf(newFoodLevelInt);
            i.foodLevel = newFoodLevelStr;
        }
        VirtualPetShelterApp.outputMessageFromPreviousCycle = "All the pets have been fed.";
    }

    public void waterAllPets() {
        for (VirtualPet i : allPetRecordsForTheShelter.values()) {
            int newWaterLevelInt = parseInt(i.waterLevel) + (int) (25 + 30 * Math.random());
            if (newWaterLevelInt >= 100) {
                newWaterLevelInt = 100;
            }
            String newWaterLevelStr = String.valueOf(newWaterLevelInt);
            i.waterLevel = newWaterLevelStr;
        }
        VirtualPetShelterApp.outputMessageFromPreviousCycle = "All the pets have been watered.";
    }

    public void playWithPet(String petToPlayWithStr) {
        if (VirtualPetShelter.getPetByName(petToPlayWithStr) != null) {
            VirtualPet selectedVirtualPetToPlayWith = VirtualPetShelter.getPetByName(petToPlayWithStr);
            int newHappyLevelInt = parseInt(selectedVirtualPetToPlayWith.happyLevel) + (int) (25 + 30 * Math.random());
            if (newHappyLevelInt >= 100) {
                newHappyLevelInt = 100;
            }
            String newHappyLevelStr = String.valueOf(newHappyLevelInt);
            selectedVirtualPetToPlayWith.happyLevel = newHappyLevelStr;
            VirtualPetShelterApp.outputMessageFromPreviousCycle = selectedVirtualPetToPlayWith.petName + " had fun playing with you.";
        } else {
            VirtualPetShelterApp.outputMessageFromPreviousCycle = "Please try again. That name does not match our records. The name is case-sensitive.";
        }
    }

    public static VirtualPet getPetByName(String searchString) {
        VirtualPet virtualPetSearchResults = allPetRecordsForTheShelter.get(searchString);
        return virtualPetSearchResults;
    }

    public void intake(VirtualPet virtualPet) {
        allPetRecordsForTheShelter.put(virtualPet.petName, virtualPet);
    }

    public void adopt(String petToAdopt){
        if( VirtualPetShelter.getPetByName(petToAdopt) != null) {
            allPetRecordsForTheShelter.remove(VirtualPetShelter.getPetByName(petToAdopt).petName);
            VirtualPetShelterApp.outputMessageFromPreviousCycle = petToAdopt + " has been adopted and the records are updated too.";
        } else {
            VirtualPetShelterApp.outputMessageFromPreviousCycle = "Please try again. That name does not match our records. The name is case-sensitive.";
        }
    }

    public static Collection<VirtualPet> getAllPets() {
        return allPetRecordsForTheShelter.values();
    }

    public String listOfAllPets() {
        String allPetsString = "";
        for (VirtualPet i : getAllPets()) {
            allPetsString += i + "\n";
        }
        return allPetsString;


    }
    public static String newMicroChipIDNumber() {
        String microChipIDNumber;
        do {
            microChipIDNumber = String.valueOf((long) (Math.random() * 10000000*100000000));
        } while (
                checkForDuplicateMicroChipID(microChipIDNumber)
        );
        return microChipIDNumber;
    }

    public static boolean checkForDuplicateMicroChipID(String newMicroChipIDNumber){
        boolean isNotDuplicate = false;
        if (VirtualPetShelter.allPetRecordsForTheShelter.containsValue(newMicroChipIDNumber)) {
            isNotDuplicate = false;
        }
        return isNotDuplicate;
    }
}


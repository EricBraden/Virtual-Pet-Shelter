package shelter;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetShelterTest {

    @Test
    public void shouldUpDateAllPetsLevelsWithTickMethod(){
        boolean[] arrayOfBooleanResultsForChangeInLevels = {false, false, false};
        int[] changeInPetsLevel = {0 ,0 ,0};
        VirtualPetShelter newVirtualPetShelter = new VirtualPetShelter();
        VirtualPetShelter.allPetRecordsForTheShelter.put("Harry", new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel = "10";
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel = "10";
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel = "10";
        int[] preTickPetsLevels = {parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel), parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel), parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel)};
        VirtualPetShelter.tick("");
        int[] postTickPetsLevels = {parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel), parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel), parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel)};
        for(int i = 0; i < 3; i++) {
            changeInPetsLevel[i] = postTickPetsLevels[i] - preTickPetsLevels[i];
            if (changeInPetsLevel[i] != 0) {
                arrayOfBooleanResultsForChangeInLevels[i] = true;
            }
            assertTrue(arrayOfBooleanResultsForChangeInLevels[i]);
        }
    }

    @Test
    public void shouldFeedAllPets(){
        int changeInFoodLevel = 0;
        VirtualPetShelter newVirtualPetShelter = new VirtualPetShelter();
        VirtualPetShelter.allPetRecordsForTheShelter.put("Harry", new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        VirtualPetShelter.allPetRecordsForTheShelter.put("Harry's cousin", new VirtualPet("Harry's cousin", "cat", "098765736465758", "2nd best pet for coders"));
        if (parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel) == 100) {
            VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel = "10";
        }
        int preFeedAllPetsLevelsForHarry = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel);
        if (parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel) == 100) {
            VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").foodLevel = "10";
        }
        int preFeedAllPetsLevelsForHarrysCousin = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").foodLevel);
        newVirtualPetShelter.feedAllPets();
        int postFeedAllPetsLevelsForHarry = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel);
        int postFeedAllPetsLevelsForHarrysCousin = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").foodLevel);
        changeInFoodLevel = preFeedAllPetsLevelsForHarry - postFeedAllPetsLevelsForHarry;
        assertTrue(changeInFoodLevel != 0);
        changeInFoodLevel = 0;
        changeInFoodLevel = preFeedAllPetsLevelsForHarrysCousin - postFeedAllPetsLevelsForHarrysCousin;
        assertTrue(changeInFoodLevel != 0);
    }

    @Test
    public void shouldWaterAllPets() {
        boolean foodLevelChanges = false;
        int changeInWaterLevel = 0;
        VirtualPetShelter newVirtualPetShelter = new VirtualPetShelter();
        newVirtualPetShelter.allPetRecordsForTheShelter.put("Harry", new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        newVirtualPetShelter.allPetRecordsForTheShelter.put("Harry's cousin", new VirtualPet("Harry's cousin", "cat", "098765736465758", "2nd best pet for coders"));
        if (parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel) == 100) {
            VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel = "10";
        }
        int preWaterAllPetsLevelsForHarry = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel);
        if (parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").waterLevel) == 100) {
            VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").waterLevel = "10";
        }
        int preWaterAllPetsLevelsForHarrysCousin = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").waterLevel);
        newVirtualPetShelter.waterAllPets();
        int postWaterAllPetsLevelsForHarry = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel);
        int postWaterAllPetsLevelsForHarrysCousin = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry's cousin").waterLevel);
        changeInWaterLevel = preWaterAllPetsLevelsForHarry - postWaterAllPetsLevelsForHarry;
        assertTrue(changeInWaterLevel != 0);
        changeInWaterLevel = 0;
        changeInWaterLevel = preWaterAllPetsLevelsForHarrysCousin - postWaterAllPetsLevelsForHarrysCousin;
        assertTrue(changeInWaterLevel != 0);
    }

    @Test
    public void updatesHappyLevelWithPlayWithPetMethod(){
        VirtualPetShelter newVirtualPetShelter = new VirtualPetShelter();
        newVirtualPetShelter.allPetRecordsForTheShelter.put("Harry", new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        if (parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel) == 100) {
            VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel = "10";
        }
        int prePlayLevel = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel);
        newVirtualPetShelter.playWithPet("Harry");
        int postPlayLevel = parseInt(VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel);
        int changeInPlayLevel = prePlayLevel-postPlayLevel;
        assertTrue(changeInPlayLevel != 0);
    }

    @Test
    public void shouldReturnVirtualPetByPassingNameToMethod(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        theVirtualPetShelter.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        VirtualPet result = VirtualPetShelter.getPetByName("Harry");
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").foodLevel = "10";
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").waterLevel = "10";
        VirtualPetShelter.allPetRecordsForTheShelter.get("Harry").happyLevel = "10";
        String resultInStringForm = VirtualPetShelter.allPetRecordsForTheShelter.get("Harry") + "";
        VirtualPet expectedResult = new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders");
        expectedResult.foodLevel = "10";
        expectedResult.waterLevel = "10";
        expectedResult.happyLevel = "10";
        String expectedResultInStringForm = expectedResult + "";
        boolean stringEqualityResult = expectedResultInStringForm.equals(resultInStringForm);
        assertTrue(stringEqualityResult);
    }

    @Test
    public void shouldAddAnimalToTheShelter(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        Map<String, VirtualPet> allPetRecordsForTheShelter = new HashMap<>();
        int startingLengthOfListOfAnimals = theVirtualPetShelter.allPetRecordsForTheShelter.size();
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        int endingLengthOfListOfAnimals = theVirtualPetShelter.allPetRecordsForTheShelter.size();;
        int changeInNumberOfAnimalsInListOfAnimals = endingLengthOfListOfAnimals - startingLengthOfListOfAnimals;
        assertTrue(changeInNumberOfAnimalsInListOfAnimals == 1);
    }

    @Test
    public void shouldRemoveAPetFromTheSheltersRecords(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        int startingLengthOfListOfAnimals = theVirtualPetShelter.allPetRecordsForTheShelter.size();
        theVirtualPetShelter.adopt("Fido");
        int endingLengthOfListOfAnimals = theVirtualPetShelter.allPetRecordsForTheShelter.size();
        int changeInNumberOfAnimalsInListOfAnimals = endingLengthOfListOfAnimals - startingLengthOfListOfAnimals;
        assertTrue(changeInNumberOfAnimalsInListOfAnimals == -1);
    }

    @Test
    public void getsAllPets(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        theVirtualPetShelter.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        theVirtualPetShelter.intake(new VirtualPet("Spot", "dog", "125497658254861", "Rhodesian Ridgeback"));
        int count = 0;
        for (VirtualPet i : theVirtualPetShelter.getAllPets()) {
            count++;
        }
    }

    @Test
    public void listsAllPets(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        theVirtualPetShelter.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        theVirtualPetShelter.intake(new VirtualPet("Spot", "dog", "125497658254861", "Rhodesian Ridgeback"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("Harry"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("Fido"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("Spot"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("cat"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("dog"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("635484897233351"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("820874598506612"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("125497658254861"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("best pet for coders"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("Belgian Malinois"));
        assertTrue(theVirtualPetShelter.listOfAllPets().contains("Rhodesian Ridgeback"));
    }

    @Test
    public void generatesNew15DigitMicrochipIDNumber(){
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        boolean isNumeric = true;
        String newMicroChipIDNumber = theVirtualPetShelter.newMicroChipIDNumber();
        assertTrue(newMicroChipIDNumber.length() == 15);

        try {
            Double testingForNumbersOnly = Double.parseDouble(newMicroChipIDNumber);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        assertTrue(isNumeric);
    }

    @Test
    public void checksForDuplicateMicrochipIDNumber(){
        boolean isNotADuplicateIDNumber = true;
        VirtualPetShelter theVirtualPetShelter = new VirtualPetShelter();
        theVirtualPetShelter.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        theVirtualPetShelter.intake(new VirtualPet("Fido", "dog", "820874598506612", "Belgian Malinois"));
        theVirtualPetShelter.intake(new VirtualPet("Spot", "dog", "125497658254861", "Rhodesian Ridgeback"));
        isNotADuplicateIDNumber = theVirtualPetShelter.checkForDuplicateMicroChipID("635484897233351");
        assertFalse(isNotADuplicateIDNumber);
    }

}
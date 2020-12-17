package shelter;

import org.junit.jupiter.api.Test;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void shouldReturnConcatenatedStringOfVirtualPetsValues(){
        VirtualPetShelter theVirtualPetShelter2 = new VirtualPetShelter();
            theVirtualPetShelter2.intake(new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders"));
        String concatenatedStringOfValues = "";
        String allPetsString = "";
            for (VirtualPet i : theVirtualPetShelter2.getAllPets()) {
            allPetsString += i + "";
            concatenatedStringOfValues = "  cat\t  | 635484897233351\t|  " + i.foodLevel + "%\t|  " + i.waterLevel + "%\t|     " + i.happyLevel + "%    |\tHarry\t| best pet for coders";
            }
            assertEquals(allPetsString, concatenatedStringOfValues);
        }

    @Test   //  random1to100
    public void shouldReturnRandomNumberFromOnetoOneHundred(){
        boolean result = false;
        VirtualPet virtualPet = new VirtualPet("Harry", "cat", "635484897233351", "best pet for coders");
        String randomNumberStr = virtualPet.random1to100();
        int randomNumberInt = parseInt(randomNumberStr);
        if (randomNumberInt >= 0 && randomNumberInt <= 100) {
            result = true;
        }
        assertEquals(true, result);
    }
}
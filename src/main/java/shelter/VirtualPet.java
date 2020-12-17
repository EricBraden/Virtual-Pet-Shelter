package shelter;

public class VirtualPet {
    protected String microChipIDNumber;
    protected String petName;
    protected String petType;
    protected String foodLevel;
    protected String waterLevel;
    protected String happyLevel;
    protected String petDescription;

    public VirtualPet(String petName, String petType, String microChipIDNumber, String petDescription){
        this.petName = petName;
        this.petType = petType;
        this.microChipIDNumber = microChipIDNumber;
        this.foodLevel = random1to100();
        this.waterLevel = random1to100();
        this.happyLevel = random1to100();
        this.petDescription = petDescription;
    }

    @Override
    public String toString() {
        return "  " + petType + "\t  | " + microChipIDNumber + "\t|  " + foodLevel + "%\t|  " + waterLevel + "%\t|     " + happyLevel + "%    |\t" + petName + "\t| " + petDescription;
    }

    public static String random1to100(){
        int mathStuff = 20+(int)(Math.random()*100);
        if (mathStuff >= 100) {
            mathStuff = 100;
        }
        String convertIntToString = String.valueOf(mathStuff);
        return convertIntToString;
    }
}

import java.util.Scanner;

/**
 * Represents an insurance policy with details such as policy number, policyholder's personal information, and policy pricing.
 */
public class Policy {
    private int policyNum;
    private int holderAge;
    private int holderSmoking;
    private int holderHeight;
    private double holderWeight;
    private double holderBMI;
    private double policyPrice;
    private double addedFees;
    private double finalPolicyPrice;
    private String holderFirstName;
    private String holderLastName;
    private String providName;

    /**
     * No-argument constructor for the Policy class. Initializes default values for the fields.
     */
    public Policy() {
        this.policyNum = 0;
        this.holderAge = 0;
        this.holderSmoking = 0;
        this.holderHeight = 0;
        this.holderWeight = 0.0;
        this.holderBMI = 0.0;
        this.policyPrice = 600.0;
        this.addedFees = 0.0;
        this.finalPolicyPrice = 600.0;
        this.holderFirstName = "";
        this.holderLastName = "";
        this.providName = "";
    }

    /**
     * Constructor for creating a Policy object with specified values.
     * 
     * @param policyNum The unique identifier for the policy.
     * @param providName The name of the insurance provider.
     * @param holderFirstName The first name of the policyholder.
     * @param holderLastName The last name of the policyholder.
     * @param holderAge The age of the policyholder.
     * @param holderSmoking The smoking status of the policyholder (1 for smoker, 0 for non-smoker).
     * @param holderHeight The height of the policyholder in inches.
     * @param holderWeight The weight of the policyholder in pounds.
     */
    public Policy(int policyNum, String providName, String holderFirstName, String holderLastName, int holderAge, int holderSmoking, int holderHeight, double holderWeight) {
        this.policyNum = policyNum;
        this.providName = providName;
        this.holderFirstName = holderFirstName;
        this.holderLastName = holderLastName;
        this.holderAge = holderAge;
        this.holderSmoking = holderSmoking;
        this.holderHeight = holderHeight;
        this.holderWeight = holderWeight;
        this.holderBMI = (holderWeight * 703) / (holderHeight * holderHeight);
        this.policyPrice = 600.0;
        this.addedFees = calculateAddedFees();
        this.finalPolicyPrice = this.policyPrice + this.addedFees;
    }

    // Getters and setters

    /**
     * Gets the policy number.
     * 
     * @return The policy number.
     */
    public int getPolicyNum() {
        return policyNum;
    }

    /**
     * Sets the policy number.
     * 
     * @param policyNum The policy number to set.
     */
    public void setPolicyNum(int policyNum) {
        this.policyNum = policyNum;
    }

    /**
     * Gets the age of the policyholder.
     * 
     * @return The policyholder's age.
     */
    public int getHolderAge() {
        return holderAge;
    }

    /**
     * Sets the age of the policyholder.
     * 
     * @param holderAge The age of the policyholder to set.
     */
    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
        updateFinalPolicyPrice();
    }

    /**
     * Gets the smoking status of the policyholder.
     * 
     * @return 1 if the policyholder is a smoker, 0 if non-smoker.
     */
    public int getHolderSmoking() {
        return holderSmoking;
    }

    /**
     * Sets the smoking status of the policyholder.
     * 
     * @param holderSmoking The smoking status to set (1 for smoker, 0 for non-smoker).
     */
    public void setHolderSmoking(int holderSmoking) {
        this.holderSmoking = holderSmoking;
        updateFinalPolicyPrice();
    }

    /**
     * Gets the weight of the policyholder in pounds.
     * 
     * @return The weight of the policyholder.
     */
    public double getHolderWeight() {
        return holderWeight;
    }

    /**
     * Sets the weight of the policyholder in pounds.
     * 
     * @param holderWeight The weight of the policyholder to set.
     */
    public void setHolderWeight(double holderWeight) {
        this.holderWeight = holderWeight;
        this.holderBMI = (holderWeight * 703) / (holderHeight * holderHeight);
        updateFinalPolicyPrice();
    }

    /**
     * Gets the height of the policyholder in inches.
     * 
     * @return The height of the policyholder.
     */
    public int getHolderHeight() {
        return holderHeight;
    }

    /**
     * Sets the height of the policyholder in inches.
     * 
     * @param holderHeight The height of the policyholder to set.
     */
    public void setHolderHeight(int holderHeight) {
        this.holderHeight = holderHeight;
        this.holderBMI = (holderWeight * 703) / (holderHeight * holderHeight);
        updateFinalPolicyPrice();
    }

    /**
     * Gets the BMI (Body Mass Index) of the policyholder.
     * 
     * @return The BMI of the policyholder.
     */
    public double getHolderBMI() {
        return holderBMI;
    }

    /**
     * Gets the base policy price.
     * 
     * @return The base price of the policy.
     */
    public double getPolicyPrice() {
        return policyPrice;
    }

    /**
     * Gets the final policy price after all calculations and added fees.
     * 
     * @return The final policy price.
     */
    public double getFinalPolicyPrice() {
        return finalPolicyPrice;
    }

    /**
     * Gets the first name of the policyholder.
     * 
     * @return The first name of the policyholder.
     */
    public String getHolderFirstName() {
        return holderFirstName;
    }

    /**
     * Sets the first name of the policyholder.
     * 
     * @param holderFirstName The first name of the policyholder to set.
     */
    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    /**
     * Gets the last name of the policyholder.
     * 
     * @return The last name of the policyholder.
     */
    public String getHolderLastName() {
        return holderLastName;
    }

    /**
     * Sets the last name of the policyholder.
     * 
     * @param holderLastName The last name of the policyholder to set.
     */
    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    /**
     * Gets the name of the insurance provider.
     * 
     * @return The name of the insurance provider.
     */
    public String getProvidName() {
        return providName;
    }

    /**
     * Sets the name of the insurance provider.
     * 
     * @param providName The name of the insurance provider to set.
     */
    public void setProvidName(String providName) {
        this.providName = providName;
    }

    /**
     * Calculates any added fees based on the policyholder's details (age, smoking, BMI).
     * 
     * @return The calculated added fees.
     */
    private double calculateAddedFees() {
        double fees = 0.0;
        if (holderAge > 50) {
            fees += 75;
        }
        if (holderSmoking == 1) {
            fees += 100;
        }
        if (holderBMI > 35) {
            fees += ((holderBMI - 35) * 20);
        }
        return fees;
    }

    /**
     * Updates the final policy price by recalculating the added fees and combining them with the base policy price.
     */
    private void updateFinalPolicyPrice() {
        this.addedFees = calculateAddedFees();
        this.finalPolicyPrice = this.policyPrice + this.addedFees;
    }

    /**
     * Main method that runs the program to collect user input and display policy information.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Create a Policy object using the no-argument constructor
        Policy policy = new Policy();

        // Display prompts and read user input
        System.out.println("Please enter the Policy Number: ");
        policy.setPolicyNum(keyboard.nextInt());
        keyboard.nextLine();

        System.out.println("Please enter the Insurance provider's name: ");
        policy.setProvidName(keyboard.nextLine());

        System.out.print("Please enter the Policyholder's First Name: ");
        policy.setHolderFirstName(keyboard.nextLine());

        System.out.print("Please enter the Policyholder's Last Name: ");
        policy.setHolderLastName(keyboard.nextLine());

        System.out.println("Please enter the Policyholder’s Age: ");
        policy.setHolderAge(keyboard.nextInt());

        System.out.println("Please enter the Policyholder's Smoking Status: ");
        System.out.println("\t1. Smoker");
        System.out.println("\t2. Non-Smoker");
        policy.setHolderSmoking(keyboard.nextInt());

        System.out.println("Please enter the Policyholder’s Height (in inches): ");
        policy.setHolderHeight(keyboard.nextInt());

        System.out.println("Please enter the Policyholder’s Weight (in pounds): ");
        policy.setHolderWeight(keyboard.nextDouble());

        // Output the collected information
        System.out.println("Policy Number: " + policy.getPolicyNum());
        System.out.println("Provider Name: " + policy.getProvidName());
        System.out.println("Policyholder's First Name: " + policy.getHolderFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getHolderLastName());
        System.out.println("Policyholder's Age: " + policy.getHolderAge());
        System.out.println("Policyholder's Smoking Status: " + (policy.getHolderSmoking() == 1 ? "Smoker" : "Non-Smoker"));
        System.out.println("Policyholder's Height: " + policy.getHolderHeight());
        System.out.println("Policyholder's Weight: " + policy.getHolderWeight());
        System.out.println("Policyholder's BMI: " + policy.getHolderBMI());
        System.out.println("Policy Price: $" + policy.getFinalPolicyPrice());
    }
}

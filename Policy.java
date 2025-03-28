import java.util.Scanner;

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

    // No-arg constructor
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

    // Constructor
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

    // getters and setters
    public int getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(int policyNum) {
        this.policyNum = policyNum;
    }

    public int getHolderAge() {
        return holderAge;
    }

    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
        updateFinalPolicyPrice();
    }

    public int getHolderSmoking() {
        return holderSmoking;
    }

    public void setHolderSmoking(int holderSmoking) {
        this.holderSmoking = holderSmoking;
        updateFinalPolicyPrice();
    }

    public double getHolderWeight() {
        return holderWeight;
    }

    public void setHolderWeight(double holderWeight) {
        this.holderWeight = holderWeight;
        this.holderBMI = (holderWeight * 703) / (holderHeight * holderHeight);
        updateFinalPolicyPrice();
    }

    public int getHolderHeight() {
        return holderHeight;
    }

    public void setHolderHeight(int holderHeight) {
        this.holderHeight = holderHeight;
        this.holderBMI = (holderWeight * 703) / (holderHeight * holderHeight);
        updateFinalPolicyPrice();
    }

    public double getHolderBMI() {
        return holderBMI;
    }

    public double getPolicyPrice() {
        return policyPrice;
    }

    public double getFinalPolicyPrice() {
        return finalPolicyPrice;
    }

    public String getHolderFirstName() {
        return holderFirstName;
    }

    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    public String getHolderLastName() {
        return holderLastName;
    }

    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
    }

    public String getProvidName() {
        return providName;
    }

    public void setProvidName(String providName) {
        this.providName = providName;
    }

    // Method to calculate added fees
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

    // Method to update final policy price
    private void updateFinalPolicyPrice() {
        this.addedFees = calculateAddedFees();
        this.finalPolicyPrice = this.policyPrice + this.addedFees;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Create a Policy object using the no-argument constructor
        Policy policy = new Policy();

        // Display for User's input for policy number
        System.out.println("Please enter the Policy Number: ");
        policy.setPolicyNum(keyboard.nextInt());
        keyboard.nextLine();

        // Display for User's input the provider's name
        System.out.println("Please enter the Insurance provider's name: ");
        policy.setProvidName(keyboard.nextLine());

        // Get the customer's first and last name
        System.out.print("Please enter the Policyholder's First Name: ");
        policy.setHolderFirstName(keyboard.nextLine());

        System.out.print("Please enter the Policyholder's Last Name: ");
        policy.setHolderLastName(keyboard.nextLine());

        // Display for User's input for their age
        System.out.println("Please enter the Policyholder’s Age: ");
        policy.setHolderAge(keyboard.nextInt());

        // Display a menu for smoking status and read the user's choice
        System.out.println("Please enter the Policyholder's Smoking Status: ");
        System.out.println("\t1. Smoker");
        System.out.println("\t2. Non-Smoker");
        policy.setHolderSmoking(keyboard.nextInt());

        // Display for User's input for their height in inches
        System.out.println("Please enter the Policyholder’s Height (in inches): ");
        policy.setHolderHeight(keyboard.nextInt());

        // Display for User's input for their weight in pounds
        System.out.println("Please enter the Policyholder’s Weight (in pounds): ");
        policy.setHolderWeight(keyboard.nextDouble());
        
        

        // Print out the output for the Insurance Policy Info
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

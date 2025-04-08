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

    private void updateFinalPolicyPrice() {
        this.addedFees = calculateAddedFees();
        this.finalPolicyPrice = this.policyPrice + this.addedFees;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Track how many smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Continuously ask the user to enter policies
        while (true) {
            Policy policy = new Policy();

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
            int smokingStatus = keyboard.nextInt();
            policy.setHolderSmoking(smokingStatus);

            System.out.println("Please enter the Policyholder’s Height (in inches): ");
            policy.setHolderHeight(keyboard.nextInt());

            System.out.println("Please enter the Policyholder’s Weight (in pounds): ");
            policy.setHolderWeight(keyboard.nextDouble());

            // Count smokers and non-smokers
            if (policy.getHolderSmoking() == 1) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }

            // Display the policy details
            System.out.println("\nPolicy Number: " + policy.getPolicyNum());
            System.out.println("Provider Name: " + policy.getProvidName());
            System.out.println("Policyholder's First Name: " + policy.getHolderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getHolderLastName());
            System.out.println("Policyholder's Age: " + policy.getHolderAge());
            System.out.println("Policyholder's Smoking Status: " + (policy.getHolderSmoking() == 1 ? "Smoker" : "Non-Smoker"));
            System.out.println("Policyholder's Height: " + policy.getHolderHeight());
            System.out.println("Policyholder's Weight: " + policy.getHolderWeight());
            System.out.println("Policyholder's BMI: " + policy.getHolderBMI());
            System.out.println("Policy Price: $" + policy.getFinalPolicyPrice());

            // Ask the user if they want to continue
            System.out.println("\nWould you like to enter another policy? (yes/no)");
            String continueInput = keyboard.next();
            if (continueInput.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Output the number of smokers and non-smokers
        System.out.println("\nTotal number of smokers: " + smokerCount);
        System.out.println("Total number of non-smokers: " + nonSmokerCount);
    }
}

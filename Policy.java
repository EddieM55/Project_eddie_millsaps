public class Policy
{  //fields
   private String policyNumber;
   private String providerName;
   private String FirstName;
   private String LastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   /**
   No-arg constructor that explicitly initializes all fields
   */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      FirstName = "";
      LastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }
   
   /**
   Constructor that accepts arguments for each field
   @param pNumber The Policy number
   @param pName The Policy Provider's Name
   @param fName The Policyhodler's first name
   @param lName The Policyholder's last name
   @param a The Policyholder's age
   @param sStatus The Policyholder's smoking status
   @param h The Policyholder's height
   @param w The Policytholder's weight
   */
   public Policy(String pNumber, String pName, String fName, String lName,int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      FirstName = fName;
      LastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }
   
   //getters//
   /**
   @return The Policy Number
   */
   public String getPolicyNumber()
   {
      return policyNumber;
   }
   
   /**
   @return The Policy Provider's Name
   */
   public String getProviderName()
   {
      return providerName;
   }
   
   /**
   @return The Policyholder's first name
   */
   public String getFirstName()
   {
      return FirstName;
   }
   
   /**
   @return The Policyholder's last name
   */
   public String getLastName()
   {
      return LastName;
   }
   
   /**
   @return The Policyholder's age
   */
   public int getAge()
   {
      return age;
   }
   
   /**
   @return The Policyholder's smoking status
   */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }
   
   /**
   @return The Policyholder's height
   */
   public double getHeight()
   {
      return height;
   }
   
   /**
   @return The Policyholder's weight
   */
   public double getWeight()
   {
      return weight;
   }
   
   //setters//
   
   /**
   @param pNumber The Policy Number
   */
   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }
   
   /**
   @param pName The Policy Provider's name
   */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }
   
   /**
   @param fName The Policy Provider's first name
   */
   public void setFirstName(String fName)
   {
      FirstName = fName;
   }
   
   /**
   @param lName The Policy Provider's last name
   */
   public void setLastName(String lName)
   {
      LastName = lName;
   }
   
   /**
   @param a The Policy Provider's age
   */
   public void setAge(int a)
   {
      age = a;
   }
   
   /**
   @param sStatus The Policy Provider's smoking status
   */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }
   
   /**
   @param h The Policy Provider's height
   */
   public void setHeight(double h)
   {
      height = h;
   }
   
   /**
   @param w The Policy Provider's weight
   */
   public void setWeight(double w)
   {
      weight = w;
   }
   
   /**
   Calculates the Policyholder's BMI
   @return The BMI of the Policyholder
   */
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
   
   /**
   Calculates the Policy's price
   @return The price of the Policy
   */
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;
      
      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;
      
      double price = BASE_PRICE;
      
      if(age > AGE_THRESHOLD)
         price += ADDITIONAL_FEE_AGE;
         
      if(smokingStatus.equalsIgnoreCase("smoker"))
         price += ADDITIONAL_FEE_SMOKING;
      
      if(getBMI() > BMI_THRESHOLD)
         price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);
         
      return price;
   }

   Displays information about the Policy
   public void displayInformation()
   {
      System.out.println("Policy Number: " + policyNumber);
      System.out.println("Provider Name: " + providerName);
      System.out.println("Policyholder's First Name: " + firstName);
      System.out.println("Policyholder's Last Name: " + lastName);
      System.out.println("Policyholder's Age: " + age);
      System.out.println("Policyholder's Smoking Status (Y/N): " + smokingStatus);
      System.out.println("Policyholder's Height: " + height + " inches");
      System.out.println("Policyholder's Weight: " + weight + " pounds");
      System.out.printf("Policyholder's BMI: %.2f\n", getBMI());
      System.out.printf("Policy Price: $%.2f\n", getPrice());
   }
   
}

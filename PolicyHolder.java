public class PolicyHolder {
    // fields
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
    No-arg constructor that explicitly initializes all fields
    */
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
    Constructor that accepts arguments for each field
    @param fName The Policyhodler's first name
    @param lName The Policyholder's last name
    @param a The Policyholder's age
    @param sStatus The Policyholder's smoking status
    @param h The Policyholder's height
    @param w The Policytholder's weight
    */
    public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w) {
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = sStatus;
        height = h;
        weight = w;
    }

    //getters//
    /**
    @return The Policy Holder's First Name
    */
    public String getFirstName()  
    { 
      return firstName; 
    }
    
    /**
    @return The Policy Holder's Last Name
    */
    public String getLastName() 
    { 
      return lastName; 
    }
    
    /**
    @return The Policy Holder's Age
    */
    public int getAge() 
    { 
      return age; 
    }
    
    /**
    @return The Policy Holder's Smoking Status
    */
    public String getSmokingStatus() 
    { 
      return smokingStatus; 
    }
    
    /**
    @return The Policy Holder's Height
    */
    public double getHeight() 
    { 
      return height; 
    }
    
    /**
    @return The Policy Holder's Weight
    */
    public double getWeight() 
    { 
      return weight; 
    }

    //setters//
   
    /**
    @param fName The Policy Holder's First Name
    */
    public void setFirstName(String fName) 
    { 
      firstName = fName; 
    }
    
    /**
    @param fName The Policy Holder's Last Name
    */

    public void setLastName(String lName) 
    { 
      lastName = lName; 
    }
    
    /**
    @param a The Policy Holder's Age
    */
    public void setAge(int a) 
    { 
      age = a; 
    }
    
    /**
    @param sStatus The Policy Holder's Smoking Status
    */
    public void setSmokingStatus(String sStatus) 
    { 
      smokingStatus = sStatus; 
    }
    
    /**
    @param h The Policy Holder's Height
    */
    public void setHeight(double h) 
    { 
      height = h; 
    }
    
    /**
    @param w The Policy Holder's Weight
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
   
    // toString Method
    public String toString() 
    {
      return "Policyholder's First Name: " + firstName + "\n" +
             "Policyholder's Last Name: " + lastName + "\n" +
             "Policyholder's Age: " + age + "\n" +
             "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n" +
             "Policyholder's Height: " + height + " inches\n" +
             "Policyholder's Weight: " + weight + " pounds\n" +
             String.format("Policyholder's BMI: %.2f\n", getBMI());
    }
}
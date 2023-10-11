package DiseaseManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InfectedUserData {
    String date = "";
    int formNumber = 0;
    String formStatus = "";
    String data = "";
    String email = "";
    String birthdate = "";
    String name = "";
    int numChildren = 0;

    // 0 is false, 1 is true
    boolean isGuardian = false;

    // 1 is true
    boolean isParent = false;

    public InfectedUserData(String name, String data, String email, String birthdate, int numChildren, boolean isGuardian,
            boolean isParent) {
        this.data = data;
        this.email = email;
        this.birthdate = birthdate;
        this.numChildren = numChildren;
        this.isGuardian = isGuardian;
        this.isParent = isParent;
        this.name = name;
    }

    
    /** 
     * Get the data.
     * @return Returns the data. 
     */
    public String getData() {
        return this.data;
    }

    /** 
     * Get the name.
     * @return Returns the name. 
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * Get the length of the data.
     * @return Returns the length of the data.
     */
    public int getDataSize() {
        return this.data.length();
    }

    
    /** 
     * Get the email.
     * @return Returns the email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get the length of the Email.
     * @return Returns the length of the email.
     */
    public int getEmailLength() {
        return this.email.length();
    }

    /**
     * Get the birthdate.
     * @return Returns the birthdate.
     */
    public String getBirthdate() {
        return this.birthdate;
    }

    /**
     * Get length of birthdate.
     * @return Returns length of the birthdate.
     */
    public int getBirthdateLength() {
        return this.birthdate.length();
    }

    /**
     * Get number of children.
     * @return Returns number of children.
     */
    public int getNumChildren() {
        return this.numChildren;
    }

    /**
     * Setter for email.
     * @param email New email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter for form number.
     * @param number Form number.
     */
    public void setFormNumber(int number) {
        this.formNumber = number;
    }

    /**
     * Setter for the data.
     * @param data New data.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Setter for the name.
     * @param name New name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the date.
     * @param date New date.
     */
    public void setDateToCurrent(String date) {

        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Format the current date as a string
        String formattedDate = currentDate.format(formatter);

        this.date = formattedDate;
    }

    /**
     * Setter for the birthdate.
     * @param birthdate New birthdate.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Setter for number of children.
     * @param numchildren New number of children.
     */
    public void setNumChildren(int numchildren) {
        this.numChildren = numchildren;
    }

    /**
     * Validates length of Infectious data.
     * @param data Infectious data.
     * @return Returns 0 for invalid, 1 for valid. 
     */
    public int validateInfectiousData(String data) {

        if (data == null) {
            return 0;
        }

        if (data.length() > 321) {
            return 0;
        } else if (data.length() <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateEmail(String email) {

        if (email == null) {
            return 0;
        }

        if (email.length() < 5) {
            return 0;
        } else if (email.length() > 60) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateBirthdate(String birthdate) {

        char[] birthdateArray = birthdate.toCharArray();

        for (int i = 0; i < birthdateArray.length; i++) {
            if (Character.isLetter(birthdateArray[i])) {
                return 0;
            }
        }
        if (birthdate.length() != 10) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateNumChild(int numChild) {

        if (String.valueOf(numChild) == null) {
            return 0;
        }
        if (numChild < 0) {
            return 0;
        } else if (numChild > 100) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateName(String name) {
        
        if (name == null) {
            return 0;
        }

        if (name.length() <= 0) {
            return 0;
        } else if (name.length() > 60) {
            return 0;
        } else {
            return 1;
        }
    }

    public int calculateFormNumber() {
        int formNumber = 0;

        return formNumber;
    }

    public void storeAllData() {

    }

    public void addEntry() {

    }

}
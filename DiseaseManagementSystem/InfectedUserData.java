package DiseaseManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 */
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

    /**
     * Constructor for InfectedUserData object form.
     * @param name Name of the immigrant.
     * @param data Infectious disease data.
     * @param email Email of the immigrant.
     * @param birthdate Immigrant birthdate.
     * @param numChildren Number of children the immigrant has.
     * @param isGuardian Boolean if the immigrant is a guardian.
     * @param date Current date.
     */
    public InfectedUserData(String name, String data, String email, String birthdate, int numChildren, boolean isGuardian, String date) {
        this.data = data;
        this.email = email;
        this.birthdate = birthdate;
        this.numChildren = numChildren;
        this.isGuardian = isGuardian;
        this.name = name;
        this.date = date;
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
     * Get if user is a guardian.
     * @return Returns if user is a guardian.
     */
    public boolean getIsGuardian() {
        return this.isGuardian;
    }

    public String getDate() {
        return this.date;
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
     */
    public void setDateToCurrent() {

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
     * Setter method to see if user is a guardian.
     * @param isGuardian Says if user is a guardian or not.
     */
    public void setGuardian(boolean isGuardian) {
        this.isGuardian = isGuardian;
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

    /**
     * Validates the email.
     * @param email Email to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
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

    /**
     * Validates the brithdate
     * @param birthdate Birthdate to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateBirthdate(String birthdate) {

        if (birthdate == null) {
            return 0;
        }

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

    /**
     * Validates the number of children. 
     * @param numChild Number of children to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
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

    /**
     * Validates the immigrant name.
     * @param name Name of the immigrant to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateName(String name) {

        if (name == null) {
            return 0;
        }
        
        boolean containsNumber = name.matches(".*\\d.*");

        boolean containsSpecialCharacter = name.matches(".*[^a-zA-Z0-9\\s].*");

        if (containsNumber == true || containsSpecialCharacter == true) {
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

    /**
     * Calculates a unique form ID.
     * @return Returns unique form ID for the form.
     * @throws NoSuchAlgorithmException
     */
    public void calculateFormNumber() throws NoSuchAlgorithmException {

        String hashString = this.getEmail();

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // compute the hash of the input string
        byte[] hash = md.digest(hashString.getBytes());

        // convert the hash to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
        hexString.append(String.format("%02x", b));
        }

        String newEmail = hexString.toString();
        

        this.email = newEmail;
    }

    /**
     * Stores all the data in the
     */
    public void storeAllData() {

    }

    /**
     * Add the form ID and status of the form to the workflow table.
     */
    public void addEntry() {

    }

}
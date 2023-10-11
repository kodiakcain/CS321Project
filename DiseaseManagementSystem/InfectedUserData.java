package DiseaseManagementSystem;

public class InfectedUserData {
    String date = "";
    int formNumber = 0;
    String formStatus = "";
    String data = "";
    String email = "";
    String birthdate = "";
    int numChildren = 0;

    // 0 is false, 1 is true
    boolean isGuardian = false;

    // 1 is true
    boolean isParent = false;

    public InfectedUserData(String data, String email, String birthdate, int numChildren, boolean isGuardian,
            boolean isParent) {
        this.data = data;
        this.email = email;
        this.birthdate = birthdate;
        this.numChildren = numChildren;
        this.isGuardian = isGuardian;
        this.isParent = isParent;
    }

    
    /** 
     * Get the data.
     * @return Returns the data. 
     */
    public String getData() {
        return this.data;
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
     * Setter for the date.
     * @param date New date.
     */
    public void setDate(String date) {
        this.date = date;
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
        if (data.length() > 321) {
            return 0;
        } else if (data.length() <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateEmail(String email) {

        if (email.length() < 5) {
            return 0;
        } else if (email.length() > 60) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateBirthdate(String birthdate) {
        if (birthdate.length() != 10) {
            return 0;
        } else {
            return 1;
        }
    }

    public int validateNumChild(int numChild) {
        if (numChild < 0) {
            return 0;
        } else if (numChild > 100) {
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
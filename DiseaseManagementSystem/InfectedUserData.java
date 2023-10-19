package DiseaseManagementSystem;

public class InfectedUserData {

    /**
     * Date of form creation.
     */
    String date = "";

    /**
     * Unique formID.
     */
    int formID = 0;

    /**
     * Status of the form.
     */
    String formStatus = "";

    /**
     * Data within the form.
     */
    String data = "";

    /**
     * Email user provided.
     */
    String email = "";

    /**
     * Birthdate user enters.
     */
    String birthdate = "";

    /**
     * Immigrant name.
     */
    String name = "";

    /**
     * Number of children user has.
     */
    int numChildren = 0;

    /**
     * Boolean to show if the immigrant is a parent or guardian.
     */
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
    public void setformID(int number) {
        this.formID = number;
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

        return 0;
    }

    /**
     * Validates the email.
     * @param email Email to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateEmail(String email) {

        return 0;
    }

    /**
     * Validates the brithdate
     * @param birthdate Birthdate to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateBirthdate(String birthdate) {

        return 0;
    }

    /**
     * Validates the number of children. 
     * @param numChild Number of children to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateNumChild(int numChild) {

        return 0;
    }

    /**
     * Validates the immigrant name.
     * @param name Name of the immigrant to be validated.
     * @return Return 0 for invalid, 1 for valid.
     */
    public int validateName(String name) {

        return 0;
    }

    /**
     * Calculates a unique form ID.
     * @return Returns unique form ID for the form.
     */
    public void calculateformID() {

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
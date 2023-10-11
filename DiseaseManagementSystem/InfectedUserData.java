package DiseaseManagementSystem;
public class InfectedUserData {
    String date = "";
    int formNumber = 0;
    String formStatus = "";
    String data = "";
    String email = "";
    String birthdate = "";
    int numChildren = 0;

    //0 is false, 1 is true
    boolean isGuardian = false;

    //1 is true
    boolean isParent = false;

    public InfectedUserData (String data, String email, String birthdate, int numChildren, boolean isGuardian, boolean isParent) {
        this.data = data;
        this.email = email;
        this.birthdate = birthdate;
        this.numChildren = numChildren;
        this.isGuardian =  isGuardian;
        this.isParent = isParent;
    }

    public String getData() {
        return this.data; 
    }

    public int getDataSize() {
        return this.data.length(); 
    }

    public int validateInfectiousData(String data) {
        int flag = 0;

        return flag;
    }
    public void storeAllData() {

    }
    public void addEntry() {

    }
    public int validateEmail(String email) {
        int flag = 0;

        return flag;
    }
    public int validateBirthdate(String birthdate) {
        int flag = 0;

        return flag;
    }
    public int calculateFormNumber() {
        int formNumber = 0;

        return formNumber;
    }

    public int validateNumChild() {
        int flag = 0;

        return flag;
    }

}
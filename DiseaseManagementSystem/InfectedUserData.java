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
    int isGuardian = 0;

    //1 is true
    int isParent = 0;

    public InfectedUserData (String data, String email, String birthdate) {
        this.data = data;
        this.email = email;
        this.birthdate = birthdate;
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
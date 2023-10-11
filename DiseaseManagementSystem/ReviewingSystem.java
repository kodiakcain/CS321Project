package DiseaseManagementSystem;
import DiseaseManagementSystem.InfectedUserData;

public class ReviewingSystem {
    public boolean reviewStatus;

    public void loadReviewerScreen() {

    }

    public int getNextReviewID() {
        int ID = 0;

        return ID;
    }

    public InfectedUserData getNextReviewObject() {
        InfectedUserData revObj = new InfectedUserData(null, null, null, 0, reviewStatus, reviewStatus);

        return revObj;
    }

    public InfectedUserData loadForm() {
        InfectedUserData nextForm = new InfectedUserData(null, null, null, 0, reviewStatus, reviewStatus);

        return nextForm;
    }

    public boolean reviewForm() {
        boolean reviewed = true;

        return reviewed;
    }

    public void editForm() {

    }

    public void editFormState() {

    }

    public void submitForm() {

    }
}
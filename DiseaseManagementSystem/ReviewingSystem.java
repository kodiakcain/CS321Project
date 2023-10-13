package DiseaseManagementSystem;
import DiseaseManagementSystem.InfectedUserData;

/**
 * This is the ReviewingSystem class, which serves as a driver class for the reviewing system.
 * It allows the review agent to review InfectedUserData forms and ensure their accuracy
 * before sending them to the approval system.
 */
public class ReviewingSystem {

    public boolean reviewStatus;
   

    public void loadReviewerScreen() {

    }

    public int getNextReviewID() {
        int ID = 0;

        return ID;
    }

    public InfectedUserData getNextReviewObject() {
        InfectedUserData revObj = new InfectedUserData(null,null, null, null, 0, reviewStatus, reviewStatus, null);

        return revObj;
    }

    public InfectedUserData loadForm() {
        InfectedUserData nextForm = new InfectedUserData(null, null, null, null, 0, reviewStatus, reviewStatus, null);

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
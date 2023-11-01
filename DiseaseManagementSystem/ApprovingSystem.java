/**
 * TODO: 
 * 
 * update the Iteration 2 ApprovingSystem diagram:
 *     1. getNextApproveItemID() no longer returns void, but returns an int
 *     2. generateEmail() no longer returns void, but returns boolean to ensure
 *          that it worked successfully.
 *     3. returnForCorrection() no longer returns void, but returns boolean to
 *          ensure that it worked successfully.
 */

package DiseaseManagementSystem;

/**
 * An Approving System that either approves or declines an applicant's
 * Infectious Disease Form.
 * 
 * @author Youssef Melk
 */
public class ApprovingSystem {
    /**
     * The Approval status of an applicant's form;
     *     it can either be approved (true) or declined (false).
     */
    private boolean approvalStatus;

    /**
     * The applicant's Infectious Disease Form.
     */
    private InfectedUserData applicantForm;

    /**
     * Returns the approval status of the applicant's Infectious Disease Form.
     *     The form has either been approved or declined.
     * 
     * @return the approval status of the applicant's Infectious Disease Form.
     */
    public boolean getApprovalStatus() {
        return this.approvalStatus;
    }

    /**
     * Sets the status of the applicant's Infectious Disease form to either
     *     approved or declined using the given approvalStatus.
     * 
     * @param approvalStatus for the given status to set the applicant's
     *     Infectious Disease Form.
     */
    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * Returns the applicant's Infectious Disease form with its corresponding
     *     data.
     * 
     * @return the applicant's Infectious Disease form that contains its
     *     corresponding data.
     */
    public InfectedUserData getApplicantForm() {
        return this.applicantForm;
    }

    /**
     * Sets the applicant's Infectious Disease form with its corresponding
     *     data.
     * 
     * @param applicantForm for the InfectedUserData object that contains
     *     the data of the applicant's Infectious Disease Form.
     */
    public void setApplicantForm(InfectedUserData applicantForm) {
        this.applicantForm = applicantForm;
    }

    /**
     * Loads the screen of the approving process to begin.
     * 
     * @return true if the approving screen loaded successfully,
     *     otherwise return false.
     */
    public boolean loadApproverScreen() {
        int x = 0;

        return true;
    }

    /**
     * Retrieves the ID of the next applicant form to be reviewed.
     * 
     * @return the ID of the applicant form to be reviewed.
     */
    private int getNextApproveItemID() {
        int ID = 0;

        return ID;
    }

    /**
     * Retrieves the corresponding data of the applicant's form by using their
     *     form's given ID number.
     * 
     * @param ID for the given identification number of the applicant's form to
     *     be used to retrieve the form's corresponding data.
     * @return the applicant's form with its corresponding data using their
     *     form's given ID number.
     */
    private InfectedUserData loadForm(int ID) {
        InfectedUserData form = new InfectedUserData(null, null,
        null, null, 0, false, null);

        this.applicantForm = form;

        return this.applicantForm;
    }

    /**
     * Accepts the applicant's Infectious Disease form, and generates for the
     *     applicant an Approval Email to notify them of their form's approval.
     */
    public void acceptForm() {
        return;
    }

    /**
     * Generates an Approval Email for the applicant of an approved Infectious
     *     Disease form to notify them of their form's approval.
     * 
     * @return true if the Approval Email was successfully generated and sent
     *     to the applicant; return false otherwise.
     */
    private boolean generateEmail() {
        return true;
    }

    /**
     * Declines the applicant's Infectious Disease form, and ultimately returns
     *     it to be reviewed for correction by the ReviewingSystem.
     */
    public void declineForm() {
        return;
    }

    /**
     * Resends the declined Infectious Disease Form to ultimately be reviewed
     *     for correction by the ReviewingSystem.
     * 
     * @return true if the applicant's form was successfully returned for
     *     correction; return false otherwise.
     */
    private boolean returnForCorrection() {
        return true;
    }

}

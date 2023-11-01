
package DiseaseManagementSystem;

import java.util.LinkedList;

/**
 * Workflow Table that will contain the corresponding IDs of all applicants'
 *     forms.
 */
public class WorkflowTable {
    
    /**
     * The list of IDs for all Infected User Data forms that are waiting to be
     *     reviewed.
     */
    private LinkedList<InfectedUserData> reviewQueue;

    /**
     * The list of IDs for all Infected User Data forms that are waiting to be
     *     approved.
     */
    private LinkedList<InfectedUserData> approveQueue;

    /**
     * Helper method that constructs the Workflow Table with its lists of
     *     IDs for all forms to be checked for review and approval.
     */
    private WorkflowTable() {
        this.reviewQueue = new LinkedList<>();
        this.approveQueue = new LinkedList<>();
    }

    /**
     * Creates the Workflow Table with its lists of IDs for all forms to be
     *     checked for review and approval.
     * 
     * @return the Workflow Table withs its lists of IDs for all forms to be
     *     checked for review and approval.
     */
    public static WorkflowTable createWorkflowTable() {
        return new WorkflowTable();   
    }

    /**
     * Adds the formID of an applicant's InfectedUserData to the end of the
     *     reviewIDQueue.
     * 
     * @param formID for the formID of the applicant's InfectedUserData.
     * @return true if the formID was successfully added to the end of the
     *     reviewIDQueue, otherwise return false.
     */
    public boolean addReviewForm(InfectedUserData form) {
        return false;
    }

    /**
     * Returns the formID of an applicant's InfectedUserData to be reviewed
     *     if it exitsts in the reviewIDQueue.
     * 
     * @return the formID of the applicant's InfectedUserData if it was found
     *     in the reviewIDQueue; return -1 if the reviewIDQueue was not
     *     initialized; return 0 if the reviewIDQueue was empty.
     */
    public InfectedUserData getNextReviewID() {
        return null;
    }

    /**
     * Adds the formID of an applicant's InfectedUserData to the end of the
     *     approveIDQueue.
     * 
     * @param formID for the formID of the applicant's InfectedUserData.
     * @return true if the formID was successfully added to the end of the
     *     approveIDQueue, otherwise return false.
     */
    public boolean addApproveForm(InfectedUserData form) {
        return false;
    }

    /**
     * Returns the formID of an applicant's InfectedUserData to be approved
     *     if it exitsts in the approveIDQueue.
     * 
     * @return the formID of the applicant's InfectedUserData if it was found
     *     in the approveIDQueue; return -1 if the approveIDQueue was not
     *     initialized; return 0 if the approveIDQueue was empty.
     */
    public InfectedUserData getNextApproveForm() {
        return null;
    }

}
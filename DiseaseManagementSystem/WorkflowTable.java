
package DiseaseManagementSystem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Workflow table that manages the movement of forms between the data entry, review and approval systems
 * @author John Fulton
 * @author Youssef Melk
 */
public class WorkflowTable {

    /**
     * The list of all InfectedUserData forms that are waiting to be
     *     reviewed.
     */
    private Queue<InfectedUserData> reviewQueue;

    /**
     * The list of all InfectedUserData forms that are waiting to be
     *     approved.
     */
    private Queue<InfectedUserData> approvalQueue;

    /**
     * Helper method that constructs the WorkflowTable with its lists of
     *     all forms to be checked for review and approval.
     */
    WorkflowTable() {
        this.reviewQueue = new LinkedList<>();
        this.approvalQueue = new LinkedList<>();
    }

    /**
     * Creates the Workflow Table with its lists of all forms to be
     *     checked for review and approval.
     * 
     * @return the Workflow Table object
     */
    public static WorkflowTable createWorkflowTable() {
        return new WorkflowTable();   
    }

    /**
     * Adds the applicant's InfectedUserData to the end of the
     *     reviewwQueue.
     * 
     * @param form the applicant's InfectedUserData.
     * @return true if the form was successfully added to the end of the
     *     reviewQueue, otherwise return false.
     */
    public boolean addReviewForm(InfectedUserData form) {

        if (form == null) {
            return false;
        }

        if (reviewQueue.add(form) == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the next InfectedUserData form in the reviewQueue.
     * 
     * @return the next InfectedUserData form in the reviewQueue, otherwise returns and empty form if the queue is empty.
     */
    public InfectedUserData getNextReviewForm() {

        InfectedUserData placeholder = new InfectedUserData(null, null, null, null, 0, false, null);

        if (!reviewQueue.isEmpty()) {
            // needs to be changed to properly implement queue functionality.
            // we actually want to remove the form, not just retrieve it.
            // peek() won't remove the form for us.
            return reviewQueue.poll();
        } else {
            return placeholder;
        }
    }

    /**
     * Adds an InfectedUserData to the end of the approvalQueue.
     * 
     * @param form the applicant's InfectedUserData.
     * @return true if the form was successfully added to the end of the
     *     approvalQueue, otherwise return false.
     */
    public boolean addApprovalForm(InfectedUserData form) {
        
        if (form == null) {
            return false;
        }

        if (approvalQueue.add(form)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the next form in the approvalQueue.
     * 
     * @return the form of the applicant's InfectedUserData if it was found
     *     in the approvalQueue; otherwise, return an empty form to avoid null pointer errors.
     */
    public InfectedUserData getNextApprovalForm() {

        InfectedUserData placeholder = new InfectedUserData(null, null, null, null, 0, false, null);

        if (!approvalQueue.isEmpty()) {
            return approvalQueue.poll();
        } else {
            return placeholder;
        }

    }

}
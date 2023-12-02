import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;
import DiseaseManagementSystem.WorkflowTable;

/**
 * Tester for the WorkflowTable class.
 *
 * @author John Fulton.
 * @author Youssef Melk.
 */
public class WorkflowTableTest {
    
    /* ==================== addReviewForm() Test Section ==================== */

    /**
     * Tests if adding a form form to the reviewQueue is successful.
     */
    @Test
    public void addReviewFormReturnsTrue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
            
        InfectedUserData newImmigrant = new InfectedUserData(null, null, null, null, 0, false, null);
        boolean actual = workflowTable.addReviewForm(newImmigrant);
        boolean expected = true;

        assertEquals(expected, actual); 
    }

    /**
     * Tests if adding a form to the reviewQueue is not successful.
     */
    @Test
    public void addReviewFormReturnsFalse() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        InfectedUserData newImmigrant = null;
        boolean actual = workflowTable.addReviewForm(newImmigrant);
        boolean expected = false;

        assertEquals(expected, actual);
    }
    
    /* ================== getNextReviewForm() Test Section ================== */

    /**
     * Tests that getting the next reviewForm from the reviewQueue is
     *     successful.
     */
    @Test
    public void getNextReviewFormReturnsForm() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        InfectedUserData newImmigrant = new InfectedUserData(null, null, null, null, 0, false, null);
        workflowTable.addReviewForm(newImmigrant);

        InfectedUserData actual = workflowTable.getNextReviewForm();
        InfectedUserData expected = newImmigrant;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextReviewForm() fails (the reviewQueue was empty) and
     *     produces null.
     */
    @Test
    public void getNextReviewFormEmptyQueue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextReviewForm();
        InfectedUserData expected = new InfectedUserData(null, null, null, null, 0, false, null);

        assertEquals(expected.getEmail(), actual.getEmail());
    }

    /* ==================== addApprovalForm() Test Section ==================== */

     /** 
     * Tests if adding a form to the approval queue is successful.
     */
    @Test
    public void addApproveFormReturnsTrue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApprovalForm(new InfectedUserData(null, null, null, null, 0, false, null));
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /* ================= getNextApprovalForm() Test Section ================= */

    /**
     * Tests that getting the next approve form from the approval queue is
     *     successful.
     */
    @Test
    public void getNextApproveFormReturnsForm() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        InfectedUserData expected = new InfectedUserData("John", "tb", "johnfulton8@gmail.com", "04/09/1998", 2, true, null);
        workflowTable.addApprovalForm(expected);
        InfectedUserData actual = workflowTable.getNextApprovalForm();

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApprovalForm() fails (the approvalQueue was empty) and
     *     produces null.
     */
    @Test
    public void getNextApproveFormReturnsNull() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextApprovalForm();
        InfectedUserData expected = new InfectedUserData(null, null, null, null, 0, false, null);

        assertEquals(expected.getEmail(), expected.getEmail());
    }
}

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
    
    /* ==================== addReviewID() Test Section ==================== */

    /**
     * Tests if adding a form ID to the reviewIDQueue is successful.
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
     * Tests if adding a form ID to the reviewIDQueue is not successful.
     *     This would occur if the queue was not initialized properly.
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
     * Tests that getting the next review Form from the reviewQueue is
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
    public void getNextReviewIDEmptyQueue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextReviewForm();
        InfectedUserData expected = new InfectedUserData(null, null, null, null, 0, false, null));

        assertEquals(expected, actual);
    }

    /* ==================== addApproveID() Test Section ==================== */

     /**
     * Tests if adding a form to the approve queue is successful.
     */
    @Test
    public void addApproveFormReturnsTrue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApprovalForm(new InfectedUserData(null, null, null, null, 0, false, null));
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /* ================= getNextApproveID() Test Section ================= */

    /**
     * Tests that getting the next approve form from the approve queue is
     *     successful.
     */
    @Test
    public void getNextApproveFormReturnsForm() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        InfectedUserData expected = new InfectedUserData("John", "tb", "johnfulton8@gmail.com", "04/09/1998", 2, true, null);
        workflowTable.addApprovalForm(new InfectedUserData(null, null, null, null, 0, false, null));
        InfectedUserData actual = workflowTable.getNextReviewForm();

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApproveForm() fails (the approveIDQueue was empty) and
     *     produces null.
     */
    @Test
    public void getNextApproveIDReturnsNull() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextApprovalForm();
        InfectedUserData expected = new InfectedUserData(null, null, null, null, 0, false, null));

        assertEquals(expected, actual);
    }
}

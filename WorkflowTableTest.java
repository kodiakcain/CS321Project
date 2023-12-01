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
    
    /* ================== getNextReviewID() Test Section ================== */

    /**
     * Tests that getting the next review ID from the reviewIDQueue is
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
     * Tests that getNextReviewID() fails (the reviewIDQueue was not
     *     initialized) and produces null.
     */
    @Test
    public void getNextReviewIDUninitializedQueue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextReviewForm();
        InfectedUserData expected = null;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextReviewID() fails (the reviewIDQueue was empty) and
     *     produces 0.
     */
    @Test
    public void getNextReviewIDEmptyQueue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextReviewForm();
        InfectedUserData expected = null;

        assertEquals(expected, actual);
    }

    /* ==================== addApproveID() Test Section ==================== */

     /**
     * Tests if adding a form ID to the approve queue is successful.
     */
    @Test
    public void addApproveIDReturnsTrue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApproveID(0);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /**
     * Tests if adding a form ID to the approve queue is not successful.
     *     This would occur if the queue was not initialized properly.
     */
    @Test
    public void addApproveIDReturnsFalse() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApproveID(0);
        boolean expected = false;

        assertEquals(expected, actual);
    }

    /* ================= getNextApproveID() Test Section ================= */

    /**
     * Tests that getting the next approve ID from the approve queue is
     *     successful.
     */
    @Test
    public void getNextApproveIDReturnsFormID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        workflowTable.addApproveID(1);
        InfectedUserData actual = workflowTable.getNextReviewID();
        InfectedUserData expected = 1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApprovalID() fails (the approveIDQueue was not
     *      initialized) and produces -1.
     */
    @Test
    public void getNextApproveIDReturnsNegativeOne() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        InfectedUserData actual = workflowTable.getNextApproveID();
        InfectedUserData expected = -1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApproveID() fails (the approveIDQueue was empty) and
     *     produces 0.
     */
    @Test
    public void getNextApproveIDReturnsZero() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        InfectedUserData actual = workflowTable.getNextApproveID();
        InfectedUserData expected = 0;

        assertEquals(expected, actual);
    }
}

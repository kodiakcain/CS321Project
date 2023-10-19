import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.WorkflowTable;

/**
 * Tester for the WorkflowTable class.
 *
 * @author John Fulton
 * @author Youssef Melk
 */
public class WorkflowTableTest {
    
    /* ==================== addReviewID() Test Section ==================== */

    /**
     * Tests if adding a form ID to the reviewIDQueue is successful.
     */
    @Test
    public void addReviewIDReturnsTrue() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addReviewID(1);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /**
     * Tests if adding a form ID to the reviewIDQueue is not successful.
     *     This would occur if the queue was not initialized properly.
     */
    @Test
    public void addReviewIDReturnsFalse() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addReviewID(1);
        boolean expected = false;

        assertEquals(expected, actual);
    }
    
    /* ================== getNextReviewID() Test Section ================== */

    /**
     * Tests that getting the next review ID from the reviewIDQueue is
     *     successful.
     */
    @Test
    public void getNextReviewIDReturnsFormID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        workflowTable.addReviewID(1);
        int actual = workflowTable.getNextReviewID();
        int expected = 1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextReviewID() fails (the reviewIDQueue was not
     *     initialized) and produces -1.
     */
    @Test
    public void getNextReviewIDReturnsNegativeOne() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextReviewID();
        int expected = -1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextReviewID() fails (the reviewIDQueue was empty) and
     *     produces 0.
     */
    @Test
    public void getNextReviewIDReturnsZero() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextReviewID();
        int expected = 0;

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
        int actual = workflowTable.getNextReviewID();
        int expected = 1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApprovalID() fails (the approveIDQueue was not
     *      initialized) and produces -1.
     */
    @Test
    public void getNextApproveIDReturnsNegativeOne() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        int actual = workflowTable.getNextApproveID();
        int expected = -1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApproveID() fails (the approveIDQueue was empty) and
     *     produces 0.
     */
    @Test
    public void getNextApproveIDReturnsZero() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextApproveID();
        int expected = 0;

        assertEquals(expected, actual);
    }
}

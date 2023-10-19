
import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.WorkflowTable;

/**
 * Tester for the WorkflowTable class
 */
public class WorkflowTableTest {

    /* AddReviewID() Test Section */

    /**
     * Tests if adding a form ID to the review queue is successful.
     */
    @Test
    public void test1AddReviewID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addReviewID(1);
        boolean expected = true;

        assertEquals(expected, actual);

    }

    /**
     * Tests if adding a form ID to the review queue is not successful.
     * This would occur if the queue was not initialized properly.
     */
    @Test
    public void test2AddReviewID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addReviewID(1);
        boolean expected = false;

        assertEquals(expected, actual);

    }
    
    /* getNextReviewID() Test Section */

    /**
     * Tests that getting the next review ID from the review queue is successful.
     */
    @Test
    public void test1GetNextReviewID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        workflowTable.addReviewID(1);
        int actual = workflowTable.getNextReviewID();
        int expected = 1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextReviewID() fails (the reviewQueue was not initialized) and produces -1.
     */
    @Test
    public void test2GetNextReviewID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextReviewID();
        int expected = -1;

        assertEquals(expected, actual);

    }

    /**
     * Tests that getNextReviewID() fails (the reviewQueue was empty) and produces 0.
     */
    @Test
    public void test3GetNextReviewID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextReviewID();
        int expected = 0;

        assertEquals(expected, actual);

    }

    /* addApproveID() Test Section */

     /**
     * Tests if adding a form ID to the approve queue is successful.
     */
    @Test
    public void test1AddApproveID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApproveID(0);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    /**
     * Tests if adding a form ID to the approve queue is not successful.
     * This would occur if the queue was not initialized properly.
     */
    @Test
    public void test2AddApproveID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addApproveID(0);
        boolean expected = false;

        assertEquals(expected, actual);
    }

    /* getNextApproveID() Test Section */

    /**
     * Tests that getting the next approve ID from the approve queue is successful.
     */
    @Test
    public void test1GetNextApproveID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        workflowTable.addApproveID(1);
        int actual = workflowTable.getNextReviewID();
        int expected = 1;

        assertEquals(expected, actual);
    }

    /**
     * Tests that getNextApprovalID() fails (the approveQueue was not initialized) and produces -1.
     */
    @Test
    public void test2GetNextApproveID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        int actual = workflowTable.getNextApproveID();
        int expected = -1;

        assertEquals(expected, actual);

    }

    /**
     * Tests that getNextApproveID() fails (the approveQueue was empty) and produces 0.
     */
    @Test
    public void test3GetNextApproveID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();

        int actual = workflowTable.getNextApproveID();
        int expected = 0;

        assertEquals(expected, actual);

    }
}

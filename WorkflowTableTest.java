
import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.WorkflowTable;

/**
 * Tester for the WorkflowTable class
 */
public class WorkflowTableTest {
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
     * Tests that getNextReviewID() fails and produces -1.
     */
    @Test
    public void test2GetNextReviewID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        int actual = workflowTable.getNextReviewID();
        int expected = -1;

        assertEquals(expected, actual);

    }

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
     * Tests that getNextApprovalID() fails and produces -1.
     */
    @Test
    public void test2GetNextApprovalID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        int actual = workflowTable.getNextApproveID();
        int expected = -1;

        assertEquals(expected, actual);

    }

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

}

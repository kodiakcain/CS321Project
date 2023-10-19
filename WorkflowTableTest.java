
import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.WorkflowTable;

/**
 * Tester for the WorkflowTable class
 */
public class WorkflowTableTest {
    /**
     * Checks for 
     */
    @Test
    public void test1AddReviewID() {
        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        
        boolean actual = workflowTable.addReviewID(1);
        boolean expected = true;

        assertEquals(expected, actual);

    }
    
    @Test
    public void test1GetNextReviewID() {

        WorkflowTable workflowTable = WorkflowTable.createWorkflowTable();
        workflowTable.addReviewID(1);
        int actual = workflowTable.getNextReviewID();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void test1AddApproveID() {

    }

    @Test
    public void test1GetNextApproveID() {

    }

}

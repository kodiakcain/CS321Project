
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
    private LinkedList<Integer> reviewIDQueue;

    /**
     * The list of IDs for all Infected User Data forms that are waiting to be
     *     approved.
     */
    private LinkedList<Integer> approveIDQueue;

    /**
     * Helper method that constructs the Workflow Table with its lists of
     *     IDs for all forms to be checked for review and approval.
     */
    private WorkflowTable() {
        this.reviewIDQueue = new LinkedList<Integer>();
        this.approveIDQueue = new LinkedList<Integer>();
    }

    /**
     * Creates the Workflow Table with its lists of IDs for all forms to be
     *     checked for review and approval.
     * 
     * @return the Workflow Table withs its lists of IDs for all forms to be
     *     checked for review and approval.
     */
    public static WorkflowTable createWorkflowTable() {
        WorkflowTable newTable = new WorkflowTable();   
        return newTable;
    }

    /**
     * Adds a form via its formID to the reviewIDQueue
     */
    public 
    

}
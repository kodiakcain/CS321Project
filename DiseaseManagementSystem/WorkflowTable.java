
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

    private WorkflowTable() {
        this.reviewIDQueue = new LinkedList<Integer>();
        this.approveIDQueue = new LinkedList<Integer>();
    }

    public WorkflowTable createWorkflowTable() {
        return WorkflowTable();
    }    


}
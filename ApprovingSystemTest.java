
import static org.junit.Assert.*;
import org.junit.*;

import DiseaseManagementSystem.ApprovingSystem;

public class ApprovingSystemTest {

    /**
     * Checks that the approving system's screen loaded successfully.
     */
    @Test
    public void testloadApproverScreen() {
        ApprovingSystem approvingSystem = new ApprovingSystem();
        
        boolean screen_status = approvingSystem.loadApproverScreen();
        
        /* print error message to user if screen failed to load */
        assertTrue("[TEST FAIL] Approving System screen failed to load",
        screen_status);
    }

}

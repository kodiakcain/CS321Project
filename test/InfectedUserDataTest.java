package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;

public class InfectedUserDataTest {
    
    @Test
    public void Test() {
        InfectedUserData testobj = new InfectedUserData(null, null, null);
        assertEquals(testobj.getData(), "");
    }
}

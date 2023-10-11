package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;

public class InfectedUserDataTest {
    
    @Test
    public void LessDataTest() {
        InfectedUserData testobj = new InfectedUserData("j", null, null, 0, false, false);

        int minLength = 1;
        int maxLength = 128;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getDataSize(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));
    }

    @Test
    public void MoreDataTest() {
        InfectedUserData testobj = new InfectedUserData("431fq432vrv42iu483fni483uv3qrncec93q2qubviv3ircjnr3n2u39nr3iv3v9314c3oiv4vu4nggbrjksadlcmdkoqv3jir3940q31ijfn239i4j130fnrvuinvvnd", null, null, 0, false, false);

    }

    @Test
    public void AllNull() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, 0, false, false);

    }

    @Test
    public void NullData() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, 0, false, false);

    }

    @Test
    public void NullEmail() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, 0, false, false);

    }

    public void NullBirthdate() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, 0, false, false);

    }
}

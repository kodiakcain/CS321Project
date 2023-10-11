

import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;

public class InfectedUserDataTest {
    
    @Test
    public void LessDataTest() {
        InfectedUserData testobj = new InfectedUserData("j", null, null, 0, false, false);

        int minLength = 1;
        int maxLength = 128;
        int dataLength = testobj.getDataSize();

        // Check that the length of the string is within the specified range
        assertTrue(dataLength >= minLength && dataLength <= maxLength);
    }

    /** 

    @Test
    public void MoreDataTest() {
        InfectedUserData testobj = new InfectedUserData("431fq432vrv42iu483fni483uv3qrncec93q2qubviv3ircjnr3n2u39nr3iv3v9314c3oiv4vu4nggbrjksadlcmdkoqv3jir3940q31ijfn239i4j130fnrvuinvvnd", null, null, 0, false, false);

        int minLength = 1;
        int maxLength = 128;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getDataSize(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));
    }

    @Test
    public void EmailLengthTestLess() {
        InfectedUserData testobj = new InfectedUserData("I have covid.", "cain", "02/15/2003", 0, false, false);

        int minLength = 5;
        int maxLength = 60;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getEmailLength(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void EmailLengthTestMore() {
        InfectedUserData testobj = new InfectedUserData("I have covid.", "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhk", "02/15/2003", 0, false, false);

        int minLength = 5;
        int maxLength = 60;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getEmailLength(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void BirthdateTestLess() {
        InfectedUserData testobj = new InfectedUserData("I have a cold.", "youssef@gmail.com", "2/15/2003", 0, false, false);

        int minLength = 10;
        int maxLength = 10;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getBirthdateLength(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void BirthdateTestMore() {
        InfectedUserData testobj = new InfectedUserData("I have a cold.", "youssef@gmail.com", "02/15/20039", 0, false, false);

        int minLength = 10;
        int maxLength = 10;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getBirthdateLength(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void NegativeChildren() {
        InfectedUserData testobj = new InfectedUserData("I have a cold.", "youssef@gmail.com", "02/15/2003", -1, false, false);

        int minLength = 0;
        int maxLength = 100;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getNumChildren(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void MoreChildren() {
        InfectedUserData testobj = new InfectedUserData("I have a cold.", "youssef@gmail.com", "02/15/2003", 101, false, false);

        int minLength = 0;
        int maxLength = 100;

        // Check that the length of the string is within the specified range
        assertThat(testobj.getNumChildren(), both(greaterThanOrEqualTo(minLength)).and(lessThanOrEqualTo(maxLength)));

    }

    @Test
    public void NullData() {
        InfectedUserData testobj = new InfectedUserData(null, "cain@gmail.com", "02/15/2003", 0, false, false);


    }

    @Test
    public void NullAllString() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, 0, false, false);

    }

    @Test
    public void NullEmail() {
        InfectedUserData testobj = new InfectedUserData("I have the flu.", null, "07/13/2001", 0, false, false);

    }

    public void NullBirthdate() {
        InfectedUserData testobj = new InfectedUserData("I have human rhinovirus.", "john@gmail.com", null, 0, false, false);

    }
    */
}

import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;

public class InfectedUserDataTest {
    
    //trying to enter data with 0 characters
    @Test
    public void LessDataTest() {
        InfectedUserData testobj = new InfectedUserData("", null, null, 0, false, false);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    //trying to enter data with 322 characters
    @Test
    public void MoreDataTest() {
        InfectedUserData testobj = new InfectedUserData("431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhkhbuewd7832udbc2u297g2ubebdjebui2o4hr9872eyh3ubfry382gf78ybrvfy4ubfhfewkjfwbqhfwerbf478yu2ufbhkuebfewihfb784yfg82fubhfrhbvreukhcbewkqykhejvkrewhqrvbhe78387843bhrvbkhrjbvhakbrgbarhkurbvhevbkurabkherhvbiuoewbhuh8vr3u9iwudehfifjn589riennejifuj8ruhcc39c39c39c9928cuh", null, null, 0, false, false);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    //trying to enter data with 50 characters
    @Test
    public void NormalDataTest() {
        InfectedUserData testobj = new InfectedUserData("431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfc", null, null, 0, false, false);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 1);
    }

    //trying email with 4 characters
    @Test
    public void EmailLengthTestLess() {
        InfectedUserData testobj = new InfectedUserData("I have covid.", "cain", "02/15/2003", 0, false, false);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    //trying email with 61 characters
    @Test
    public void EmailLengthTestMore() {
        InfectedUserData testobj = new InfectedUserData("I have covid.", "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhk", "02/15/2003", 0, false, false);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    //trying email with 24 characters
    @Test
    public void EmailLengthTestNormal() {
        InfectedUserData testobj = new InfectedUserData("I have covid.", "myexampleemail@gmail.com", "02/15/2003", 0, false, false);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 1);

    }

    //testing birthdate with 9 characters
    @Test
    public void BirthdateTestLess() {
        InfectedUserData testobj = new InfectedUserData("I have a cold.", "youssef@gmail.com", "2/15/2003", 0, false, false);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);

    }

    /** 

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

import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;


/**
 * Tester class for InfectedUserData object.
 */
public class InfectedUserDataTest {
    
    /**
    * Trying to enter data with 0 characters.
     */
    @Test
    public void lessDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "", null, null, 0, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    /**
     * Trying to enter data with 322 characters.
     */
    @Test
    public void moreDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhkhbuewd7832udbc2u297g2ubebdjebui2o4hr9872eyh3ubfry382gf78ybrvfy4ubfhfewkjfwbqhfwerbf478yu2ufbhkuebfewihfb784yfg82fubhfrhbvreukhcbewkqykhejvkrewhqrvbhe78387843bhrvbkhrjbvhakbrgbarhkurbvhevbkurabkherhvbiuoewbhuh8vr3u9iwudehfifjn589riennejifuj8ruhcc39c39c39c9928cuh", null, null, 0, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    /**
     * Trying to enter data with 50 characters.
     */
    @Test
    public void normalDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfc", null, null, 0, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 1);
    }

    /**
     * Trying email with 4 characters.
     */
    @Test
    public void emailLengthTestLess() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "cain", "02/15/2003", 0, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    /**
     * Trying email with 61 characters.
     */
    @Test
    public void emailLengthTestMore() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhk", "02/15/2003", 0, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    /**
     * Trying email with 24 characters.
     */ 
    @Test
    public void emailLengthTestNormal() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "myexampleemail@gmail.com", "02/15/2003", 0, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 1);

    }

    /**
     * Testing birthdate with 9 characters.
     */ 
    @Test
    public void birthdateTestLess() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "2/15/2003", 0, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);

    }

    /**
     * Trying birthdate with 11 characters.
     */
    @Test
    public void birthdateTestMore() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/20039", 0, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    /**
     * Trying birthdate with 10 characters.
     */
    @Test
    public void birthdateTestNormal() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/2003", 0, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 1);
    }

    /**
     * Trying birthdate with 10 characters.
     */
    @Test
    public void birthdateTestAlphabeticChar() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/200k", 0, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    /**
     * Trying to enter negative amount of children.
     */ 
    @Test
    public void negativeChildren() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/2003", -1, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 0);

    }

    /**
     * Trying to enter 101 children.
     */ 
    @Test
    public void moreChildren() {
        InfectedUserData testobj = new InfectedUserData(null,"I have a cold.", "youssef@gmail.com", "02/15/2003", 101, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 0);

    }

    /**
     * Trying to enter 4 children.
     */ 
    @Test
    public void normalChildren() {
        InfectedUserData testobj = new InfectedUserData(null,"I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 1);

    }

    /**
     * Empty name entered.
     */ 
    @Test
    public void emptyName() {
        InfectedUserData testobj = new InfectedUserData("","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    /**
     * Normal size name entered.
     */
    @Test
    public void normalName() {
        InfectedUserData testobj = new InfectedUserData("Cain","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 1);

    }

    /**
     * Entering long name with 61 characters.
     */
    @Test
    public void longName() {
        InfectedUserData testobj = new InfectedUserData("caubcweuvhbljebqeuilvbwluBWLIABVLIBQVBUILVREBVIRVBLVBUIVUIWJK","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    /**
     * Entering a name with a special character.
     */
    @Test
    public void specialCharName() {
        InfectedUserData testobj = new InfectedUserData("cain@","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    /**
     * Entering a name with a number in it.
     */
    @Test
    public void numberName() {
        InfectedUserData testobj = new InfectedUserData("cain12","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    /**
     * Entering no data, null.
     */ 
    @Test
    public void nullData() {
        InfectedUserData testobj = new InfectedUserData("cain", null, "cain@gmail.com", "02/15/2003", 0, false, null);

        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    /**
     * Entering null for data, birthdate, and email.
     */ 
    @Test
    public void nullAllString() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, null, 0, false, null);

        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0 && testobj.validateEmail(testobj.getEmail()) == 0 && testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    /**
     * Entering null email.
     */ 
    @Test
    public void nullEmail() {
        InfectedUserData testobj = new InfectedUserData("cain", "I have the flu.", null, "07/13/2001", 0, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);
    }

    /**
     * Entering null birthdate.
     */
    @Test
    public void nullBirthdate() {
        InfectedUserData testobj = new InfectedUserData("cain", "I have human rhinovirus.", "john@gmail.com", null, 0, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }
}

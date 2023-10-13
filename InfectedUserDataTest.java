import static org.junit.Assert.*;
import org.junit.Test;

import DiseaseManagementSystem.InfectedUserData;

public class InfectedUserDataTest {
    
    //trying to enter data with 0 characters
    @Test
    public void LessDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "", null, null, 0, false, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    //trying to enter data with 322 characters
    @Test
    public void MoreDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhkhbuewd7832udbc2u297g2ubebdjebui2o4hr9872eyh3ubfry382gf78ybrvfy4ubfhfewkjfwbqhfwerbf478yu2ufbhkuebfewihfb784yfg82fubhfrhbvreukhcbewkqykhejvkrewhqrvbhe78387843bhrvbkhrjbvhakbrgbarhkurbvhevbkurabkherhvbiuoewbhuh8vr3u9iwudehfifjn589riennejifuj8ruhcc39c39c39c9928cuh", null, null, 0, false, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    //trying to enter data with 50 characters
    @Test
    public void NormalDataTest() {
        InfectedUserData testobj = new InfectedUserData(null, "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfc", null, null, 0, false, false, null);

        // Check that the length of the string is within the specified range
        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 1);
    }

    //trying email with 4 characters
    @Test
    public void EmailLengthTestLess() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "cain", "02/15/2003", 0, false, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    //trying email with 61 characters
    @Test
    public void EmailLengthTestMore() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "431fq432vrv42iu483fni483uv3qrncec9vkhjtjfcrdhrtgfcgctrhdtrdhk", "02/15/2003", 0, false, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);

    }

    //trying email with 24 characters
    @Test
    public void EmailLengthTestNormal() {
        InfectedUserData testobj = new InfectedUserData(null, "I have covid.", "myexampleemail@gmail.com", "02/15/2003", 0, false, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 1);

    }

    //testing birthdate with 9 characters
    @Test
    public void BirthdateTestLess() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "2/15/2003", 0, false, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);

    }

    //trying birthdate with 11 characters
    @Test
    public void BirthdateTestMore() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/20039", 0, false, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    //trying birthdate with 10 characters
    @Test
    public void BirthdateTestNormal() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/2003", 0, false, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 1);
    }

    //trying birthdate with 10 characters
    @Test
    public void BirthdateTestAlphabeticChar() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/200k", 0, false, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    //trying to enter negative amount of children
    @Test
    public void NegativeChildren() {
        InfectedUserData testobj = new InfectedUserData(null, "I have a cold.", "youssef@gmail.com", "02/15/2003", -1, false, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 0);

    }

    //trying to enter 101 children
    @Test
    public void MoreChildren() {
        InfectedUserData testobj = new InfectedUserData(null,"I have a cold.", "youssef@gmail.com", "02/15/2003", 101, false, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 0);

    }

    //trying to enter 4 children
    @Test
    public void NormalChildren() {
        InfectedUserData testobj = new InfectedUserData(null,"I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateNumChild(testobj.getNumChildren()) == 1);

    }

    //empty name entered
    @Test
    public void EmptyName() {
        InfectedUserData testobj = new InfectedUserData("","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    //normal size name entered
    @Test
    public void NormalName() {
        InfectedUserData testobj = new InfectedUserData("Cain","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 1);

    }

    //entering long name with 61 characters
    @Test
    public void LongName() {
        InfectedUserData testobj = new InfectedUserData("caubcweuvhbljebqeuilvbwluBWLIABVLIBQVBUILVREBVIRVBLVBUIVUIWJK","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    @Test
    public void SpecialCharName() {
        InfectedUserData testobj = new InfectedUserData("cain@","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    @Test
    public void NumberName() {
        InfectedUserData testobj = new InfectedUserData("cain12","I have a cold.", "youssef@gmail.com", "02/15/2003", 4, false, false, null);

        assertTrue(testobj.validateName(testobj.getName()) == 0);

    }

    //entering no data, null
    @Test
    public void NullData() {
        InfectedUserData testobj = new InfectedUserData("cain", null, "cain@gmail.com", "02/15/2003", 0, false, false, null);

        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0);
    }

    //entering null for data, birthdate, and email
    @Test
    public void NullAllString() {
        InfectedUserData testobj = new InfectedUserData(null, null, null, null, 0, false, false, null);

        assertTrue(testobj.validateInfectiousData(testobj.getData()) == 0 && testobj.validateEmail(testobj.getEmail()) == 0 && testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }

    //entering null email
    @Test
    public void NullEmail() {
        InfectedUserData testobj = new InfectedUserData("cain", "I have the flu.", null, "07/13/2001", 0, false, false, null);

        assertTrue(testobj.validateEmail(testobj.getEmail()) == 0);
    }

    //entering null birthdate
    @Test
    public void NullBirthdate() {
        InfectedUserData testobj = new InfectedUserData("cain", "I have human rhinovirus.", "john@gmail.com", null, 0, false, false, null);

        assertTrue(testobj.validateBirthdate(testobj.getBirthdate()) == 0);
    }
}

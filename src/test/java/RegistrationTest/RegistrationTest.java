package RegistrationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import testBase.TestBase;

public class RegistrationTest extends TestBase {

    @Test (priority = 0)
    public void RegisterWithValidData(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.selectMaleGender();
        Assert.assertTrue(registrationPage.chkSelectMaleGender());
        registrationPage.enterFirstName("Hossam");
        Assert.assertEquals(registrationPage.getTextInFirstNameField(),"Hossam");
        registrationPage.enterLastName("Mostafa");
        Assert.assertEquals(registrationPage.getTextInLastNameField(),"Mostafa");
        registrationPage.enterEmail("hossam@gmail.com");
        Assert.assertEquals(registrationPage.getTextInEmailField(),"hossam@gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.enterConfPassword("123456");
        registrationPage.clickOnRegisterBtn();
        Assert.assertEquals(registrationPage.getSuccessfullMessageText(), "Your registration completed");
    }

    @Test(priority = 1)
    public void RegisterWithBlankData(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.clickOnRegisterBtn();
        Assert.assertEquals(registrationPage.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertEquals(registrationPage.getLastNameErrorMessageText(), "Last name is required.");
        Assert.assertEquals(registrationPage.getEmailErrorMessageText(), "Email is required.");
        Assert.assertEquals(registrationPage.getPasswordErrorMessageText(), "Password is required.");
        Assert.assertEquals(registrationPage.getConfirmPasswordErrorMessageText(), "Password is required.");
    }

    @Test(priority = 1)
    public void RegisterWithInvalidEmailFormat(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.selectMaleGender();
        Assert.assertTrue(registrationPage.chkSelectMaleGender());
        registrationPage.enterFirstName("Hossam");
        Assert.assertEquals(registrationPage.getTextInFirstNameField(),"Hossam");
        registrationPage.enterLastName("Mostafa");
        Assert.assertEquals(registrationPage.getTextInLastNameField(),"Mostafa");
        registrationPage.enterEmail("hossam1#gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.enterConfPassword("123456");
        registrationPage.clickOnRegisterBtn();
        Assert.assertEquals(registrationPage.getEmailErrorMessageText(), "Wrong email");
    }

    @Test(priority = 1)
    public void RegisterWithPasswordLessThan3Chars(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.selectMaleGender();
        Assert.assertTrue(registrationPage.chkSelectMaleGender());
        registrationPage.enterFirstName("Hossam");
        Assert.assertEquals(registrationPage.getTextInFirstNameField(),"Hossam");
        registrationPage.enterLastName("Mostafa");
        Assert.assertEquals(registrationPage.getTextInLastNameField(),"Mostafa");
        registrationPage.enterEmail("hossam1@gmail.com");
        Assert.assertEquals(registrationPage.getTextInEmailField(),"hossam1@gmail.com");
        registrationPage.enterPassword("123");
        registrationPage.enterConfPassword("123");
        registrationPage.clickOnRegisterBtn();
        Assert.assertTrue(registrationPage.getPasswordErrorMessageText().contains("at least 6 characters"));
    }

    @Test(priority = 1)
    public void RegisterWithNotMatchingPasswords(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.selectMaleGender();
        Assert.assertTrue(registrationPage.chkSelectMaleGender());
        registrationPage.enterFirstName("Hossam");
        Assert.assertEquals(registrationPage.getTextInFirstNameField(),"Hossam");
        registrationPage.enterLastName("Mostafa");
        Assert.assertEquals(registrationPage.getTextInLastNameField(),"Mostafa");
        registrationPage.enterEmail("hossam1@gmail.com");
        Assert.assertEquals(registrationPage.getTextInEmailField(),"hossam1@gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.enterConfPassword("123");
        registrationPage.clickOnRegisterBtn();
        Assert.assertTrue(registrationPage.getConfirmPasswordErrorMessageText().contains("do not match"));
    }

    @Test(priority = 1)
    public void RegisterWithAlreadyRegisteredEmail(){
        RegistrationPage registrationPage = homePage.clickRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
        registrationPage.selectMaleGender();
        Assert.assertTrue(registrationPage.chkSelectMaleGender());
        registrationPage.enterFirstName("Hossam");
        Assert.assertEquals(registrationPage.getTextInFirstNameField(),"Hossam");
        registrationPage.enterLastName("Mostafa");
        Assert.assertEquals(registrationPage.getTextInLastNameField(),"Mostafa");
        registrationPage.enterEmail("hossam2@gmail.com");
        Assert.assertEquals(registrationPage.getTextInEmailField(),"hossam2@gmail.com");
        registrationPage.enterPassword("123456");
        registrationPage.enterConfPassword("123456");
        registrationPage.clickOnRegisterBtn();
        Assert.assertTrue(registrationPage.getexistEmailErrorMessageText().contains("email already exists"));
    }
}

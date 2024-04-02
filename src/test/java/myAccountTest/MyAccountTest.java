package myAccountTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MyAccountPage_Addresses;
import pages.MyAccountPage_ChangePassword;
import pages.MyAccountPage_CustomerInfo;
import testBase.TestBase;

import java.time.Duration;

public class MyAccountTest extends TestBase {
    protected String odlEmail= "hossam@gmail.com";
    protected String newEmail= "hossam3@gmail.com";

    @Test(priority = 0)
    public void UpdateAccountInfoWithValidData(){
        login(odlEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getHeaderText(),"My account - Customer info");
        myAccountPageCustomerInfo.selectMaleGender();
        Assert.assertTrue(myAccountPageCustomerInfo.chkSelectMaleGender());
        myAccountPageCustomerInfo.changeFirstName("Hossam");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInFirstNameField(),"Hossam");
        myAccountPageCustomerInfo.changeLastName("Mostafa");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInLastNameField(),"Mostafa");
        myAccountPageCustomerInfo.changeEmail(newEmail);
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInEmailField(),newEmail);
        myAccountPageCustomerInfo.clickOnSaveBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(myAccountPageCustomerInfo.getSuccessfullMessageText(), "The customer info has been updated successfully.");
    }

    @Test(priority = 1)
    public void UpdateAccountInfoWithBlankData(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getHeaderText(),"My account - Customer info");
        myAccountPageCustomerInfo.selectMaleGender();
        Assert.assertTrue(myAccountPageCustomerInfo.chkSelectMaleGender());
        myAccountPageCustomerInfo.changeFirstName("");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInFirstNameField(),"");
        myAccountPageCustomerInfo.changeLastName("");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInLastNameField(),"");
        myAccountPageCustomerInfo.changeEmail("");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInEmailField(),"");
        myAccountPageCustomerInfo.clickOnSaveBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertEquals(myAccountPageCustomerInfo.getLastNameErrorMessageText(), "Last name is required.");
        Assert.assertEquals(myAccountPageCustomerInfo.getEmailErrorMessageText(), "Email is required.");
    }

    @Test(priority = 1)
    public void UpdateAccountInfoWithInvalidEmailFormat(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getHeaderText(),"My account - Customer info");
        myAccountPageCustomerInfo.selectMaleGender();
        Assert.assertTrue(myAccountPageCustomerInfo.chkSelectMaleGender());
        myAccountPageCustomerInfo.changeFirstName("Hossam");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInFirstNameField(),"Hossam");
        myAccountPageCustomerInfo.changeLastName("Mostafa");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInLastNameField(),"Mostafa");
        myAccountPageCustomerInfo.changeEmail("hossam6#gmail.com");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInEmailField(),"hossam6#gmail.com");
        myAccountPageCustomerInfo.clickOnSaveBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getEmailErrorMessageText(), "Wrong email");
    }

    @Test(priority = 1)
    public void UpdateAccountInfoWithAlreadyRegisteredEmail(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getHeaderText(),"My account - Customer info");
        myAccountPageCustomerInfo.selectMaleGender();
        Assert.assertTrue(myAccountPageCustomerInfo.chkSelectMaleGender());
        myAccountPageCustomerInfo.changeFirstName("Hossam");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInFirstNameField(),"Hossam");
        myAccountPageCustomerInfo.changeLastName("Mostafa");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInLastNameField(),"Mostafa");
        myAccountPageCustomerInfo.changeEmail("hossam2@gmail.com");
        Assert.assertEquals(myAccountPageCustomerInfo.getTextInEmailField(),"hossam2@gmail.com");
        myAccountPageCustomerInfo.clickOnSaveBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getMainMessageErrorText(), "The e-mail address is already in use");
    }

    @Test(priority = 1)
    public void CreateNewAddressWithValidData(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_Addresses myAccountPageAddresses = myAccountPageCustomerInfo.clickOnAddressesBtn();
        Assert.assertEquals(myAccountPageCustomerInfo.getHeaderText(),"My account - Addresses");
        myAccountPageAddresses.clickOnAddNewBtn();

        myAccountPageAddresses.enterFirstNameAddress("Hossam");
        Assert.assertEquals(myAccountPageAddresses.getFirstNameAddress(),"Hossam");
        myAccountPageAddresses.enterLastNameAddress("Mostafa");
        Assert.assertEquals(myAccountPageAddresses.getLastNameAddress(),"Mostafa");
        myAccountPageAddresses.enterEmailAddress(newEmail);
        Assert.assertEquals(myAccountPageAddresses.getEmailAddress(),newEmail);
        myAccountPageAddresses.selectCountry("Egypt");
        Assert.assertEquals(myAccountPageAddresses.getSelectedCountry(),"Egypt");
        myAccountPageAddresses.enterCity("Cairo");
        Assert.assertEquals(myAccountPageAddresses.getCity(),"Cairo");
        myAccountPageAddresses.enterAddress1("Makram St.");
        Assert.assertEquals(myAccountPageAddresses.getAddress1(),"Makram St.");
        myAccountPageAddresses.enterZipCode("18282");
        Assert.assertEquals(myAccountPageAddresses.getZipCode(),"18282");
        myAccountPageAddresses.enterPhoneNumber("0123456789");
        Assert.assertEquals(myAccountPageAddresses.getPhoneNumber(),"0123456789");

        myAccountPageAddresses.clickOnSaveAddressBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(myAccountPageAddresses.getSuccessfullMessageText(), "The new address has been added successfully.");
    }
    @Test(priority = 1)
    public void CreateNewAddressWithBlankData(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_Addresses myAccountPageAddresses = myAccountPageCustomerInfo.clickOnAddressesBtn();
        Assert.assertEquals(myAccountPageAddresses.getHeaderText(),"My account - Addresses");
        myAccountPageAddresses.clickOnAddNewBtn();
        myAccountPageAddresses.clickOnSaveAddressBtn();

        Assert.assertEquals(myAccountPageAddresses.getFirstNameErrorMessage_Addr(), "First name is required.");
        Assert.assertEquals(myAccountPageAddresses.getLastNameErrorMessage_Addr(), "Last name is required.");
        Assert.assertEquals(myAccountPageAddresses.getEmailErrorMessage_Addr(), "Email is required.");
        Assert.assertEquals(myAccountPageAddresses.getCityErrorMessage_Addr(), "City is required");
        Assert.assertEquals(myAccountPageAddresses.getAddress1ErrorMessage_Addr(), "Street address is required");
        Assert.assertEquals(myAccountPageAddresses.getZipCodeErrorMessage_Addr(), "Zip / postal code is required");
        Assert.assertEquals(myAccountPageAddresses.getPhoneErrorMessage_Addr(), "Phone is required");

    }

    @Test(priority = 2)
    public void ChangePasswordToNewValidPassword(){
        login(newEmail,"123456");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_ChangePassword myAccountPageChangePassword = myAccountPageCustomerInfo.clickOnChangePasswordBtn();
        Assert.assertEquals(myAccountPageChangePassword.getHeaderText(),"My account - Change password");
        myAccountPageChangePassword.enterOldPassword("123456");
        myAccountPageChangePassword.enterNewPassword("654321");
        myAccountPageChangePassword.enterConfirmPassword("654321");
        myAccountPageChangePassword.clickOnConfirmChangePasswordBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals(myAccountPageChangePassword.getSuccessfullMessageText(), "Password was changed");
    }

    @Test(priority = 3)
    public void ChangePasswordToSamePassword(){
        login(newEmail,"654321");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_ChangePassword myAccountPageChangePassword = myAccountPageCustomerInfo.clickOnChangePasswordBtn();
        Assert.assertEquals(myAccountPageChangePassword.getHeaderText(),"My account - Change password");
        myAccountPageChangePassword.enterOldPassword("654321");
        myAccountPageChangePassword.enterNewPassword("654321");
        myAccountPageChangePassword.enterConfirmPassword("654321");
        myAccountPageChangePassword.clickOnConfirmChangePasswordBtn();
        Assert.assertTrue(myAccountPageChangePassword.getMainMessageErrorText().contains("Please create a new password."));
    }

    @Test(priority = 3)
    public void ChangePasswordToPasswordLessThan3Chars(){
        login(newEmail,"654321");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_ChangePassword myAccountPageChangePassword = myAccountPageCustomerInfo.clickOnChangePasswordBtn();
        Assert.assertEquals(myAccountPageChangePassword.getHeaderText(),"My account - Change password");
        myAccountPageChangePassword.enterOldPassword("654321");
        myAccountPageChangePassword.enterNewPassword("123");
        myAccountPageChangePassword.enterConfirmPassword("123");
        myAccountPageChangePassword.clickOnConfirmChangePasswordBtn();
        Assert.assertTrue(myAccountPageChangePassword.getPasswordErrorMessageText().contains("at least 6 characters"));
    }

    @Test(priority = 3)
    public void ChangePasswordWithNotMatchingPasswords(){
        login(newEmail,"654321");
        MyAccountPage_CustomerInfo myAccountPageCustomerInfo = homePage.clickMyAccountBtn();
        MyAccountPage_ChangePassword myAccountPageChangePassword = myAccountPageCustomerInfo.clickOnChangePasswordBtn();
        Assert.assertEquals(myAccountPageChangePassword.getHeaderText(),"My account - Change password");
        myAccountPageChangePassword.enterOldPassword("654321");
        myAccountPageChangePassword.enterNewPassword("123456");
        myAccountPageChangePassword.enterConfirmPassword("523541");
        myAccountPageChangePassword.clickOnConfirmChangePasswordBtn();
        Assert.assertTrue(myAccountPageChangePassword.getConfirmPasswordErrorMessageText().contains("do not match"));
    }

}

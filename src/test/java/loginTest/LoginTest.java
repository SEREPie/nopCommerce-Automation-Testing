package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import testBase.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

    @Test
    public void loginWithValidData(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossam@gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossam@gmail.com");
        loginPage.enterTextInPasswordField("123456");
        Assert.assertEquals(loginPage.getTextInPasswordField(),"123456");
        loginPage.clickOnLoginBtn();
    }

    @Test
    public void loginWithCheckingRememberMeChkBox(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossam@gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossam@gmail.com");
        loginPage.enterTextInPasswordField("123456");
        Assert.assertEquals(loginPage.getTextInPasswordField(),"123456");
        loginPage.checkRememberMeBox();
        loginPage.clickOnLoginBtn();
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://demo.nopcommerce.com/");
        Assert.assertTrue(homePage.getLogoutBtn());
    }


    @Test
    public void loginWithValidEmailAndInvalidPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossam@gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossam@gmail.com");
        loginPage.enterTextInPasswordField("123");
        Assert.assertEquals(loginPage.getTextInPasswordField(),"123");
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Login was unsuccessful"));
    }

    @Test
    public void loginWithInvalidEmailAndValidPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossamaa@gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossamaa@gmail.com");
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Login was unsuccessful"));
    }


    @Test
    public void loginWithValidEmailAndEmptyPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossamaa@gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossamaa@gmail.com");
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Login was unsuccessful"));
    }

    @Test
    public void loginWithInvalidEmailFormatAndValidPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField("hossam#gmail.com");
        Assert.assertEquals(loginPage.getTextInEmailField(),"hossam#gmail.com");
        loginPage.enterTextInPasswordField("12356");
        Assert.assertEquals(loginPage.getTextInPasswordField(),"12356");
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.getEmailErrorMessage().contains("Wrong email"));
    }

    @Test
    public void loginWithEmptyEmailAndEmptyPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.getEmailErrorMessage(),"Please enter your email");
    }

    @Test
    public void RegisterBtnShouldRedirectToRegistrationPage(){
        LoginPage loginPage = homePage.clickLoginBtn();
        RegistrationPage registrationPage = loginPage.clickOnRegisterBtn();
        Assert.assertEquals(registrationPage.getHeaderText(),"Register");
    }

    @Test
    public void ForgotPasswordBtnShouldRedirectToForgotPasswordPage(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnForgotPasswordBtn();
        Assert.assertEquals(loginPage.getHeaderText(),"Password recovery");
    }


}

package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Factory;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }

    protected void login(String email , String password){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterTextInEmailField(email);
        Assert.assertEquals(loginPage.getTextInEmailField(),email);
        loginPage.enterTextInPasswordField(password);
        Assert.assertEquals(loginPage.getTextInPasswordField(),password);
        loginPage.clickOnLoginBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

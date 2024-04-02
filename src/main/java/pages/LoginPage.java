package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    protected WebDriver driver;

    public LoginPage (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By emailField = By.name("Email");
    private By passwordField = By.name("Password");
    private By loginBtn = By.xpath("//button[contains(@class,'login-button')]");
    private By rememberMeChkBox = By.name("RememberMe");

    private By errorMessage = By.xpath("//div[contains(@class,'message-error')]");

    private By emailErrorMessage = By.id("Email-error");

    private By registerBtn = By.xpath("//button[contains(@class,'register-button')]");

    private By forgotPasswordBtn = By.linkText("Forgot password?");

    public void enterTextInEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public String getTextInEmailField(){
       return driver.findElement(emailField).getAttribute("value");
    }

    public void enterTextInPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public String getTextInPasswordField(){
        return driver.findElement(passwordField).getAttribute("value");
    }

    public void checkRememberMeBox(){
        driver.findElement(rememberMeChkBox).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public String getEmailErrorMessage(){
        return driver.findElement(emailErrorMessage).getText();
    }

    public void clickOnLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public RegistrationPage clickOnRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new RegistrationPage(driver);
    }

    public void clickOnForgotPasswordBtn(){
        driver.findElement(forgotPasswordBtn).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends PageBase{

    protected WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By header = By.xpath("//h1[contains(text(),'Register')]");
    private By maleGenderLocator = By.id("gender-male");
    private By femaleGenderLocator = By.id("gender-female");
    private By firstNameLocator = By.id("FirstName");
    private By lastNameLocator = By.id("LastName");
    private By emailLocator = By.id("Email");
    private By passwordLocator = By.id("Password");
    private By confirmPasswordLocator = By.id("ConfirmPassword");
    private By registerBtnLocator = By.id("register-button");
    private By successfullRegMessage = By.cssSelector(".page-body .result");
    private By emailErrorMessage = By.id("Email-error");
    private By firstNameErrorMessage = By.id("FirstName-error");
    private By lastNameErrorMessage = By.id("LastName-error");
    private By passwordErrorMessage = By.id("Password-error");
    private By confirmPasswordErrorMessage = By.id("ConfirmPassword-error");
    private By existEmailErrorMessage = By.className("message-error");

    public void selectMaleGender() {
        clicking(driver.findElement(maleGenderLocator));
    }
    public boolean chkSelectMaleGender() {
        return driver.findElement(maleGenderLocator).isSelected();
    }

    public void selectFemaleGender() {
        clicking(driver.findElement(femaleGenderLocator));
    }
    public boolean chkSelectFemaleGender() {
        return driver.findElement(femaleGenderLocator).isSelected();
    }

    public void enterFirstName(String fname) {
        clicking(driver.findElement(firstNameLocator));
        enterText(driver.findElement(firstNameLocator), fname);
    }

    public String getTextInFirstNameField(){
        return driver.findElement(firstNameLocator).getAttribute("value");
    }

    public void enterLastName(String lname) {
        clicking(driver.findElement(lastNameLocator));
        enterText(driver.findElement(lastNameLocator), lname);
    }
    public String getTextInLastNameField(){
        return driver.findElement(lastNameLocator).getAttribute("value");
    }

    public void enterPassword(String pass) {
        clicking(driver.findElement(passwordLocator));
        enterText(driver.findElement(passwordLocator), pass);
    }

    public void enterConfPassword(String conPass) {
        clicking(driver.findElement(confirmPasswordLocator));
        enterText(driver.findElement(confirmPasswordLocator), conPass);
    }

    public void enterEmail(String mail) {
        clicking(driver.findElement(emailLocator));
        enterText(driver.findElement(emailLocator), mail);
    }

    public String getTextInEmailField(){
        return driver.findElement(emailLocator).getAttribute("value");
    }

    public void clickOnRegisterBtn() {
        clicking(driver.findElement(registerBtnLocator));
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getSuccessfullMessageText() {
        return driver.findElement(successfullRegMessage).getText();
    }
    public String getFirstNameErrorMessageText() {
        return driver.findElement(firstNameErrorMessage).getText();
    }
    public String getLastNameErrorMessageText() {
        return driver.findElement(lastNameErrorMessage).getText();
    }
    public String getEmailErrorMessageText() {
        return driver.findElement(emailErrorMessage).getText();
    }
    public String getPasswordErrorMessageText() {
        return driver.findElement(passwordErrorMessage).getText();
    }
    public String getConfirmPasswordErrorMessageText() {
        return driver.findElement(confirmPasswordErrorMessage).getText();
    }

    public String getexistEmailErrorMessageText() {
        return driver.findElement(existEmailErrorMessage).getText();
    }
}

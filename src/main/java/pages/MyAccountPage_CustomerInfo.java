package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage_CustomerInfo extends PageBase {

    protected WebDriver driver;
    public MyAccountPage_CustomerInfo(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By header = By.cssSelector("div h1");
    private By maleGenderLocator = By.id("gender-male");
    private By femaleGenderLocator = By.id("gender-female");
    private By firstNameLocator = By.id("FirstName");
    private By lastNameLocator = By.id("LastName");
    private By emailLocator = By.id("Email");
    private By saveInfoBtn = By.id("save-info-button");
    private By successfullUpdateMessage = By.cssSelector("#bar-notification .content");
    private By firstNameErrorMessage = By.id("FirstName-error");
    private By lastNameErrorMessage = By.id("LastName-error");
    private By emailErrorMessage = By.id("Email-error");
    private By MainErrorMessage = By.className("message-error");
    private By addressesBtn = By.linkText("Addresses");
    private By chngPasswordBtn = By.linkText("Change password");





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

    public void changeFirstName(String fname) {
        clicking(driver.findElement(firstNameLocator));
        clear(driver.findElement(firstNameLocator));
        enterText(driver.findElement(firstNameLocator), fname);
    }

    public String getTextInFirstNameField(){
        return driver.findElement(firstNameLocator).getAttribute("value");
    }

    public void changeLastName(String lname) {
        clicking(driver.findElement(lastNameLocator));
        clear(driver.findElement(lastNameLocator));
        enterText(driver.findElement(lastNameLocator), lname);
    }
    public String getTextInLastNameField(){
        return driver.findElement(lastNameLocator).getAttribute("value");
    }
    public void changeEmail(String mail) {
        clicking(driver.findElement(emailLocator));
        clear(driver.findElement(emailLocator));
        enterText(driver.findElement(emailLocator), mail);
    }
    public String getLastNameErrorMessageText() {
        return driver.findElement(lastNameErrorMessage).getText();
    }

    public String getTextInEmailField(){
        return driver.findElement(emailLocator).getAttribute("value");
    }

    public void clickOnSaveBtn() {
        clicking(driver.findElement(saveInfoBtn));
    }
    public String getSuccessfullMessageText() {
        return driver.findElement(successfullUpdateMessage).getText();
    }

    public String getFirstNameErrorMessageText() {
        return driver.findElement(firstNameErrorMessage).getText();
    }

    public String getEmailErrorMessageText() {
        return driver.findElement(emailErrorMessage).getText();
    }
    public String getMainMessageErrorText() {
        return driver.findElement(MainErrorMessage).getText();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public MyAccountPage_Addresses clickOnAddressesBtn(){
        clicking(driver.findElement(addressesBtn));
        return new MyAccountPage_Addresses(driver);
    }


    public MyAccountPage_ChangePassword clickOnChangePasswordBtn(){
        clicking(driver.findElement(chngPasswordBtn));
        return new MyAccountPage_ChangePassword(driver);
    }




}

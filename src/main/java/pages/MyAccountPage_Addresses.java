package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage_Addresses extends PageBase{

    protected WebDriver driver;
    public MyAccountPage_Addresses(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


    private By firstName_Addr = By.id("Address_FirstName");
    private By lastName_Addr = By.id("Address_LastName");
    private By email_Addr = By.id("Address_Email");
    private By country_Addr = By.id("Address_CountryId");
    private By city_Addr = By.id("Address_City");
    private By address1_Addr = By.id("Address_Address1");
    private By zipCode_Addr = By.id("Address_ZipPostalCode");
    private By phoneNumber_Addr = By.id("Address_PhoneNumber");
    private By addNewAddressBtn = By.cssSelector(".add-button button");
    private By saveAddressBtn = By.xpath("//button[contains(@class,'save-address')]");
    private By successfullUpdateMessage = By.cssSelector("#bar-notification .content");
    private By firstNameErrorMessage_Addr = By.id("Address_FirstName-error");
    private By lastNameErrorMessage_Addr = By.id("Address_LastName-error");
    private By emailErrorMessage_Addr = By.id("Address_Email-error");
    private By cityErrorMessage_Addr = By.id("Address_City-error");
    private By address1ErrorMessage_Addr = By.id("Address_Address1-error");
    private By zipCodeErrorMessage_Addr = By.id("Address_ZipPostalCode-error");
    private By phoneErrorMessage_Addr = By.id("Address_PhoneNumber-error");
    private By MainErrorMessage = By.className("message-error");


    public void clickOnAddNewBtn(){
        clicking(driver.findElement(addNewAddressBtn));
    }
    public void enterFirstNameAddress(String fname) {
        clicking(driver.findElement(firstName_Addr));
        enterText(driver.findElement(firstName_Addr), fname);
    }

    public String getFirstNameAddress() {
        return driver.findElement(firstName_Addr).getAttribute("value");
    }

    public void enterLastNameAddress(String lname) {
        clicking(driver.findElement(lastName_Addr));
        enterText(driver.findElement(lastName_Addr), lname);
    }

    public String getLastNameAddress() {
        return driver.findElement(lastName_Addr).getAttribute("value");
    }

    public void enterEmailAddress(String email) {
        clicking(driver.findElement(email_Addr));
        enterText(driver.findElement(email_Addr), email);
    }

    public String getEmailAddress() {
        return driver.findElement(email_Addr).getAttribute("value");
    }

    public void selectCountry(String country) {
        WebElement drop = driver.findElement(country_Addr);
        Select select = new Select(drop);
        select.selectByVisibleText(country);
    }

    public String getSelectedCountry() {
        return new Select(driver.findElement(country_Addr)).getFirstSelectedOption().getText();
    }

    public void enterCity(String city) {
        clicking(driver.findElement(city_Addr));
        enterText(driver.findElement(city_Addr), city);
    }

    public String getCity() {
        return driver.findElement(city_Addr).getAttribute("value");
    }

    public void enterAddress1(String address) {
        clicking(driver.findElement(address1_Addr));
        enterText(driver.findElement(address1_Addr), address);
    }

    public String getAddress1() {
        return driver.findElement(address1_Addr).getAttribute("value");
    }

    public void enterZipCode(String zipCode) {
        clicking(driver.findElement(zipCode_Addr));
        enterText(driver.findElement(zipCode_Addr), zipCode);
    }

    public String getZipCode() {
        return driver.findElement(zipCode_Addr).getAttribute("value");
    }

    public void enterPhoneNumber(String phoneNumber) {
        clicking(driver.findElement(phoneNumber_Addr));
        enterText(driver.findElement(phoneNumber_Addr), phoneNumber);
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumber_Addr).getAttribute("value");
    }
    public void clickOnSaveAddressBtn(){
        clicking(driver.findElement(saveAddressBtn));
    }
    public String getFirstNameErrorMessage_Addr() {
        return driver.findElement(firstNameErrorMessage_Addr).getText();
    }

    public String getLastNameErrorMessage_Addr() {
        return driver.findElement(lastNameErrorMessage_Addr).getText();
    }

    public String getEmailErrorMessage_Addr() {
        return driver.findElement(emailErrorMessage_Addr).getText();
    }

    public String getCityErrorMessage_Addr() {
        return driver.findElement(cityErrorMessage_Addr).getText();
    }

    public String getAddress1ErrorMessage_Addr() {
        return driver.findElement(address1ErrorMessage_Addr).getText();
    }

    public String getZipCodeErrorMessage_Addr() {
        return driver.findElement(zipCodeErrorMessage_Addr).getText();
    }

    public String getPhoneErrorMessage_Addr() {
        return driver.findElement(phoneErrorMessage_Addr).getText();
    }
    public String getSuccessfullMessageText() {
        return driver.findElement(successfullUpdateMessage).getText();
    }

    public String getMainMessageErrorText() {
        return driver.findElement(MainErrorMessage).getText();
    }
}

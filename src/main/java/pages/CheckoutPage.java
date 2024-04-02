package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

    protected WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By firstName_Addr = By.id("BillingNewAddress_FirstName");
    private By lastName_Addr = By.id("BillingNewAddress_LastName");
    private By email_Addr = By.id("BillingNewAddress_Email");
    private By country_Addr = By.id("BillingNewAddress_CountryId");
    private By city_Addr = By.id("BillingNewAddress_City");
    private By address1_Addr = By.id("BillingNewAddress_Address1");
    private By zipCode_Addr = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumber_Addr = By.id("BillingNewAddress_PhoneNumber");
    private By cardHolderName = By.id("CardholderName");
    private By cardNumber = By.id("CardNumber");
    private By expMonth = By.id("ExpireMonth");
    private By expYear = By.id("ExpireYear");
    private By cardCode = By.id("CardCode");



    private By shipSameAddressChkBox = By.cssSelector(".selector *[type='checkbox']");
    private By billingAddrContinueBtn = By.cssSelector("#billing-buttons-container button[name='save']");
    private By shipMethodContinueBtn = By.cssSelector("#co-shipping-method-form button");
    private By paymentMethodContinueBtn = By.cssSelector("#checkout-step-payment-method button");
    private By paymentInfoContinueBtn = By.cssSelector("#checkout-step-payment-info button");
    private By confirmOrderConfBtn = By.cssSelector("#checkout-step-confirm-order button");
    private By creditCardBtn = By.id("paymentmethod_1");
    private By successfulOrderContinueBtn = By.cssSelector(".buttons button");

    private By shipMethodSection = By.className("method-list");
    private By paymentMethodSection = By.id("checkout-step-payment-method");
    private By paymentInfoSection = By.id("checkout-step-payment-info");
    private By confirmOrderSection = By.id("checkout-step-confirm-order");
    private By name_Ship = By.cssSelector(".shipping-info .name");
    private By email_Ship = By.cssSelector(".shipping-info .email");
    private By phone_Ship = By.cssSelector(".shipping-info .phone");
    private By address1_Ship = By.cssSelector(".shipping-info .address1");
    private By cityZip_Ship = By.cssSelector(".shipping-info .city-state-zip");
    private By country_Ship = By.cssSelector(".shipping-info .country");
    private By name_Bill = By.cssSelector(".billing-info .name");
    private By email_Bill = By.cssSelector(".billing-info .email");
    private By phone_Bill = By.cssSelector(".billing-info .phone");
    private By address1_Bill = By.cssSelector(".billing-info .address1");
    private By cityZip_Bill = By.cssSelector(".billing-info .city-state-zip");
    private By country_Bill = By.cssSelector(".billing-info .country");





    private By successfullUpdateMessage = By.cssSelector("#bar-notification .content"); //
    private By firstNameErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.FirstName']");
    private By lastNameErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.LastName']");
    private By emailErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.Email']");
    private By cityErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.City']");
    private By address1ErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.Address1']");
    private By zipCodeErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.ZipPostalCode']");
    private By phoneErrorMessage = By.cssSelector("span[data-valmsg-for='BillingNewAddress.PhoneNumber']");
    private By paymentInfoErrorMessage =By.className("message-error");
    private By guestBtn = By.xpath("//button[contains(@class,'guest')]");
    private By waitMessage = By.id("billing-please-wait");
    private By confOrderwaitMessage = By.id("confirm-order-please-wait");
    private By successfulOrderMessage = By.cssSelector(".section .title");



    public void enterFirstNameAddress(String fname) {
        clear(driver.findElement(firstName_Addr));
        enterText(driver.findElement(firstName_Addr), fname);
    }

    public String getFirstNameAddress() {
        return driver.findElement(firstName_Addr).getAttribute("value");
    }

    public void enterLastNameAddress(String lname) {
        clear(driver.findElement(lastName_Addr));
        enterText(driver.findElement(lastName_Addr), lname);
    }

    public String getLastNameAddress() {
        return driver.findElement(lastName_Addr).getAttribute("value");
    }

    public void enterEmailAddress(String email) {
        clear(driver.findElement(email_Addr));
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
        clear(driver.findElement(city_Addr));
        enterText(driver.findElement(city_Addr), city);
    }

    public String getCity() {
        return driver.findElement(city_Addr).getAttribute("value");
    }

    public void enterAddress1(String address) {
        clear(driver.findElement(address1_Addr));
        enterText(driver.findElement(address1_Addr), address);
    }

    public String getAddress1() {
        return driver.findElement(address1_Addr).getAttribute("value");
    }

    public void enterZipCode(String zipCode) {
        clear(driver.findElement(zipCode_Addr));
        enterText(driver.findElement(zipCode_Addr), zipCode);
    }

    public String getZipCode() {
        return driver.findElement(zipCode_Addr).getAttribute("value");
    }

    public void enterPhoneNumber(String phoneNumber) {
        clear(driver.findElement(phoneNumber_Addr));
        enterText(driver.findElement(phoneNumber_Addr), phoneNumber);
    }

    public String getPhoneNumber() {
        return driver.findElement(phoneNumber_Addr).getAttribute("value");
    }
    public void clickOnBillingContinueBtn(){
        clicking(driver.findElement(billingAddrContinueBtn));
    }
    public WebElement getSameAddressChkBox(){
        return driver.findElement(shipSameAddressChkBox);
    }

    public WebElement getShipMethodSection(){
        return driver.findElement(shipMethodSection);
    }
    public WebElement getPaymentMethodSection(){
        return driver.findElement(paymentMethodSection);
    }

    public WebElement getPaymentInformationSection(){
        return driver.findElement(paymentInfoSection);
    }
    public WebElement getConfirmOrderSection(){
        return driver.findElement(confirmOrderSection);
    }

    public String getFirstNameErrorMessage() {
        return driver.findElement(firstNameErrorMessage).getText();
    }

    public WebElement getFirstNameErrorMessageLocator() {
        return driver.findElement(firstNameErrorMessage);
    }

    public String getLastNameErrorMessage() {
        return driver.findElement(lastNameErrorMessage).getText();
    }

    public String getEmailErrorMessage() {
        return driver.findElement(emailErrorMessage).getText();
    }

    public String getCityErrorMessage() {
        return driver.findElement(cityErrorMessage).getText();
    }

    public String getAddress1ErrorMessage() {
        return driver.findElement(address1ErrorMessage).getText();
    }

    public String getZipCodeErrorMessage() {
        return driver.findElement(zipCodeErrorMessage).getText();
    }

    public String getPhoneErrorMessage() {
        return driver.findElement(phoneErrorMessage).getText();
    }

    public WebElement getWaitMessageLocator() {
        return driver.findElement(waitMessage);
    }

    public void clickOnShipMethodContinueBtn(){
        clicking(driver.findElement(shipMethodContinueBtn));
    }

    public void clickOnPaymentMethodContinueBtn(){
        clicking(driver.findElement(paymentMethodContinueBtn));
    }
    public void clickOnPaymentInfoContinueBtn(){
        clicking(driver.findElement(paymentInfoContinueBtn));
    }

    public void clickOnGuestBtn(){
        clicking(driver.findElement(guestBtn));
    }

    public void clickOnCreditCardBtn(){
        clicking(driver.findElement(creditCardBtn));
    }

    public void enterCardholderName(String name) {
        clear(driver.findElement(cardHolderName));
        enterText(driver.findElement(cardHolderName), name);
    }

    public String getCardholderName() {
        return driver.findElement(cardHolderName).getAttribute("value");
    }

    public void enterCardNumber(String number) {
        clear(driver.findElement(cardNumber));
        enterText(driver.findElement(cardNumber), number);
    }

    public String getCardNumber() {
        return driver.findElement(cardNumber).getAttribute("value");
    }

    public void selectExpMonth(String month) {
        WebElement drop = driver.findElement(expMonth);
        Select select = new Select(drop);
        select.selectByVisibleText(month);
    }

    public String getSelectedExpMonth() {
        return new Select(driver.findElement(expMonth)).getFirstSelectedOption().getText();
    }

    public void selectExpYear(String country) {
        WebElement drop = driver.findElement(expYear);
        Select select = new Select(drop);
        select.selectByVisibleText(country);
    }

    public String getSelectedExpYear() {
        return new Select(driver.findElement(expYear)).getFirstSelectedOption().getText();
    }

    public void enterCardCode(String code) {
        clear(driver.findElement(cardCode));
        enterText(driver.findElement(cardCode), code);
    }

    public String getCardCode() {
        return driver.findElement(cardCode).getAttribute("value");
    }

    public String getPaymentInfoErrorMessage(){
        return driver.findElement(paymentInfoErrorMessage).getText();
    }

    public String getNameInBillingAddressSection(){
        return driver.findElement(name_Bill).getText();
    }
    public String getEmailInBillingAddressSection(){
        return driver.findElement(email_Bill).getText();
    }
    public String getPhoneInBillingAddressSection(){
        return driver.findElement(phone_Bill).getText();
    }
    public String getAddressInBillingAddressSection(){
        return driver.findElement(address1_Bill).getText();
    }
    public String getCountryInBillingAddressSection(){
        return driver.findElement(country_Bill).getText();
    }
    public String getCityAndZipCodeInBillingAddressSection(){
        return driver.findElement(cityZip_Bill).getText();
    }

    public String getNameInShippingAddressSection(){
        return driver.findElement(name_Ship).getText();
    }
    public String getEmailInShippingAddressSection(){
        return driver.findElement(email_Ship).getText();
    }
    public String getPhoneInShippingAddressSection(){
        return driver.findElement(phone_Ship).getText();
    }
    public String getAddressInShippingAddressSection(){
        return driver.findElement(address1_Ship).getText();
    }
    public String getCountryInShippingAddressSection(){
        return driver.findElement(country_Ship).getText();
    }
    public String getCityAndZipCodeInShippingAddressSection(){
        return driver.findElement(cityZip_Ship).getText();
    }
    public void clickOnConfirmButton(){
        clicking(driver.findElement(confirmOrderConfBtn));
    }
    public String getSuccessfulOrderMessage(){
        System.out.println(driver.findElement(successfulOrderMessage).getText());
        return driver.findElement(successfulOrderMessage).getText();
    }

    public void clickOnSuccessfulOrderContinueBtn(){
        clicking(driver.findElement(successfulOrderContinueBtn));
    }
    public WebElement getConfirmationWaitMessageLocator() {
        return driver.findElement(confOrderwaitMessage);
    }

}

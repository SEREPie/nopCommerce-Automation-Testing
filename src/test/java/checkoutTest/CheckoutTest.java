package checkoutTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testBase.TestBase;

import java.time.Duration;

public class CheckoutTest extends TestBase {


    protected WebDriverWait wait;
    protected ProductPage productPage;
    protected CheckoutPage checkoutPage;
    protected CartPage cartPage;

    @BeforeMethod()
    private void AddItemToCart(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnSecondProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.setQuantity("1");
        productPage.clickOnAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        cartPage = productPage.clickOnShoppingCartBtn();
        checkoutPage = cartPage.clickOnCheckoutAndChkBoxBtns();
        checkoutPage.clickOnGuestBtn();
        Assert.assertTrue(checkoutPage.getHeaderText().contains("Checkout"));
    }



    @Test
    public void EnterValidDataInBillingAddress(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
    }


    @Test
    public void LeaveBillingAddressFieldsWithBlankData(){
        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertEquals(checkoutPage.getFirstNameErrorMessage(), "First name is required.");
        Assert.assertEquals(checkoutPage.getLastNameErrorMessage(), "Last name is required.");
        Assert.assertEquals(checkoutPage.getEmailErrorMessage(), "Email is required.");
        Assert.assertEquals(checkoutPage.getCityErrorMessage(), "City is required");
        Assert.assertEquals(checkoutPage.getAddress1ErrorMessage(), "Street address is required");
        Assert.assertEquals(checkoutPage.getZipCodeErrorMessage(), "Zip / postal code is required");
        Assert.assertEquals(checkoutPage.getPhoneErrorMessage(), "Phone is required");

    }


    @Test
    public void EnterInvalidEmailFormatInBillingAddressData(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam#gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam#gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertEquals(checkoutPage.getEmailErrorMessage(), "Wrong email");
    }


    @Test
    public void EnterValidDataInPaymentInfo(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("4732293588909505");
        Assert.assertEquals(checkoutPage.getCardNumber(),"4732293588909505");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("585");
        Assert.assertEquals(checkoutPage.getCardCode(),"585");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getConfirmOrderSection()));


    }


    @Test
    public void LeavePaymentInfoWithBlankFields(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Enter cardholder name"));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card number"));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card code"));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Card is expired"));
    }

    @Test
    public void TypeCharactersInCardNumberField(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("hossam");
        Assert.assertEquals(checkoutPage.getCardNumber(),"hossam");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("585");
        Assert.assertEquals(checkoutPage.getCardCode(),"585");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card number"));
    }

    @Test
    public void TypeSpecialCharactersInCardNumberField(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("h#$@@m");
        Assert.assertEquals(checkoutPage.getCardNumber(),"h#$@@m");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("585");
        Assert.assertEquals(checkoutPage.getCardCode(),"585");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card number"));
    }

    @Test
    public void TypeCharactersInCardCodeField(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("4732293588909505");
        Assert.assertEquals(checkoutPage.getCardNumber(),"4732293588909505");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("abc");
        Assert.assertEquals(checkoutPage.getCardCode(),"abc");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card code"));
    }


    @Test
    public void TypeSpecialCharactersInCardCodeField(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("4732293588909505");
        Assert.assertEquals(checkoutPage.getCardNumber(),"4732293588909505");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("@#$");
        Assert.assertEquals(checkoutPage.getCardCode(),"@#$");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Wrong card code"));
    }

    @Test
    public void TypeExpiredDateInExpirationDateField(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("4732293588909505");
        Assert.assertEquals(checkoutPage.getCardNumber(),"4732293588909505");
        checkoutPage.selectExpMonth("01");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"01");
        checkoutPage.selectExpYear("2024");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2024");
        checkoutPage.enterCardCode("585");
        Assert.assertEquals(checkoutPage.getCardCode(),"585");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getPaymentInfoErrorMessage().contains("Card is expired"));
    }



    @Test
    public void ConfirmOrderDataShouldBeCorrect(){
        Assert.assertTrue(checkoutPage.getSameAddressChkBox().isSelected());
        checkoutPage.enterFirstNameAddress("Hossam");
        Assert.assertEquals(checkoutPage.getFirstNameAddress(),"Hossam");
        checkoutPage.enterLastNameAddress("Mostafa");
        Assert.assertEquals(checkoutPage.getLastNameAddress(),"Mostafa");
        checkoutPage.enterEmailAddress("hossam@gmail.com");
        Assert.assertEquals(checkoutPage.getEmailAddress(),"hossam@gmail.com");
        checkoutPage.selectCountry("Egypt");
        Assert.assertEquals(checkoutPage.getSelectedCountry(),"Egypt");
        checkoutPage.enterCity("Cairo");
        Assert.assertEquals(checkoutPage.getCity(),"Cairo");
        checkoutPage.enterAddress1("Makram St.");
        Assert.assertEquals(checkoutPage.getAddress1(),"Makram St.");
        checkoutPage.enterZipCode("18282");
        Assert.assertEquals(checkoutPage.getZipCode(),"18282");
        checkoutPage.enterPhoneNumber("0123456789");
        Assert.assertEquals(checkoutPage.getPhoneNumber(),"0123456789");

        checkoutPage.clickOnBillingContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getShipMethodSection()));
        checkoutPage.clickOnShipMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentMethodSection()));
        checkoutPage.clickOnCreditCardBtn();
        checkoutPage.clickOnPaymentMethodContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getPaymentInformationSection()));

        checkoutPage.enterCardholderName("Emma Clark");
        Assert.assertEquals(checkoutPage.getCardholderName(),"Emma Clark");
        checkoutPage.enterCardNumber("4732293588909505");
        Assert.assertEquals(checkoutPage.getCardNumber(),"4732293588909505");
        checkoutPage.selectExpMonth("04");
        Assert.assertEquals(checkoutPage.getSelectedExpMonth(),"04");
        checkoutPage.selectExpYear("2025");
        Assert.assertEquals(checkoutPage.getSelectedExpYear(),"2025");
        checkoutPage.enterCardCode("585");
        Assert.assertEquals(checkoutPage.getCardCode(),"585");

        checkoutPage.clickOnPaymentInfoContinueBtn();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.getConfirmOrderSection()));

        Assert.assertTrue(checkoutPage.getNameInBillingAddressSection().contains("Hossam Mostafa"));
        Assert.assertTrue(checkoutPage.getEmailInBillingAddressSection().contains("hossam@gmail.com"));
        Assert.assertTrue(checkoutPage.getPhoneInBillingAddressSection().contains("0123456789"));
        Assert.assertTrue(checkoutPage.getAddressInBillingAddressSection().contains("Makram St."));
        Assert.assertTrue(checkoutPage.getCityAndZipCodeInBillingAddressSection().contains("Cairo"));
        Assert.assertTrue(checkoutPage.getCityAndZipCodeInBillingAddressSection().contains("18282"));
        Assert.assertTrue(checkoutPage.getCountryInBillingAddressSection().contains("Egypt"));

        Assert.assertTrue(checkoutPage.getNameInShippingAddressSection().contains("Hossam Mostafa"));
        Assert.assertTrue(checkoutPage.getEmailInShippingAddressSection().contains("hossam@gmail.com"));
        Assert.assertTrue(checkoutPage.getPhoneInShippingAddressSection().contains("0123456789"));
        Assert.assertTrue(checkoutPage.getAddressInShippingAddressSection().contains("Makram St."));
        Assert.assertTrue(checkoutPage.getCityAndZipCodeInShippingAddressSection().contains("Cairo"));
        Assert.assertTrue(checkoutPage.getCityAndZipCodeInShippingAddressSection().contains("18282"));
        Assert.assertTrue(checkoutPage.getCountryInShippingAddressSection().contains("Egypt"));

        checkoutPage.clickOnConfirmButton();
        wait.until(ExpectedConditions.invisibilityOf(checkoutPage.getConfirmationWaitMessageLocator()));
        Assert.assertTrue(checkoutPage.getSuccessfulOrderMessage().contains("Your order has been successfully processed"));

    }

}

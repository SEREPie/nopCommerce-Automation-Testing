package cartTest;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import pages.SearchResultPage;
import testBase.TestBase;

import java.time.Duration;

public class CartTest extends TestBase {


    @Test
    public void productDetailsInCartShouldBeCorrect(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        String productNameSrch = searchResultPage.getFirstProductName();
        Double productPriceSrch = searchResultPage.getFirstProductPrice();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        Assert.assertEquals(productNameSrch,productPage.getProductName());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(productPriceSrch,productPage.getProductPrice());
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        String productNamePro = productPage.getProductName();
        String productSKUpro = productPage.getProductSKU();
        Double productPricePro = productPage.getProductPrice();
        productPage.clickOnAddToCartBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));
        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        Assert.assertEquals(cartPage.getProductPrice(),productPricePro);
        Assert.assertTrue(cartPage.getProductNames().contains(productNamePro));
        Assert.assertEquals(cartPage.getProductSKU(),productSKUpro);
        Assert.assertEquals(cartPage.getProductQuantity(),"3");
        Assert.assertTrue(cartPage.getProductCustomText().contains("Hossam"));
    }

    @Test
    public void addProductToCartWithNegativeQuantity(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("-3");
        productPage.clickOnAddToCartBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("should be positive"));
    }

    @Test
    public void addProductToCartWithSpecialCharacterInQuantityField(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("#");
        productPage.clickOnAddToCartBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("should be positive"));
    }

    @Test
    public void changeQuantityInTheCartShouldChangeSubtotalPrice(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToCartBtn();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Double productPrice = cartPage.getProductPrice();
        Double oldSubtotalPrice = cartPage.getProductSubtotalPrice();
        cartPage.changeQuantity("4");
        cartPage.clickOnUpdateCartBtn();
        Double newSubtotalPrice = cartPage.getProductSubtotalPrice();
        Assert.assertNotEquals(oldSubtotalPrice,newSubtotalPrice);
        Assert.assertEquals(newSubtotalPrice,productPrice * 4);
    }

    @Test
    public void DeleteProductFromCart(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToCartBtn();
        productPage.hoverOnApparelNav();
        searchResultPage = productPage.clickOnClothingNav();
        productPage = searchResultPage.clickOnSecondProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String firstProductName = cartPage.getFirstProductName();
        cartPage.clickOnRemoveBtn();
        Assert.assertFalse(cartPage.getProductNames().contains(firstProductName));
    }

    @Test
    public void CorrectProductDataInCartAfterUpdatingTheData(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String oldProductCustomTxt = cartPage.getProductCustomText();
        String oldProductQuantity = cartPage.getProductQuantity();
        productPage = cartPage.clickOnEditBtn();
        productPage.setQuantity("2");
        productPage.enterTextInCustomTextField("Mostafa");
        productPage.clickOnUpdateCartBtn();
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));
        cartPage = productPage.clickOnShoppingCartBtn();
        Assert.assertFalse(cartPage.getProductCustomText().contains(oldProductCustomTxt));
        Assert.assertNotEquals(cartPage.getProductQuantity(),oldProductQuantity);
        Assert.assertTrue(cartPage.getProductCustomText().contains("Mostafa"));
        Assert.assertEquals(cartPage.getProductQuantity(),"2");
    }

    @Test
    public void AddingGiftWrappingWillAdd10$ToTotalPrice() throws InterruptedException {
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("1");
        productPage.clickOnAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Double oldTotalPrice = cartPage.getProductsTotalPrice();
        cartPage.selectGiftWrapping("2");
        Thread.sleep(3000);
        Assert.assertEquals(cartPage.getProductsTotalPrice(),oldTotalPrice+10);
        Assert.assertTrue(cartPage.getGiftWrappingStatus().contains("Yes [+$10.00]"));
    }
    @Test
    public void RemovingGiftWrappingWillRemove10$FromTotalPrice() throws InterruptedException {
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("1");
        productPage.clickOnAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        cartPage.selectGiftWrapping("2");
        Thread.sleep(2000);
        Double oldTotalPrice = cartPage.getProductsTotalPrice();
        cartPage.selectGiftWrapping("1");
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.getProductsTotalPrice(),oldTotalPrice-10);
        Assert.assertTrue(cartPage.getGiftWrappingStatus().contains("No"));
    }

    @Test
    public void CheckoutButtonRedirectsToCheckoutPage() {
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("1");
        productPage.clickOnAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToCartBtn();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        CartPage cartPage = productPage.clickOnShoppingCartBtn();
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutAndChkBoxBtns();
        checkoutPage.clickOnGuestBtn();
        Assert.assertTrue(checkoutPage.getHeaderText().contains("Checkout"));
    }

}

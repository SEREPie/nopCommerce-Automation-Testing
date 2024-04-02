package wishlistTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import pages.SearchResultPage;
import pages.WishlistPage;
import testBase.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WishlistTest extends TestBase {
    @Test
    public void productDetailsInWishlistShouldBeCorrect(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        String productNameSrch = searchResultPage.getFirstProductName();
        Double productPriceSrch = searchResultPage.getFirstProductPrice();

        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        Assert.assertEquals(productPage.getProductName(),productNameSrch);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals(productPage.getProductPrice(),productPriceSrch);
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        String productNamePro = productPage.getProductName();
        String productSKUpro = productPage.getProductSKU();
        Double productPricePro = productPage.getProductPrice();
        productPage.clickOnAddToWishlistBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        WishlistPage wishlistPage = productPage.clickOnWishlistBtn();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(wishlistPage.getProductNames().contains(productNamePro));
        Assert.assertEquals(wishlistPage.getProductSKU(),productSKUpro);
        Assert.assertEquals(wishlistPage.getProductPrice(),productPricePro);
        Assert.assertEquals(wishlistPage.getProductQuantity(),"3");
        Assert.assertTrue(wishlistPage.getProductCustomText().contains("Hossam"));
    }

    @Test
    public void addProductToWishlistWithNegativeQuantity(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("-3");
        productPage.clickOnAddToWishlistBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("should be positive"));
    }

    @Test
    public void addProductToWishlistWithSpecialCharacterInQuantityField(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("#");
        productPage.clickOnAddToWishlistBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("should be positive"));
    }

    @Test
    public void changeQuantityInTheWishlistShouldChangeSubtotalPrice(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToWishlistBtn();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        WishlistPage wishlistPage = productPage.clickOnWishlistBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Double productPrice = wishlistPage.getProductPrice();
        Double oldSubtotalPrice = wishlistPage.getProductSubtotalPrice();
        wishlistPage.changeQuantity("4");
        wishlistPage.clickOnUpdateWishlistBtn();
        Double newSubtotalPrice = wishlistPage.getProductSubtotalPrice();
        Assert.assertNotEquals(oldSubtotalPrice,newSubtotalPrice);
        Assert.assertEquals(newSubtotalPrice,productPrice * 4);
    }

    @Test
    public void DeleteProductFromWishlist(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToWishlistBtn();
        productPage.hoverOnApparelNav();
        searchResultPage = productPage.clickOnClothingNav();
        productPage = searchResultPage.clickOnSecondProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToWishlistBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        WishlistPage wishlistPage = productPage.clickOnWishlistBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String firstProductName = wishlistPage.getFirstProductName();
        wishlistPage.clickOnRemoveBtn();
        Assert.assertFalse(wishlistPage.getProductNames().contains(firstProductName));
    }

    @Test
    public void CorrectProductDataInWishlistAfterUpdatingTheData(){
        homePage.hoverOnApparelNav();
        SearchResultPage searchResultPage = homePage.clickOnClothingNav();
        ProductPage productPage = searchResultPage.clickOnFirstProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.enterTextInCustomTextField("Hossam");
        productPage.setQuantity("3");
        productPage.clickOnAddToWishlistBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        productPage.clickOnAddToWishlistBtn();


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));

        WishlistPage wishlistPage = productPage.clickOnWishlistBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String oldProductCustomTxt = wishlistPage.getProductCustomText();
        String oldProductQuantity = wishlistPage.getProductQuantity();
        productPage = wishlistPage.clickOnEditBtn();
        productPage.setQuantity("2");
        productPage.enterTextInCustomTextField("Mostafa");
        productPage.clickOnUpdateWishlistBtn();
        wait.until(ExpectedConditions.visibilityOf(productPage.getBarNotification()));
        Assert.assertTrue(productPage.getBarNotificationMessage().contains("has been added"));
        wishlistPage = productPage.clickOnWishlistBtn();
        Assert.assertFalse(wishlistPage.getProductCustomText().contains(oldProductCustomTxt));
        Assert.assertNotEquals(wishlistPage.getProductQuantity(),oldProductQuantity);
        Assert.assertTrue(wishlistPage.getProductCustomText().contains("Mostafa"));
        Assert.assertEquals(wishlistPage.getProductQuantity(),"2");
    }
}

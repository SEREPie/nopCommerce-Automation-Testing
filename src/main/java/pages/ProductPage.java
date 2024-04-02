package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends PageBase{

    protected WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    protected By productQuantity = By.cssSelector(".add-to-cart-panel input");
    private By addToCartBtn = By.cssSelector(".add-to-cart-panel button");
    private By addToWishlistBtn = By.className("add-to-wishlist");
    private By wishlistBtn = By.linkText("wishlist");
    private By customTextField = By.cssSelector(".attributes input");
    private By productPrice = By.className("product-price");
    private By productName = By.cssSelector(".product-name h1");
    private By productSKU = By.cssSelector(".sku span:nth-child(2)");
    private By shoppingCartBtn = By.linkText("shopping cart");
    private By barNorification = By.id("bar-notification");


    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public void enterTextInCustomTextField(String text){
        clear(driver.findElement(customTextField));
        enterText(driver.findElement(customTextField),text);
    }

    public Double getProductPrice(){
        String price = driver.findElement(productPrice).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }

    public void setQuantity(String text){
        clear(driver.findElement(productQuantity));
        enterText(driver.findElement(productQuantity),text);
    }
    public String getProductSKU(){
        return driver.findElement(productSKU).getText();
    }
    public void clickOnAddToCartBtn (){
        clicking(driver.findElement(addToCartBtn));
    }

    public void clickOnUpdateCartBtn (){
        clicking(driver.findElement(addToCartBtn));
    }

    public void clickOnUpdateWishlistBtn (){
        clicking(driver.findElement(addToWishlistBtn));
    }

    public CartPage clickOnShoppingCartBtn(){
        clicking(driver.findElement(shoppingCartBtn));
        return new CartPage(driver);
    }

    public void clickOnAddToWishlistBtn(){
        clicking(driver.findElement(addToWishlistBtn));
    }

    public WishlistPage clickOnWishlistBtn(){
        clicking(driver.findElement(wishlistBtn));
        return new WishlistPage(driver);
    }
    public String getBarNotificationMessage(){
        return driver.findElement(barNorification).getText();
    }
    public WebElement getBarNotification(){
        return driver.findElement(barNorification);
    }


}

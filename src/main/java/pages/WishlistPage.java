package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends PageBase{
    protected WebDriver driver;

    public WishlistPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By productNames = By.className("product-name");
    private By firstProductName = By.cssSelector("tr:nth-child(1) .product-name");
    private By productSKU = By.cssSelector(".sku span");
    private By productCustomText = By.cssSelector(".master-wrapper-content .attributes");
    private By productPrice = By.cssSelector(".unit-price span");
    private By subtotal = By.className("product-subtotal");
    private By productQauntity =By.cssSelector(".quantity input");
    private By removeBtn = By.className("remove-btn");
    private By addToCartChkBox = By.name("addtocart");
    private By addToCartBtn = By.name("addtocartbutton");
    private By updateWishlistBtn = By.id("updatecart");
    private By editBtn = By.linkText("Edit");


    public String getProductNames(){
        return driver.findElement(productNames).getText();
    }
    public String getFirstProductName(){
        return driver.findElement(firstProductName).getText();
    }
    public String getProductSKU(){
        return driver.findElement(productSKU).getText();
    }
    public String getProductCustomText(){
        return driver.findElement(productCustomText).getText();
    }
    public Double getProductPrice(){
        String price = driver.findElement(productPrice).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }
    public String getProductQuantity(){
        return driver.findElement(productQauntity).getAttribute("value");
    }
    public void changeQuantity(String quantity){
        clear(driver.findElement(productQauntity));
        enterText(driver.findElement(productQauntity),quantity);
    }
    public void clickOnRemoveBtn (){
        clicking(driver.findElement(removeBtn));
    }
    public void checkAddToCartChkBox (){
        clicking(driver.findElement(addToCartChkBox));
    }
    public CartPage clickOnAddToCartChkBtn (){
        clicking(driver.findElement(addToCartBtn));
        return new CartPage(driver);
    }
    public void clickOnUpdateWishlistBtn (){
        clicking(driver.findElement(updateWishlistBtn));
    }

    public Double getProductSubtotalPrice(){
        String price = driver.findElement(subtotal).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }
    public ProductPage clickOnEditBtn (){
        clicking(driver.findElement(editBtn));
        return new ProductPage(driver);
    }




}

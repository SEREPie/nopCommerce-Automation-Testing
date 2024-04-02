package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageBase{

    protected WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By productNames = By.className("product-name");
    private By firstProductName = By.cssSelector("tr:nth-child(1) .product-name");
    private By productSKU = By.cssSelector(".sku span");
    private By productCustomText = By.cssSelector(".master-wrapper-content .attributes");
    private By productPrice = By.cssSelector(".unit-price span");
    private By productQauntity =By.cssSelector(".quantity input");
    private By subtotal = By.className("product-subtotal");
    private By totalPrice = By.cssSelector(".order-total .value-summary");
    private By updateCartBtn = By.id("updatecart");
    private By removeBtn = By.className("remove-btn");
    private By editBtn = By.linkText("Edit");
    private By giftWrappingDropList = By.id("checkout_attribute_1");
    private By giftWrappingStatus = By.cssSelector(".cart-options .selected-checkout-attributes");
    private By checkoutBtn = By.name("checkout");
    private By termChkBox = By.name("termsofservice");
    private By guestBtn = By.xpath("//button[contains(@class,'guest')]");


    public String getProductNames(){
        return driver.findElement(productNames).getText();
    }

    public String getFirstProductName(){
        return driver.findElement(firstProductName).getText();
    }
    public Double getProductPrice(){
        String price = driver.findElement(productPrice).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }

    public Double getProductSubtotalPrice(){
        String price = driver.findElement(subtotal).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }
    public Double getProductsTotalPrice(){
        String price = driver.findElement(totalPrice).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }
    public String getProductSKU(){
        return driver.findElement(productSKU).getText();
    }
    public String getProductQuantity(){
        return driver.findElement(productQauntity).getAttribute("value");
    }
    public String getProductCustomText(){
        return driver.findElement(productCustomText).getText();
    }

    public void changeQuantity(String quantity){
        clear(driver.findElement(productQauntity));
        enterText(driver.findElement(productQauntity),quantity);
    }

    public void clickOnRemoveBtn (){
        clicking(driver.findElement(removeBtn));
    }
    public ProductPage clickOnEditBtn (){
        clicking(driver.findElement(editBtn));
        return new ProductPage(driver);
    }

    public void selectGiftWrapping(String sortType){
        WebElement drop = driver.findElement(giftWrappingDropList);
        Select select = new Select(drop);
        select.selectByValue(sortType);
    }
    public String getGiftWrappingStatus(){
        return driver.findElement(giftWrappingStatus).getText();
    }

    public WebElement getGiftWrappingStatusLocator(){
        System.out.println(driver.findElement(giftWrappingStatus).getText());
        return driver.findElement(giftWrappingStatus);
    }
    public CheckoutPage clickOnCheckoutAndChkBoxBtns(){
        clicking(driver.findElement(termChkBox));
        clicking(driver.findElement(checkoutBtn));
        return new CheckoutPage(driver);
    }


    public void clickOnGuestBtn(){
        clicking(driver.findElement(guestBtn));
    }
    public void clickOnUpdateCartBtn(){
        clicking(driver.findElement(updateCartBtn));
    }

}

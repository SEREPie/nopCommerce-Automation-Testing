package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultPage extends PageBase{

    protected WebDriver driver;


    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By productsElementsLocator = By.cssSelector("h2 a");
    private By productsPricesLocator = By.className("prices");
    private By sortBy = By.id("products-orderby");
    private By prodPerPage = By.id("products-pagesize");
    private By loading = By.className("ajax-products-busy");
    private By currencyChanger = By.id("customerCurrency");
    private By firstProductLocator = By.cssSelector("div[class= 'item-box']:nth-child(1) .details a");
    private By secondProductLocator = By.cssSelector("div[class= 'item-box']:nth-child(2) .details a");
    private By firstProductPrice = By.cssSelector(".item-box:nth-child(1) .prices");

    private List<String> productNames;
    private List<String> sortedProductNames;
    private List<Double> productPrices;
    private List<Double> sortedProductPrices;


    public String getSearchResultsText(){
        return driver.findElement(productsElementsLocator).getText();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }

    public void selectSortType(String sortType){

        WebElement drop = driver.findElement(sortBy);
        Select select = new Select(drop);
        clicking(driver.findElement(sortBy));
        select.selectByVisibleText(sortType);
    }

    public void selectCurrency(String currency){
        WebElement drop = driver.findElement(currencyChanger);
        Select select = new Select(drop);
        select.selectByVisibleText(currency);
    }

    public void getAndSortProductNamesAscending(){
        List<WebElement> productsElements = driver.findElements(productsElementsLocator);
        productNames = new ArrayList<>();

        for (WebElement element : productsElements){
            String productName = element.getText();
            productNames.add(productName);
        }

        sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
    }

    public void getAndSortProductNamesDescending(){

        List<WebElement> productsElements = driver.findElements(productsElementsLocator);
        productNames = new ArrayList<>();

        for (WebElement element : productsElements){
            String productName = element.getText();
            productNames.add(productName);
        }
        sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
        sortedProductNames.sort(Collections.reverseOrder());
    }

    public void getAndSortProductPricesAscending(){
        List<WebElement> productsElements = driver.findElements(productsPricesLocator);
        productPrices = new ArrayList<>();

        for (WebElement element : productsElements){
            String productPrice = element.getText();
            String priceValue = productPrice.replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceValue);
            productPrices.add(price);
        }

        sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);
    }

    public void getAndSortProductPricesDescending(){
        List<WebElement> productsElements = driver.findElements(productsPricesLocator);
        productPrices = new ArrayList<>();

        for (WebElement element : productsElements){
            String productPrice = element.getText();
            String priceValue = productPrice.replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceValue);
            productPrices.add(price);
        }
        sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);
        sortedProductPrices.sort(Collections.reverseOrder());
    }


    public List<String> getProductNames() {
        System.out.println(productNames);
        return productNames;
    }

    public List<String> getSortedProductNames() {
        System.out.println(sortedProductNames);
        return sortedProductNames;
    }

    public List<Double> getProductPrices() {
        return productPrices;
    }

    public List<Double> getProductPricesList() {
        List<WebElement> productsElements = driver.findElements(productsPricesLocator);
        productPrices = new ArrayList<>();

        for (WebElement element : productsElements){
            String productPrice = element.getText();
            String priceValue = productPrice.replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceValue);
            productPrices.add(price);
        }
        return productPrices;
    }

    public List<Double> getSortedProductPrices() {
        return sortedProductPrices;
    }

    public WebElement getLoadingAfterSort(){
        return driver.findElement(loading);
    }

    public String getPriceSymbol(){
        List<WebElement> productsElements = driver.findElements(productsPricesLocator);
        productPrices = new ArrayList<>();
        String productPrice = productsElements.getFirst().getText();
        return productPrice.substring(0, 1);
    }

    public ProductPage clickOnFirstProduct(){
        clicking(driver.findElement(firstProductLocator));
        return new ProductPage(driver);
    }

    public ProductPage clickOnSecondProduct(){
        clicking(driver.findElement(secondProductLocator));
        return new ProductPage(driver);
    }

    public String getFirstProductName(){
        return driver.findElement(firstProductLocator).getText();
    }

    public Double getFirstProductPrice(){
        String price = driver.findElement(firstProductPrice).getText().replaceAll("[^\\d.]", "");
        return  Double.parseDouble(price);
    }



}

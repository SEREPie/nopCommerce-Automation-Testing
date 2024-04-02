package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {
    private WebDriver driver;
    private By computerNav = By.partialLinkText("Computers");
    private By notbooksNav = By.partialLinkText("Notebooks");
    private By apparelNav = By.partialLinkText("Apparel");
    private By clothingNav = By.partialLinkText("Clothing");
    private By header = By.cssSelector("div h1");


    public PageBase (WebDriver driver){
        this.driver = driver;
    }


    public void clicking(WebElement element){
        element.click();
    }

    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clear(WebElement element){
        element.clear();
    }

    public void hover(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverOnComputerNav(){
        hover(driver.findElement(computerNav));
    }

    public SearchResultPage clickOnNotebooksNav(){
        clicking(driver.findElement(notbooksNav));
        return new SearchResultPage(driver);
    }

    public void hoverOnApparelNav(){
        hover(driver.findElement(apparelNav));
    }

    public SearchResultPage clickOnClothingNav(){
        clicking(driver.findElement(clothingNav));
        return new SearchResultPage(driver);
    }
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
    public WebElement getHeaderElement() {
        return driver.findElement(header);
    }

}

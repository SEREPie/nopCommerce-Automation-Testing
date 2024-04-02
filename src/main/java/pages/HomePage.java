package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase{

    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By loginBtn = By.linkText("Log in");
    private By registerBtn = By.linkText("Register");
    private By logoutBtn = By.linkText("Log out");
    private By myAccountBtn = By.linkText("My account");
    private By searchField = By.id("small-searchterms");
    private By searchBtn = By.cssSelector("#small-search-box-form button");
    private By searchList = By.id("ui-id-1");




    public LoginPage clickLoginBtn(){
        clicking(driver.findElement(loginBtn));
        return new LoginPage(driver);
    }

    public void clickLogoutBtn(){
        clicking(driver.findElement(logoutBtn));
    }

    public RegistrationPage clickRegisterBtn(){
        clicking(driver.findElement(registerBtn));
        return new RegistrationPage(driver);
    }

    public MyAccountPage_CustomerInfo clickMyAccountBtn(){
        clicking(driver.findElement(myAccountBtn));
        return new MyAccountPage_CustomerInfo(driver);
    }

    public SearchResultPage clickOnSearchBtn(){
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(searchBtn)).perform();
        return new SearchResultPage(driver);
    }

    public void enterTextInSearchField(String text){
        enterText(driver.findElement(searchField), text);
    }

    public void clickOnSearchField(){
        clicking(driver.findElement(searchField));
    }

    public boolean getLogoutBtn(){
        return driver.findElement(logoutBtn).isDisplayed();
    }

    public String getSearchResultListText(){
        return driver.findElement(searchList).getText();
    }


    public WebElement getSearchResultListTextLocator(){
        return driver.findElement(searchList);
    }




}

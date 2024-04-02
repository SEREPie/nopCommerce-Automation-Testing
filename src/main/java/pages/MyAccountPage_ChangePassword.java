package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage_ChangePassword extends PageBase{

    protected WebDriver driver;
    public MyAccountPage_ChangePassword(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By header = By.cssSelector("div h1");
    private By oldPassword = By.id("OldPassword");
    private By newPassword = By.id("NewPassword");
    private By confirmPassword = By.id("ConfirmNewPassword");
    private By confChngPasswordBtn = By.xpath("//button[contains(@class,'change-password')]");
    private By successfullUpdateMessage = By.cssSelector("#bar-notification .content");
    private By passwordErrorMessage = By.id("NewPassword-error");
    private By confirmPasswordErrorMessage = By.id("ConfirmNewPassword-error");
    private By MainErrorMessage = By.className("message-error");


    public void enterOldPassword(String oldPass) {
        clicking(driver.findElement(oldPassword));
        enterText(driver.findElement(oldPassword), oldPass);
    }

    public void enterNewPassword(String newPass) {
        clicking(driver.findElement(newPassword));
        enterText(driver.findElement(newPassword), newPass);
    }

    public void enterConfirmPassword(String confPass) {
        clicking(driver.findElement(confirmPassword));
        enterText(driver.findElement(confirmPassword), confPass);
    }
    public void clickOnConfirmChangePasswordBtn(){
        clicking(driver.findElement(confChngPasswordBtn));
    }

    public String getPasswordErrorMessageText() {
        return driver.findElement(passwordErrorMessage).getText();
    }

    public String getConfirmPasswordErrorMessageText() {
        return driver.findElement(confirmPasswordErrorMessage).getText();
    }
    public String getSuccessfullMessageText() {
        return driver.findElement(successfullUpdateMessage).getText();
    }
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
    public String getMainMessageErrorText() {
        return driver.findElement(MainErrorMessage).getText();
    }
}

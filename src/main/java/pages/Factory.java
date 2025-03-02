package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Factory {

    public static WebDriver browser= null;
    public WebDriver setBrowser(String browser){
        if (Factory.browser == null){
        switch (browser){
            case ("Google"):
                this.browser = new ChromeDriver();
            case ("Edge"):
                this.browser = new EdgeDriver();
        }
    return this.browser;
    }}
}

package DZ6.CRM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {
    WebDriver driver;
    WebDriverWait webDriverWait;
    JavascriptExecutor js;
    Actions actions;


    public BaseAction(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,20);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
}

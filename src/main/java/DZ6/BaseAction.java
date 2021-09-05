package DZ6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAction {
    WebDriver driver;
    WebDriverWait webDriverWait;


    public BaseAction(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,8);
        PageFactory.initElements(driver,this);
    }
}

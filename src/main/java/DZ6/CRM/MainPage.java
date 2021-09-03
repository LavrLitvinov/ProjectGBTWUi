package DZ6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseAction{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a/span[contains(text(),'Проекты')]")
    public WebElement moveProjectMenu;

    public MainPage moveProject(){
        actions.moveToElement(moveProjectMenu).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span[contains(text(),'Все проекты')]")));
        return this;
    }

    @FindBy(xpath = "//a/span[contains(text(),'Все проекты')]")
    public WebElement createProject;

    public AllProjectPage allButtonClic(){

        createProject.click();
        return new AllProjectPage(driver);
    }

}

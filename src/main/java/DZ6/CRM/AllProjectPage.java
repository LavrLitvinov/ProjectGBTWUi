package DZ6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.WatchEvent;

public class AllProjectPage extends BaseAction{
    public AllProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public CreateProjectPage createProjectButtonClick(){
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        return new CreateProjectPage(driver);
    }
}

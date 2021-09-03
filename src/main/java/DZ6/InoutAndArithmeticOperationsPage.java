package DZ6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InoutAndArithmeticOperationsPage extends BaseAction{
    public InoutAndArithmeticOperationsPage(WebDriver driver) {
        super(driver);
    }
    //findElement(By.xpath("//div[contains(text(),'Условия')]"
    @FindBy(xpath = "//div[contains(text(),'Условия')]")
    public WebElement goToIfClick;

    public IfElsePage goToIfElsePage(){
        goToIfClick.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Минимум из двух')]")));
        return new IfElsePage(driver);
    }
}

package DZ6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IfElsePage extends BaseAction{
    public IfElsePage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
public void print(){
        System.out.println("IFelsee-IfElse");
    }

    @FindBy(xpath = "//a[contains(text(),'Минимум из двух')]")
    public WebElement clickMinimun;

    public MinimumPage clicMinimum(){

        clickMinimun.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                         ("//button[contains(text(),'Проверить решение на ')]")));
        return new MinimumPage(driver);
    }
}

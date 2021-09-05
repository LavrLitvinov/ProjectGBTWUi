package DZ6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinimumPage extends BaseAction{
    public MinimumPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//button[contains(text(),'Проверить решение на ')]")
    public WebElement checkDecision;

    void checkDecisionClic(){
        driver.get("https://pythontutor.ru/lessons/ifelse/problems/minimum/");// Это костыль.В реальной жизни надо снимать такую рекламу

        js.executeScript("scroll(0,350)");
        checkDecision.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//b[contains(text(),'Правильное решение, поздравляем.')]")));
    }

}

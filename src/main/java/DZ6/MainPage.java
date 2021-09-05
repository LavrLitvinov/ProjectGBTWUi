package DZ6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseAction{

    public static final String INTRANSBUTTONMAIN = "//a[contains(text(),'Войти')]";

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath=INTRANSBUTTONMAIN)
    public WebElement clickIntrans;


    @Step("Кликаем главный вход")
    public IntransPage clicIntransButton() throws InterruptedException {
        clickIntrans.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.name(IntransPage.PASSWORD)));
        return new IntransPage(driver);
    }
}

package DZ6.CRM;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Story("Мучаем CRM")
public class LoginToCRM extends BaseAction {
    public LoginToCRM(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement prependerInput;

    @Step("Ввод логина")
    public LoginToCRM clicPrependedInput(String login) {
        prependerInput.sendKeys(login);
        return this;
    }

    @FindBy(id = "prependedInput2")
    public WebElement prependedInput2;

    @Step("Ввод пассворда")
    public LoginToCRM clicPrependedInput2(String pass) {
        prependedInput2.sendKeys(pass);
        return this;
    }

    @FindBy(xpath = "//button")
    public WebElement inputClick;

    @Step("Собственно вход")
    public MainPage clicInputButton() {
        inputClick.click();
        return new MainPage(driver);
    }

}

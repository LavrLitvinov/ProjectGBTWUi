package DZ6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntransPage extends BaseAction{

    public static final String INTRANSBUTTON = "//button[contains(text(),'Войти')]";
    public static final String PASSWORD = "password";
    public IntransPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = PASSWORD)
    public  WebElement passwordInput;

    @FindBy(xpath = INTRANSBUTTON)
    public WebElement clickButton;
    @Step("Заполнение username")
    public IntransPage inputUsername (String username){
        usernameInput.sendKeys(username);
        return this;
    }
   @Step("Заполнение password")
    public IntransPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Kликаем на вход")
    public void  inputClicButton(){
        clickButton.click();

    }
}

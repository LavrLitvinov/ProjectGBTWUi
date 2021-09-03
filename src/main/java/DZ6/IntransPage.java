package DZ6;

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

    public IntransPage inputUsername (String username){
        usernameInput.sendKeys(username);
        return this;
    }

    public IntransPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    public void  inputClicButton(){
        clickButton.click();

    }
}

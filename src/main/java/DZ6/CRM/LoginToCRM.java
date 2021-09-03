package DZ6.CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToCRM extends BaseAction{
    public LoginToCRM(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="prependedInput")
    public WebElement prependerInput;

    public LoginToCRM clicPrependedInput(String login){
        prependerInput.sendKeys(login);
        return this;
    }

    @FindBy(id = "prependedInput2")
    public WebElement prependedInput2;

    public LoginToCRM clicPrependedInput2(String pass){
        prependedInput2.sendKeys(pass);
        return this;
    }

    @FindBy(xpath ="//button")
    public WebElement inputClick;

    public MainPage clicInputButton(){
        inputClick.click();
        return new MainPage(driver);
    }

}

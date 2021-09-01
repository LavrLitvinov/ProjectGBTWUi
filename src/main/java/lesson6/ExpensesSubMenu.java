package lesson6;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesSubMenu extends BaseView {
    public ExpensesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Заявки на расходы']")
    public WebElement expensesRequestsMenuItem;

    public void goToExpensesRequestsPage() {
        expensesRequestsMenuItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(ExpensesRequestsPage.createExpenseXpathLocator)));
    }

}

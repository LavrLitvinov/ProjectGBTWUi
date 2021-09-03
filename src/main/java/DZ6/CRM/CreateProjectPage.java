package DZ6.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;
import java.util.List;

public class CreateProjectPage extends BaseAction {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectName;

    public CreateProjectPage projectNameClic(String projectNameInput) {
        projectName.sendKeys(projectNameInput); // firstfirsttwo

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Укажите организацию']")));
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement selectOrganization;

    public CreateProjectPage selectOrganizationClick() throws InterruptedException {
        selectOrganization.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='select2-drop']//input")));
        return this;
    }


    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement selectOrganizationName;

    public CreateProjectPage selectOrganizationNameClick(String organizationName) throws InterruptedException {
        //    Thread.sleep(3000);
        selectOrganizationName.sendKeys(organizationName); // test
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        return this;
    }


    @FindBy(xpath = "//div[@class='select2-result-label']")
    public List<WebElement> inputOrganizationName;

    public CreateProjectPage inputOrganizationNameClick() throws InterruptedException {
        inputOrganizationName.get(0).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        //    Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "123test"));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        return this;
    }

    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")
    public WebElement mainContactField;

    public CreateProjectPage mainContakt() {
        mainContactField.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement mainContactInput;

    public CreateProjectPage mainContactInputClick(String input) {
        mainContactInput.sendKeys(input);
        mainContactInput.sendKeys(Keys.ENTER);
        return this;
    }


    // начало iframe надо вставить
    public CreateProjectPage testFrame(String strTest) throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys(strTest);
        driver.switchTo().defaultContent();
     //   js.executeScript("scroll(0,550)");
        return this;
    }


    // конец фрейма

    @FindBy(xpath = "//select[@name='crm_project[financeSource]']")
    public WebElement selectFinans;

    public CreateProjectPage selectFinansClic(String selectText) {
        Select dropdown = new Select(selectFinans);
        dropdown.selectByVisibleText(selectText);// внутреннее
        return this;

    }

    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement departament;


    public CreateProjectPage selectDepartament(String nameDepartament) { // "Research & Development"
        Select dropdown = new Select(departament);
        dropdown.selectByVisibleText(nameDepartament);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement curatorName1;

    public CreateProjectPage selectCurator(String curatorName) { // "Applanatest Applanatest Applanatest"
        Select dropdown = new Select(curatorName1);
        dropdown.selectByVisibleText(curatorName);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement projectRp;

    public CreateProjectPage selectProjectRp(String NameRp) {
        Select dropdown = new Select(projectRp);
        dropdown.selectByVisibleText(NameRp);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,\"crm_project_manager\")]")
    public WebElement projectManager;

    public CreateProjectPage selectProjectManager(String nameManager) {
        Select dropdown = new Select(projectManager);
        dropdown.selectByVisibleText(nameManager);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//button[@class='btn btn-success action-button']")));
        return this;
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement endButton;

    public CreateProjectPage endButtonClic() throws InterruptedException {
     //   Thread.sleep(5000);
        endButton.click();
        return this;
    }


}

package DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class NewProjectCrmTest {
    private static WebDriver wb;
    private Boolean flag;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void prepearAllTest() {
        WebDriverManager.chromedriver().setup();


    }

    @BeforeEach  // возможно, тестов будет несколько
    void prepearEachTest() {
        wb = new ChromeDriver();
        wb.manage().window().maximize();

    }

    @AfterEach
    void endTests() {
        wb.quit();
    }

    @Test
    void newTestCRM() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) wb;
        loginToCrm();

        Actions action = new Actions(wb);
        WebDriverWait webDriverWait = new WebDriverWait(wb, 5);

        WebElement projectMenu = wb.findElement(By.xpath("//a/span[contains(text(),'Проекты')]"));
        action.moveToElement(projectMenu).perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a/span[contains(text(),'Все проекты')]")));
        wb.findElement(By.xpath("//a/span[contains(text(),'Все проекты')]")).click();

        //   Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        wb.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        wb.findElement(By.name("crm_project[name]")).sendKeys("FirstFirstSecond");
        // //span[contains(text(), 'Это значение уже используется.')]
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Укажите организацию']")));
        //   Thread.sleep(3000);
        wb.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        wb.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = wb.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                wb.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "123test"));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        wb.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        wb.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        wb.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        wb.switchTo().frame(wb.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        wb.findElement(By.xpath("//body")).sendKeys("testtest");

        wb.switchTo().defaultContent();

        wb.switchTo().frame(wb.findElement(By.xpath("//iframe[contains(@id,'crm_project_requirementsManagement')]")));
        wb.findElement(By.xpath("//body")).sendKeys("Какие требования?");

        wb.switchTo().defaultContent();

        Select dropdown = new Select(wb.findElement(By.xpath("//select[@name='crm_project[financeSource]']")));
        dropdown.selectByVisibleText("Внутреннее");

        Select dropdown1 = new Select(wb.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        dropdown1.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select dropdown3 = new Select(wb.findElement
                (By.xpath("//select[@name='crm_project[businessUnit]']")));
        dropdown3.selectByVisibleText("Research & Development");

        List<WebElement> projectBoss = Collections.singletonList(wb.findElement(By.xpath("//div[contains(@id,'uniform-crm_project_rp')]")));
        projectBoss.get(0).click();
        Select dropdown0 = new Select(wb.findElement(By.name("crm_project[rp]")));
        dropdown0.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select dropdown4 = new Select(wb.findElement(By.xpath("//select[contains(@id,\"crm_project_manager\")]")));
        dropdown4.selectByVisibleText("Applanatest Applanatest Applanatest");

        wb.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        Thread.sleep(5000); // элемент не обязан появиться. Поэтому так

        try {
            WebElement element = wb.findElement(By.xpath
                    ("//span[contains(text(),'Это значение уже используется.')]"));
            flag = true;
        } catch (NoSuchElementException noSuchElementException) {
            flag = false;
        }
        Assertions.assertTrue(flag);



        WebElement elem = wb.findElement(By.xpath
                ("//span[contains(text(),'Это значение уже используется.')]"));
        assertThat(elem,isDisplayed());




    }

    public static void loginToCrm() {
        wb.get("https://crm.geekbrains.space/user/login");
        wb.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        wb.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        wb.findElement(By.xpath("//button")).click();
    }

    public static void pitStop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Для продолжения работы что-нибудь введите и ENTER!");
        String a = sc.next();
        sc.close();
    }

}

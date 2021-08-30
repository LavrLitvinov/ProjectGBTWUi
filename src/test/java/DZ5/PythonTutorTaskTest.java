package DZ5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

import java.util.NoSuchElementException;

import static Lesson4.utils.ColorMatcher.hasColor;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.JsUtils.clickWithJs;

public class PythonTutorTaskTest {

    private static WebDriver wd;
    private Boolean flag;
    private WebDriverWait webDriverWait;

    @BeforeAll
    static void start() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
        // возможно, тестов будет несколько
    void prepearEachTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--disable-notifications").addArguments("--disable-popup-blocking")
                .addArguments("test-type")
                .addArguments("incognito");
        //      .addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

        wd = new ChromeDriver(chromeOptions);
        wd.manage().window().maximize();
        webDriverWait = new WebDriverWait(wd, 5);

    }

    @AfterEach
    void endTests() {
        wd.quit();
    }

    @Test
    void TestMethod() throws InterruptedException {
        wd.get("http://pythontutor.ru/");
        wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        wd.findElement(By.name("username")).sendKeys("LavrLitvinov");
        wd.findElement(By.name("password")).sendKeys("PTvay");
        wd.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();


        wd.get("http://pythontutor.ru/lessons/inout_and_arithmetic_operations/");// костыль для преодоления е..чей рекламы


        wd.findElement(By.xpath("//div[contains(text(),'Условия')]")).click();
        wd.get("http://pythontutor.ru/lessons/ifelse/"); // костыль для преодоления е..чей рекламы
        //Thread.sleep(2000);
        //    clickWithJs(wd, wd.findElement(By.xpath("//a[contains(text(),'Минимум из двух')]")));
        wd.findElement(By.xpath("//a[contains(text(),'Минимум из двух')]")).click();
        wd.get("http://pythontutor.ru/lessons/ifelse/problems/minimum/");

        WebElement element = wd.findElement(By.xpath("//button[contains(text(),'Проверить решение на ')]"));
        element.click();
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("scroll(0,350)");

        Thread.sleep(5000);

        // Первая попытка
        try {
            WebElement elem = wd.findElement(By.xpath
                    ("//b[contains(text(),'Правильное решение, поздравляем.')]"));
            flag = true;
        } catch (NoSuchElementException noSuchElementException) {
            flag = false;
        }
        Assertions.assertTrue(flag);

        // Вторая попытка
        WebElement elemm = wd.findElement(By.xpath
                ("//b[contains(text(),'Правильное решение, поздравляем.')]"));
        assertThat(elemm, isDisplayed());



        // Третья попытка
        assertThat(wd.findElement(By.xpath("//b[contains(text(),'Правильное решение, поздравляем.')]")).getCssValue("color")
                , is("rgba(0, 128, 0, 1)"));

        wd.findElement(By.xpath("//a[contains(text(),'Выйти')]")).click();


    }

}
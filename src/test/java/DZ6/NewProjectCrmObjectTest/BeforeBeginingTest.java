package DZ6.NewProjectCrmObjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeforeBeginingTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void beforeAllTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void eachInit() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--disable-notifications").addArguments("--disable-popup-blocking")
                .addArguments("test-type")
                .addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    void endBrowser() {
        driver.quit();
    }
}

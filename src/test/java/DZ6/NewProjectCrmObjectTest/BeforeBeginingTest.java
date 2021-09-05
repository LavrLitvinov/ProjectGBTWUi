package DZ6.NewProjectCrmObjectTest;

import DZ6.ListenerClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

public class BeforeBeginingTest {
    EventFiringWebDriver driver;
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
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions) );
        driver.register(new ListenerClass());
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    void endBrowser() {

        LogEntries browserConsolLogs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = browserConsolLogs.iterator();
        while (iterator.hasNext()){
            Allure.addAttachment("Элемент лога",iterator.next().getMessage());

        }

        driver.quit();
    }
}

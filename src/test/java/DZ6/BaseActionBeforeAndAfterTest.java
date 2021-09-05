package DZ6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActionBeforeAndAfterTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void  webdriwerInit(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    void eachInit(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--disable-notifications").addArguments("--disable-popup-blocking")
                .addArguments("test-type")
                .addArguments("incognito");
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions) );
        driver.register(new ListenerClass());
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, 8);
    }
    @AfterEach
    void killProcess(){
        driver.quit();
    }
}

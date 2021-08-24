package DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PythonTutorTask {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--disable-notifications")
      //          .addArguments("incognito")
                .addArguments("--disable-popup-blocking")
                .addArguments("test-type")
                .addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
                 // пришлось подложтить свои реальные настройки, иначе работать не  заработало.


        WebDriver wd = new ChromeDriver(chromeOptions);

        wd.manage().window().maximize();
        JavascriptExecutor js = ((JavascriptExecutor) wd);

        WebDriverWait webDriverWait = new WebDriverWait(wd, 5);
        wd.get("http://pythontutor.ru/");
        wd.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        wd.findElement(By.name("username")).sendKeys("LavrLitvinov");
        wd.findElement(By.name("password")).sendKeys("PTvay");
        wd.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
        //   RegistrationInPyTutor.pitStop();// пауза
        Thread.sleep(2000);
        //  wd.get("http://pythontutor.ru/lessons/inout_and_arithmetic_operations/");// костыль для преодоления е..чей рекламы

        wd.findElement(By.xpath("//div[contains(text(),'Условия')]")).click();

        Thread.sleep(2000);
    //    wd.get("http://pythontutor.ru/lessons/ifelse/"); // костыль для преодоления е..чей рекламы
        //     wd.findElement(By.xpath("//span[contains(text(),'Закрыть')]")).click(); Этот костыль не сработал

        wd.findElement(By.xpath("//a[contains(text(),'Минимум из двух')]")).click();

        WebElement element = wd.findElement(By.xpath("//button[contains(text(),'Проверить решение на ')]")); // тренировка

        ((JavascriptExecutor) wd).executeScript("scroll(0,100)"); // тренировка в прокрутке
        element.click();
        js.executeScript("arguments[0].scrollIntoView(true);", element);// тренировка в прокрутке

        wd.findElement(By.xpath("//a[contains(text(),'Выйти')]")).click();
        wd.quit();
    }

    public static void scenarioWithExtention() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=src/main/resources/chrome_profile");
        ChromeDriver wd = new ChromeDriver(chromeOptions);
        wd.get("https://afisha.ru");
        //
        Thread.sleep(10000);
    }
}

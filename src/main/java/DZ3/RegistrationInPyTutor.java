package DZ3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Scanner;

public class RegistrationInPyTutor {

    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);

        driver.get("http://pythontutor.ru/accounts/register/?next=/accounts/login/");
        driver.findElement(By.id("username")).sendKeys("LavrLavrLavr");
        driver.findElement(By.id("first_name")).sendKeys("Lavr");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Litvinov");
        driver.findElement(By.id("school")).sendKeys("№132, г.Ленинград");
        driver.findElement(By.name("email")).sendKeys("LavrLitvinovTest1@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ya?Lavr!Litvinov!");
        driver.findElement(By.xpath("//input[@name='confirm_password']")).sendKeys("Ya?Lavr!Litvinov!");
        driver.findElement(By.xpath("//input[contains(@id,'Checkbox1')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Зарегистрироваться')]")).click();

        pitStop(); // постоим, посмотрим, подумаем

        driver.quit();



    }
    public static void pitStop() {

        System.out.println("Для продолжения нажмите 1 и ENTER");
        Scanner scanner = new Scanner(System.in);
        String stop = scanner.nextLine();
        scanner.close();
        return;
    }
}

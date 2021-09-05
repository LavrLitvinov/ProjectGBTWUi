package DZ6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@Story("Что-то за Питон")
public class TestPythonObjectPage extends  BaseActionBeforeAndAfterTest{


    @Test
    @Description("Тест логина и перехода по страницам ПитонТьютора")
    void testPythonPage() throws InterruptedException {
        driver.get("https://pythontutor.ru/");
        new MainPage(driver).clicIntransButton();

        new IntransPage(driver)
                .inputUsername("LavrLitvinov")
                .inputPassword("PTvay")
                .inputClicButton();

        new InoutAndArithmeticOperationsPage(driver);
        new IfElsePage(driver);
        new MinimumPage(driver).checkDecisionClic();

        assertThat(driver.findElement(By.xpath("//b[contains(text(),'Правильное решение, поздравляем.')]")).getCssValue("color")
                , is("rgba(0, 128, 0, 1)"));
    //    Thread.sleep(5000);

    }


}

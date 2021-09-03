package DZ6.NewProjectCrmObjectTest;

import DZ6.CRM.AllProjectPage;
import DZ6.CRM.CreateProjectPage;
import DZ6.CRM.LoginToCRM;
import DZ6.CRM.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class NewCRMObjectTest extends BeforeBeginingTest {
    boolean flag;

    @Test

    void newCRMObjectTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/user/login");
        new LoginToCRM(driver)
                .clicPrependedInput("Applanatest1")
                .clicPrependedInput2("Student2020!")
                .clicInputButton();

        new MainPage(driver)
                .moveProject()
                .allButtonClic();
        Thread.sleep(5000);
        new AllProjectPage(driver).createProjectButtonClick();

        new CreateProjectPage(driver)
                .projectNameClic("FirstFirstSecond")
                .selectOrganizationClick()
                .selectOrganizationNameClick("test")
                .inputOrganizationNameClick()
                .mainContakt()
                .mainContactInputClick("1111")
                .selectFinansClic("Внутреннее")
                .selectDepartament("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectProjectRp("Applanatest Applanatest Applanatest")
                .selectProjectManager("Applanatest Applanatest Applanatest")
                .endButtonClic();
            Thread.sleep(4000);
        try {
            WebElement element = driver.findElement(By.xpath
                    ("//span[contains(text(),'Это значение уже используется.')]"));
            flag = true;
        } catch (NoSuchElementException noSuchElementException) {
            flag = false;
        }
        Assertions.assertTrue(flag);

        WebElement elem = driver.findElement(By.xpath
                ("//span[contains(text(),'Это значение уже используется.')]"));
        assertThat(elem,isDisplayed());


    }
}

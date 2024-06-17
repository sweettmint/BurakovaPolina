package Task2.Test;

import Task2.Test.BaseTest;
import Task2.Page.StartPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class MospolitexSheduleTest extends BaseTest {
    @Test
    @DisplayName("Тестирование страницы расписания на сайте Мосполитеха")
    public void test(){
        StartPage startPage  = new StartPage();
        startPage.checkOpenPage()
                .clickOnButton()
                .checkOpenPage()
                .clickOnButton()
                .checkOpenPage()
                .inputGroupNumber()
                .clickOnGroup();
    }
}

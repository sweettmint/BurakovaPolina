package Task1.Test;

import Task1.Page.StartPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class LambdaTestSampleAppTest extends BaseTest {
    @Test
    @DisplayName("Тестирование списка дел \"LambdaTest Sample App\"")
    public void test(){
        StartPage startPage  = new StartPage();
        startPage.verifyPageTitle()
                .verifyRemainingItemsText()
                .verifyFirstItemNotChecked()
                .checkFirstItem()
                .verifyFirstItemChecked()
                .verifyRemainingItemsTextAfterFirstItemChecked()
                .verifyRemainingItemsNotChecked()
                .checkRemainingItems()
                .addNewItem()
                .clickOnNewItem();
    }
}
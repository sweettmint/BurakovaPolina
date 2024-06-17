package Task3.Test;

import Task3.Page.StartPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
public class YandexMarketTest extends BaseTest {

    @Test
    @DisplayName("Тестирование Яндекс Маркета (проверка фильтрации товаров по цене)")
    public void test(){
        StartPage startPage  = new StartPage();
        startPage.checkOpenPage()
                .clickOnCatalog()
                .moveToCategory()
                .changeCategory()
                .clickOnMenuItem()
                .checkOpenPage()
                .logProducts()
                .setPrice();
    }
}
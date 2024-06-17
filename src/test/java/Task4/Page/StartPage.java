package Task4.Page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(Task1.Page.StartPage.class);
    @FindBy(xpath = "//*[@id=\"Добро_пожаловать_в_Википедию,\"]")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"searchInput\"]")
    private WebElement searchInput;

    @Step("Открывается главная страница Википедии")
    public StartPage checkOpenPage() {
        waitUntilElementToBeVisible(title);
        Assert.assertEquals("Заголовок не соответствует требуемому", "Добро пожаловать в Википедию,", title.getText());
        logger.info("Открывается главная страница Википедии");
        return this;
    }
    @Step("Поиск статьи по ключевому слову 'Вино'")
    public SearchResultPage searchForArticle() {
        logger.info("Вводим ключевое слово 'Вино' в поле поиска");
        searchInput.sendKeys("Вино");
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Нажимаем кнопку 'Поиск'");
        return pageManager.getSearchResultPage();
    }
}
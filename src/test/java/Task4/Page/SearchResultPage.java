package Task4.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchResultPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);
    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//span[@class = 'searchmatch']")
    private List<WebElement> searchResults;

    @Step("Открываются результаты поиска")
    public SearchResultPage checkOpenPage() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Результаты поиска", title.getText());
        logger.info("Открываются результаты поиска");
        return this;
    }
    @Step("Проверка результатов поиска")
    public SearchResultPage verifySearchResults() {
        logger.info("Проверяем, что результаты поиска содержат статьи о Вине");
        for (WebElement result : searchResults) {
            if (result.getText().contains("Вино")) {
                return this;
            }
        }
        throw new AssertionError("Результаты поиска не содержат статей о Вине");
    }
    @Step("Нажать на статью с названием 'Вино'")
    public WinePage clickArticle() {
        logger.info("Ищем и кликаем на статью с названием 'Вино'");
        for (WebElement result : searchResults) {
            if (result.getText().contains("Вино")) {
                result.click();
                return pageManager.getWinePage();
            }
        }
        throw new AssertionError("Не удалось найти статью с названием 'Вино'");
    }
}
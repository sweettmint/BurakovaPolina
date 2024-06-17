package Task4.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);
    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//*[@id=\"ca-talk\"]")
    private WebElement DicsussionButton;

    @Step("Открывается статья про Вино")
    public WinePage checkOpenPage() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Вино", title.getText());
        logger.info("Открывается статья про Вино");
        return this;
    }
    @Step("Нажать на Обсуждение")
    public DiscussionPage clickDiscussionButton() {
        DicsussionButton.click();
        logger.info("Кликаем на Обсуждение");
        return pageManager.getDiscussionPage();
    }
}

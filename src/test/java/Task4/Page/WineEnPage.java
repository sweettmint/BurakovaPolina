package Task4.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WineEnPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);
    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//a[@href='https://en.wikipedia.org/wiki/Wine' and @title='Wine — английский' and @lang='en' and @hreflang='en' and @class='interlanguage-link-target']")
    private WebElement Button;

    @Step("Открывается статья про Вино")
    public WineEnPage checkOpenPageRu() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Вино", title.getText());
        logger.info("Открывается статья про Вино");
        return this;
    }
    @Step("Нажать на кнопку 'Английский язык'")
    public WineEnPage clickEn() {
        waitUntilElementToBeVisible(Button);
        moveToElement(Button);
        Button.click();
        logger.info("Настройка языка на английский");
        return this;
    }
    @Step("Открывается статья про Вино")
    public WineEnPage checkOpenPageEn() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Wine", title.getText());
        logger.info("Статья открылась на английском");
        return this;
    }
}

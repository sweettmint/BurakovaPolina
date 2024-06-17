package Task4.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscussionPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);
    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//a[@class='oo-ui-buttonElement-button' and contains(@href, 'action=edit&section=new')]")
    private WebElement discussionButton;
    @FindBy(xpath = "//input[@class='oo-ui-inputWidget-input']")
    private WebElement InputTopic;
    @FindBy(xpath = "//div[@class='ve-ce-branchNode ve-ce-documentNode ve-ce-attachedRootNode ve-ce-rootNode mw-content-ltr mw-parser-output mw-show-empty-elt ime-position-inside']")
    private WebElement InputDescription;
    @FindBy(xpath = "//span[@class='oo-ui-widget oo-ui-buttonElement oo-ui-buttonElement-framed oo-ui-labelElement oo-ui-flaggedElement-primary oo-ui-flaggedElement-progressive oo-ui-buttonWidget oo-ui-widget-enabled']/a")
    private WebElement discussion2Button;
    @FindBy(xpath = "//*[@id=\"Отличная_статья\"]")
    private WebElement newsTitleElement;
    @FindBy(xpath = "//*[@id=\"ca-nstab-main\"]")
    private WebElement Button;

    @Step("Открывается сраница Обсуждения")
    public DiscussionPage checkOpenPage() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Обсуждение:Вино", title.getText());
        logger.info("Открывается страница обсуждения");
        return this;
    }
    @Step("Нажать на добавить тему")
    public DiscussionPage clickDiscussion() {
        logger.info("Кликаем на добавить тему");
        scrollToElementJs(discussionButton);
        discussionButton.click();
        return pageManager.getDiscussionPage();
    }
    @Step("Ввести текст 'Отличная статья' в поле ввода темы")
    public DiscussionPage inputTopicText() {
        logger.info("Ввести текст 'Отличная статья' в поле ввода темы");
        InputTopic.click();
        InputTopic.sendKeys("Отличная статья");
        return this;
    }
    @Step("Ввести текст 'Вдохновляет' в поле ввода описание")
    public DiscussionPage inputDescriptionText() {
        logger.info("Ввести текст 'Вдохновляет' в поле ввода описание");
        waitUntilElementToBeVisible(InputDescription);
        InputDescription.click();
        InputDescription.sendKeys("Вдохновляет");
        return this;
    }
    @Step("Нажать на добавить тему")
    public DiscussionPage clickcheckDiscussion() {
        logger.info("Кликаем на добавить тему и проверяем появилась ли");
        scrollToElementJs(discussion2Button);
        discussion2Button.click();
        Assert.assertEquals("Отличная статья",newsTitleElement.getText());
        return this;
    }
    @Step("Открывается статья про Вино")
    public WineEnPage click() {
        moveToElement(Button);
        waitUntilElementToBeVisible(Button);
        Button.click();
        logger.info("Открывается статья про Вино");
        return pageManager.getWineEnPage();
    }
}

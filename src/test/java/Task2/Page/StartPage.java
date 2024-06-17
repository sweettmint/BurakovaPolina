package Task2.Page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task1.Page.StartPage.class);

    @FindBy(xpath = "//h1")
    private WebElement titleElement;
    @FindBy(xpath = "//a[@href='/obuchauschimsya/raspisaniya/']")
    private WebElement scheduleButtonElement;

    @Step("Проверить открытие страницы Мосполитеха(на странице присутствует заголовок 'Московский Политех')")
    public StartPage checkOpenPage() {
        String expectedTitle = "Московский Политех";
        String actualTitle = titleElement.getText();
        Assert.assertEquals("Заголовок не соответствует требуемому", expectedTitle, actualTitle);
        LOGGER.info("Заголовок соответсвует требованиям -> открылась главная страница Московского Политеха");
        return this;
    }
    @Step("Нажать на кнопку 'Расписания'")
    public RaspPage clickOnButton() {
        waitUntilElementToBeClickable(scheduleButtonElement).click();
        LOGGER.info("Нажата кнопка 'Расписания' -> переход на страницу 'Расписания'");
        return pageManager.getRaspPage();
    }
}

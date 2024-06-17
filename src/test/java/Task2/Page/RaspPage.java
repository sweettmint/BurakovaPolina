package Task2.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RaspPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h1")
    private WebElement titleElement;
    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/session' and @target='_blank' and contains(@class, 'btn') and contains(@class, 'text-button')]")
    private WebElement scheduleButtonElement;

    @Step("Проверить открытие страницы Расписания(на странице присутствует заголовок 'Расписания'")
    public RaspPage checkOpenPage() {
        String expectedTitle = "Расписания";
        String actualTitle = titleElement.getText();
        Assert.assertEquals("Заголовок не соответствует требуемому", expectedTitle, actualTitle);
        LOGGER.info("Заголовок соответсвует требованиям -> открылась страница Расписания");
        return this;
    }
    @Step("В разделе 'Расписания занятий' нажать 'Смотрите на сайте'")
    public ShedulePage clickOnButton() {
        moveToElement(scheduleButtonElement);
        waitUntilElementToBeClickable(scheduleButtonElement).click();
        moveToNewTab();
        LOGGER.info("Открывается страница поиска расписания в новой вкладке");
        return pageManager.getShedulePage();
    }
}

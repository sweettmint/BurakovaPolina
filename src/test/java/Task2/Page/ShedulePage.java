package Task2.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShedulePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h4")
    private WebElement titleElement;
    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement inputGroup;
    @FindBy(xpath = "//div[contains(@class, 'found-groups')]/*")
    private List<WebElement> foundGroupsElements;
    @FindBy(xpath = "//div[@class='schedule-day schedule-day_today']/div[@class='bold schedule-day__title']")
    private WebElement today;

    @Step("Проверить открытие страницы Расписания(на странице присутствует текст 'Расписание зачетов и экзаменов'")
    public ShedulePage checkOpenPage() {
        String expectedTitle = "Расписание зачетов и экзаменов";
        String actualTitle = titleElement.getText();
        Assert.assertEquals("Заголовок не соответствует требуемому", expectedTitle, actualTitle);
        LOGGER.info("Текст соответсвует требованиям -> открылась страница Расписания в новой вкладке");
        return this;
    }
    @Step("Ввести номер группы в поле поиска")
    public ShedulePage inputGroupNumber() {
        inputGroup.sendKeys("221-361");
        Assert.assertEquals("В результатах поиска отображается больше одной группы или вовсе не отображается", 1, foundGroupsElements.size());
        LOGGER.info("Ввод группы 221 - 361, в результатах поиска отображается только искомая группа");
        return this;
    }
    @Step("Нажать на найденную группу в результатах поиска")
    public ShedulePage clickOnGroup() {
        String expectedGroupId = "221-361";
        String expectedScheduleTitle = "Расписание 221-361";
        String expectedTodayDay = getCurrentDayOfWeek();
        for (WebElement group : foundGroupsElements) {
            if (group.getAttribute("id").equals(expectedGroupId)) {
                group.click();
                Assert.assertEquals("Не открылось расписание выбранной группы", expectedScheduleTitle, driverManager.getDriver().getTitle());
                if (!expectedTodayDay.equals("Воскресенье")) {
                    String Today = today.getText();
                    Assert.assertTrue("Текущий день недели не выделен цветом", Today.contains(expectedTodayDay));
                }
                break;
            }
        }
        LOGGER.info("Нажата найденная группа в результатах поиска -> текущий день недели выделен цветом");
        return this;
    }
}
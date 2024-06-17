package Task3.Page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class StartPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(Task1.Page.StartPage.class);
    @FindBy(xpath = "//div[@class='cia-cs' and @data-zone-name='Button']/button[@class='_3Cep- _3HNZP']/span[text()='Для вас']")
    private WebElement buttonToYou;
    @FindBy(xpath = "//div[@data-baobab-name='catalog']/button")
    private WebElement catalogButton;
    @FindBy(xpath = "//li[@data-zone-name='category-link']/a")
    private List<WebElement> categoryList;
    @FindBy(xpath = "//div[@role = 'heading' and @aria-level = '3']")
    private List<WebElement> categorizedMenuItems;
    @FindBy(xpath = "//ul[@data-autotest-id]//li//a")
    private List<WebElement> menuItemList;

    @Step("Проверить наличие кнопки при открытии главной страницы Яндекс.Маркета")
    public StartPage checkOpenPage(){
        Assert.assertEquals("Заголовок не соответствует требуемому", "Для вас", buttonToYou.getText());
        logger.info("Открывается главная страница Яндекс.Маркета");
        return this;
    }
    @Step("Нажать на каталог")
    public StartPage clickOnCatalog() {
        waitUntilElementToBeClickable(catalogButton).click();
        logger.info("Переход в каталог");
        return this;
    }
    @Step("Навести на категорию Электроника")
    public StartPage moveToCategory() {
        for (WebElement element: categoryList) {
            waitUntilElementToBeVisible(element);
            if (element.findElement(By.xpath("./span")).getText().equals("Электроника")) {
                moveToElement(element);
                logger.info("Переход на категорию Электроника");
            }
        }
        return this;
    }
    @Step("Навести на категорию Ноутбуки, планшеты и электронные книги")
    public StartPage changeCategory() {
        for (WebElement item : categorizedMenuItems) {
            if (waitUntilElementToBeVisible(item).getText().equals("Ноутбуки, планшеты и электронные книги")) {
                moveToElement(item);
            }
        }
        logger.info("Переход на категорию Ноутбуки, планшеты и электронные книги");
        return this;
    }
    @Step("Нажать на пункт меню Ноутбуки")
    public LaptopPage clickOnMenuItem() {
        for (WebElement item : menuItemList) {
            if (waitUntilElementToBeVisible(item).getText().equals("Ноутбуки")) {
                moveToElement(item);
                item.click();
                logger.info("Переход на страницу с ноутбуками");
                return pageManager.getLaptopPage();
            }
        }
        Assert.fail("Не найден пункт меню ");
        return pageManager.getLaptopPage();
    }
}
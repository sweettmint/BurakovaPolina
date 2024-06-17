package Task1.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;
import java.util.List;

public class StartPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h2")
    private WebElement pageTitle;
    @FindBy(xpath = "//span[@class='ng-binding']")
    private WebElement remainingItemsText;
    @FindBy(xpath = "//li[1]//span")
    private WebElement firstItem;
    @FindBy(xpath = "//li[1]/input")
    private WebElement firstCheckbox;
    @FindBy(xpath = "//li/span")
    private List<WebElement> itemsList;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxesList;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement addItemInput;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement addItemButton;
    @FindBy(xpath = "//li[6]/input")
    private WebElement sixthCheckbox;

    private int remainingItems;
    private int totalItems;

    @Step("Проверить, что заголовок страницы - 'LambdaTest Sample App'")
    public StartPage verifyPageTitle() {
        waitUntilElementToBeVisible(pageTitle);
        Assert.assertEquals("LambdaTest Sample App", pageTitle.getText());
        logger.info("Заголовок страницы - 'LambdaTest Sample App'.");
        return this;
    }
    @Step("Проверить, что присутствует текст '5 of 5 remaining'")
    public StartPage verifyRemainingItemsText() {
        waitUntilElementToBeVisible(remainingItemsText);
        Assert.assertTrue(remainingItemsText.getText().contains("5 of 5 remaining"));
        logger.info("Присутствует текст '5 of 5 remaining'.");
        return this;
    }
    @Step("Проверить, что первый элемент не зачеркнут")
    public StartPage verifyFirstItemNotChecked() {
        waitUntilElementToBeVisible(firstItem);
        Assert.assertTrue(firstItem.getAttribute("class").contains("done-false"));
        logger.info("Первый элемент не зачеркнут.");
        return this;
    }
   @Step("Отметить первый элемент")
   public StartPage checkFirstItem() {
       waitUntilElementToBeVisible(firstCheckbox);
       firstCheckbox.click();
       logger.info("Первый элемент отмечен.");
       return this;
   }
    @Step("Проверить, что первый элемент списка зачеркнут")
    public StartPage verifyFirstItemChecked() {
        waitUntilElementToBeVisible(firstItem);
        Assert.assertTrue(firstItem.getAttribute("class").contains("done-true"));
        logger.info("Первый элемент списка зачеркнут.");
        return this;
    }
    @Step("Проверить, что присутствует текст '4 of 5 remaining'")
    public StartPage verifyRemainingItemsTextAfterFirstItemChecked() {
        waitUntilElementToBeVisible(remainingItemsText);
        Assert.assertTrue(remainingItemsText.getText().contains("4 of 5 remaining"));
        logger.info("Присутствует текст '4 of 5 remaining'.");
        return this;
    }
    @Step("Проверить, что остальные элементы не зачеркнуты")
    public StartPage verifyRemainingItemsNotChecked() {
        for (int i = 2; i < itemsList.size(); i++) {
            WebElement item = itemsList.get(i);
            Assert.assertTrue(item.getAttribute("class").contains("done-false"));
            logger.info("Элемент под индексом {" + i + "} не зачеркнут.");
        }
        return this;
    }
    @Step("Отметить остальные элементы")
    public StartPage checkRemainingItems() {
        totalItems = checkboxesList.size();
        remainingItems = totalItems - 1;
        for (int i = 1; i < checkboxesList.size(); i++) {
            WebElement checkbox = checkboxesList.get(i);
            checkbox.click();
            remainingItems--;
            String text = String.format("%s of %s remaining", remainingItems, totalItems);
            Assert.assertEquals("Текст об оставшихся элементах уменьшился.",text, remainingItemsText.getText());
            WebElement checkedItem = itemsList.get(i);
            Assert.assertEquals("done-true", checkedItem.getAttribute("class"));
            logger.info("Элемент под индексом {" + i + "} отмечен, зачеркнут, отображаемое число оставшихся элементов уменьшается на 1");
        }
        return this;
    }
    @Step("Добавить новый элемент списка")
    public StartPage addNewItem() {
        waitUntilElementToBeVisible(addItemInput);
        addItemInput.click();
        addItemInput.clear();
        addItemInput.sendKeys("Sixth Item");
        waitUntilElementToBeVisible(addItemButton);
        addItemButton.click();
        totalItems++;
        remainingItems++;
        WebElement newItem = checkboxesList.get(checkboxesList.size() - 1).findElement(By.xpath("./..//span"));
        Assert.assertEquals("done-false", newItem.getAttribute("class"));
        Assert.assertEquals("1 of 6 remaining", remainingItemsText.getText());
        logger.info("Добавлен новый элемент списка,новый элемент списка не зачеркнут,отображаемое общее число и число оставшихся элементов увеличиваются на 1");
        return this;
    }
    @Step("Нажать на новый элемент списка")
    public StartPage clickOnNewItem() {
        WebElement newItem = checkboxesList.get(checkboxesList.size() - 1).findElement(By.xpath("./..//span"));
        sixthCheckbox.click();
        Assert.assertEquals("done-true", newItem.getAttribute("class"));
        remainingItems--;
        Assert.assertEquals(String.format("%d of %d remaining", remainingItems, totalItems), remainingItemsText.getText());
        logger.info("Нажат на новый элемент списка, он стал зачеркнутым, количество оставшихся элементов уменьшилось на 1");
        return this;
    }
}

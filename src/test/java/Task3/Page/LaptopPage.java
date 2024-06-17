package Task3.Page;

import Task1.Page.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LaptopPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h1")
    private WebElement title;
    @FindBy(xpath = "//div[@data-auto-themename='listDetailed']")
    private List<WebElement> productList;
    @FindBy(xpath = "//label[contains(text(), 'Цена, ₽ от')]/following-sibling::div//input[@type='text']")
    private WebElement minPrice;
    @FindBy(xpath = "//label[contains(text(), 'Цена, ₽ до')]/following-sibling::div//input[@type='text']")
    private WebElement maxPrice;

    @Step("Проверить наличие заголовка при открытии страницы 'Ноутбуки'")
    public LaptopPage checkOpenPage() {
        Assert.assertEquals("Заголовок не соответствует требуемому", "Ноутбуки", title.getText());
        logger.info("Открывается страница Ноутбуки");
        return this;
    }
    @Step("Вывести в лог первые 5 найденных товаров")
    public LaptopPage logProducts() {
        for (int i = 0; i < 5 && i < productList.size(); i++) {
            WebElement product = productList.get(i);
            moveToElement(product);
            String title = product.findElement(By.xpath(".//h3")).getText();
            String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
            logger.info("Название: " + title + ". Цена: " + price);
        }
        return this;
    }
    @Step("Проверяем, что цены первых 5 ноутбуков в диапазоне minPrice и maxPrice")
    public LaptopPage setPrice() {
        minPrice.sendKeys("60000");
        maxPrice.sendKeys("110000");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5 && i < productList.size(); i++) {
            WebElement product = productList.get(i);
            waitUntilElementToBeVisible(product);
            moveToElement(product);
            String priceText = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
            double price = Double.parseDouble(priceText.replaceAll("[^\\d,]", "").replace(",", "."));
            double minPriceValue = Double.parseDouble("60000");
            double maxPriceValue = Double.parseDouble("110000");
            double tolerance = 0.01;
            assertTrue("Цена " + price + " находится вне диапазона [" + minPriceValue + ", " + maxPriceValue + "]", (price >= minPriceValue - tolerance) && (price <= maxPriceValue + tolerance));
        }
        logger.info("Введена цена, все ноутбуки находятся в диапазоне цены");
        return this;
    }
}




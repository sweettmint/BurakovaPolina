package Task3.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.DriverManager;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10, 1000);
    protected PageManager pageManager = PageManager.getInstance();
    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }
    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void moveToElement(WebElement element) {
        Actions action = new Actions(driverManager.getDriver());
        action.moveToElement(element).build().perform();
    }
    protected WebElement waitFor(By selector) {
        return wait.until(ExpectedConditions.elementToBeClickable(driverManager.getDriver().findElement(selector)));
    }
}


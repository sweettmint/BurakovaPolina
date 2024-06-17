package Task4.Test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import managers.DriverManager;
import managers.InitManager;

public class BaseTest {
    private final DriverManager driverManager = DriverManager.getInstance();
    @BeforeClass
    public static void beforeClass(){
        InitManager.initFramework();
    }
    @Before
    public void before(){
        driverManager.getDriver().get("https://ru.wikipedia.org/wiki/Заглавная_страница");
    }
    @AfterClass
    public static void after(){
        InitManager.quitFramework();
    }
}
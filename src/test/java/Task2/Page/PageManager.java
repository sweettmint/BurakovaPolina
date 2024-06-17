package Task2.Page;

import Task2.Page.StartPage;

public class PageManager {
    private static PageManager INSTANCE = null;
    private StartPage startPage;
    private RaspPage RaspPage;
    private ShedulePage ShedulePage;
    private PageManager() {
    }
    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }
    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }
    public RaspPage getRaspPage() {
        if (RaspPage == null) {
            RaspPage = new RaspPage();
        }
        return RaspPage;
    }
    public ShedulePage getShedulePage() {
        if (ShedulePage == null) {
            ShedulePage = new ShedulePage();
        }
        return ShedulePage;
    }

}
package Task4.Page;

public class PageManager {
    private static PageManager INSTANCE = null;
    private StartPage startPage;
    private SearchResultPage SearchResultPage;
    private WinePage WinePage;
    private WineEnPage WineEnPage;
    private DiscussionPage DiscussionPage;
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
    public WinePage getWinePage() {
        if (WinePage == null) {
            WinePage = new WinePage();
        }
        return WinePage;
    }
    public WineEnPage getWineEnPage() {
        if (WineEnPage == null) {
            WineEnPage = new WineEnPage();
        }
        return WineEnPage;
    }
    public SearchResultPage getSearchResultPage() {
        if (SearchResultPage == null) {
            SearchResultPage = new SearchResultPage();
        }
        return SearchResultPage;
    }
    public DiscussionPage getDiscussionPage() {
        if (DiscussionPage == null) {
            DiscussionPage = new DiscussionPage();
        }
        return DiscussionPage;
    }
}

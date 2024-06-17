package Task4.Test;

import Task4.Page.StartPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class WikiPediaTest  extends BaseTest {
    @Test
    @DisplayName("Тестирование Википедии")
    public void test() {
        StartPage startPage = new StartPage();
        startPage.checkOpenPage()
                .searchForArticle()
                .checkOpenPage()
                .checkOpenPage()
                .verifySearchResults()
                .clickArticle()
                .checkOpenPage()
                .clickDiscussionButton()
                .checkOpenPage()
                .clickDiscussion()
                .inputTopicText()
                .inputDescriptionText()
                .clickcheckDiscussion()
                .click()
                .checkOpenPageRu()
                .clickEn()
                .checkOpenPageEn();
    }
}

package page.object.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;
import static page.object.test.cred.SearchKeywords.SEARCH_KEYWORD;
import static page.object.test.cred.Urls.BASE_URL;
import static page.object.test.cred.WishListData.*;
import static page.object.test.cred.UserCred.EMAIL;
import static page.object.test.cred.UserCred.PASSWORD;

public class WishListTests extends BaseTests {

    public HomePageSteps getHomePageSteps = new HomePageSteps();
    public LogInPageSteps getLogInPageSteps = new LogInPageSteps();
    public AccountPageSteps getAccountPageSteps = new AccountPageSteps();
    public WishListPageSteps getWishListPageSteps = new WishListPageSteps();
    public CreatedWishListPageSteps getCreatedWishListPageSteps = new CreatedWishListPageSteps();
    public SearchResultsPageSteps getSearchResultsPageSteps = new SearchResultsPageSteps();


    private static final String WISH_URL ="https://www.board-game.co.uk/";

    @AfterMethod
    public void clean(){
        open(WISH_URL);
        if(getWishListPageSteps.getListHeadersCount()>0) {
            getWishListPageSteps.deleteAllWishLists();
        }
    }

    @Test
    public void checkCreateWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.getTextOfAmountOfWishLists();
        assertEquals(getCreatedWishListPageSteps.getTextOfAmountOfWishLists(), EXPECTED_AMOUNT_OF_WISH_LISTS);
    }

    @Test
    public void checkUpdateWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.makeWishListPrivate();
        assertEquals(getCreatedWishListPageSteps.getPrivacyTagText(), PRIVACY_TAG);
    }
    @Test
    public void checkDeleteWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.deleteWishList();
        assertEquals(getWishListPageSteps.getTextOfWishPageCount(),EXPECTED_AMOUNT_OF_WISH_LISTS_AFTER_DELETING_ALL);
    }

    @Test
    public void checkCreateMoreThanFiveWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.getCreateWishListButton();
        while (!Objects.equals(getCreatedWishListPageSteps.getTextOfAmountOfWishLists(), "(5/5)")) {
            getCreatedWishListPageSteps.createNewWishList();
        }
        assertFalse(getCreatedWishListPageSteps.getCreateWishListButtonAfterCreatingAllWishLists().isDisplayed());
    }

    @Test
    public void checkDeleteNotEmptyWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.clickAddProducts();
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPageSteps.clickThreeAddToWishlistButtons();
        getSearchResultsPageSteps.clickGoToWishList();
        getWishListPageSteps.clickCreatedList();
        getCreatedWishListPageSteps.deleteWishList();
        getWishListPageSteps.getWishPageCount();
        assertEquals(getWishListPageSteps.getTextOfWishPageCount(),EXPECTED_AMOUNT_OF_WISH_LISTS_AFTER_DELETING_ALL);

    }

    @Test
    public void checkAddToWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.clickAddProducts();
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPageSteps.clickThreeAddToWishlistButtons();
        getSearchResultsPageSteps.clickGoToWishList();
        getWishListPageSteps.clickCreatedList();
        assertEquals(getCreatedWishListPageSteps.getWishItemTitlesSize(), 3);

    }




}


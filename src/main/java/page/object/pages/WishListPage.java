package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class WishListPage {

    public SelenideElement createWishListButton = $(xpath("//button[@class='wishlist-create-trigger wishlist-button wishlist-button-icon-before wishlist-button-primary']"));
    public SelenideElement createWishListWithNameButton = $(xpath("//button[contains(text(),'Create Wish List')]"));
    public SelenideElement amountOfWishLists = $(xpath("//span[@class='wishlist-list-count']"));
    public SelenideElement settingsButton = $(xpath("//a[@class='wishlist-edit-trigger wishlist-action-bar-button icon-before']"));
    public SelenideElement saveChangesButton = $(xpath("//button[@id='wishlist-edit-button-save']"));
    public SelenideElement deleteWishButton = $(xpath("//button[@id='wishlist-edit-delete-trigger']"));
    public SelenideElement wishListPageCount = $(xpath("//span[@class='wishlist-page-header-count']"));
    public SelenideElement makePrivateButton = $(xpath("//input[@id='wishlist-edit-private']"));
    public SelenideElement privacyTag = $(xpath("//span[@class='wishlist-privacy-private active']"));


}

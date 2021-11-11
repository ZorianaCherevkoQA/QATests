package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.CreatedWishListPage;

public class CreatedWishListPageSteps {

    public CreatedWishListPage createdWishListPage = new CreatedWishListPage();

    public String getTextOfAmountOfWishLists(){
        return createdWishListPage.amountOfWishLists.shouldBe(Condition.appear).getText();
    }

    public SelenideElement getCreateWishListButton(){
        return createdWishListPage.createWishListButton.shouldBe(Condition.visible);
    }

    public void makeWishListPrivate(){
        createdWishListPage.settingsButton.shouldBe(Condition.visible).click();
        createdWishListPage.makePrivateButton.click();
        createdWishListPage.saveChangesButton.click();
    }

    public void clickAddProducts(){
        createdWishListPage.addProductsButton.click();
    }

    public void deleteWishList(){
        createdWishListPage.settingsButton.click();
        createdWishListPage.deleteWisDeleteButton.click();
        createdWishListPage.deleteWisConfirmButton.click();

    }

    public String getPrivacyTagText(){
        return createdWishListPage.privacyTag.shouldBe(Condition.appear).getText();
    }

    public void createNewWishList(){
       createdWishListPage.createWishListButton.shouldBe(Condition.visible).click();
       createdWishListPage.createWishListWithNameButton.shouldBe(Condition.visible);
       createdWishListPage.createWishListWithNameButton.click();
    }

    public int getWishItemTitlesSize(){
        return createdWishListPage.wishItemTitle.size();
    }

    public String getWishItemsCount(){
        return createdWishListPage.wishItemsCount.getText();

    }
}

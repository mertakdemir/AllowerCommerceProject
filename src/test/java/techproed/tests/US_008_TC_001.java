package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_008_TC_001 {

    /*

    The user should be able to add her/his favorite items to her/his Wishlist.
    The user should be able to view the items added to the Wishlist.
    The user should be able to view the attributes of the items on their Wishlist.(QUICK VIEW)
    The user should be able to add the items on their Wishlist to their cart and purchase.
     */
    HomePage homePage;
    Register_Page register_page;
    WishlistPage wishlistPage;
    SignInPage signInPage;
    Faker faker;
    Actions actions;
    BillingAddressPage billingAddressPage;

    @Test
    public void US_008_TC_001_Test() throws NullPointerException, IOException {

        //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage = new HomePage();
        register_page = new Register_Page();
        faker = new Faker();
        wishlistPage = new WishlistPage();
        billingAddressPage = new BillingAddressPage();

        homePage.registerButton.click();

        //User should enter username.
        register_page.userName.sendKeys(faker.name().username());
        ReusableMethods.waitFor(2);
        register_page.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(2);
        register_page.password.sendKeys(faker.number().digits(8));
        ReusableMethods.waitFor(2);
        register_page.checkBoxPolicy.click();
        ReusableMethods.waitFor(2);
        register_page.SignUpButton.click();
        ReusableMethods.waitFor(5);


        //The user should be able to add 2 products she/he likes to the wishlist
        JSUtils.clickElementByJS(wishlistPage.mensClothing);
        ReusableMethods.waitFor(2);

        wishlistPage.womenButton.click();
        ReusableMethods.waitFor(3);

        wishlistPage.kadinTrikoKazak.click();

        ReusableMethods.waitFor(3);

        wishlistPage.kadinTrikoKazakFavoriteSign.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);

        JSUtils.scrollIntoViewJS(wishlistPage.wishListIcon);


        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(wishlistPage.wishListIcon);

        ReusableMethods.waitFor(2);

        //The user should be able to view the items added to the Wishlist.
        wishlistPage.wishListTable.isDisplayed();

        //The user should be able to view the attributes of the items on their Wishlist.(QUICK VIEW)
        JSUtils.clickElementByJS(wishlistPage.kadinTrikoQuickView);
        ReusableMethods.waitFor(5);


        JSUtils.clickElementByJS(wishlistPage.kadinTrikoViewClose);
        ReusableMethods.waitFor(5);


        JSUtils.clickElementByJS(wishlistPage.mensClothingQuickView);
        ReusableMethods.waitFor(5);

        JSUtils.clickElementByJS(wishlistPage.mensClothingViewClose);


        //The user should be able to add the items on their Wishlist to their cart and purchase.


        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(wishlistPage.kadinTrikoAddToCart);
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(wishlistPage.mensClothingAddToCart);
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(wishlistPage.addToCartIcon);
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(wishlistPage.checkOutButton);

        ReusableMethods.waitFor(5);

        billingAddressPage.firstName.sendKeys(faker.name().firstName());
        billingAddressPage.lastName.sendKeys(faker.name().lastName());

        ReusableMethods.waitFor(3);


        ReusableMethods.waitFor(3);
        billingAddressPage.streetAddress.sendKeys(faker.address().streetAddress());
        billingAddressPage.townOrCity.sendKeys(faker.address().city());
        ReusableMethods.waitFor(3);


        ReusableMethods.waitFor(3);
        billingAddressPage.postcodeOrZipCode.sendKeys(faker.address().zipCode());
        billingAddressPage.phone.sendKeys(faker.phoneNumber().cellPhone());


        JSUtils.clickElementByJS(wishlistPage.placeOrderButton);
        ReusableMethods.waitFor(2);


        String orderCompletePage= wishlistPage.thankYouMessage.getText();
        ReusableMethods.getScreenshot(orderCompletePage);


        }
    }













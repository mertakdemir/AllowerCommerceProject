package techproed.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class US_011_TC_001 {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Test
    public void US_011_TC_001() throws IOException {

        //User goes to url
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //User clicks on sign in button
        homePage = new HomePage();
        homePage.signInButton1.click();

        //User enters email and password as a "vendor"
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(ConfigReader.getProperty("vendor_email"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendor_password"));
        loginPage.rememberMeCheckBox.click();
        loginPage.signInButton.click();

        //User clicks on "My Account" option
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoViewJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(homePage.myAccountButton);

        //Verify that "Orders, Downloads, Addresses, Account Details, Wishlist, Logout" options are displayed
        myAccountPage = new MyAccountPage();
        Assert.assertTrue(myAccountPage.ordersOption.isDisplayed());
        Assert.assertTrue(myAccountPage.downloadOption.isDisplayed());
        Assert.assertTrue(myAccountPage.addressesButton.isDisplayed());
        Assert.assertTrue(myAccountPage.accountDetailsOption.isDisplayed());
        Assert.assertTrue(myAccountPage.wishListOption.isDisplayed());
        Assert.assertTrue(myAccountPage.logOutOption.isDisplayed());


        //List<WebElement> optionsList = myAccountPage.options;
        //for (WebElement w : optionsList){
        //    Assert.assertTrue(w.isDisplayed());
        //}

        //Verify that "Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings and log out" are displayed
        Assert.assertTrue(myAccountPage.storeManagerDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.ordersDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.downloadDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.addressDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.accountDetailsButton.isDisplayed());
        Assert.assertTrue(myAccountPage.wishListDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.supportTicketDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.followingsDashboard.isDisplayed());
        Assert.assertTrue(myAccountPage.logoutDashboard.isDisplayed());

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.getScreenshot("The requirements are displayed");
        ReusableMethods.waitFor(2);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

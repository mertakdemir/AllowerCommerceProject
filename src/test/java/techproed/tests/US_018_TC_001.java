package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.StoreManagerPage;
import techproed.utilities.*;

public class US_018_TC_001 {

/*
    External - Affiliate Product should be selectable.
    User should be able fill in URL, Button Text, Price, Sale Price.
    The steps of US14 and US15 should be done succesfully.
*/

    HomePage homePage;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    Faker faker;


    @Test
    public void TC_001(){

    // User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        AllowerMethods.signIn();

        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(homePage.myAccountButton);

        myAccountPage.storeManagerDashboard.click();

        storeManagerPage = new StoreManagerPage();
        storeManagerPage.products.click();

       // Select select = new Select(storeManagerPage.allProductTypes);
       // select.selectByVisibleText("External/Affiliate Product");

        storeManagerPage.addNewButton.click();
        Select productDropdown = new Select(storeManagerPage.productDropdown);
        productDropdown.selectByVisibleText("External/Affiliate Product");


    }
}

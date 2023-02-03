package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.utilities.*;

public class US_018_TC_001 {

/*
    External - Affiliate Product should be selectable.
    User should be able fill in URL, Button Text, Price, Sale Price.
    The steps of US14 and US15 should be done succesfully.
*/

    HomePage homePage;
    MyAccountPage myAccountPage;
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


    }
}

package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.SignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class US_005_TC_001 {

    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;

    @Test
    public void US_005_TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage = new HomePage();
        signInPage = new SignInPage();
        homePage.signInButton1.click();



    }
}

package techproed.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.US_002_TC_01_AlloverCommerceHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class US_002_TC_01_AlloverCommerceTest {

    US_002_TC_01_AlloverCommerceHomePage us_002_tc_01_alloverCommerceHomePage = new US_002_TC_01_AlloverCommerceHomePage();

    @Test
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));
        us_002_tc_01_alloverCommerceHomePage.registerIcon.click();
        us_002_tc_01_alloverCommerceHomePage.usernameInput.sendKeys("bilaltarik");
        us_002_tc_01_alloverCommerceHomePage.emailInput.sendKeys("bilaltarikk@gmail.com");
        us_002_tc_01_alloverCommerceHomePage.passwordInput.sendKeys("123456");
        us_002_tc_01_alloverCommerceHomePage.privatePolicy.click();
        us_002_tc_01_alloverCommerceHomePage.signupButton.click();

        Assert.assertTrue(us_002_tc_01_alloverCommerceHomePage.existentAccount.isDisplayed());

    }
}

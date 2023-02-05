package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.Register_Page;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_001_TC_002 {

    HomePage homePage;
    Register_Page register_page;
    Faker faker;
    MyAccountPage myAccountPage;
    @Test
    public void US_001_TC_001_Register_Page_Test() throws IOException {


        //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //User should click register button.
        homePage = new HomePage();
        register_page = new Register_Page();
        faker = new Faker();
        myAccountPage= new MyAccountPage();

        homePage.registerButton.click();

        //User should enter username.
        register_page.userName.sendKeys( faker.name().username());
        ReusableMethods.waitFor(2);
        register_page.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(2);
        register_page.password.sendKeys(faker.number().digits(8));
        ReusableMethods.waitFor(2);
        register_page.checkBoxPolicy.click();
        register_page.SignUpButton.click();
        ReusableMethods.getScreenshot("user could sign up with clicking policy check box" + register_page.SignUpButton);
        Assert.assertTrue(myAccountPage.signOutButton.isDisplayed());


    }
}
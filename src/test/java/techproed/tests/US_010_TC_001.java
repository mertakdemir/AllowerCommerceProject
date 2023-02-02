package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class US_010_TC_001 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;
    Register_Page registerPage;
    VendorSignUpPage signUpPage=new VendorSignUpPage();

    Faker faker;
    @Test
    public void US_010_TC_001(){

        //User goes to url
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //User clicks on sign in button
        homePage = new HomePage();
        homePage.signInButton1.click();




    }

    @Test
    public void US_010_TC_002(){

        faker = new Faker();

        //User goes to home page
        Driver.getDriver().get(ConfigReader.getProperty("vendor_registration_url"));

       signUpPage.passwordInput.sendKeys(faker.internet().password());










    }

}

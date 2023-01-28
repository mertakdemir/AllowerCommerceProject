package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.Register_Page;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_001_Register_Page_Test {

    HomePage homePage;
    Register_Page _register_page;
    Faker faker;
    @Test
    public void US_001_TC_001_Register_Page_Test() throws IOException {


    //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

    //User should click register button.
      homePage = new HomePage();
      _register_page =new Register_Page();
      faker = new Faker();

      homePage.registerButton.click();

    //User should enter username.
        _register_page.userName.sendKeys( faker.name().username());
        ReusableMethods.waitFor(2);
        _register_page.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(2);
        _register_page.password.sendKeys(faker.number().digits(8));
        ReusableMethods.waitFor(2);
        _register_page.checkBoxPolicy.click();
        _register_page.SignUpButton.click();
        ReusableMethods.getScreenshot("user could not sign up without clicking policy check box" + _register_page.SignUpButton);


}
}
package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.US_001_TC_001_Home_Page;
import techproed.pages.US_001_TC_001_Register_Page;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_001_TC_001_Register_Page_Test {

US_001_TC_001_Home_Page us_001_tc_001_home_page;
    US_001_TC_001_Register_Page us_001_tc_001_register_page;
    Faker faker;
    @Test
    public void US_001_TC_001_Register_Page_Test() throws IOException {


    //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

    //User should click register button.
        us_001_tc_001_home_page =new US_001_TC_001_Home_Page();
        us_001_tc_001_register_page =new US_001_TC_001_Register_Page();
        faker = new Faker();

        us_001_tc_001_home_page.homePageRegisterButton.click();

    //User should enter username.
        us_001_tc_001_register_page.userName.sendKeys("fakeusername");
        ReusableMethods.waitFor(2);
        us_001_tc_001_register_page.yourEmailAddress.sendKeys("fake@allovercommerce.com");
        ReusableMethods.waitFor(2);
        us_001_tc_001_register_page.password.sendKeys("fakepass");
        ReusableMethods.waitFor(2);
        //us_001_tc_001_register_page.checkBoxPolicy.click();
        us_001_tc_001_register_page.SignUpButton.click();
        ReusableMethods.getScreenshot("user could not sign up without clicking policy check box" + us_001_tc_001_register_page.SignUpButton);


}
}
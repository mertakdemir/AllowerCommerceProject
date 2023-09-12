package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_010_TC_001 {
    HomePage homePage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;
    Register_Page registerPage;
    VendorSignUpPage signUpPage=new VendorSignUpPage();

    Faker faker;
    @Test
    public void US_010_TC_001(){
        faker = new Faker();
//      Vendor goes to Vendor Registration page
        Driver.getDriver().get(ConfigReader.getProperty("vendor_registration_url"));

//      Vendor uses few characters in his  password, "Too short" should be seen on the screen.
        JSUtils.scrollIntoViewJS(signUpPage.passwordInput);
        signUpPage.passwordInput.sendKeys(faker.internet().password(1,2));
        Assert.assertEquals("Too short",signUpPage.chartLevel.getText());
    }

    @Test
    public void US_010_TC_002(){
        faker = new Faker();
//      User goes to Vendor Registration page
        Driver.getDriver().get(ConfigReader.getProperty("vendor_registration_url"));

//      Vendor not using short and different characters in vendor's password, "weak" should be seen on the screen.
        JSUtils.scrollIntoViewJS(signUpPage.passwordInput);
        signUpPage.passwordInput.sendKeys(faker.internet().password(6,7));
        Assert.assertEquals("Weak",signUpPage.chartLevel.getText());
    }

    @Test
    public void US_010_TC_003(){

        faker = new Faker();

//      User goes to Vender Registration page
        Driver.getDriver().get(ConfigReader.getProperty("vendor_registration_url"));

//      Vender uses  different characters in his passport, "good" should be seen on the screen.
        JSUtils.scrollIntoViewJS(signUpPage.passwordInput);
        signUpPage.passwordInput.sendKeys(faker.internet().password());
        Assert.assertEquals("Good",signUpPage.chartLevel.getText());
    }
    @Test
    public void US_010_TC_004(){
        faker=new Faker();
//      User goes to Vender Registration page
        Driver.getDriver().get(ConfigReader.getProperty("vendor_registration_url"));

//      Vender uses long and different characters in his  passport, "Strong" should be seen on the screen.
        JSUtils.scrollIntoViewJS(signUpPage.passwordInput);
        signUpPage.passwordInput.sendKeys(faker.internet().password(6,9,true,true));
        Assert.assertEquals("Strong",signUpPage.chartLevel.getText());
    }
}

package techproed.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.SignUpPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;


import static techproed.utilities.JSUtils.scrollIntoViewJS;

public class US_009_TC_01_VendorSignUpTest extends SignUpPage{
    SignUpPage signUpPage=new SignUpPage();




    @Test
    public void signUpTest(){
        Driver.getDriver().get(ConfigReader.getProperty("vendor_signup_url"));
        signUpPage.signupIcon.click();
        scrollIntoViewJS(signUpPage.becomeVendorButton);
        ReusableMethods.waitFor(1);
        signUpPage.becomeVendorButton.click();
        ReusableMethods.switchToWindow("vendor_registration_url");
        signUpPage.emailInput.sendKeys("bilaltarikk@gmail.com");
        signUpPage.verificationCode.sendKeys("311789");
        signUpPage.passwordInput.sendKeys("12345Alti@");
        signUpPage.confirmPwdInput.sendKeys("12345Alti@");
        signUpPage.registerButton.click();
        Assert.assertTrue(signUpPage.errorMessage.isDisplayed());


    }
}

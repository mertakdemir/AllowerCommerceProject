package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AccountDetailsPage;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.SignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_005_TC_001 {

    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    AccountDetailsPage accountDetailsPage;
    Faker faker;


    @Test
    public void US_005_TC_001(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        accountDetailsPage = new AccountDetailsPage();
        faker= new Faker();

        //User goes to home page
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage.registerButton.click();
        signInPage.username.sendKeys(faker.name().username());
        signInPage.email.sendKeys(faker.internet().emailAddress());
        String password = faker.internet().password();
        signInPage.password.sendKeys(password);
        signInPage.agreeThePolicy.click();
        signInPage.signUpButton.click();


        //User clicks on My Account Details Button
        ReusableMethods.waitFor(3);
        JSUtils.scrollIntoViewJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(myAccountPage.accountDetailsButton);

        //User should be able to see Account Details.
        ReusableMethods.verifyElementDisplayed(accountDetailsPage.title);

        //First name, Last name, Display name ve Email address should be editable.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        accountDetailsPage.accountFirstName.sendKeys(faker.name().firstName());
        Assert.assertTrue(accountDetailsPage.accountFirstName.isEnabled());
        accountDetailsPage.accountLastName.sendKeys(faker.name().lastName());
        Assert.assertTrue(accountDetailsPage.accountLastName.isEnabled());
        Assert.assertTrue(accountDetailsPage.accountDisplayName.isEnabled());
        Assert.assertTrue(accountDetailsPage.accountEmail.isEnabled());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //User should be able to fill in the Biography section.
        ReusableMethods.waitFor(3);
        Assert.assertTrue(accountDetailsPage.biographySection.isEnabled());
        accountDetailsPage.biographySection.sendKeys("Hello, I love shopping");

        //User should be able to change password.
        accountDetailsPage.passwordCurrent.sendKeys(password);
        String newPassword = faker.internet().password();
        accountDetailsPage.passwordNew.sendKeys(newPassword);
        accountDetailsPage.passwordConfirm.sendKeys(newPassword);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);

        JSUtils.clickElementByJS(accountDetailsPage.saveChangesButton);




    }
}

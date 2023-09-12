package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_003_TC_001 {

    //User should add be able to Billing Adress.
    // (My Account > Addresses > Billing Address)
    HomePage homePage;
    MyAccountPage myAccountPage;
    BillingAddressPage billingAddressPage;
    Faker faker;
    Register_Page registerPage;

    public void register() {
        homePage = new HomePage();

        faker = new Faker();
        registerPage = new Register_Page();
        //User goes to home page
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage.registerButton.click();
        registerPage.userName.sendKeys(faker.name().username());

        registerPage.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(3);
        registerPage.password.sendKeys(faker.internet().password());
        registerPage.checkBoxPolicy.click();
        registerPage.SignUpButton.click();
    }

    @Test
    public void US_003_TC_001() {
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        billingAddressPage = new BillingAddressPage();

        //Sign In
        register();

        //User clicks on My Account button
        JSUtils.clickElementByJS(homePage.myAccountButton);

        //User clicks on signOut Button
        homePage.signOut.click();

        //User clicks on Addresses Button
        JSUtils.clickElementByJS(myAccountPage.addressesButton);

        //User click on "Add" for billing address
        myAccountPage.addBillingAddress.sendKeys(Keys.ENTER);

        //User fills the required parts
        billingAddressPage.firstName.sendKeys(faker.address().firstName());
        billingAddressPage.lastName.sendKeys(faker.address().lastName());

        Select country = new Select(billingAddressPage.countryOrRegion);
        country.selectByVisibleText(faker.address().country());

        billingAddressPage.streetAddress.sendKeys(faker.address().streetAddress());
        billingAddressPage.townOrCity.sendKeys(faker.address().city());
        ReusableMethods.waitFor(3);
        try {

            Select state = new Select(billingAddressPage.stateOrCountry);
            state.selectByVisibleText(faker.address().city());

        } catch (Exception ignored) {

        }

        billingAddressPage.postcodeOrZipCode.sendKeys(faker.address().zipCode());
        billingAddressPage.phone.sendKeys(faker.phoneNumber().phoneNumber());
//         billingAddressPage.emailAddress.clear();
//         billingAddressPage.emailAddress.sendKeys(faker.internet().emailAddress());

         JSUtils.clickElementByJS(billingAddressPage.saveAddressButton);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
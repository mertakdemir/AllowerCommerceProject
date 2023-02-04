package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_012_TC_001 {

    HomePage homePage;
    Register_Page register_page;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    BillingAddressPage billingAddressPage;
    Faker faker;

    @Test
    public void US_012_TC_001() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        register_page = new Register_Page();
        myAccountPage = new MyAccountPage();
        billingAddressPage = new BillingAddressPage();
        faker = new Faker();

        //User goes to homepage
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //User clicks on sign in button

        homePage.signInButton1.click();

        //User enters email and password as a "vendor"

        WebElement registeredEmail = loginPage.emailInput;
        registeredEmail.sendKeys("ballimerve0@gmail.com");
        String email = registeredEmail.getText();
        loginPage.passwordInput.sendKeys("meryselenium123");
        loginPage.rememberMeCheckBox.click();
        loginPage.signInButton.click();

        //User clicks on My Account button
        ReusableMethods.waitFor(3);
        JSUtils.scrollIntoViewJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(homePage.myAccountButton);

        //User click on "Addresses" for billing address
        myAccountPage.addressesButton.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

        myAccountPage.addBillingAddress.click();

        //User fills the required parts
        billingAddressPage.firstName.sendKeys(faker.address().firstName());
        billingAddressPage.lastName.sendKeys(faker.address().lastName());

        try {
            Select country = new Select(billingAddressPage.getCountryOrRegion2);
            country.selectByVisibleText("South Africa");
        } catch (Exception ignored) {
        }

        billingAddressPage.streetAddress.sendKeys(faker.address().streetAddress());
        billingAddressPage.townOrCity.sendKeys(faker.address().cityName());

        try {

            Select state =new Select(billingAddressPage.province1);
            state.selectByVisibleText("Limpopo");

        }catch (Exception ignored){

        }
        billingAddressPage.postcodeOrZipCode.sendKeys(faker.address().zipCode());
        billingAddressPage.phone.sendKeys(faker.phoneNumber().phoneNumber());

        //The registered email address should be filled in automatically.
        ReusableMethods.waitFor(2);
        String billingEmail = billingAddressPage.emailAddress.getText();
        Assert.assertEquals(billingEmail, email);

        //After clicking 'Save Address', the Billing Address should be added.
        JSUtils.clickElementByJS(billingAddressPage.saveAddressButton);
        Assert.assertTrue(billingAddressPage.editYourBillingAddress.isDisplayed());



    }
}

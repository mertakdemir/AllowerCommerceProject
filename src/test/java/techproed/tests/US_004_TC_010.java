package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.ShippingAddressPage;
import techproed.pages.SignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_004_TC_010 {
    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    ShippingAddressPage shippingAddressPage;
    Faker faker;

    public void register(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        faker = new Faker();

        //User goes to home page
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage.registerButton.click();
        signInPage.username.sendKeys(faker.name().username());
        signInPage.email.sendKeys(faker.internet().emailAddress());
        signInPage.password.sendKeys(faker.internet().password());
        signInPage.agreeThePolicy.click();
        signInPage.signUpButton.click();

    }

    @Test
    public void US_004_TC_002() throws IOException {

        homePage = new HomePage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        shippingAddressPage = new ShippingAddressPage();

        register();

        //User clicks on My Account button
        ReusableMethods.waitFor(3);
        JSUtils.scrollIntoViewJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(homePage.myAccountButton);

        //User clicks on Addresses Button
        myAccountPage.addressesButton.click();

        //User click on "Add" for shipping address
        myAccountPage.addShippingAddressButton.click();

        Actions actions = new Actions(Driver.getDriver());

        //User enters first name
        shippingAddressPage.firstNameInput.sendKeys(faker.name().firstName());
        //User enters Last name
        shippingAddressPage.lastNameInput.sendKeys(faker.name().lastName());
        shippingAddressPage.companyNameInput.sendKeys(faker.company().name());
        ReusableMethods.waitFor(1);
        Select countryDD = new Select(shippingAddressPage.countryDropdown);
        countryDD.selectByVisibleText("South Africa");
        ReusableMethods.waitFor(1);
        shippingAddressPage.adressHouseNumberAndStreetNameInput.sendKeys(faker.address().streetName());
        ReusableMethods.waitFor(1);
        shippingAddressPage.addressApartmentOrSuiteInput.sendKeys(faker.address().buildingNumber());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

        //User enters invalid City name
        shippingAddressPage.cityInput.sendKeys("!");
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Invalid city name");
        ReusableMethods.waitFor(1);
        try {
            Select stateDD = new Select(shippingAddressPage.stateDropdown);
            stateDD.selectByVisibleText("Limpopo");
        }catch (Exception ignored){

        }

        shippingAddressPage.zipCodeInput.sendKeys("12345");
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(shippingAddressPage.saveAddressButton);
        ReusableMethods.waitFor(3);

        //Verify that user has been registered
        Assert.assertFalse(shippingAddressPage.editYourShippingAddressText.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
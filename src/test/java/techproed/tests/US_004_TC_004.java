package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class US_004_TC_004 {

    HomePage homePage;
    Register_Page register_page;
    MyAccountPage myAccountPage;
    ShippingAddressPage shippingAddressPage;
    Faker faker;


    public void register(){
        homePage = new HomePage();
        register_page = new Register_Page();
        faker = new Faker();

        //User goes to home page
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        homePage.registerButton.click();
        register_page.userName.sendKeys(faker.name().username());
        register_page.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        register_page.password.sendKeys(faker.internet().password());
        register_page.checkBoxPolicy.click();
        register_page.SignUpButton.click();

    }

    @Test
    public void US_004_TC_004() throws IOException {

        homePage = new HomePage();
        register_page = new Register_Page();
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

        //User enters first name
        shippingAddressPage.firstNameInput.sendKeys(faker.name().firstName());
        //User enters invalid Last name
        shippingAddressPage.lastNameInput.sendKeys(faker.number().digit());
        ReusableMethods.getScreenshot("Invalid Last name");
        ReusableMethods.waitFor(3);

        Actions actions = new Actions(Driver.getDriver());
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
        shippingAddressPage.cityInput.sendKeys(faker.address().cityName());
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

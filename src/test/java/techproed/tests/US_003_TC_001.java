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

public class US_003_TC_001 {

    //User should add be able to Billing Adress.
    // (My Account > Addresses > Billing Address)


    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    BillingAddressPage billingAddressPage;
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
    public void US_003_TC_001() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        billingAddressPage = new BillingAddressPage();

        //Sign In
        register();

        //User clicks on My Account button
        JSUtils.clickElementByJS(homePage.myAccountButton);

        //User clicks on signOut Button
        homePage.signOut.click();

        //User clicks on Addresses Button
        JSUtils.clickElementByJS( myAccountPage.addressesButton);

        //User click on "Add" for billing address
        myAccountPage.addBillingAddress.sendKeys(Keys.ENTER);


        //User fills the required parts
        billingAddressPage.firstName.sendKeys(faker.address().firstName());
        billingAddressPage.lastName.sendKeys(faker.address().lastName());

        try {

            Select country =new Select(billingAddressPage.countryOrRegion);
            country.selectByVisibleText("South Africa");
        }catch (Exception ignored){

        }

        billingAddressPage.streetAddress.sendKeys(faker.address().streetAddress());
        billingAddressPage.townOrCity.sendKeys(faker.address().city());

        try {

            Select  state =new Select(billingAddressPage.stateOrCountry);
            state.selectByVisibleText("Limpopo");

        }catch (Exception ignored){

        }



        billingAddressPage.postcodeOrZipCode.sendKeys(faker.address().zipCode());
        billingAddressPage.phone.sendKeys(faker.phoneNumber().phoneNumber());





         billingAddressPage.emailAddress.clear();
        billingAddressPage.emailAddress.sendKeys(faker.internet().emailAddress());

        JSUtils.clickElementByJS(billingAddressPage.saveAddressButton);


        //Verify that user has been registered
        Assert.assertTrue(billingAddressPage.editYourBillingAddress.isDisplayed());




    }

//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }

}

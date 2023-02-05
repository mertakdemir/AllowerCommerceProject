package techproed.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import techproed.pages.*;

import java.io.IOException;

public class AllowerMethods {
    static HomePage homePage;
    static CustomerSignInPage signInPage;
    static ShippingAddressPage shippingAddressPage;
    static VendorSignUpPage vendorSignUpPage;
    static Register_Page registerPage;
    static Faker faker;


//  Sign Up for Customer
    public static void register() {
        homePage = new HomePage();
        registerPage = new Register_Page();
        faker = new Faker();

        homePage.registerButton.click();
        registerPage.userName.sendKeys(faker.name().username());
        registerPage.yourEmailAddress.sendKeys(faker.internet().emailAddress());
        registerPage.password.sendKeys(faker.internet().password());
        registerPage.checkBoxPolicy.click();
        registerPage.signUpButton.click();
    }

//  Sign Up for Vendor
    public void signUpVendor(){
        vendorSignUpPage = new VendorSignUpPage();
        vendorSignUpPage.signupVendorLink.click();
        vendorSignUpPage.emailInput.sendKeys("snbahar395@gmail.com");
        vendorSignUpPage.passwordInput.sendKeys("8PaUN!");
        vendorSignUpPage.confirmPwdInput.sendKeys("8PaUN!");
        vendorSignUpPage.registerButton.click();
    }

//  Sign In Customer or Vendor
    public static void signIn() {
        homePage = new HomePage();
        homePage.signInButton1.click();
        ReusableMethods.waitFor(3);
        signInPage = new CustomerSignInPage();

        signInPage.username.sendKeys("snbahar395@gmail.com");
        signInPage.password.sendKeys("8PaUN!");
        signInPage.signInButton.click();
    }


//  Add Shipping Address for Customer or Vendor
    public static void shippingAddress() throws IOException {
        shippingAddressPage = new ShippingAddressPage();
        faker = new Faker();
        shippingAddressPage.firstNameInput.sendKeys(faker.name().firstName());
        shippingAddressPage.lastNameInput.sendKeys(faker.name().lastName());

    // add country
        try{
            Select country = new Select(shippingAddressPage.countryDropdown);
            country. selectByVisibleText(faker.address().country());
        }catch (Exception e){
        }

        shippingAddressPage.adressHouseNumberAndStreetNameInput.sendKeys(faker.address().streetAddress());
        shippingAddressPage.addressApartmentOrSuiteInput.sendKeys(faker.address().streetAddressNumber());

    //  aad city
        try {
            shippingAddressPage.cityInput.sendKeys(faker.address().cityName());
        } catch (Exception e) {
        }


    //  add state
        try {
            Select state = new Select(shippingAddressPage.stateDropdown);
            state.selectByVisibleText(faker.address().state());
        } catch (Exception e) {
        }
        shippingAddressPage.stateInput.sendKeys(faker.address().state());

    //  add zipcode
        try {
            shippingAddressPage.zipCodeInput.sendKeys(faker.address().zipCode());
        } catch (Exception e) {
        }

        JSUtils.clickElementByJS(shippingAddressPage.saveAddressButton);

        ReusableMethods.getScreenshot("OK Save Address");
    }




//  Edit Shipping Address for Customer or Vendor
    public static void editShippingAddress() {
        shippingAddressPage = new ShippingAddressPage();
        shippingAddressPage.firstNameInput.clear();
        shippingAddressPage.lastNameInput.clear();
        Select country = new Select(shippingAddressPage.countryDropdown);
        country.selectByIndex(0);

        shippingAddressPage.adressHouseNumberAndStreetNameInput.clear();
        shippingAddressPage.addressApartmentOrSuiteInput.clear();
        shippingAddressPage.cityInput.clear();

        try {
            Select state = new Select(shippingAddressPage.stateDropdown);
            state.selectByIndex(0);
        } catch (Exception e) {
        }
        shippingAddressPage.stateInput.clear();

        shippingAddressPage.zipCodeInput.clear();
        JSUtils.clickElementByJS(shippingAddressPage.saveAddressButton);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(shippingAddressPage.errorMessages.isDisplayed());
    }

}
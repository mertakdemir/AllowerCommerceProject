package techproed.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.HomePage;
import techproed.pages.Register_Page;
import techproed.pages.ShippingAddressPage;
import techproed.pages.SignInPage;

public class AllowerMethods {
    static HomePage homePage;
    static SignInPage signInPage;
    static ShippingAddressPage shippingAddressPage;
    static Register_Page registerPage;
    static Faker faker;


    public static void register(){
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



    public static void shippingAddress() {
        shippingAddressPage = new ShippingAddressPage();
        faker = new Faker();
        shippingAddressPage.firstNameInput.sendKeys(faker.name().firstName());
        shippingAddressPage.lastNameInput.sendKeys(faker.name().lastName());
        Select country = new Select(shippingAddressPage.countryDropdown);
        country.selectByVisibleText(faker.address().country());
        shippingAddressPage.adressHouseNumberAndStreetNameInput.sendKeys(faker.address().streetAddress());
        shippingAddressPage.addressApartmentOrSuiteInput.sendKeys(faker.address().streetAddressNumber());

        try {
            shippingAddressPage.cityInput.sendKeys(faker.address().cityName());
        }catch (Exception e) {
        }
            ReusableMethods.waitFor(2);

        try {
            Select state = new Select(shippingAddressPage.stateDropdown);
            state.selectByVisibleText(faker.address().state());
        }catch (Exception e) {
        }
        shippingAddressPage.stateInput.sendKeys(faker.address().state());

        try {
            shippingAddressPage.zipCodeInput.sendKeys(faker.address().zipCode());
        }catch (Exception e){

        }
        shippingAddressPage.saveAddressButton.click();
        }


    public static void editShippingAddress() {
        ReusableMethods.waitFor(2);
        try {
            shippingAddressPage.firstNameInput.clear();
        }catch (Exception e){

        }
        shippingAddressPage.lastNameInput.clear();
        shippingAddressPage.countryDropdown.clear();
        shippingAddressPage.adressHouseNumberAndStreetNameInput.clear();
        shippingAddressPage.addressApartmentOrSuiteInput.clear();
        shippingAddressPage.cityInput.clear();
        shippingAddressPage.stateDropdown.clear();
        shippingAddressPage.zipCodeInput.clear();
        shippingAddressPage.saveAddressButton.click();
    }


    }
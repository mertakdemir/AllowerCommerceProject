package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

import java.io.IOException;

public class US_013_TC_001 {
    /*
        Given
            User should go to https://www.allovercommerce.com/
        When
            Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.
        And
            After clicking 'Save Address', the Shipping Address should be added.
    */
    HomePage homePage;
    VendorSignUpPage vendorPage;
    CustomerSignInPage signInPage;
    MyAccountPage myAccountPage;
    ShippingAddressPage shippingAddressPage;
    Faker faker = new Faker();


    @Test

    public void US_013_TC_001() throws IOException {
        //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.
        //After clicking 'Save Address', the Shipping Address should be added. ------->>>>> with AllowerMethods.shippingAddress()
        // Sign in as a vendor first
        AllowerMethods.signIn();

        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(myAccountPage.addressesButton);

        ReusableMethods.waitFor(2);
        shippingAddressPage = new ShippingAddressPage();
        JSUtils.clickElementByJS(shippingAddressPage.editShippingAddress);

        AllowerMethods.editShippingAddress();
        AllowerMethods.shippingAddress();


        Driver.closeDriver();
    }

}
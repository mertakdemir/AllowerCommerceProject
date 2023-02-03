package techproed.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

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


    //Vendor olarak signUp yapmak icin;
    public void signUpVendor(){
        vendorPage = new VendorSignUpPage();
        vendorPage.signupVendorLink.click();
        vendorPage.emailInput.sendKeys("snbahar395@gmail.com");
        vendorPage.passwordInput.sendKeys("8PaUN!");
        vendorPage.confirmPwdInput.sendKeys("8PaUN!");
        vendorPage.registerButton.click();
    }


    @Test

    public void US_013_TC_001(){
        //User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        //Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.
        homePage = new HomePage();
        signInPage =new CustomerSignInPage();

        homePage.signInButton1.click();
        ReusableMethods.waitFor(3);

        signInPage.username.sendKeys("snbahar395@gmail.com");
        signInPage.password.sendKeys("8PaUN!");
        signInPage.signInButton.click();
        //ReusableMethods.waitFor(2);
        //System.out.println("Sign In Message = " + signInPage.signInStatus.getText());

        myAccountPage = new MyAccountPage();
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(homePage.myAccountButton);
        JSUtils.clickElementByJS(myAccountPage.addressesButton);

        ReusableMethods.waitFor(2);
        //JSUtils.clickElementByJS(myAccountPage.addShippingAddressButton);
        //JSUtils.clickElementByJS(myAccountPage.addShippingAddressButton);
        shippingAddressPage = new ShippingAddressPage();
       JSUtils.clickElementByJS(shippingAddressPage.editShippingAddress);

        AllowerMethods.editShippingAddress();
        AllowerMethods.shippingAddress();





//    vendorPage.signupIcon.click();
//    signUpVendor();
//
//    homePage.myAccountButton.click();




        //After clicking 'Save Address', the Shipping Address should be added.

        //Driver.closeDriver();




    }



    public void shippingAddressMethod(){

    }
}

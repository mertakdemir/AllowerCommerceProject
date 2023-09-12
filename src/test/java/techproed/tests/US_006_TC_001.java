package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.CheckoutPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_006_TC_001 {
/*
    Given
        Go to https://allovercommerce.com
    When
        The user should be able to find the desired product in the search box. "Television"
    And
        The user should be able to add the product they are looking for to their cart. (ADD TO CART)
    Then
        User should see the items that have been added to the cart.
    When
        The amount of products in the cart should be adjustable by the user.
    Then
        User should be able to see the Billing Address in order to purchase the products
    And
        The user should be able to view and select payment options.
    And
        The user should be able to complete their purchase.
*/

    HomePage homePage= new HomePage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage;
    Faker faker;

   @Test
   public void TC_001(){

   // Go to https://allovercommerce.com
       Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

   // The user should be able to find the desired product in the search box. "Television"
       Assert.assertTrue(homePage.searchBox.isEnabled());
       homePage.searchBox.sendKeys("Television", Keys.ENTER);

   // The user should be able to add the product they are looking for to their cart. (ADD TO CART)
       productPage.addToCart.click();
       ReusableMethods.waitFor(2);

   // User should see the items that have been added to the cart.
       String message = productPage.addToCartMessage.getText();
       System.out.println("message = " + message);
       Assert.assertTrue(productPage.addToCartMessage.isDisplayed());
       productPage.viewCart.click();
       checkoutPage = new CheckoutPage();
       Assert.assertTrue(checkoutPage.shoppingCart.isDisplayed());

   // The amount of products in the cart should be adjustable by the user.
       Assert.assertTrue(checkoutPage.quantity.isDisplayed());
       int quantity = Integer.parseInt(checkoutPage.quantity.getText());
       System.out.println("quantity = " + quantity);
       checkoutPage.quantityplus.click();
       checkoutPage.updateCart.click();
       ReusableMethods.waitFor(6);
       int newquantity = Integer.parseInt(checkoutPage.quantity.getText());
       System.out.println("newquantity = " + newquantity);
       Assert.assertTrue(newquantity>quantity);

   // User should be able to see the Billing Address in order to purchase the products

       ReusableMethods.waitFor(3);
       JSUtils.clickElementByJS(checkoutPage.proceedToCheckout);
      // productPage.proceedToCheckout.click();
       Assert.assertTrue(checkoutPage.billingDetails.isDisplayed());

   // The user should be able to view and select payment options.

       Assert.assertTrue(checkoutPage.paymentMethod.isDisplayed());
       Assert.assertTrue(checkoutPage.billingAdress.isDisplayed());

       try {
           Select select = new Select(checkoutPage.country);
           select.selectByVisibleText("United Kingdom (UK)");
       }catch(Exception e){

       }

       faker = new Faker();
       ReusableMethods.waitFor(2);
       checkoutPage.firstName.sendKeys(faker.name().firstName());
       checkoutPage.lastName.sendKeys(faker.name().lastName());
       checkoutPage.billingAdress.sendKeys(faker.address().streetAddress());
       checkoutPage.town.sendKeys(faker.address().city());
       checkoutPage.postcode.sendKeys(faker.address().zipCode());
       checkoutPage.phone.sendKeys(faker.phoneNumber().cellPhone());
       checkoutPage.email.sendKeys(faker.internet().emailAddress());

       ReusableMethods.waitFor(2);
       checkoutPage.placeOrder.click();

   // The user should be able to complete their purchase.

      Assert.assertTrue(checkoutPage.thankyouMessage.isDisplayed());
       Driver.closeDriver();

   }
}

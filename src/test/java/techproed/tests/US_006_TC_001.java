package techproed.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class US_006_TC_001 {
/*
   The user should be able to find the desired product in the search box.
   The user should be able to add the product they are looking for to their cart. (ADD TO CART)
   User should see the items that have been added to the cart.
   The amount of products in the cart should be adjustable by the user.
   User should be able to see the Billing Address in order to purchase the products
   The user should be able to view and select payment options.
   The user should be able to complete their purchase.
*/

    HomePage homePage= new HomePage();
    ProductPage productPage = new ProductPage();

   @Test
   public void test(){

   //The user should be able to find the desired product in the search box.
       Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

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
       Assert.assertTrue(productPage.shoppingCart.isDisplayed());

   // The amount of products in the cart should be adjustable by the user.
       Assert.assertTrue(productPage.quantity.isDisplayed());
       int quantity = Integer.parseInt(productPage.quantity.getText());
       System.out.println("quantity = " + quantity);
       productPage.quantityplus.click();
       productPage.updateCart.click();
       ReusableMethods.waitFor(5);
       int newquantity = Integer.parseInt(productPage.quantity.getText());
       System.out.println("newquantity = " + newquantity);
       Assert.assertTrue(newquantity>quantity);

   // User should be able to see the Billing Address in order to purchase the products
        Assert.assertTrue(productPage.billingDetails.isDisplayed());

   // The user should be able to view and select payment options.
       productPage.proceedToCheckout.click();
       Assert.assertTrue(productPage.paymentMethod.isDisplayed());

   // The user should be able to complete their purchase.






   
   }

}

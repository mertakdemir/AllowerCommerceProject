package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
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

public class US_006_TC_002 {
/*
    Given
        Go to https://allovercommerce.com
    When
        The user should be able to find the desired product in the search box. "Mirror"
    Then
        If the user cannot find the product they want, they should be able to see a message that the product is not found.
*/

    HomePage homePage= new HomePage();
    ProductPage productPage = new ProductPage();
    CheckoutPage checkoutPage;
    Faker faker;

   @Test
   public void TC_002(){

   //The user should be able to find the desired product in the search box.
       Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

   //The user should be able to find the desired product in the search box. "Mirror"
       Assert.assertTrue(homePage.searchBox.isEnabled());
       homePage.searchBox.sendKeys("Mirror", Keys.ENTER);

   //If the user cannot find the product they want, they should be able to see a message that the product is not found.
       Assert.assertTrue(productPage.noProductMessage.isDisplayed());

      // Driver.closeDriver();

   }

}

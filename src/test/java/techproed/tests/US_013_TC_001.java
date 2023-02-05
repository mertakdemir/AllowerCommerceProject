package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class US_013_TC_001 {
/*
    Given
        User should go to https://www.allovercommerce.com/
    When
        Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.
    And
        After clicking 'Save Address', the Shipping Address should be added.
*/

    @Test
    public void US_013_TC_001(){
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));
    }



}

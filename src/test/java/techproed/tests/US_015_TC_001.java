package techproed.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.SignInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class US_015_TC_001 {

    HomePage homePage;
    SignInPage signInPage;
//Vendor should be able  to navigate to  https://allovercommerce.com/
//Vendor should be able  to  signin as vendor
//Vendor can clickMy Account
//Vendor  can  click Store Manager ,Then verifies Store Manager page
//Vendor can click Products,verifies Products page
//Vendor can click Add New,and verifies existence of links Inventory,Shipping,Attributes,Linked,Seo.holesale product display settings,Advanced
//Close the application
@Test
 public void US_015_TC_001() {
    Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

    homePage = new HomePage();
    signInPage = new SignInPage();

 homePage.signInButton1.click();
 ReusableMethods.waitFor(5);
 homePage.SignIn.click();

homePage.UserName.sendKeys("durkaya@gmail.com");
homePage.password.sendKeys("E.satZ.ehra2012");
homePage.login.click();
}


}

package techproed.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.SignInPage;
import techproed.pages.VendorHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class US_015_TC_001 {

    HomePage homePage;
    SignInPage signInPage;
    VendorHomePage vendorHomePage;
@BeforeTest
public void login(){
    Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

    homePage = new HomePage();
    signInPage = new SignInPage();
    vendorHomePage =new VendorHomePage();
    homePage.signInButton1.click();
    ReusableMethods.waitFor(5);
    homePage.SignIn.click();

    homePage.UserName.sendKeys("durkaya@gmail.com");
    homePage.password.sendKeys("E.satZ.ehra2012");
    homePage.login.click();

    ReusableMethods.waitFor(3);
    JSUtils.scrollDownByJS();
    ReusableMethods.waitFor(3);
    vendorHomePage.myAccount.click();//Vendor can clickMy Account

}



//Close the application
@Test
 public void test01() {

//Vendor  can  click Store Manager ,Then verifies Store Manager page
vendorHomePage.storeManager.click();
for(WebElement w:vendorHomePage.menu){
    Assert.assertTrue(w.isDisplayed());
}
ReusableMethods.waitFor(3);
vendorHomePage.products.click();
//Vendor can click Add New,and verifies existence of links Inventory,Shipping,Attributes,Linked,Seo.holesale product display settings,Advanced
ReusableMethods.waitFor(3);
vendorHomePage.addNew.click();

}

@Test
public void  test02(){
/*Vendor is able to click Inventory
Vendor  is able to add SKU  amount
Vendor can click checkbox ManageStock, verify clicked
Vendor can change stock quantity
Vendor can allow backorders
Vendor can click sold individually checkbox,verify click
Vendor is able to click Shipping
Vendor should be able to enter weight ,dimensions,shipping class,processing time,
Close the application*/
login();

}
    @AfterTest
    public void tearDown() {
        Driver.getDriver().close();
    }

}

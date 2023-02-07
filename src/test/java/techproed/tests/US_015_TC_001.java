package techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;



public class US_015_TC_001 {

    HomePage homePage;
    SignInPage signInPage;
    LoginPage loginPage;
    VendorHomePage vendorHomePage;
    VendorProductPage vendorProductPage;
@BeforeTest
public void login() {


    homePage = new HomePage();

    signInPage = new SignInPage();
    loginPage = new LoginPage();
    vendorProductPage = new VendorProductPage();
    vendorHomePage=new VendorHomePage();
    Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

homePage.signInButton1.click();
ReusableMethods.waitFor(1);
loginPage.emailInput.sendKeys("durkaya@gmail.com");
ReusableMethods.waitFor(1);
loginPage.passwordInput.sendKeys("E.satZ.ehra2012");
ReusableMethods.waitFor(1);
loginPage.signInButton.click();
ReusableMethods.waitFor(1);
JSUtils.scrollDownByJS();
ReusableMethods.waitFor(5);
vendorHomePage.myAccount.click();
ReusableMethods.waitFor(2);
vendorHomePage.storeManager.click();
ReusableMethods.waitFor(2);
Assert.assertEquals(vendorProductPage.storeManagerTitle.getText(),"Store Manager");
    ReusableMethods.waitFor(2);
vendorHomePage.products.click();
ReusableMethods.waitFor(2);
}

//Close the application
@Test
 public void test01() {

 vendorProductPage.addNew.click();
    ReusableMethods.waitFor(2);

 Select product=new Select(vendorProductPage.selectProductType);

product.selectByVisibleText("Simple Product");
vendorProductPage.isVirtual.click();
    ReusableMethods.waitFor(1);
vendorProductPage.productTitle.sendKeys("HiPhone");
    ReusableMethods.waitFor(1);
vendorProductPage.regularPrice.sendKeys("229");
    vendorProductPage.salePrice.sendKeys("199");
 //Picture Insert
    String userHOME=System.getProperty("user.home");
    String pathOfFile=userHOME+"C:/Users/mdurk/Downloads/Phone4.jpeg";
ReusableMethods.waitFor(1);
JSUtils.clickElementByJS(vendorProductPage.featuredDisplayPicture);
    ReusableMethods.waitFor(1);

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

vendorProductPage.featuredDisplayMediaLibrary.click();
ReusableMethods.waitFor(1);
vendorProductPage.featuredDisplayPictureSelect.click();
    ReusableMethods.waitFor(1);
vendorProductPage.featuredDisplaySelect.click();
ReusableMethods.waitFor(1);
///MiniDisplay Picture Add
    JSUtils.clickElementByJS(vendorProductPage.miniDisplayPicture);
    ReusableMethods.waitFor(3);
    vendorProductPage.miniMediaLib.click();
    ReusableMethods.waitFor(3);
    vendorProductPage.phonePic.click();
    ReusableMethods.waitFor(2);
    vendorProductPage.miniAddToGallery.click();
    ReusableMethods.waitFor(2);

  vendorProductPage.shortDescriptionAddMedia.click();
    ReusableMethods.waitFor(2);
   vendorProductPage.mediaLibraryShortDescription.click();
    ReusableMethods.waitFor(2);
 vendorProductPage.selectShortDescriptionPicture.click();
 vendorProductPage.insertIntoPost.click();
    ReusableMethods.waitFor(2);

JSUtils.scrollIntoViewJS(vendorProductPage.addDescriptionMedia);
    ReusableMethods.waitFor(5);
vendorProductPage.addDescriptionMedia.click();
    ReusableMethods.waitFor(2);

vendorProductPage.descriptionMediaLibrary.click();
    ReusableMethods.waitFor(2);
vendorProductPage.selectDescriptionPicture.click();
    ReusableMethods.waitFor(2);
vendorProductPage.insertIntoPost2.click();
    ReusableMethods.waitFor(2);

    JSUtils.scrollIntoViewJS(vendorProductPage.electronics);
    ReusableMethods.waitFor(4);
    vendorProductPage.electronics.click();


    }



@Test
public void  test02() throws IOException {
    test01();

    JSUtils.scrollIntoViewJS(vendorProductPage.inventory);
    ReusableMethods.waitFor(3);
vendorProductPage.inventory.click();
    ReusableMethods.waitFor(3);
vendorProductPage.sku.sendKeys("Per Item");
    ReusableMethods.waitFor(3);

  ReusableMethods.selectCheckBox(vendorProductPage.manageStockCheck,true);
    ReusableMethods.waitFor(3);

vendorProductPage.stockQuantity.sendKeys("10");
Select backorders=new Select(vendorProductPage.backOrders);

backorders.selectByIndex(2);
    ReusableMethods.waitFor(3);
JSUtils.clickElementByJS(vendorProductPage.soldIndividually);

vendorProductPage.submit.click();
String assertStockQuantity=vendorProductPage.stockQuantity.getText();
    boolean assertStock=assertStockQuantity.equals("100");
    if (assertStock==false){
        System.out.println("STOCK QUANTITY AND SENT VALUE ARE NOT SAME");
        ReusableMethods.getScreenshot("StockQuantityMistake");
    }

}
    @AfterTest
    public void tearDown() {
//Driver.getDriver().close();
    }

}

package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.MyAccountPage;
import techproed.pages.StoreManagerPage;
import techproed.utilities.*;

public class US_018_TC_001 {

/*
    External - Affiliate Product should be selectable.
    User should be able fill in URL, Button Text, Price, Sale Price.
    The steps of US14 and US15 should be done succesfully.
*/

    HomePage homePage;
    MyAccountPage myAccountPage;
    StoreManagerPage storeManagerPage;
    Faker faker;


    @Test
    public void TC_001(){

    // User should go to https://www.allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        AllowerMethods.signIn();

        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(homePage.myAccountButton);

        myAccountPage.storeManagerDashboard.click();

        storeManagerPage = new StoreManagerPage();
        storeManagerPage.products.click();

       // Select select = new Select(storeManagerPage.allProductTypes);
       // select.selectByVisibleText("External/Affiliate Product");

        storeManagerPage.addNewButton.click();
        Select productDropdown = new Select(storeManagerPage.productDropdown);
        productDropdown.selectByVisibleText("External/Affiliate Product");

        faker = new Faker();
        storeManagerPage.productUrl.sendKeys(faker.internet().url());

        String  productName= faker.commerce().productName();
        int sonBosluk = productName.lastIndexOf(" ")+1; //faker'in verdigi product name cok uzun. cumledeki son boslugun index'ini aldik.
        int productNameSize = productName.length(); //cumlenin uzunlugunu aldik
        String product = productName.substring(sonBosluk,productNameSize);
        storeManagerPage.productTitle.sendKeys(product);
        storeManagerPage.buttonText.sendKeys(product);
        storeManagerPage.price.sendKeys(faker.commerce().price());
        storeManagerPage.salePrice.sendKeys(faker.commerce().price());


        System.out.println(System.getProperty("user.dir"));
        storeManagerPage.submitButton.click();

       // Driver.closeDriver();





    }
}

//String userDIR = System.getProperty("user.dir");
//        System.out.println("Project Folder = " + userDIR);
//
//        String userHOME = System.getProperty("user.home"); // ==> gives you the user folder
//        System.out.println(userHOME); // /Users/ismailefe ---> her bilgisayarda kullanici ismi farklidir.
//
//    //  2. Pick a file on your computer
//        String pathOfFile = System.getProperty(userHOME + "/Desktop/IT/Selenium/SeleniumNotlari"); // Writing the path dynamically so this path can work on other laptops
//                                                                                        // Diger bilgisayarlarda calisabilmek icin kodu dinamik yazdik.
//    // 3. Verify if that file exists on your computer or not
//        boolean isExist = Files.exists(Paths.get(userHOME + " /Desktop/IT/Selenium/SeleniumNotlari")); //returns TRUE if file exists. FALSE if file doesn't exists
//
//        Assert.assertTrue(isExist);
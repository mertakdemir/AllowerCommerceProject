package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

        HomePage homePage = new HomePage();
        Faker faker = new Faker();
        ProductPage productPage;

        /*
                Search box'a faker class'iyla product ismi aldik.
                Product yoksa olmadigina dair uyari mesajinin olup olmadigini kontrol ettirdik.
                Eger urun varsa da user'in aradigi urunu buldugunu dogrulamis olduk.
                bunlari if-else ile yaptik.
                Urunun add to Cart butonu tiklandi.
        */
        @Test
        public void productTest1(){
        Driver.getDriver().get(ConfigReader.getProperty("url_allovercommerce"));

        Assert.assertTrue(homePage.searchBox.isEnabled());
        ReusableMethods.clickWithTimeOut(homePage.searchBox,1);

        String  productName= faker.commerce().productName();
        int sonBosluk = productName.lastIndexOf(" ")+1; //faker'in verdigi product name cok uzun. cumledeki son boslugun index'ini aldik.
        int productNameSize = productName.length(); //cumlenin uzunlugunu aldik
        String product = productName.substring(sonBosluk,productNameSize); // son bolukla son index'e kadar olan kelimeyi aldik. yani 1 kelime
                System.out.println("Product Name = " + product);

        homePage.searchBox.sendKeys(product, Keys.ENTER);


        productPage =new ProductPage();
        int  productsItem = productPage.productsList.size();
                System.out.println("productsItem = " + productsItem);

                for(int i=0; i>3; i++){
                if(productsItem>0){
                        System.out.println("New Products Item = " + productsItem);
                        Assert.assertTrue(productsItem>0);
                        productPage.productsList.get(1).click();

                        WebElement a= productPage.addToCart.get(0);
                        String text=a.getText();
                        System.out.println("text = " + text);

                }else {
                        Assert.assertTrue(productPage.noProduct.getText().contains("No products"));
                        homePage.searchBox.clear();
                        String  newProductName= faker.commerce().productName();
                        int sonBosluk1 = productName.lastIndexOf(" ")+1; //faker'in verdigi
                        int productNameSize1 = productName.length(); //cumlenin uzunlugunu
                        String newProduct = productName.substring(sonBosluk1,productNameSize1);
                        homePage.searchBox.sendKeys(newProduct, Keys.ENTER);
                        ReusableMethods.waitFor(2);
                        int  newProductsItem = productPage.productsList.size();
                        Assert.assertTrue(newProductsItem==0);
                }
                }



        ReusableMethods.waitFor(2);
        //Driver.closeDriver();


    }
}

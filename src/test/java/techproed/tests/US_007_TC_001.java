package techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

import java.util.List;

public class US_007_TC_001 {

    @Test
    public void selectProducts(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://allovercommerce.com/");

        // click on select button
       // driver.findElement();

       // Select 4 products
       // WebElement element = driver.findElement(By.xpath("//*[@id=\"product-15096\"]/div[2]/div/form/div/div/div/button"));
       // Select select = new Select(element);
       // select.selectByValue("");

       List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"product-15096\"]/div[2]/div/form/div/div/div/button"));

        for (int i =0; i<5; i++){
            elements.get(i).click();
        }

    }

}

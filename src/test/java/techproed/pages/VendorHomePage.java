package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import techproed.utilities.Driver;

import java.util.List;

public class VendorHomePage {
    public VendorHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
  @FindBy (xpath = "//a[.='My Account']")
    public WebElement myAccount;
    @FindBy(xpath = "//a[.='Store Manager']")
  public WebElement storeManager;
    @FindBy(xpath = "//a[@class='wcfm_menu_item']")
    public List<WebElement> menu;

    @FindBy (xpath ="//*[@id='wcfm_menu']/div[5]")
    public WebElement products;



}
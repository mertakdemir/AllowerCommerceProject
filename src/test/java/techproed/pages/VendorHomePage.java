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
    @FindBy(xpath = "//*[@id='add_new_product_dashboard']/span[2]")
    public WebElement addNew;
    @FindBy(xpath = "//*[.='Inventory']")
    public WebElement inventory;
    @FindBy(xpath = "//*[.='Shipping']")
    public WebElement shipping;
    @FindBy(xpath = "//*[.='Attributes']")
    public WebElement attributes;
    @FindBy(xpath = "//*[.='Linked']")
    public WebElement linked;
    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_yoast_head']")
    public WebElement seo;
@FindBy (xpath = "//*[.='Toptan Ürün Gösterme Ayarları']")
    public WebElement wholeProductDisplay;

@FindBy (xpath = "//*[.='Advanced']")
    public WebElement advanced;


}
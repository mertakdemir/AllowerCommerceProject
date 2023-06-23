package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class StoreManagerPage {
    public StoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement products;

    @FindBy(xpath = "//select[@id='dropdown_product_type']")
    public WebElement allProductTypes;

    @FindBy(id = "add_new_product_dashboard")
    public WebElement addNewButton;

    @FindBy(id = "product_type")
    public WebElement productDropdown;

    @FindBy(id = "product_url")
    public WebElement productUrl;

    @FindBy(id = "button_text")
    public WebElement buttonText;

    @FindBy(id = "regular_price")
    public WebElement price;

    @FindBy(id = "sale_price")
    public WebElement salePrice;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement submitButton;

    @FindBy(id = "pro_title")
    public WebElement productTitle;








}

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






}

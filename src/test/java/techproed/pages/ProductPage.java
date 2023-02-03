package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ProductPage {
    public ProductPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-btn alert-success']")
    public WebElement addToCartMessage;

    @FindBy(xpath = "//a[@class='btn btn-success btn-md']")
    public WebElement viewCart;




}

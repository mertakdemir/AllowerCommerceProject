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

    @FindBy(xpath = "//a[.='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//span[@class='cart-count']")
    public WebElement quantity;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement quantityplus;

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCart;

    @FindBy(id = "payment")
    public WebElement paymentMethod;

    @FindBy(partialLinkText = "Proceed to checkout")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@class='woocommerce-billing-fields__field-wrapper row gutter-sm']")
    public WebElement billingDetails;



}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    @FindBy(xpath = "//div//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@class='woocommerce-billing-fields__field-wrapper row gutter-sm']")
    public WebElement billingDetails;

    @FindBy(xpath = "(//input[@class='input-text '])[4]")
    public WebElement billingAdress;

    @FindBy(xpath = "(//input[@class='input-text '])[1]")
    public WebElement firstName;

    @FindBy(xpath = "(//input[@class='input-text '])[2]")
    public WebElement lastName;

    @FindBy(xpath = "//span//span[@id='select2-billing_country-container']")
    public WebElement country;

    @FindBy(xpath = "(//input[@class='input-text '])[6]")
    public WebElement town;

    @FindBy(xpath = "(//input[@class='input-text '])[7]")
    public WebElement postcode;

    @FindBy(xpath = "(//input[@class='input-text '])[8]")
    public WebElement phone;

    @FindBy(xpath = "(//input[@class='input-text '])[9]")
    public WebElement email;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrder;

    @FindBy(xpath= "//i[@class='fas fa-check']")
    public WebElement thankyouMessage;






}

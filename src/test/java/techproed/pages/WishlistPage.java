package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class WishlistPage {

    public WishlistPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //div[@data-fragment-ref='13229']")
    public WebElement automaticCrusherFavorite;

    @FindBy(xpath = " //a[@data-product-id='13226']")
    public WebElement electricRiceCooker;

    @FindBy(xpath = " //a[@data-product-id='13228']")
    public WebElement electricFryingPan;

    @FindBy(xpath = " //a[@data-product-id='14000']")
    public WebElement pusula;

    @FindBy(xpath ="//span[.='Wishlist']")
    public WebElement wishListIcon;


    @FindBy(xpath = " (//td[@class='product-thumbnail'])[1]")
    public WebElement pusulaProduct;

    @FindBy(xpath = " (//td[@class='product-thumbnail'])[2]")
    public WebElement fryingPanProduct;

    @FindBy(xpath = " (//td[@class='product-thumbnail'])[3]")
    public WebElement riceCookerProduct;

    @FindBy(xpath = " ((//div[@data-product-id='13229'])[2]")
    public WebElement crusherProduct;


    @FindBy(xpath = " (//div[@data-product-id='13229'])[2]")
    public WebElement crusherProductHover;

    @FindBy(xpath = " //a[@data-original-product-id='13206']")
    public WebElement mensClothing;

    @FindBy(xpath = " //div[@data-product-id='13780']")
    public WebElement urun1;

    @FindBy(id = "menu-item-12987")
    public WebElement womenButton;

    @FindBy(xpath = "//div[@data-product-id='14661']")
    public WebElement kadinTrikoKazak;

    @FindBy(xpath = "//a[@data-original-product-id='14661']")
    public WebElement kadinTrikoKazakFavoriteSign;

    @FindBy(xpath = "//a[@data-original-product-id='13229']")
    public WebElement crusherFavoriteSign;

     @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement wishListTable;

     @FindBy(xpath = "//button[@data-product='13206']")
    public WebElement mensClothingQuickView;
    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement mensClothingViewClose;
    @FindBy(xpath = "//button[@data-product='14661']")
    public WebElement kadinTrikoQuickView;

    @FindBy(xpath = "//button[@class='mfp-close']")
    public WebElement kadinTrikoViewClose;
    @FindBy(xpath = "(//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[2]")
    public WebElement kadinTrikoAddToCart;



    @FindBy(xpath = "(//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt'])[1]")
    public WebElement mensClothingAddToCart;

    @FindBy(xpath = "//i[@class='w-icon-cart']")
    public WebElement addToCartIcon;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkOutButton;


    @FindBy(name = "woocommerce_checkout_place_order")
    public WebElement placeOrderButton;


    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    public WebElement thankYouMessage;



}

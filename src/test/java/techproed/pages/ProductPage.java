package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class ProductPage {
        public ProductPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(className = "product-media")
        public List<WebElement> productsList;

        @FindBy(className = "no-product")
        public WebElement noProduct;

        @FindBy(xpath = "//*[text()='Add to cart']")
        public List<WebElement> addToCart;

}

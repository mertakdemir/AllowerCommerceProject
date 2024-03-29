package techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ShippingAddressPage {

    public ShippingAddressPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "shipping_first_name")
    public WebElement firstNameInput;

    @FindBy(id = "shipping_last_name")
    public WebElement lastNameInput;

    @FindBy(id = "shipping_company")
    public WebElement companyNameInput;

    @FindBy(id = "shipping_country")
    public WebElement countryDropdown;

    @FindBy(id = "shipping_address_1")
    public WebElement adressHouseNumberAndStreetNameInput;

    @FindBy(id = "shipping_address_2")
    public WebElement addressApartmentOrSuiteInput;

    @FindBy(id = "shipping_city")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='shipping_state']")
    public WebElement stateDropdown;

    @FindBy(id = "shipping_postcode")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//button[.='Save address']")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//a[.='Edit Your Shipping Address']")
    public WebElement editYourShippingAddressText;

    @FindBy(xpath = "//li[@data-id='shipping_first_name']")
    public WebElement warningForFirstName;

    @FindBy(xpath = "//li[@data-id='shipping_last_name']")
    public WebElement warningForLastName;

    @FindBy(xpath = "//li[@data-id='shipping_address_1']")
    public WebElement warningForStreetName;

    @FindBy(xpath = "//li[@data-id='shipping_city']")
    public WebElement warningForCityName;

    @FindBy(xpath = "//li[@data-id='shipping_postcode']")
    public WebElement warningForZipCode;

    //=============zeynep=============

    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement stateInput;

    @FindBy(xpath = "//div/*[text()='Edit Your Shipping Address']")
    public WebElement editShippingAddress;

    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    public WebElement errorMessages;

    @FindBy(xpath = "//i[@class='fas fa-exclamation-triangle']")
    public WebElement errorCountryMessage;
}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BillingAddressPage {

    public BillingAddressPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement firstName;


    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement lastName;
////*[@id='billing_country']
//    @FindBy(xpath = "(//*[text()='Select a country / region…'])[1]")
//    public WebElement countryOrRegion;

    @FindBy(id = "billing_country")
  public WebElement countryOrRegion;



    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement streetAddress;



    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement townOrCity;


    @FindBy(id= "billing_state")
    public WebElement stateOrCountry;

//"//span[@id='select2-billing_state-container']"

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement postcodeOrZipCode;


    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement phone;


    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement saveAddressButton;

    @FindBy(xpath = "//*[text()='Edit Your Billing Address']")
    public WebElement editYourBillingAddress;





}

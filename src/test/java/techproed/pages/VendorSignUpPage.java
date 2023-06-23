package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class VendorSignUpPage {
    public VendorSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[@class='nav-link']")
    public WebElement signupIcon;

    @FindBy(xpath = "//div[@class='wcfmmp_become_vendor_link']//a")
    public WebElement becomeVendorButton;
    //div.wcfmmp_become_vendor_link
    @FindBy(id = "user_email")
    public WebElement emailInput;

    @FindBy(name = "wcfm_email_verified_input")
    public WebElement verificationCode;

    @FindBy(id = "passoword")
    public WebElement passwordInput;

    @FindBy(id = "confirm_pwd")
    public WebElement confirmPwdInput;

    @FindBy(id="wcfm_membership_register_button")
    public WebElement registerButton;

////*[@id="wcfm_membership_registration_form"]/div[3]/text()
    @FindBy(xpath = "//*[ text() = 'This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement errorMessage;


//=========================zeynep===========
    @FindBy(xpath = "//a[.='Signup as a vendor?']")
    public WebElement signupVendorLink;














   @FindBy(id = "password_strength")
    public WebElement chartLevel;




}

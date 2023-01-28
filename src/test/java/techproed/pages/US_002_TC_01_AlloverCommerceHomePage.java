package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class US_002_TC_01_AlloverCommerceHomePage {
    public US_002_TC_01_AlloverCommerceHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Register")
    public WebElement registerIcon;

    @FindBy(id = "reg_username")
    public WebElement usernameInput;

    @FindBy(id = "reg_email")
    public WebElement emailInput;

    @FindBy(id = "reg_password")
    public WebElement passwordInput;

    @FindBy(id = "register-policy")
    public  WebElement privatePolicy;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement signupButton;

    @FindBy(xpath = "//*[ text() ='An account is already registered with your email address. ']")
    public WebElement existentAccount;

}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class SignInPage {




    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "reg_username")
    public WebElement username;

    @FindBy(id = "reg_email")
    public WebElement email;

    @FindBy(id = "reg_password")
    public WebElement password;

    @FindBy(id = "register-policy")
    public WebElement agreeThePolicy;

    @FindBy(xpath = "//button[.='Sign Up']")
    public WebElement signUpButton;




}

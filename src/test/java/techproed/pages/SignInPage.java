package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class SignInPage {




    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "reg_username") //It supposed to be on register page, because there is no option as "username" in sign in part.
    public WebElement username;  //But DO NOT TOUCH IT. Because it will affect the whole project.

    @FindBy(id = "reg_email")
    public WebElement email;

    @FindBy(id = "reg_password")
    public WebElement password;

    @FindBy(id = "register-policy")
    public WebElement agreeThePolicy;

    @FindBy(xpath = "//button[.='Sign Up']")//It supposed to be on register page, because there is no option as "signUp" in sign in part.
    public WebElement signUpButton;//But DO NOT TOUCH IT. Because it will affect the whole project.




}

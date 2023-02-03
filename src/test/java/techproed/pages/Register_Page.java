package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Register_Page {

    public Register_Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "reg_username")
    public WebElement userName;

    @FindBy(id = "reg_email")
    public WebElement yourEmailAddress;

    @FindBy(id = "reg_password")
    public WebElement password;

    @FindBy(id = "register-policy")
    public WebElement checkBoxPolicy;

    @FindBy(name = "register")
    public WebElement SignUpButton;

   //========zeynep==========

    @FindBy(name = "register")
    public WebElement signUpButton;



}

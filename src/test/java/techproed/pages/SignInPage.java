package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class SignInPage {
    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username'][1]")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password'][1]")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButton2;
}

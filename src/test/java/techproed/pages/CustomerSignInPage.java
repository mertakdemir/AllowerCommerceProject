package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CustomerSignInPage {

    public CustomerSignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "(//button[text()='Sign In'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[1]")
    public WebElement signInStatus;
}


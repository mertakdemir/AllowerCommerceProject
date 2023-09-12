package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AccountDetailsPage {
    public AccountDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h4[.='Account Details']")
    public WebElement title;

    @FindBy(name = "account_first_name")
    public WebElement accountFirstName;

    @FindBy(name = "account_last_name")
    public WebElement accountLastName;

    @FindBy(name = "account_display_name")
    public WebElement accountDisplayName;

    @FindBy(name = "account_email")
    public WebElement accountEmail;

    @FindBy(id = "tinymce")
    public WebElement biographySection;

    @FindBy(name = "password_current")
    public WebElement passwordCurrent;

    @FindBy(name = "password_1")
    public WebElement passwordNew;

    @FindBy(name = "password_2")
    public WebElement passwordConfirm;

    @FindBy(name = "save_account_details")
    public WebElement saveChangesButton;
}

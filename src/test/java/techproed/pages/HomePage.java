package techproed.pages;


<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
=======
>>>>>>> master
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


<<<<<<< HEAD
=======


>>>>>>> master
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {

<<<<<<< HEAD
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInButton1;
=======
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchBox;

>>>>>>> master

    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccountButton;


<<<<<<< HEAD
}

=======




    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;


    }
>>>>>>> master






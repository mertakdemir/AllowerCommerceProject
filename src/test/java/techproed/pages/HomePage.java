package techproed.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;







import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInButton1;









    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchBox;









    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccountButton;
















    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//div[@data-id='0ceec07']")
    public WebElement homeLogo;


    //div[@data-id='0ceec07']

    }












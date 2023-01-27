package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class US_001_TC_001_Home_Page {

    public US_001_TC_001_Home_Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement homePageRegisterButton;
}

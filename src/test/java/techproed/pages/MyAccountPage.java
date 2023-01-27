package techproed.pages;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MyAccountPage {




    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//h4[.='Account Details']")
    public WebElement title;



    @FindBy(xpath = "//p[.='Addresses']")
    public WebElement addressesButton;

    @FindBy(xpath = "(//a[.='Add'])[2]")
    public WebElement addShippingAddressButton;

}

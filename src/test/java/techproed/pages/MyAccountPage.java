package techproed.pages;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class
MyAccountPage {




    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//p[.='Addresses']")
    public WebElement addressesButton;

    @FindBy(xpath = "(//a[.='Add'])[2]")
    public WebElement addShippingAddressButton;


    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetailsButton;

    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addBillingAddress;

    @FindBy(xpath = "//p[.='Orders']")
    public WebElement ordersOption;

    @FindBy(xpath = "//p[.='Downloads']")
    public WebElement downloadOption;

    @FindBy(xpath = "//p[.='Account details']")
    public WebElement accountDetailsOption;

    @FindBy(xpath = "//p[.='Wishlist']")
    public WebElement wishListOption;

    @FindBy(xpath = "//p[.='Logout']")
    public WebElement logOutOption;

    @FindBy(xpath = "//div[@class='icon-box text-center']")
    public List<WebElement> options;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManagerDashboard;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement ordersDashboard;

    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement downloadDashboard;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressDashboard;

    @FindBy(xpath = "(//a[.='Wishlist'])[1]")
    public WebElement wishListDashboard;

    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement supportTicketDashboard;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement followingsDashboard;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutDashboard;

    @FindBy(xpath = "//*[.='Sign Out']")
    public WebElement signOutButton;

}

package techproed.pages;

import org.checkerframework.checker.formatter.qual.Format;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class VendorProductPage {
    public VendorProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    //StoreManagerVerify
 @FindBy (xpath = "//h2[@class='page-title']")
 public WebElement storeManagerTitle;
//ADD NEW
  @FindBy (xpath = "//span[.='Add New']  ")
public WebElement addNew;
//SELECT PRODUCT TYPE
  @FindBy (id = "product_type")
    public WebElement selectProductType;
//ISVIRTUAL
  @FindBy (id = "is_virtual")
    public WebElement isVirtual;
//PRODUCT TYPE
  @FindBy (id = "pro_title")
 public WebElement productTitle;
  //RegularPrice
 @FindBy(id = "regular_price")
 public WebElement regularPrice;
//Sale Price
 @FindBy (id = "sale_price")
  public WebElement salePrice;
 //Short Description Add Media
 @FindBy(xpath = "//button[@id='insert-media-button'][@data-editor='excerpt']")
 public WebElement shortDescriptionAddMedia;

//IFRAMES
@FindBy(id = "excerpt_ifr")
public WebElement iframe1;
@FindBy(id = "description_ifr")
public WebElement iframe2;
//ShortDescriptionMediaLibrary
 @FindBy(xpath = "(//*[.='Media Library'])[3]")
 public WebElement mediaLibraryShortDescription ;
//Media Library Short Description Media
 @FindBy(xpath = "(//li[@aria-label='Mock up screen phone.'])[3]")
 public WebElement selectShortDescriptionPicture;
//Insert Into Post Short DescriptionMEdia
@FindBy(xpath = "//div[@class='media-toolbar-primary search-form'][.='Insert into post']")
public WebElement insertIntoPost;

//Add Description Media
@FindBy (xpath = "//button[@class='button insert-media add_media'][@data-editor='description']")
public WebElement addDescriptionMedia;
@FindBy (xpath = "(//button[@id='menu-item-browse'])[4]")
    public WebElement descriptionMediaLibrary;
@FindBy (xpath = "(//li[@data-id='19630'])[4]")
    public WebElement  selectDescriptionPicture;
@FindBy (xpath = "(//*[.='Insert into post'])[4]")
    public WebElement insertIntoPost2;

//uploadselectfiles1
    @FindBy(xpath = "//button[@class='media-menu-item active'][.='Upload files']")
    public WebElement uploadShortDescriptionFileLink;
@FindBy(xpath = "//button[@id='__wp-uploader-id-1'][.='Select Files'] ")
    public WebElement uploadLinkShortDescription;
//ADD MEDIA SECOND FRAME
    @FindBy(xpath = "//div[@id='__wp-uploader-id-0']//*[@id='media-frame-title']")
    public WebElement frame2AddFile;

    //CATEGORIES
@FindBy (xpath = "//*[@name='product_cats[]']")
    public List<WebElement> checkBoxItems;

@FindBy (xpath= "//div[@class='wcfm_product_manager_cats_checklist_fields']")
    public WebElement checkBoxFields;
@FindBy (xpath = "//input[@value='230']")
    public WebElement electronics;

//FeaturedDisplay
 @FindBy  (xpath = "//*[@id='featured_img_display']")
    public WebElement featuredDisplayPicture;
    @FindBy(xpath ="(//*[@id='menu-item-upload'])[2]" )
    public WebElement uploadFiles;
 @FindBy(xpath = "(//button[.='Select Files'])[2]")
    public WebElement selectFilesFeaturedDisplay;

 @FindBy(xpath = "//button[@id='menu-item-browse'][.='Media Library']")
    public WebElement featuredDisplayMediaLibrary;
@FindBy (xpath = "//li[@aria-label='2']")
    public WebElement featuredDisplayPictureSelect;
@FindBy(xpath = "//button[@type='button'][.='Select']")
public WebElement featuredDisplaySelect;

@FindBy (xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement miniDisplayPicture;

@FindBy(xpath ="(//*[.='Media Library'])[2]")
    public WebElement miniMediaLib;

@FindBy(xpath = "(//li[@tabindex=0][@aria-label='phone6'])[2]")
    public WebElement phonePic;

@FindBy(xpath = "(//button[.='Add to Gallery'])[2]")
    public WebElement miniAddToGallery;
///////////////////////////////PRODUCT MANAGE PAGE\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////Inventory\\\\\\\\\\\
    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement inventory;
    @FindBy(id = "sku")
    public WebElement sku;
    @FindBy (id = "manage_stock")
    public WebElement manageStockCheck;
@FindBy (id = "stock_status")
    public WebElement stockStatus;
@FindBy(id = "stock_qty")
public WebElement stockQuantity;
@FindBy (id = "sold_individually")
    public WebElement soldIndividually;

@FindBy (id = "backorders")
    public WebElement backOrders;
@FindBy (id = "wcfm_products_simple_submit_button")
    public WebElement submit;
}
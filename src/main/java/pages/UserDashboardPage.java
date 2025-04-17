package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelReader;
import utilities.JSUtilities;

import java.util.List;





public class UserDashboardPage extends BasePage {


 public UserDashboardPage(WebDriver driver) {
  super(driver);
 }

 ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");



































































































































































































































































































































































































    //Dachboard/login butonu locati
    @FindBy(xpath = "(//*[@href='https://qa.buysellcycle.com/login'])[1]")
    public WebElement DashboardAsumanButton;

    //Dachboard/login butonu görünürlülügü icin "Sign in with Email or Phone" yazisi  locati
    @FindBy(xpath = "//*[@class='form_sep_text font_14 f_w_500 ']")
    public WebElement DashboardVisibilityButtonButton;

    //Dachboard/login butonu görünürlülügü icin  locati
    @FindBy(xpath = "(//*[@href='https://qa.buysellcycle.com/profile/dashboard'])[1]")
    public WebElement DashboardButton;

    //Dachboard/login E_Mail Butonu locati
    @FindBy(xpath = "//*[@*='text']")
    public WebElement DashboardE_MailButton;

    //Dachboard/login Passwort Butonu locati
    @FindBy(xpath = "//*[@*='password']")
    public WebElement DashboardPasswortButton;

    //Dachboard/login Sig In Butonu locati
    @FindBy(xpath = "//*[@id='sign_in_btn']")
    public WebElement DashboardSignInButton;

    //Dachboard/login "These credentials do not match our records "yazisi locati
    @FindBy(xpath = "(//span[@class='text-danger'])[2]")
    public WebElement DashboardErrorMessageButton;

    //Dachboard/login Dashboard sayfasi kullanici bilgileri locati(bak var burada)
    @FindBy(xpath = "//*[@class='customer-info-content d-flex align-items-center flex-wrap']")
    public WebElement DashboardUserProfileButton;

    //Dachboard/login Dashboard sayfasi kullanici Balance bilgileri locati
    @FindBy(xpath = "//*[@id='total_balance']")
    public WebElement DashboardProfileBalanceButton;

    //Dashboard/login Purchase History locati
    @FindBy(xpath = "(//*[@class='font_20 f_w_700 mb-0  flex-fill'])[1]")
    public WebElement DashboardPurchaseHistoryButton;

    //Dachboard/login My Wishlist locati
    @FindBy(xpath = "(//*[@class='font_20 f_w_700 mb-0  flex-fill'])[2]")
    public WebElement DashboardMyWishlistButton;

    //Dachboard/login Recent Order locati
    @FindBy(xpath = "(//*[@class='font_20 f_w_700 mb-0  flex-fill'])[3]")
    public WebElement DashboardRecentOrderButton;

    //Dachboard/login Product in Cart locati
    @FindBy(xpath = "(//*[@class='font_20 f_w_700 mb-0  flex-fill'])[4]")
    public WebElement DashboardProductInCartButton;











 @FindBy(xpath = "(//*[@class='position-relative d-flex align-items-center'])[2]")
 public WebElement dashboardSideBarMyWishlistButton;

 @FindBy(xpath = "(//*[@class='nice-select amaz_select4'])[2]")
 public WebElement dashboardMyWishlistNewButton;

 @FindBy(xpath = "(//*[text()='Price (Low to high)'])[2]")
 public WebElement dashboardMyWishlistPriceLowToHighButton;

 @FindBy(xpath = "(//a[@title='Add to Cart'])[6]")
 public WebElement dashboardMyWishlistSepetIkonu;

 @FindBy(id = "add_to_cart_btn_modal")
 public WebElement dashboardMyWishlistWishlistAddToCart;

 @FindBy(css = "div.add_cart_modalAdded h4")
 public WebElement dashboardMyWishlistWishlistAddToCartSuccessMessage;

 @FindBy(xpath = "(//button[@class='close_modal_icon'])[2]")
 public WebElement dashboardMyWishlistWishlistPopUpCloseButton;

 @FindBy(xpath = "//div[@class='chart_close']")
 public WebElement dashboardMyWishlistWishlistYanEkranCloseButton;

 @FindBy(xpath = "//span[text()='Next']")
 public WebElement dashboardMyWishListNextButton;

 @FindBy(xpath = "//span[text()='Prev']")
 public WebElement dashboardMyWishListPreviousButton;



 @FindBy(xpath = "(//*[@class='position-relative d-flex align-items-center '])[1]")
 public WebElement myWalletMenu;

 @FindBy(xpath = "//*[@class='singl_dashboard_wallet green_box d-flex align-items-center justify-content-center flex-column']")
 public WebElement runningBalanceBoard;

 @FindBy(xpath = "//*[@class='singl_dashboard_wallet pink_box d-flex align-items-center justify-content-center flex-column']")
 public WebElement pendingBalanceBoard;

 @FindBy(xpath = "(//*[.='Recharge Wallet'])[2]")
 public WebElement rechargeWalletButton;

 @FindBy(xpath = "//*[@id='recharge_amount']")
 public WebElement amountInput;

 @FindBy(xpath = "//*[@class='amaz_primary_btn style2 text-nowrap']")
 public WebElement addFundButton;

 @FindBy(xpath = "//*[@class='wallet_elemnt']")
 public WebElement stripeButton;

 @FindBy(xpath = "//*[@id='email']")
 public WebElement emailInput;

 @FindBy(xpath = "//*[@id='card_number']")
 public WebElement cardNumberInput;

 @FindBy(xpath = "//*[@id='cc-exp']")
 public WebElement cardExpireInput;

 @FindBy(xpath = "//*[@id='cc-csc']")
 public WebElement cardCvcInput;

 @FindBy(xpath = "//*[@id='submitButton']")
 public WebElement payButton;

 @FindBy(xpath = "//*[@class='table_border_whiteBox mb_30']")
 public WebElement walletRechargeHistoryTable;

 @FindBy(xpath = "//table[@class='table amazy_table style3 mb-0']//thead//tr//th")
 public List<WebElement> walletHistoryTableHeaders;

 @FindBy(xpath = "//*[@class='log_out']")
 public WebElement logoutButton;


 @FindBy(xpath = "//*[.='Cancel']")
 public WebElement cancelButton;

    @FindBy(xpath = "//a[@class='close right']")
    public WebElement closeButton;


 public void validStripePayment() {

  WebElement iframe = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
  driver.switchTo().frame(iframe);

  JSUtilities.setInputFieldWithJS(driver, emailInput, excelReader.getExcelText("Sheet1", 1, 0));
  JSUtilities.setInputFieldWithJS(driver, cardNumberInput, excelReader.getExcelText("Sheet4", 1, 0));
  JSUtilities.setInputFieldWithJS(driver, cardExpireInput, excelReader.getExcelText("Sheet4", 1, 1));
  JSUtilities.setInputFieldWithJS(driver, cardCvcInput, excelReader.getExcelText("Sheet4", 1, 2));
  payButton.click();
 }

 public void invalidStripePayment() {

  WebElement iframe = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
  driver.switchTo().frame(iframe);

  JSUtilities.setInputFieldWithJS(driver, emailInput, excelReader.getExcelText("Sheet1", 1, 0));
  JSUtilities.setInputFieldWithJS(driver, cardNumberInput, excelReader.getExcelText("Sheet5", 1, 0));
  JSUtilities.setInputFieldWithJS(driver, cardExpireInput, excelReader.getExcelText("Sheet5", 1, 1));
  JSUtilities.setInputFieldWithJS(driver, cardCvcInput, excelReader.getExcelText("Sheet5", 1, 2));
  payButton.click();

 }







}










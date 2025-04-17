package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelReader;





public class HomeFooterPage extends  BasePage {

    public HomeFooterPage(WebDriver driver) {
        super(driver);
    }

    ExcelReader excelReader = new ExcelReader("src/test/resources/TestData.xlsx");

    @FindBy(xpath = "//footer//a[contains(text(),'About Us')]")
    public WebElement aboutUsLink;

    @FindBy(xpath = "//footer//a[text()='Blog']")
    public WebElement blogLink;

    @FindBy(xpath = "//footer//a[contains(@href, '/profile/dashboard')]")
    public WebElement dashboardLink;

    @FindBy(xpath = "//footer//a[contains(@href, '/profile')]")
    public WebElement myProfileLink;

    @FindBy(id = "subscription_email_id")
    public WebElement newsletterInput;

    @FindBy(id = "subscribeBtn")
    public WebElement subscribeButton;

    @FindBy(xpath = "//div[contains(@class,'message_div') and not(contains(@class,'d-none'))]")
    public WebElement subscriptionMessage;

    @FindBy(xpath = "//a[contains(@href, 'play.google.com')]")
    public WebElement googlePlayIcon;

    @FindBy(xpath = "//a[contains(@href, 'apple.com')]")
    public WebElement appStoreIcon;

    @FindBy(xpath = "//footer//a[contains(@href, 'facebook.com')]")
    public WebElement facebookIcon;

    @FindBy(xpath = "//div[contains(text(),'Copyright')]")
    public WebElement copyrightText;

    @FindBy(xpath = "//a[contains(@class,'scroll-top')]")
    public WebElement backToTopButton;

    @FindBy(xpath = "//footer")  //
    public WebElement footerContainer;

    @FindBy(xpath = "//*[@class='text-success']")
    public WebElement successMessage;







}



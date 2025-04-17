package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.HomeCategoriesPage;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_015and036Step  {

    private static final Logger logger = LogManager.getLogger();
    WebDriver driver = Hooks.getDriver();
    HomeCategoriesPage homeCategoriesPage = new HomeCategoriesPage(driver);

    @When("The user clicks on the All Categories Link")
    public void the_user_clicks_on_the_all_categories_link() {

        homeCategoriesPage.click(homeCategoriesPage.allCategoriesButton);

    }
    @When("The user hovers over the Electronics menu item.")
    public void the_user_hovers_over_the_electronics_menu_item() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.electronicsMenu).perform();
    }

    @Then("The Electronics category widget is displayed in the body section of the homepage.")
    public void the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage() {

        Assert.assertTrue(homeCategoriesPage.mobilPhoneMenu.isDisplayed());
    }

    @Then("Subcategories of the Electronics category widget is displayed in the body section of the homepage.")
    public void subcategories_of_the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage() {
        WebElement telephoneCategory = driver.findElement(By.xpath("//*[text()='Telephone']"));
        Assert.assertTrue(telephoneCategory.isDisplayed());
    }

    @Then("{string} of the Electronics category widget is displayed in the body section of the homepage.")
    public void of_the_electronics_category_widget_is_displayed_in_the_body_section_of_the_homepage(String subCategory) {
        String path = "//*[text()='" + subCategory + "']";
        WebElement category = driver.findElement(By.xpath(path));
        Assert.assertTrue(category.isDisplayed());
    }

    @When("The user clicks on the {string} subcategory link")
    public void the_user_clicks_on_the_subcategory_link(String subCategory) {
        String path = "//*[text()='" + subCategory + "']";
        WebElement category = driver.findElement(By.xpath(path));
        category.click();
    }

    @Then("The {string} subcategory links to the relevant page with appropriate content")
    public void the_subcategory_links_to_the_relevant_page_with_appropriate_content(String subCategory) {

        String categoryText = homeCategoriesPage.subCategoryName.getText();
        Assert.assertEquals(subCategory.toUpperCase(), categoryText);
    }

    @Then("The user verifies that Add to Cart icon is clickable")
    public void the_user_verifies_that_add_to_cart_icon_is_clickable() {

    }
    @Then("The user clicks on the Add to Cart icon")
    public void the_user_clicks_on_the_add_to_cart_icon() {

        WebElement addToCartIcon = driver.findElement(By.xpath("(//*[@title = 'Add to Cart'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartIcon).perform();
        addToCartIcon.click();

        ReusableMethods.wait(3);


    }

    @Then("The user verifies that a confirmation message indicating that the product is added to cart is displayed.")
    public void the_user_verifies_that_a_confirmation_message_indicating_that_the_product_is_added_to_cart_is_displayed() {

        Assert.assertTrue(homeCategoriesPage.itemAddedConfirmationElement.isDisplayed());

    }
    @When("The user clicks on the View Cart button")
    public void the_user_clicks_on_the_view_cart_button() {

        homeCategoriesPage.click(homeCategoriesPage.viewCartButton);

    }

    @Then("The user is navigated to the Cart page.")
    public void the_user_is_navigated_to_the_cart_page() {

        String expectedUrl = "https://qa.buysellcycle.com/cart";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Then("The user verifies that Compare icon is displayed")
    public void the_user_verifies_that_compare_icon_is_displayed() {

        Assert.assertTrue(homeCategoriesPage.compareIcon.isDisplayed());

    }
    /*@Then("The user clicks on the Compare icon")
    public void the_user_clicks_on_the_compare_icon() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.firstProductCard).perform();
        homeCategoriesPage.click(homeCategoriesPage.compareIcon);

    }*/

    @Then("The user verifies and clicks on the compare icon of the first product")
    public void the_user_verifies_and_clicks_on_the_compare_icon_of_the_first_product() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.firstProductCard).perform();

        Assert.assertTrue(homeCategoriesPage.compareIcon.isDisplayed());
        homeCategoriesPage.click(homeCategoriesPage.compareIcon);

    }
    @Then("The user verifies and clicks on the compare icon of the second product")
    public void the_user_verifies_and_clicks_on_the_compare_icon_of_the_second_product() {

        Actions actions = new Actions(driver);
        actions.moveToElement(homeCategoriesPage.secondProductCard).perform();

        Assert.assertTrue(homeCategoriesPage.compareIcon2.isDisplayed());
        homeCategoriesPage.click(homeCategoriesPage.compareIcon2);
    }

    @Then("The user verifies that a confirmation message indicating that the product is added to compare list is displayed.")
    public void the_user_verifies_that_a_confirmation_message_indicating_that_the_product_is_added_to_compare_list_is_displayed() {

        // compare kismina eklendi mesaji

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".toast-message")
        ));

        System.out.println(toastMessage.getText());
        Assert.assertTrue("Toast mesajı görünmüyor!", toastMessage.isDisplayed());
        Assert.assertTrue(toastMessage.getText().contains("Product added to compare list successfully"));

    }

    @When("The user clicks on the Compare link on the homepage")
    public void the_user_clicks_on_the_compare_link_on_the_homepage() {


    }
    @Then("The user is navigated to the Compare page")
    public void the_user_is_navigated_to_the_compare_page() {

    }












}

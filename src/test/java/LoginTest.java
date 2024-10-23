import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

// This annotation is used to specify that the ExtentTestNGITestListener class should be used to listen to the test events.
// The listener will generate reports based on the test results using the ExtentReports library.
@Listeners(ExtentTestNGITestListener.class)

// Declaring the CheckoutTest class, which extends the Hooks class.
// By extending Hooks, CheckoutTest inherits the setup and teardown methods for WebDriver.
public class LoginTest extends Hooks {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    // Declaring a public variable of type CheckoutPage named 'checkoutPage'.
    // This will be used to interact with the CheckoutPage object during the tests.
    public LoginPage loginPage;

    // Declaring a public variable of type WebDriverWait named 'wait'.
    // WebDriverWait is used to explicitly wait for certain conditions or elements during test execution.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Method annotated with @BeforeMethod, indicating that it will run before each test method.
    // This method is used to set up the page objects and other necessary components before each test.
    @BeforeMethod
    public void SetupPageObject() {

        // Initializing the checkoutPage object with the current WebDriver instance.
        // This allows the test methods to interact with elements on the checkout page.
        loginPage = new LoginPage(driver);

        // Initializing the WebDriverWait object with the current WebDriver instance and a timeout of 30 seconds.
        // This wait will be used to pause the execution until certain conditions are met or elements are found.
        wait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
    }

    @Test(description = "Login test")
    public void loginTest() throws InterruptedException {
        loginPage.loginUser();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserLoggedIn()));
//        Thread.sleep(5000);
        assertEquals(loginPage.getUserLoggedIn().getText(), "dino");
    }

    @Test(description = "Sorting test")
    public void sortTest() throws InterruptedException {
        List<WebElement> productElements = loginPage.getProductElements();
        List<String> actualProductNames = new ArrayList<>();
        loginPage.selectOption(loginPage.getSortBar(), "Sort by price (low to high)");
        Thread.sleep(5000);
        for(WebElement productElement : productElements) {
            actualProductNames.add(productElement.getText());
        }

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Comparator.reverseOrder());

        Assert.assertEquals(actualProductNames, expectedProductNames, "The products are not sorted in reverse alphabetical order");
    }

    @Test(description = "login to HAIVE")
    public void loginToHaive() {
        loginPage.clickAuthentificate();
        wait.until(ExpectedConditions.visibilityOf(loginPage.onLoginPage()));
        assertEquals(loginPage.onLoginPage().getText(), "Autentificare");
        loginPage.setEmail();
        loginPage.setPassword();
        loginPage.clickSecondAuthentificate();
        wait.until(ExpectedConditions.visibilityOf(loginPage.onDashboard()));
        assertEquals(loginPage.onDashboard().getText(), "Vedeți cum merge afacerea dvs");
    }

    @Test(description = "Add a location in HAIVE")
    public void addLocation() throws InterruptedException {
        loginPage.loginToHaive();
        loginPage.clickOnLocationsTab();
        wait.until(ExpectedConditions.visibilityOf(loginPage.waitTextBeforeCreatingLocations()));
        loginPage.clickOnCreateLocation();
        wait.until(ExpectedConditions.visibilityOf(loginPage.waitTextAfterCreatingLocations()));
//        Thread.sleep(2000);
        loginPage.sendKeysWhenReady(loginPage.getName(), "Best of Town");
//        loginPage.insertLocationName();
        loginPage.insertLocationAddress();
        loginPage.insertLocationCity();
        loginPage.insertLocationPostcode();
//        wait.until(ExpectedConditions.visibilityOf(loginPage.getLocationButton()));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(580, 2800);");
        Thread.sleep(5000);
        loginPage.clickOnButtonCreateLocation();
//        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getNameOfLocation()));
        Thread.sleep(3000);
        assertEquals(loginPage.getNameOfLocation().getText(), "Best of Town");
    }

    @Test(description = "Log out from HAIVE")
    public void logoutFromHaive() throws InterruptedException {
        loginPage.loginToHaive();
        loginPage.clickLogoutIcon();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLogoutButton()));
        loginPage.clickLogoutButton();
    }

    @Test(description = "Working with dashboard")
    public void dashboard() throws InterruptedException {
        loginPage.loginToHaive();
//        wait.until(ExpectedConditions.visibilityOf(loginPage.getDate()));
//        loginPage.clickDate();
        loginPage.clickWhenReady(loginPage.getDate());
        loginPage.clickPreviousMonth();
        loginPage.clickDay1();
        loginPage.clickDay3();
    }

    @Test(description = "Adding a menu in Haive")
    public void addingMenu() throws InterruptedException {
        loginPage.loginToHaive();
        loginPage.clickMenuTab();
        Thread.sleep(2000);
        loginPage.clickCreateMenuFirstButton();
        loginPage.insertMenuName();
        loginPage.clickCreateMenuSecondButton();
        Thread.sleep(3000);
    }

    @Test(description = "Adding a category to menu and deleting it")
    public void addingCategoryToMenu() throws InterruptedException {
        loginPage.loginToHaive();
        loginPage.clickMenuTab();
        Thread.sleep(3000);
        loginPage.clickBurgersButton();
        Thread.sleep(3000);
        loginPage.clickNewCategory();
        loginPage.insertCategoryName();
        loginPage.clickCreateCategoryButton();
        Thread.sleep(3000);
        loginPage.clickDeleteCategoryButton();
        Thread.sleep(3000);
    }

    @Test(description = "Deactivating transparent button")
    public void deactivatingTransparentButton() throws InterruptedException {
        loginPage.clickTransparentButton();
        Thread.sleep(3000);
    }
}


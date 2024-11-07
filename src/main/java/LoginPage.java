import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;


// Declaring the CheckoutPage class, which extends the BasePage class.
// By extending BasePage, CheckoutPage inherits the WebDriver instance and the PageFactory initialization.
public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    // Declaring a public WebDriverWait variable named 'wait'.
    // WebDriverWait is used for implementing explicit waits during interactions with web elements.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Constructor for the CheckoutPage class that takes a WebDriver object as an argument.
    // This constructor calls the parent class (BasePage) constructor to initialize the WebDriver instance
    // and sets up the PageFactory to initialize the web elements on this page.
    public LoginPage(WebDriver driver) {
        // Calling the parent class (BasePage) constructor using 'super' to initialize the WebDriver.
        super(driver);

        // Initializing the WebDriverWait object with a 10-second timeout.
        // This will be used to wait for certain conditions or elements during test execution.
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
    }

    // Locating the search bar element using the @FindBy annotation.
    // @FindBy is a Selenium annotation that helps locate elements on the web page.
    // Here, the element is being located by its 'id' attribute with the value "input-search".
    // Declare the WebElement as private to enforce encapsulation
    // This ensures that 'searchBar' cannot be accessed directly from outside this class

    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16 ")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(id = "user-name")
    private WebElement username;

    public void setUsername() {
        username.sendKeys("dino");
    }

    @FindBy(id = "password")
    private WebElement password1;

    public void setPassword1() {
        password1.sendKeys("choochoo");
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement logButton;

    public void clickLogButton() {
        logButton.click();
    }

    @FindBy(linkText = "dino")
    private WebElement userLoggedIn;

    public WebElement getUserLoggedIn() {
        return userLoggedIn;
    }

    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement resetButton;

    public void clickResetButton() {
        resetButton.click();
    }

    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortBar;

    public WebElement getSortBar() {
        return sortBar;
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    public void loginUser() {
        clickLoginButton();
        setUsername();
        setPassword1();
        clickLogButton();
    }

    @FindBy(css = ".card-link")
    private List<WebElement> productElements;

    public List<WebElement> getProductElements() {
        return productElements;
    }

    @FindBy(css = ".card-text")
    private List<WebElement> priceElements;

    public List<WebElement> getPriceElements() {
        return priceElements;
    }

    //login to HAIVE
    @FindBy(xpath = "//input[contains(@type, 'email')]")
    private WebElement email;

    public void setEmail() {
        email.sendKeys("beny.cazac.u@gmail.com");
    }

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    private WebElement password;

    public void setPassword() {
        password.sendKeys("wearehaive");
    }

    @FindBy(linkText = "Autentificare")
    private WebElement authentification;

    public void clickAuthentificate() {
        authentification.click();
    }

    @FindBy(xpath = "//button[contains(@class, 'h-11 rounded-md px-8 w-full')]")
    private WebElement secondAuthentification;

    public void clickSecondAuthentificate() {
        secondAuthentification.click();
    }

    @FindBy(css = ".text-2xl.font-semibold.tracking-tight")
    private WebElement textOnLoginPage;

    public WebElement onLoginPage() {
        return textOnLoginPage;
    }

    @FindBy(xpath = "//*[@class = 'text-lg text-muted-foreground']")
    private WebElement dashboard;

    public WebElement onDashboard() {
        return dashboard;
    }

    //    @FindBy(xpath = "(//*[contains(@class, 'group flex items-center')])[2]")
    @FindBy(linkText = "Locații")
    private WebElement locations;

    public void clickOnLocationsTab() {
        locations.click();
    }

    @FindBy(linkText = "Creați locație")
    private WebElement createLocation;

    public void clickOnCreateLocation() {
        createLocation.click();
    }

    @FindBy(css = ".mt-6.text-xl.font-semibold")
    private WebElement waitText1;

    public WebElement waitTextBeforeCreatingLocations() {
        return waitText1;
    }

    @FindBy(css = ".text-lg.text-muted-foreground")
    private WebElement waitText2;

    public WebElement waitTextAfterCreatingLocations() {
        return waitText2;
    }

    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement locationName;

    public WebElement getName() {
        return locationName;
    }

    public void insertLocationName() {
        locationName.sendKeys("Best of Town");
    }

    @FindBy(xpath = "//input[@name = 'address']")
    private WebElement locationAddress;

    public void insertLocationAddress() {
        locationAddress.sendKeys("Bulevardul George Enescu, nr. 48");
    }

    @FindBy(xpath = "//input[@name = 'city']")
    private WebElement locationCity;

    public void insertLocationCity() {
        locationCity.sendKeys("Suceava");
    }

    @FindBy(xpath = "//input[@name = 'postcode']")
    private WebElement locationPostcode;

    public void insertLocationPostcode() {
        locationPostcode.sendKeys("450897");
    }

    @FindBy(xpath = "//button[text()='Creați locația']")
    private WebElement createLocationButton;

    public void clickOnButtonCreateLocation() {
        createLocationButton.click();
    }

    public WebElement getLocationButton() {
        return createLocationButton;
    }

    @FindBy(id = "date")
    private WebElement datePicker;

    public void clickDate() {
        datePicker.click();
    }

    public WebElement getDate() {
        return datePicker;
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void sendKeysWhenReady(WebElement locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(text);
    }

    @FindBy(xpath = "(//*[@name= 'day' and text() = '1'])[1]")
    private WebElement day1;

    public void clickDay1() {
        day1.click();
    }

    @FindBy(xpath = "(//*[@name= 'day' and text() = '3'])[1]")
    private WebElement day3;

    public void clickDay3() {
        day3.click();
    }

    @FindBy(name = "previous-month")
    private WebElement previousMonth;

    public void clickPreviousMonth() {
        previousMonth.click();
    }

    public void loginToHaive() {
        clickAuthentificate();
        wait.until(ExpectedConditions.visibilityOf(onLoginPage()));
        assertEquals(onLoginPage().getText(), "Autentificare");
        setEmail();
        setPassword();
        clickSecondAuthentificate();
        wait.until(ExpectedConditions.visibilityOf(onDashboard()));
        assertEquals(onDashboard().getText(), "Vedeți cum merge afacerea dvs");
    }

    @FindBy(css = ".aspect-square.size-full")
    private WebElement logoutIcon;

    public void clickLogoutIcon() {
        logoutIcon.click();
    }

    @FindBy(xpath = "//div[text()='Ieşi din cont']")
    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    @FindBy(xpath = "//h1[text()='Autentificare']")
    private WebElement logoutHeading;

    public WebElement getLogoutHeading() {
        return logoutHeading;
    }

    @FindBy(css = ".text-xl.font-semibold.leading-none.tracking-tight")
    private WebElement getLocationName;

    public WebElement getNameOfLocation() {
        return getLocationName;
    }

    //Add menu in Haive

    @FindBy(linkText = "Meniu")
    private WebElement menu;

    public void clickMenuTab() {
        menu.click();
    }

    @FindBy(xpath = "//button[text()='Creați meniu']")
    private WebElement createMenuFirstButton;

    public void clickCreateMenuFirstButton() {
        createMenuFirstButton.click();
    }

    @FindBy(id = "name")
    private WebElement menuName;

    public void insertMenuName() {
        menuName.sendKeys("Burgers");
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createMenuSecondButton;

    public void clickCreateMenuSecondButton() {
        createMenuSecondButton.click();
    }

    @FindBy(xpath = "//h1[text()='Burgers']")
    private WebElement checkMenu;

    public WebElement getCheckMenu() {
        return checkMenu;
    }

    //Adding category to menu in Haive

    @FindBy(xpath = "//*[text()='Burgers']")
    private WebElement burgersButton;

    public void clickBurgersButton() {
        burgersButton.click();
    }

    @FindBy(xpath = "//*[text()='Categorie nouă']")
    private WebElement newCategory;

    public void clickNewCategory() {
        newCategory.click();
    }

    @FindBy(xpath = "//input[@placeholder='ex: Antreuri']")
    private WebElement categoryName;

    public void insertCategoryName() {
        categoryName.sendKeys("Burgeri mexicani");
    }

    @FindBy(xpath = "//button[text()='Creați']")
    private WebElement createCategoryButton;

    public void clickCreateCategoryButton() {
        createCategoryButton.click();
    }

    @FindBy(xpath = "//h2[@class='text-lg font-semibold']")
    private WebElement checkCategory;

    public WebElement getCategory() {
        return checkCategory;
    }

    @FindBy(xpath = "//*[@class='lucide lucide-trash size-4 text-destructive']")
    private WebElement deleteCategoryButton;

    public void clickDeleteCategoryButton() {
        deleteCategoryButton.click();
    }

    @FindBy(xpath = "//button[@class = 'minimal-toolbar_iconButton__hBqdp']")
    private WebElement transparentButton;

    public void clickTransparentButton() {
        transparentButton.click();
    }
    
    @FindBy(css = ".card-link")
    private WebElement miscProduct;

    public WebElement getMiscProduct() {
        return miscProduct;
    }
}
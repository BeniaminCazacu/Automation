import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static java.lang.Double.parseDouble;


// Declaring the CheckoutPage class, which extends the BasePage class.
// By extending BasePage, CheckoutPage inherits the WebDriver instance and the PageFactory initialization.
public class CheckoutPage extends BasePage {

    // Declaring a public WebDriverWait variable named 'wait'.
    // WebDriverWait is used for implementing explicit waits during interactions with web elements.
    public WebDriverWait wait;

    public SoftAssert softAssert;
    
    // Constructor for the CheckoutPage class that takes a WebDriver object as an argument.
    // This constructor calls the parent class (BasePage) constructor to initialize the WebDriver instance
    // and sets up the PageFactory to initialize the web elements on this page.
    public CheckoutPage(WebDriver driver) {
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
    @FindBy(id = "input-search")
    private WebElement searchBar;

    // A public method to set a value in the search bar.
    // This method interacts with the searchBar element and sends the text "mouse" to it.
    // Public method to interact with the private 'searchBar' element
    // Provides controlled access to the encapsulated WebElement
    public void setSearchBar(String param) {
        // Typing the word "mouse" into the search bar.
        searchBar.sendKeys(param);
    }

    // Locating the search button element using the @FindBy annotation.
    // The element is being located by its CSS selector, which identifies elements based on their classes.
    // Here, the button has the classes "btn", "btn-light", and "btn-sm".

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }

    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement frozenMouse;

    public WebElement getFrozenMouse() {
        return frozenMouse;
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement awesomeChipsProduct;

    public void clickAwesomeChipsLink() {
        awesomeChipsProduct.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement cartIcon;

    public void clickCartIcon() {
        cartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement shoppingCartIcon;

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    public void insertFirstName() {
        firstName.sendKeys("Beniamin");
    }

    @FindBy(id = "last-name")
    private WebElement lastName;

    public void insertLastName() {
        lastName.sendKeys("Cazacu");
    }

    @FindBy(id = "address")
    private WebElement address;

    public void insertAddress() {
        address.sendKeys("Suceava");
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckout;

    public void clickContinueCheckout() {
        continueCheckout.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement completeOrder;

    public void clickCompleteOrder() {
        completeOrder.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement successMessage;

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x ")
    private WebElement heartIcon;

    public void clickHeartIcon() {
        heartIcon.click();
    }

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public WebElement getShoppingCartBadge() {
        return shoppingCartBadge;
    }

    public void clickShoppingCartBadge() {
        shoppingCartBadge.click();
    }

    public WebElement getAwesomeChipsProduct(){
        return awesomeChipsProduct;
    }

    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x ")
    private WebElement brokenHeartIcon;

    public void clickBrokenHeartIcon(){
        brokenHeartIcon.click();
    }

    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement awesomeShirt;

    public void clickAwesomeShirt() {
        awesomeShirt.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement add2Cart;

    public void clickAdd2Cart() {
        add2Cart.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement cartBtn;

    public void clickCartBtn() {
        cartBtn.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16 ")
    private WebElement plusOne;

    public void clickPlusOne() {
        plusOne.click();
    }

    @FindBy(css = ".amount-total")
    private WebElement validationTotal;

    public WebElement getValidationTotal() {
        return validationTotal;
    }

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;

    public double productPrice() {
        String amountValue = itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }

    //Compare two smartphones on emag website

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBox;

    public void insertTextInSearchBox(String search) {
        searchBox.sendKeys(search);
    }

    @FindBy(css = ".btn.btn-default.searchbox-submit-button")
    private WebElement mainSearchButton;

    public void clickMainSearchButton() {
        mainSearchButton.click();
    }

    @FindBy(xpath = "//*[@data-name = 'Telefon mobil Google Pixel 9 Pro, 256GB, 16GB RAM, 5G, Rose Quartz']")
    private WebElement googlePixel9Pro;

    public void clickFirstSmartphone() {
        googlePixel9Pro.click();
    }

    @FindBy(xpath = "//div[@class = 'checkbox checkbox-custom']")
    private WebElement compareCheckbox;

    public void clickCompareCheckbox() {
        compareCheckbox.click();
    }

    @FindBy(xpath = "//*[@data-name = 'Telefon mobil Samsung Galaxy S24 Ultra, Dual SIM, 12GB RAM, 512GB, 5G, Titanium Black']")
    private WebElement samsungGalaxyS24Ultra;

    public void clickSecondSmartphone() {
        samsungGalaxyS24Ultra.click();
    }

    @FindBy(css = ".btn.btn-sm.btn-info")
    private WebElement compareButton;

    public void clickCompareButton() {
        compareButton.click();
    }

    //Add/Delete product to/from favorite on emag

    @FindBy(xpath = "//*[contains(@class, 'add-to-favorites btn') and contains(@data-product, 'Telefon mobil Google Pixel 9 Pro, 128GB, 16GB RAM, 5G, Hazel')]")
    private WebElement addToFavoriteButton;

    public void clickAddToFavoriteButton() {
        addToFavoriteButton.click();
    }

    @FindBy(id = "my_wishlist")
    private WebElement wishlist;

    public void clickWishlist() {
        wishlist.click();
    }

    @FindBy(css = ".products-number.hidden-xs.js-products-count")
    private WebElement productsNumber;

    public String favoriteProducts() {
        if(productsNumber.getText().replace("1 lista", "").contains("1"))
        {
            return "1";
        }
        return "0";
    }

    @FindBy(css = ".gtm_9p2y1a.d-none.d-md-inline-block")
    private WebElement deleteProductButton;

    public void clickDeleteProductButton() {
        deleteProductButton.click();
    }

    //Apply some filters for laptop category on emag

    @FindBy(css = ".navbar-aux-content__departments")
    private WebElement menu;

    public void clickMenu() {
        menu.click();
    }

    @FindBy(xpath = "//*[@class = 'megamenu-list-department js-megamenu-list-department'][1]")
    private WebElement laptopTabletPhoneCategory;

    public void clickLaptopTabletPhoneCategory() {
        laptopTabletPhoneCategory.click();
    }

    @FindBy(linkText = "Laptopuri si accesorii")
    private WebElement laptopsAndAccessories;

    public void clickLaptopsAndAccessories() {
        laptopsAndAccessories.click();
    }

    @FindBy(linkText = "Laptopuri")
    private WebElement laptops;

    public void clickLaptops() {
        laptops.click();
    }

    @FindBy(css = ".form-control.js-custom-price-min")
    private WebElement minimPrice;

    public void insertMinimPrice() {
        minimPrice.clear();
        minimPrice.sendKeys("3000");
    }

    @FindBy(css = ".form-control.js-custom-price-max")
    private WebElement maximPrice;

    public void insertMaximPrice() {
        maximPrice.clear();
        maximPrice.sendKeys("5000");
    }

    @FindBy(css = ".btn.btn-alt.js-custom-price-trigger.btn-primary")
    private WebElement intervalFilterButton;

    public void clickIntervalFilterButton() {
        intervalFilterButton.click();
    }

    //END of applying some filters for laptop category

    public void addProductToWishlist() {
        clickAwesomeChipsLink();
        clickHeartIcon();
    }

    public void addProductToCart() {
        clickAwesomeShirt();
        clickAdd2Cart();
        clickCartBtn();
    }

    @FindBy (xpath = "(//td[@class='amount'])[2]")
    private WebElement taxPrice;

    public double taxPrice() {
        String taxValue = taxPrice.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);
    }

    @FindBy (xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice;

    public double totalPrice() {
        String totalValue = totalPrice.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }

    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14 ")
    private WebElement deleteItemButton;

    public void clickDeleteItemButton() {
        deleteItemButton.click();
    }

    @FindBy(css = ".text-center.container")
    private WebElement emptyCartText;

    public WebElement getEmptyCartText() {
        return emptyCartText;
    }
}

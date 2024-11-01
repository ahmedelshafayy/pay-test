import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import utils.ExcelUtils;

public class CheckoutTest {
    private WebDriver driver;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private static ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUp() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testCheckoutProcess() {
        test = extent.createTest("Checkout Process Test");

        test.info("Opening the home page");
        driver.get("https://practicesoftwaretesting.com/");

        test.info("Selecting a product");
        homePage.selectProduct();

        test.info("Adding product to cart");
        homePage.addToCart();

        test.info("Proceeding to checkout");
        homePage.proceedToCheckout();

        checkoutPage.checkOutGo();

        // Read login and billing information from Excel
        String email = ExcelUtils.readDataFromExcel("email");
        String password = ExcelUtils.readDataFromExcel("password");
        String address = ExcelUtils.readDataFromExcel("address");
        String city = ExcelUtils.readDataFromExcel("city");
        String state = ExcelUtils.readDataFromExcel("state");
        String country = ExcelUtils.readDataFromExcel("country");
        String postcode = ExcelUtils.readDataFromExcel("postcode");

        test.info("Entering logging data");

        checkoutPage.enterEmail(email);
        checkoutPage.enterPassword(password);
        checkoutPage.login();

        test.info("Entering billing details");
        checkoutPage.enterBillingInfo(address, city, state, country, postcode);

        test.info("Completing the order");
        checkoutPage.completeOrder();
        test.pass("Checkout process completed successfully");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
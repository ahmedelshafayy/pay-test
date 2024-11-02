import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CheckoutPage;
import pages.HomePage;

public class TestBase {
    public WebDriver driver;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    public static ExtentReports extent;
    public ExtentTest test;
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

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}


import org.testng.annotations.Test;
import utils.ExcelUtils;

public class CheckoutTest extends  TestBase {


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

}
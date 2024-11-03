
import org.testng.annotations.Test;
import utils.ExcelUtils;

public class CheckoutTest extends  TestBase {


    @Test
    public void testCheckoutProcess() {
        test = extent.createTest("Checkout Process Test");

        test.info("Opening the Register");
        driver.get("https://practicesoftwaretesting.com/auth/register");
        String email = ExcelUtils.readDataFromExcel("email");
        String password = ExcelUtils.readDataFromExcel("password");
        String address = ExcelUtils.readDataFromExcel("address");
        String city = ExcelUtils.readDataFromExcel("city");
        String state = ExcelUtils.readDataFromExcel("state");
        String country = ExcelUtils.readDataFromExcel("country");
        String postcode = ExcelUtils.readDataFromExcel("postcode");
        String firstName = ExcelUtils.readDataFromExcel("First name");
        String lastName = ExcelUtils.readDataFromExcel("Last name");
        String phone = ExcelUtils.readDataFromExcel("phone");
        String BD = ExcelUtils.readDataFromExcel("BD");

        test.info("Signup");
        signupPage.signupData(address, city, state, country, postcode,firstName,lastName,phone,BD,email, password);
        signupPage.register();
        signupPage.goToHome();

        test.info("Selecting a product");
        homePage.selectProduct();

        test.info("Adding product to cart");
        homePage.addToCart();

        test.info("Proceeding to checkout");
        homePage.proceedToCheckout();

        checkoutPage.checkOutGo();

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
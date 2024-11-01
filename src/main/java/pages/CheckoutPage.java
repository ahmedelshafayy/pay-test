package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHandel;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(22));
    }

    public void checkOutGo(){
        WebElement checkOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[1]/app-cart/div/div/button")));
        checkOutButton.click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordInput.sendKeys(password);
    }

    public void login() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btnSubmit")));
        loginButton.click();

        WebElement goToBillingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[2]/app-login/div/div/div/div/button")));
        goToBillingButton.click();

    }

    public void enterBillingInfo(String address, String city, String state, String country, String postcode) {
        driver.findElement(By.cssSelector("input#address")).sendKeys(address);
        driver.findElement(By.cssSelector("input#city")).sendKeys(city);
        driver.findElement(By.cssSelector("input#state")).sendKeys(state);
        driver.findElement(By.cssSelector("input#country")).sendKeys(country);
        driver.findElement(By.cssSelector("input#postcode")).sendKeys(postcode);
    }

    public void completeOrder() {
        WebElement proceedToBillingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-step[3]/app-address/div/div/div/div/button")));
        proceedToBillingButton.click();

        // Select payment method and confirm order
        WebElement paymentMethodDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("payment-method")));
        Select paymentMethodSelect = new Select(paymentMethodDropdown);
        paymentMethodSelect.selectByValue("cash-on-delivery");


        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/app-checkout/aw-wizard/div/aw-wizard-completion-step/app-payment/div/div/div/div/button")));
        confirmButton.click();
        AssertionHandel.checkAssertion(wait, By.cssSelector(".alert-success"), "Payment success message not displayed");
    }
}
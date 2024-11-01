package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AssertionHandel;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(22));
    }

    public void selectProduct() {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card-img-top")));
        productElement.click();
    }

    public void addToCart() {
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-add-to-cart")));
        addToCartElement.click();
        AssertionHandel.checkAssertion(wait, By.cssSelector(".toast-success"), "Add to cart success message not displayed");
    }

    public void proceedToCheckout() {
        WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/checkout']")));
        checkoutElement.click();
    }
}
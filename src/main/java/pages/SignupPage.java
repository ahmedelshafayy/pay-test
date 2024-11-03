package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(22));
    }

    public void signupData(String address, String city, String state, String country, String postcode ,String firstName ,String lastName,String phone ,String DB , String email , String password ) {
        driver.findElement(By.cssSelector("input#address")).sendKeys(address);
        driver.findElement(By.cssSelector("input#city")).sendKeys(city);
        driver.findElement(By.cssSelector("input#state")).sendKeys(state);
     //   driver.findElement(By.cssSelector("input#country")).sendKeys(country);
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#country")));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Egypt");

        driver.findElement(By.cssSelector("input#postcode")).sendKeys(postcode);
        driver.findElement(By.cssSelector("#first_name")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#last_name")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#phone")).sendKeys(phone);
        driver.findElement(By.cssSelector("#dob")).sendKeys(DB);
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);

    }
    public void register () {
        WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Register')]")));
        checkoutElement.click();
    }
    public void goToHome () {
        WebElement checkoutElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.navbar-brand")));
        checkoutElement.click();
    }
}
package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AssertionHandel {

    private static final List<String> assertionErrors = new ArrayList<>();

    public static void checkAssertion(WebDriverWait wait, By locator, String errorMessage) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!element.isDisplayed()) {
                assertionErrors.add(errorMessage);
            }
        } catch (Exception e) {
            assertionErrors.add(errorMessage);
        }
    }

}

package wdu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebElement element = null;

    public static WebElement btnLogin(WebDriver driver) {
        element = driver.findElement(By.id("login-button"));
        return element;
    }
}

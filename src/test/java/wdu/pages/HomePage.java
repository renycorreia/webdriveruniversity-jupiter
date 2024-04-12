package wdu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static WebElement element = null;

    public static WebElement pagContact(WebDriver driver) {
        element = driver.findElement(By.id("contact-us"));
        return element;
    }

    public static WebElement pagLogin(WebDriver driver) {
        element = driver.findElement(By.id("login-portal"));
        return element;
    }

}


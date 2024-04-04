package wdu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    private static WebElement element = null;

    public static WebElement cmpFirstName(WebDriver driver) {
        element = driver.findElement(By.name("first_name"));
        return element;
    }

    public static WebElement cmpLastName(WebDriver driver) {
        element = driver.findElement(By.name("last_name"));
        return element;
    }

    public static WebElement cmpEmail(WebDriver driver) {
        element = driver.findElement(By.name("email"));
        return element;
    }

    public static WebElement btnSubmit(WebDriver driver) {
        element = driver.findElement(By.cssSelector("[value='SUBMIT']"));
        return element;
    }

    public static WebElement tagBody(WebDriver driver) {
        element = driver.findElement(By.tagName("body"));
        return element;
    }

}

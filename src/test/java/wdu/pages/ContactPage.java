package wdu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wdu.domain.Pessoa;
import wdu.utils.GenericsUtils;

import static wdu.utils.GenericsUtils.retornaPessoa;

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

    public static WebElement cmpComment(WebDriver driver) {
        element = driver.findElement(By.name("message"));
        return element;
    }

    public static WebElement btnReset(WebDriver driver) {
        element = driver.findElement(By.cssSelector("[value='RESET']"));
        return element;
    }

    public static WebElement btnSubmit(WebDriver driver) {
        element = driver.findElement(By.cssSelector("[value='SUBMIT']"));
        return element;
    }

    public static WebElement tagBodyErro(WebDriver driver) {
        element = driver.findElement(By.tagName("body"));
        return element;
    }

    public static WebElement tagH1Sucesso(WebDriver driver) {
        element = driver.findElement(By.tagName("h1"));
        return element;
    }

    public static void preencheCampos(WebDriver driver, String nomeCampo)
    {
        Pessoa p = retornaPessoa();

        switch (nomeCampo){
            case "First Name":
                cmpFirstName(driver).sendKeys(p.getPrimeiroNome());
                break;
            case "Last Name":
                cmpLastName(driver).sendKeys(p.getUltimoNome());
                break;
            case "Email Address":
                cmpEmail(driver).sendKeys(p.getEmail());
                break;
            case "Comments":
                cmpComment(driver).sendKeys(GenericsUtils.faker.lorem().fixedString(100));
                break;
        }
    }

    public static void preencheTodosOsCampos(WebDriver driver)
    {
        Pessoa p = retornaPessoa();

        cmpFirstName(driver).sendKeys(p.getPrimeiroNome());
        cmpLastName(driver).sendKeys(p.getUltimoNome());
        cmpEmail(driver).sendKeys(p.getEmail());
        cmpComment(driver).sendKeys(GenericsUtils.faker.lorem().fixedString(100));
    }

    public static void limpaFormulario(WebDriver driver)
    {
        btnReset(driver).click();
    }

}

package wdu.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wdu.pages.ContactPage.*;
import static wdu.pages.HomePage.pagContact;

public class ContactUsTests {
    public WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        boolean isHeadless = Boolean.parseBoolean(System.getProperty("HEADLESS"));

        if (isHeadless) {
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--window-size=1366,768");
        }

        driver = new ChromeDriver(options);

        driver.get("https://webdriveruniversity.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Dado("que estou na página contato")
    public void queEstouNaPaginaContato() {
        pagContact(driver).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @Dado("que não preencho nenhum campo do formulário")
    public void queNaoPreenchoNenhumCampoDoFormulario() {
    }

    @Quando("clico no botão SUBMIT")
    public void clicoNoBotaoSUBMIT() {
        btnSubmit(driver).click();
    }

    @Entao("é exibida a mensagem de erro")
    public void eExibidaAMensagemDeErro(String msg) {
        String bodyError = tagBody(driver).getText();

        assertEquals(msg, bodyError);
    }

}

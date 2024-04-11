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

    //region Hooks
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
    //endregion

    //region Given
    @Dado("que estou na página contato")
    public void queEstouNaPaginaContato() {
        pagContact(driver).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @Dado("que não preencho nenhum campo do formulário")
    public void queNaoPreenchoNenhumCampoDoFormulario() {
    }

    @Dado("que preencho apenas o campo {string} do formulário")
    public void quePreenchoApenasOCampoCampoDoFormulario(String nomeCampo) {
        limpaFormulario(driver);
        preencheCampos(driver, nomeCampo);
    }

    @Dado("que não preencho o campo {string} do formulário")
    public void queNaoPreenchoOCampoCampoDoFormulario(String nomeCampo) {
        limpaFormulario(driver);
        preencheTodosOsCampos(driver);

        switch (nomeCampo){
            case "First Name":
                cmpFirstName(driver).clear();
                break;
            case "Last Name":
                cmpLastName(driver).clear();
                break;
            case "Email Address":
                cmpEmail(driver).clear();
                break;
            case "Comments":
                cmpComment(driver).clear();
                break;
        }
    }

    @Dado("que preencho todos os campos do formulário")
    public void quePreenchoTodosOsCamposDoFormulario() {
        preencheTodosOsCampos(driver);
    }
    //endregion

    //region When
    @Quando("clico no botão SUBMIT")
    public void clicoNoBotaoSUBMIT() {
        btnSubmit(driver).click();
    }//endregion

    //region Then
    @Entao("é exibida a mensagem de erro")
    public void eExibidaAMensagemDeErro(String msg) {
        String bodyError = tagBodyErro(driver).getText();

        assertEquals(msg, bodyError);
    }

    @Entao("é exibida a mensagem de erro {string}")
    public void eExibidaAMensagemDeErroMsg(String msg) {
        String bodyError = tagBodyErro(driver).getText();

        assertEquals(msg, bodyError);
    }

    @Entao("o formulário é enviado com sucesso, exibindo a mensagem de confirmação")
    public void oFormularioEEnviadoComSucessoExibindoAMensagemDeConfirmacao(String msg) {
        String h1Sucesso = tagH1Sucesso(driver).getText();

        assertEquals(msg, h1Sucesso);
    }
    //endregion
}
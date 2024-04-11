package wdu.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wdu.helpers.TestContext;
import wdu.helpers.WebDriverHelper;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static wdu.pages.ContactPage.*;
import static wdu.pages.HomePage.pagContact;

public class ContactUsTests {
    WebDriver driver;
    TestContext testContext;

    public ContactUsTests(TestContext context) {
        testContext = context;
        driver = WebDriverHelper.driver;
    }


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

    @Dado("que preencho todos os campos do formulário corretamente")
    public void quePreenchoTodosOsCamposDoFormularioCorretamente() {
        preencheTodosOsCampos(driver);
    }

    @Mas("preencho o campo e-mail com um valor no formato inválido")
    public void preenchoOCampoEMailComUmValorNoFormatoInvalido() {
        cmpEmail(driver).clear();
        cmpEmail(driver).sendKeys("mail@mail");
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
        String url = driver.getCurrentUrl();

        assertTrue(url.contains("/Contact-Us/contact-form-thank-you.html"));
        assertEquals(msg, h1Sucesso);
    }
    //endregion
}
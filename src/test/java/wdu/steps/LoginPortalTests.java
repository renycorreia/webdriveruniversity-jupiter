package wdu.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Mas;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wdu.helpers.TestContext;
import wdu.helpers.WebDriverHelper;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wdu.pages.HomePage.pagLogin;
import static wdu.pages.LoginPage.*;

public class LoginPortalTests {
    WebDriver driver;
    TestContext testContext;

    public LoginPortalTests(TestContext context) {
        testContext = context;
        driver = WebDriverHelper.driver;
    }


    //region Given

    @Dado("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {
        pagLogin(driver).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @Dado("que não preencho o campo {string}")
    public void queNaoPreenchoOCampoCampo(String nomeCampo) {

    }

    @Dado("que preencho o campo username com um usuário válido")
    public void quePreenchoOCampoUsernameComUmUsuarioValido() {
        //Não há usuário válido para o sistema em questão
    }

    @Mas("preencho o campo senha com um valor inválido")
    public void preenchoOCampoSenhaComUmValorInvalido() {
    }

    //endregion

    //region When
    @Quando("clico no botão Login")
    public void clicoNoBotaoLogin() {
        btnLogin(driver).click();
    }
    //endregion

    //region Then
    @Entao("é exibida a mensagem de alerta")
    public void eExibidaAMensagemDeAlerta(String msg) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();

        assertEquals(msg, text);
    }
    //endregion
}
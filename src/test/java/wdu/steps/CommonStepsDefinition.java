package wdu.steps;

import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;
import wdu.helpers.TestContext;
import wdu.helpers.WebDriverHelper;

public class CommonStepsDefinition {

    WebDriver driver;
    TestContext testContext;

    public CommonStepsDefinition(TestContext context) {
        testContext = context;
        driver = WebDriverHelper.driver;
    }

    @Dado("que não preencho nenhum campo do formulário")
    public void queNaoPreenchoNenhumCampoDoFormulario() {
    }
}

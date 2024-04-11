package wdu.helpers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
    private WebDriverHelper webDriverHelper;

    public TestContext(){
        webDriverHelper = new WebDriverHelper();
    }
}

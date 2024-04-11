package wdu.helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp(){
        testContext.getWebDriverHelper().setUp();
    }

    @After
    public void tearDown(){
        testContext.getWebDriverHelper().tearDown();
    }
}

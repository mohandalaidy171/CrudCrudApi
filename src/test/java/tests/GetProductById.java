package tests;

import actions.Actions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class GetProductById {

    @Test(description = "Verify get product by id returns status 200")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test GET /products endpoint for status 200 and valid response")
    public void testGetProductById() {
        Actions actions = new Actions();
        actions.checkGetProductById();

    }
}

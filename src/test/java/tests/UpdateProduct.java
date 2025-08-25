package tests;

import actions.Actions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class UpdateProduct {

    @Test(description = "Verify update product returns status 200")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test PUT /products endpoint for status 200 and valid response")
    public void testUpdateProduct() {
        Actions actions = new Actions();
        actions.checkUpdateProduct();

    }
}

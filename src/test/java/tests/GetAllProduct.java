package tests;

import actions.Actions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class GetAllProduct {
    @Test(description = "Verify GET all products returns status 200")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test GET /products endpoint for status 200 and valid response")
    public void testGetAllProducts() {
        Actions actions = new Actions();
        actions.checkReturnAllProducts();

    }

}

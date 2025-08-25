package tests;

import actions.Actions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class DeleteProductById {


    @Test(description = "Verify Delete Product By Id And returns status 200")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Post /products endpoint for status 200 and valid response")
    public void verifyDeleteProductById() {
        Actions actions = new Actions();
        actions.checkDeleteProductById();


    }
}

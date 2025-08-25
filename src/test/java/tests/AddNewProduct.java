package tests;

import actions.Actions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class AddNewProduct {
    
        @Test(description = "Verify Add New Product And returns status 201")
        @Severity(SeverityLevel.CRITICAL)
        @Description("Test Post /products endpoint for status 201 and valid response")
        public void verifyAddNewProduct() {
            Actions actions = new Actions();
            actions.checkAddNewProduct();

        
    }
}
package actions;

import base.Base;
import base.Product;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import utils.ExcelReader;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class Actions {
Base base=new Base();
//mohannad
    public void checkReturnAllProducts() {
        Response response = RestAssured
                .given()
                .baseUri(Base.URL)
                .header("Content-Type", "application/json")
                .get("/items")
                .then()
                .extract()
                .response();
        Allure.addAttachment("GET /items Response", response.asPrettyString());
        assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }
public static String id="";
    public void checkAddNewProduct() {
        String filePath = "src/test/resources/testData.xlsx";
        List<Product> productList = ExcelReader.readProductsFromExcel(filePath, "Products");

        for (Product product : productList) {

            System.out.println(productList.get(1));
            Response response = RestAssured.given()
                    .baseUri(Base.URL)
                    .header("Content-Type", "application/json")
                    .body(product)
                    .post("/items")
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();

            if ("sami".equalsIgnoreCase(product.getName())) {
                id = response.path("_id");
                System.out.println("ID of sami = " + id);
            }
            Allure.addAttachment("Created Product: " + product.getName(), response.asPrettyString());

            assertEquals(response.getStatusCode(), 201, "Expected status code 201");
        }    }

    public void checkGetProductById() {
        System.out.println("Stored ID = " + id);
//moh
        Response response = RestAssured.given()
                .baseUri(Base.URL)
                .header("Content-Type", "application/json")
                .get("/items/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Allure.addAttachment("Fetched Product with ID: " + id, response.asPrettyString());

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }
    public void checkDeleteProductById() {
        System.out.println("Stored ID = " + id);

        Response response = RestAssured.given()
                .baseUri(Base.URL)
                .header("Content-Type", "application/json")
                .delete("/items/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Allure.addAttachment("Deleted Product with ID: " + id, response.asPrettyString());

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");
    }

    public void checkUpdateProduct() {
        Product product = new Product("khalil", 34);
        Response response = RestAssured.given()
                .baseUri(Base.URL)
                .header("Content-Type", "application/json")
                .body(product)
                .put("/items/" + id)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Allure.addAttachment("Update Product with ID: " + id, response.asPrettyString());

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");

    }
}

package utils;


import base.Product;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelReader {

    public static List<Product> readProductsFromExcel(String filePath, String sheetName) {
        List<Product> products = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                int price = (int) row.getCell(1).getNumericCellValue();

                products.add(new Product(name, price));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}

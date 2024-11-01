package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static String readDataFromExcel(String columnName) {
        String data = "";
        FileInputStream file = null;
        XSSFWorkbook workbook = null;

        try {
            file = new FileInputStream("C:\\222\\src\\test\\resources\\file.xlsx");
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int columnIndex = -1;
            for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
                if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex != -1) {
                Cell cell = sheet.getRow(1).getCell(columnIndex);
                data = switch (cell.getCellType()) {
                    case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
                    case STRING -> cell.getStringCellValue();
                    default -> "";
                };
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (file != null) file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}
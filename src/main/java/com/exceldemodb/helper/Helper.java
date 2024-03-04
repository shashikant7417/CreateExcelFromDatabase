package com.exceldemodb.helper;

import com.exceldemodb.model.Estore;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper {

    public static String[] HEADER = {
            "id",
            "name",
            "description",
            "type"
    };

    public static String SHEET_NAME = "estore_data";

    public static ByteArrayInputStream dataToExcel(List<Estore> estoreList) throws IOException {

        // create workbook
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {

            // create sheet
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            // create row for HEADER
            Row row = sheet.createRow(0);

            for (int i = 0; i < HEADER.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADER[i]);

            }

            // create value rows

            int rowIndex = 1;
            for (Estore e : estoreList) {
                Row dataRow = sheet.createRow(rowIndex);
                rowIndex++;
                dataRow.createCell(0).setCellValue(e.getEid());
                dataRow.createCell(1).setCellValue(e.getName());
                dataRow.createCell(2).setCellValue(e.getDesc());
                dataRow.createCell(3).setCellValue(e.getType());
            }

            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to import data in excel");
            return null;
        } finally {
            workbook.close();
            outputStream.close();

        }

    }


}

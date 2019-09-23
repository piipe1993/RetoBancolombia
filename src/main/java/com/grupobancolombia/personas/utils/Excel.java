package com.grupobancolombia.personas.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Excel {
    public void write (String pathFile, String nameSheet, int rowNumber, int columnIndex, String valueSave) {
        try {
            File file = new File(pathFile);
            InputStream fileInputStream;
            XSSFWorkbook workbook;
            XSSFSheet sheet1;
            if(file.exists()){
                fileInputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(fileInputStream);
                sheet1 = workbook.getSheet(nameSheet);
            } else {
                workbook = new XSSFWorkbook();
                sheet1 = workbook.createSheet(nameSheet);
            }

            XSSFRow row = sheet1.createRow(rowNumber);
            XSSFCell cell = row.createCell(columnIndex);
            cell.setCellValue(valueSave);

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            workbook.close();

        } catch (Exception e) {
            e.getMessage();
            System.out.println("-------------------------- No encontro - Excel --------------------------\n" + e);
        }
    }

}

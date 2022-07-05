package com.facs.utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {


    public static FileInputStream fileInputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheets;


    public static void loadExcel(String path) {
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static String getCellData(String path, String sheetName, int rowNum, int colNum) {

        loadExcel(path);
        sheets = workbook.getSheet(sheetName);
        return sheets.getRow(rowNum).getCell(colNum).getStringCellValue();

    }


    public static String getCellData(String path, int rowNum, int colNum) {

        loadExcel(path);
        sheets = workbook.getSheet("Sheet1");
        return sheets.getRow(rowNum).getCell(colNum).getStringCellValue();


    }


    public static List<List<String>> getDataFromExcel(String path, String sheetName) {

        List<List<String>> data = new ArrayList<>();

        loadExcel(path);

        sheets = workbook.getSheet(sheetName);
        for (int i = 0; i < sheets.getPhysicalNumberOfRows(); i++) {

            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < sheets.getRow(i).getPhysicalNumberOfCells(); j++) {

                rowData.add(sheets.getRow(i).getCell(j).getStringCellValue());

            }
            data.add(rowData);

        }


        return data;
    }

    public static List<List<String>> getDataFromExcel(String path) {

        List<List<String>> data = new ArrayList<>();

        loadExcel(path);

        sheets = workbook.getSheet("Sheet1");
        for (int i = 0; i < sheets.getPhysicalNumberOfRows(); i++) {

            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < sheets.getRow(i).getPhysicalNumberOfCells(); j++) {

                rowData.add(sheets.getRow(i).getCell(j).getStringCellValue());

            }
            data.add(rowData);

        }


        return data;
    }

    public static List<String> getColumnData(String path, String sheetName, int colNum) {

        loadExcel(path);

        List<String> columnData = new ArrayList<>();


        sheets = workbook.getSheet(sheetName);
        columnData = new ArrayList<>();
        for (int i = 0; i < sheets.getPhysicalNumberOfRows(); i++) {
            columnData.add(sheets.getRow(i).getCell(colNum).getStringCellValue());
        }


        return columnData;
    }


    public static List<String> getColumnData(String path, int colNum) {

        loadExcel(path);

        List<String> columnData = new ArrayList<>();


        sheets = workbook.getSheet("Sheet1");
        columnData = new ArrayList<>();
        for (int i = 0; i < sheets.getPhysicalNumberOfRows(); i++) {
            columnData.add(sheets.getRow(i).getCell(colNum).getStringCellValue());
        }


        return columnData;
    }


    public static List<String> getRollData(String path, String sheetName, int rollNum) {

        loadExcel(path);

        List<String> rollData = new ArrayList<>();

        sheets = workbook.getSheet(sheetName);
        for (int i = 0; i < sheets.getRow(rollNum).getPhysicalNumberOfCells(); i++) {
            rollData.add(sheets.getRow(rollNum).getCell(i).getStringCellValue());
        }
        return rollData;
    }

    public static List<String> getRollData(String path, int rollNum) {

        loadExcel(path);

        List<String> rollData = new ArrayList<>();

        sheets = workbook.getSheet("Sheet1");
        for (int i = 0; i < sheets.getRow(rollNum).getPhysicalNumberOfCells(); i++) {
            rollData.add(sheets.getRow(rollNum).getCell(i).getStringCellValue());
        }
        return rollData;
    }


    public static List<Map<String, Object>> getCSVData(String path, String sheetName) {

        List<Map<String, Object>> data = new ArrayList<>();

        loadExcel(path);

        sheets = workbook.getSheet(sheetName);

        List<String> metaData = getRollData(path, sheetName, 0);

        for (int i = 0; i < metaData.size(); i++) {

            Map<String,Object> colNameValueMap = new HashMap<>();

            List<String> columnData = getColumnData(path, sheetName, i);
            columnData.remove(0);

            colNameValueMap.put(metaData.get(i),columnData);

            data.add(colNameValueMap);
        }

        return data;


    }


}


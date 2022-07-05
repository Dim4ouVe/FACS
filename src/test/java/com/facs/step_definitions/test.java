package com.facs.step_definitions;

import com.facs.utils.ExcelUtil;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.lang.reflect.Executable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class test {


    @Test
    public void test1(){

       // System.out.println( ExcelUtil.getCellData("Sheet1", "C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", 0, 1));

       // System.out.println(ExcelUtil.getDataFromExcel("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", "Sheet1"));

       // System.out.println(ExcelUtil.getColumnData("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", "Sheet1", 0));

      //  System.out.println(ExcelUtil.getCellData("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", 0, 0));

       // System.out.println(ExcelUtil.getRollData("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", 0));

       // System.out.println(ExcelUtil.getRollData("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", 0));

         System.out.println(ExcelUtil.getCSVData("C:\\Users\\dimov\\OneDrive\\Desktop\\test.xlsx", "Sheet1"));


    }
}

package com.codebind;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelTest {

	public static void main(String[] args) throws Exception {
		File f= new File("xls/Test.xlsx");// to load file
		FileInputStream fis =new FileInputStream(f);// read the file 
		
		//convert the file workbook format
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("gmail");
		XSSFRow row=sheet.getRow(1);
		XSSFCell cell=row.getCell(0);
		String un=cell.toString();//usename
		XSSFCell cell2=row.getCell(1);
		String pwd=cell2.toString();//password
		System.out.println("username-->"+un+"pwd-->"+pwd);
		
		
		
		FileOutputStream fos = new FileOutputStream(f);//write the data to the file
		row.createCell(5).setCellValue("Tesetd");//to write data on cell
		wb.write(fos);//write the in workbook
		fos.close();
		fis.close();
		
		
		
		
		
	}

}

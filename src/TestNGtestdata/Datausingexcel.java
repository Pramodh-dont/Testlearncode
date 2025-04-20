package TestNGtestdata;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datausingexcel {
	@DataProvider
	public String[][] getdata() throws Exception {
	File files = new File("C:\\Users\\user\\Downloads\\data of orangehrmexcel.xlsx");
	FileInputStream fls = new FileInputStream(files);
	XSSFWorkbook excel = new XSSFWorkbook(fls);
	XSSFSheet sheet = excel.getSheet("Sheet1");
	int getrownum = sheet.getPhysicalNumberOfRows();
	int getcolnm = sheet.getRow(0).getLastCellNum();
	String[][] values= new String[getrownum-1][getcolnm-1];
	for(int i=0; i<getrownum-1;i++) {
		for(int j=0;j<getcolnm;j++) {
			DataFormatter df = new DataFormatter();
			values[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}
	}
	return values;
	}
}

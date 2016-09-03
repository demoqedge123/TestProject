import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtilities 
{

	public int getRowcount(String xlfile,String xlsheet) throws IOException
	{
		int rc;
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		rc=ws.getLastRowNum()+1;
		return rc;
	}
	
	public int getCellcount(String xlfile,String xlsheet,int rowno) throws IOException
	{
		int cellcount;
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.getRow(rowno-1);
		cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	
	
	public String getCellData(String xlfile,String xlsheet,int rowno,int colno) throws IOException
	{
		String data;
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.getRow(rowno-1);
		XSSFCell cell=row.getCell(colno-1);
		data=cell.getStringCellValue();
		return data;
	}
	
	
	public void writeCell(String xlfile,String xlsheet,int rowno,int colno,String data) throws IOException
	{
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.createRow(rowno-1);
		XSSFCell cell=row.createCell(colno-1);
		cell.setCellValue(data);
		FileOutputStream fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();		
	}
	
	
	public void setPasscolor(String xlfile,String xlsheet,int rowno,int colno) throws IOException
	{
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.getRow(rowno-1);
		XSSFCell cell=row.getCell(colno-1);
		
		CellStyle style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		FileOutputStream fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();		
	}
	
	public void setFailcolor(String xlfile,String xlsheet,int rowno,int colno) throws IOException
	{
		FileInputStream fi=new FileInputStream(xlfile);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet(xlsheet);
		XSSFRow row=ws.getRow(rowno-1);
		XSSFCell cell=row.getCell(colno-1);
		
		CellStyle style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		FileOutputStream fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();		
	}
	
	
	
	
}

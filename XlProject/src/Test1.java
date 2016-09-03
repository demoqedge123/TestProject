import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test1 {

	public static void main(String[] args) throws IOException 
	{
	
	XSSFRow row;
	FileInputStream fi=new FileInputStream("d:\\inputdata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet ws=wb.getSheet("LoginData");
		
	row=ws.getRow(1);
	XSSFCell c1=row.createCell(2);
	
	row=ws.getRow(2);
	XSSFCell c2=row.createCell(2);
	
	c1.setCellValue("Pass");
	c2.setCellValue("Fail");
	
	//Code to fill a cell with Green Color
	CellStyle passstyle=wb.createCellStyle();
	passstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	passstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	c1.setCellStyle(passstyle);
	
	//Code to fill a cell with Red Color	
	CellStyle failstyle=wb.createCellStyle();
	failstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
	failstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
	c2.setCellStyle(failstyle);
	
	
	
	
	
	FileOutputStream fo=new FileOutputStream("d:\\inputdata.xlsx");
	wb.write(fo);
	wb.close();
	
	
	
	
				

	}

}

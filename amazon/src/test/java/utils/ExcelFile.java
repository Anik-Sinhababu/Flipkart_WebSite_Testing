package utils;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelFile {
	static XSSFWorkbook book;
	static XSSFSheet sheet;
 
	public String getCellValue(String key) {
		try {
			book = new XSSFWorkbook(System.getProperty("user.dir") + Prop.getProperties("excelPath"));
			sheet = book.getSheet("Sheet1");
			for (Row row : sheet) {
				for (Cell cell : row) {
					if (cell.toString().equalsIgnoreCase(key)) {
						int col = cell.getColumnIndex();
						return row.getCell(col + 1).toString();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "No value found";
	}
}
 
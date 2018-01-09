package utils.fileUtils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileUtils {
    public static List<String> readColumnsValueRowWise(String path, String sheetName) throws IOException {
        File fileLocation = new File(path);
        InputStream inputStream = new FileInputStream(fileLocation);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        HSSFSheet hssfSheet = hssfWorkbook.getSheet(sheetName);
        int numberOfRows = getNumberOfRows(hssfSheet);
        Row row = null;
        Cell cell;
        List<String> rowElements = new ArrayList<>();
        for (int i = 1; i < numberOfRows; i++) {
            row = hssfSheet.getRow(i);
            int numberOfColumns = getNumberOfColumnInARow((HSSFRow) row);
            for (int j = 0; j < numberOfColumns; j++) {
                cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        rowElements.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        rowElements.add(Double.toString(cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        rowElements.add(Boolean.toString(cell.getBooleanCellValue()));
                        break;
//                    case Cell.CELL_TYPE_BLANK:
//                        rowElements.add(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_ERROR:
//                        rowElements.add(cell.getStringCellValue());
//                        break;
                }
            }
        }
        inputStream.close();
        return rowElements;
    }

    public static int getNumberOfRows(HSSFSheet rows) {
        Iterator<Row> rowIterator = rows.rowIterator();
        int numberOfRows = 0;
        HSSFRow row = null;
        while (rowIterator.hasNext()) {
            row = (HSSFRow) rowIterator.next();
            ++numberOfRows;
        }
        return numberOfRows;
    }

    public static int getNumberOfColumnInARow(HSSFRow row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        int numberOfColumnsInARow = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            ++numberOfColumnsInARow;
        }
        return numberOfColumnsInARow;
    }

    public void readSpecificRowFromSheet() {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotInUse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author
 */
public class ExcelManager implements ExcelManagerInterface {

    @Override
    public void createExcelFile(String filePath, ArrayList<String> spreadsheetList) {
        FileOutputStream out = null;
        try {
            //Create Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();
            
            for (String spreadsheetName : spreadsheetList) {
                //Create a blank spreadsheet
                workbook.createSheet(spreadsheetName);
            }
            
            //Create file
            File file = new File(filePath);
            //Create file system using specific name
            out = new FileOutputStream(file);
            //write operation workbook using file out object
            workbook.write(out);
            out.close();
            System.out.println(file.getName() + " written successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void createExcelFileWithData(String filePath, Map<String, Object[]> data) {

    }

    @Override
    public void deleteExcelFile(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void appendDataInExcel(String filePath, String spreadsheetName, Map<String, Object[]> data) {

        FileInputStream fis = null;

        try {

            File excelFile = new File(filePath);
            fis = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheet(spreadsheetName);

            // XSSFRow lastRow = spreadsheet.createRow(spreadsheet.getLastRowNum()+1);
            //Create row object
            XSSFRow row;

            //Iterate over data and write to sheet
            Set< String> keyid = data.keySet();

            int rowid = spreadsheet.getLastRowNum()+1;

            for (String key : keyid) {
                row = spreadsheet.createRow(rowid++);
                Object[] objectArr = data.get(key);
                int cellid = 0;
                for (Object obj : objectArr) {
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((String) obj);
                }
            }

            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(excelFile);
            workbook.write(out);
            out.close();
            System.out.println(excelFile.getName() + " written successfully");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

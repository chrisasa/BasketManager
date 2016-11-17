/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author
 */
public interface ExcelManagerInterface {
    
    public void createExcelFile(String filePath, ArrayList<String> spreadsheetList);
    
    public void createExcelFileWithData(String filePath, Map<String, Object[]> data);
    
    public void appendDataInExcel(String filePath, String spreadsheetName, Map<String, Object[]> data);
    
    public void deleteExcelFile(String filePath);
        
    
}

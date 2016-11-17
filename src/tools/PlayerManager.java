/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PlayerManager implements PlayerManagerInterface {

    ExcelManagerInterface excelManager = new ExcelManager();

    @Override
    public void createPlayersExcelFile() {
        ArrayList playersExcelSpreadsheetsNamesList = new ArrayList<String>();
        playersExcelSpreadsheetsNamesList.add(GlobalVariables.nameSpreadSheetPlayersInfo);
        playersExcelSpreadsheetsNamesList.add(GlobalVariables.nameSpreadSheetPlayersMatchData);
        excelManager.createExcelFile(GlobalVariables.pathPlayersExcel, playersExcelSpreadsheetsNamesList);

        // Append Headers
        Map< String, Object[]> data = new TreeMap< String, Object[]>();
        data.put("1", new Object[]{"ID", "FirstName", "LastName", "DoB", "PoB", "Height", "Weight", "Position", "Jersey"});
        excelManager.appendDataInExcel(GlobalVariables.pathPlayersExcel, GlobalVariables.nameSpreadSheetPlayersInfo, data);
    }

    @Override
    public void addNewPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

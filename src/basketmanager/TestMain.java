/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import objects.PlayerRecord;
import database.FileDatabaseManagerPlayerGame;
import java.io.FileInputStream;
import java.util.Iterator;
import objects.PlayerGame;
import objects.PlayerGameRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class TestMain {

    public static String filePath = GlobalVariables.pathPlayersRaf;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int k = 1345;
        int l = 234;
        double res = k/l;
        
        System.out.println(res);
        
//        TestMain mn = new TestMain();
//
//        mn.testImportPlayer();
    }

    public void test1() throws FileNotFoundException, IOException {

        File tmpFile = new File(filePath);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

        //randomAccessFile.seek(0);
        long pointer = randomAccessFile.getFilePointer();

//        System.out.println(randomAccessFile.readUTF();
//        randomAccessFile.write("test test test".getBytes());
        randomAccessFile.close();
    }

    public void testPlayer() throws IOException {
        File tmpFile = new File(filePath);

//        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
//        randomAccessFile.writeInt(0);
//        System.out.println();
//        randomAccessFile.close();
        PlayerRecord playerRecord = new PlayerRecord();
        FileDatabaseManagerPlayerGame database = new FileDatabaseManagerPlayerGame();
        playerRecord = (PlayerRecord) database.getRecord(1);
        System.out.println(playerRecord.toString());
//        PlayerRecord playerRecord1 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "1", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord2 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "2", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord3 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "3", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord4 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "4", "123", "123", "123", "123", "123", "123", "123");
//        
//        database.insertRecord(playerRecord1);
//        database.insertRecord(playerRecord2);
//        database.insertRecord(playerRecord3);
//        database.insertRecord(playerRecord4);
//        ArrayList al = DatabaseManager.getAllPlayerEntries(GlobalVariables.pathPlayersRaf);

//        System.out.println(al.size());
//        DatabaseManager.showAllPlayerRecords(GlobalVariables.pathPlayersRaf);
//        PlayerRecord playerRecord1 = new PlayerRecord(1, "1up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord2 = new PlayerRecord(2, "2up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord3 = new PlayerRecord(3, "3up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord4 = new PlayerRecord(4, "4up", "123", "123", "123", "123", "123", "123", "123");
//        
//        database.updateRecord(playerRecord1);
//        database.updateRecord(playerRecord2);
//        database.updateRecord(playerRecord3);
//        database.updateRecord(playerRecord4);
//
//        database.showAllRecords();
    }

    public void testImportPlayer() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(new File(GlobalVariables.pathPlayersExcel));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        
        XSSFRow rowHeader;
        Iterator<Row> rowIterator = spreadsheet.iterator();
        rowHeader = (XSSFRow) rowIterator.next();
        
        XSSFRow rowContent;
        while (rowIterator.hasNext()) {
            PlayerRecord playerRecord = new PlayerRecord();
            
            rowContent = (XSSFRow) rowIterator.next();
            
            Iterator< Cell> cellIterator = rowContent.cellIterator();
            
            PlayerExcellCellPointer cellPointer = PlayerExcellCellPointer.FIRSTNAME;
            
            boolean allEntriesAreOkFlag = false;
            
            while (cellIterator.hasNext()) {
                
                Cell cell = cellIterator.next();
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + " \t\t ");
//                        break;
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + " \t\t ");
//                        break;
//                }
                
                switch (cellPointer) {
                    case FIRSTNAME:
                        playerRecord.setDoB(cellIterator.next().getStringCellValue());
                        // Point to the next Player property for the next loop
                        cellPointer = PlayerExcellCellPointer.LASTNAME;
                        break;
                    case LASTNAME:
                        playerRecord.setLastName(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.DOB;
                        break;
                    case DOB:
                        playerRecord.setPoB(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.POB;
                        break;
                    case POB:
                        playerRecord.setPoB(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.HEIGHT;
                        break;
                    case HEIGHT:
                        playerRecord.setHeight(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.WEIGHT;
                        break;
                    case WEIGHT:
                        playerRecord.setWeight(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.POSITION;
                        break;
                    case POSITION:
                        playerRecord.setPosition(cellIterator.next().getStringCellValue());
                        cellPointer = PlayerExcellCellPointer.JERSEY;
                        break;
                    case JERSEY:
                        playerRecord.setJersey(cellIterator.next().getStringCellValue());                        
                        allEntriesAreOkFlag = true;
                        break;
                }                
            } // end of cell loop
        } // end of row loop
        
        fis.close();
    }
    
    
    public enum PlayerExcellCellPointer {
        FIRSTNAME,
        LASTNAME,
        DOB,
        POB,
        HEIGHT,
        WEIGHT,
        POSITION,
        JERSEY
    }
    

}

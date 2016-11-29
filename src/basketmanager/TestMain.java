/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketmanager;

import database.DatabaseManager;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import objects.PlayerRecord;
import database.FileDatabaseManager;
import java.util.ArrayList;
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

        TestMain mn = new TestMain();

        mn.testPlayer();
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
        FileDatabaseManager database = new FileDatabaseManager(filePath, playerRecord);
//        PlayerRecord playerRecord1 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "1", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord2 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "2", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord3 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "3", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord4 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "4", "123", "123", "123", "123", "123", "123", "123");
//        
//        database.insertRecord(playerRecord1);
//        database.insertRecord(playerRecord2);
//        database.insertRecord(playerRecord3);
//        database.insertRecord(playerRecord4);
        ArrayList al = DatabaseManager.getAllPlayerEntries(GlobalVariables.pathPlayersRaf);
        
        System.out.println(al.size());
        
        DatabaseManager.showAllPlayerRecords(GlobalVariables.pathPlayersRaf);

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
}

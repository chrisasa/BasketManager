/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author
 */
public class DatabaseManager {
    
    public static int generateNewPlayerEntryId(String DatabaseFilePath) throws FileNotFoundException, IOException{
        
        RandomAccessFile randomAccessFile = new RandomAccessFile(DatabaseFilePath, "rw");
        
        randomAccessFile.seek(0);
        
        int lastId = randomAccessFile.readInt();
        
        int newId = lastId + 1;
        
        // Get the pointer from the file
        randomAccessFile.seek(0);
        randomAccessFile.writeInt(newId);
        randomAccessFile.close();
        
        return newId;
    }
    
    
    
}

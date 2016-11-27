/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template randomAccessFile, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objects.PlayerRecord;

/**
 *
 * @author
 */
public class FileDatabaseManagerPlayer {

    RandomAccessFile randomAccessFile;

    public FileDatabaseManagerPlayer(String fileString) throws IOException {
        randomAccessFile = new RandomAccessFile(fileString, "rw");
    }

    public void close() throws IOException {
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public PlayerRecord getRecord(int id) throws IOException {
        PlayerRecord record = new PlayerRecord();

        if (id < 1) {
            throw new IllegalArgumentException("invalid ID!!");
        }

        randomAccessFile.seek((id - 1) * PlayerRecord.DATABASE_ENRTY_SIZE);

        record.readFromFile(randomAccessFile);

        return record;
    }

    public void insertRecord(PlayerRecord record) throws IllegalArgumentException, IOException {
        randomAccessFile.seek(getEntryStartPointerOffset(record.getId()));
        record.writeToFile(randomAccessFile);
    }

    public void updateRecord(PlayerRecord record) throws IllegalArgumentException, IOException {
        if (getRecord(record.getId()).getId() == 0) {
            System.out.println("Cannot update.Record does not exist.");
        } else {
            randomAccessFile.seek(getEntryStartPointerOffset(record.getId()));
            record.writeToFile(randomAccessFile);
        }
    }

    public void deleteRecord(PlayerRecord record) throws IllegalArgumentException, IOException {
        if (getRecord(record.getId()).getId() == 0) {
            System.out.println("Cannot delete.Record does not exist.");
        } else {
            randomAccessFile.seek(getEntryStartPointerOffset(record.getId()));
            record = new PlayerRecord();
            record.writeToFile(randomAccessFile);
        }
    }

    public void showAllRecords() {
        PlayerRecord record = new PlayerRecord();
        try {
            randomAccessFile.seek(getDataEntriesStartPointerOffset());

            while (true) {
                do {
                    record.readFromFile(randomAccessFile);
                } while (record.getId() == 0);
                System.out.println(record.toString());
            }
            
        } catch (EOFException ex1) {
            return;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }
    }

    public void test(){
        ArrayList<PlayerRecord> tmpList = getAllEntrys();
        
        for (PlayerRecord record : tmpList) {
            System.out.println(record.toString());
        }
    }
    
    private ArrayList<PlayerRecord> getAllEntrys() {
        ArrayList<PlayerRecord> recordsArrayList = new ArrayList<>();
        
        try {            
            long seekPoint = getDataEntriesStartPointerOffset();
    
            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);
                
                PlayerRecord tmpRecord = new PlayerRecord();
                
                tmpRecord.readFromFile(randomAccessFile);
                
                recordsArrayList.add(tmpRecord);
                
                // Increase by one entry size the seek position to get the next entry
                seekPoint += PlayerRecord.DATABASE_ENRTY_SIZE;                
            }
            
        } catch (EOFException ex1) {
            return recordsArrayList;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }
        
        return recordsArrayList;
    } 
    
    private long getEntryStartPointerOffset(int id) {
        return (PlayerRecord.ID_POINTER_LENGTH + ((id - 1) * PlayerRecord.DATABASE_ENRTY_SIZE));
    }

    private long getDataEntriesStartPointerOffset() {
        return PlayerRecord.ID_POINTER_LENGTH;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template randomAccessFile, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.io.RandomAccessFile;
import objects.DatabaseRecord;

/**
 *
 * @author
 */
public class FileDatabaseManager {

    DatabaseRecord databaseRecord;
    
    RandomAccessFile randomAccessFile;

    public FileDatabaseManager(String fileString, DatabaseRecord databaseRecord) throws IOException {
        this.randomAccessFile = new RandomAccessFile(fileString, "rw");
        this.databaseRecord = databaseRecord;
    }

    public void close() throws IOException {
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public DatabaseRecord getRecord(int id) throws IOException {
        //Record record = new Record();

        if (id < 1) {
            throw new IllegalArgumentException("invalid ID!!");
        }

        randomAccessFile.seek(getEntryStartPointerOffset(id));

        databaseRecord.readFromFile(randomAccessFile);

        return databaseRecord;
    }

    public void insertRecord(DatabaseRecord record) throws IllegalArgumentException, IOException {
        randomAccessFile.seek(getEntryStartPointerOffset(record.getRecordId()));
        record.writeToFile(randomAccessFile);
    }

    public void updateRecord(DatabaseRecord record) throws IllegalArgumentException, IOException {
        
        if (getRecord(record.getRecordId()).getRecordId() == 0) {
            System.out.println("Cannot update.Record does not exist.");
        } 
        else {
            randomAccessFile.seek(getEntryStartPointerOffset(record.getRecordId()));
            record.writeToFile(randomAccessFile);
        }
    }

    public void deleteRecord(DatabaseRecord record) throws IllegalArgumentException, IOException {
        if (getRecord(record.getRecordId()).getRecordId() == 0) {
            System.out.println("Cannot delete.Record does not exist.");
        } else {
            randomAccessFile.seek(getEntryStartPointerOffset(record.getRecordId()));
            
            
            record.writeToFile(randomAccessFile);
        }
    }

    private long getEntryStartPointerOffset(int id) {
        return (DatabaseManager.getIdPointerLength() + ((id - 1) * databaseRecord.getDatabaseEntrySize()));
    }
    
}

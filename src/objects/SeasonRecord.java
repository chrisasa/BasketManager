/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import database.DatabaseManager;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author
 */
public class SeasonRecord extends Season implements DatabaseRecord {
    
    private static final int STRING_ENTRY_LENGTH = 15;

    private static final int NUMBER_OF_STRING_FIELDS = 1;

    public SeasonRecord() {
    }

    public SeasonRecord(int Id, String SeasonName) {
        super(Id, SeasonName);
    }
    
    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setSeasonName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        DatabaseManager.writeString(file, getSeasonName(), STRING_ENTRY_LENGTH);        
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH));
    }

    @Override
    public boolean isValidRecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

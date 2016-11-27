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
public class PlayerRecord extends Player implements DatabaseRecord {
    
    private static final int STRING_ENTRY_LENGTH = 15;

    private static final int NUMBER_OF_STRING_FIELDS = 8;

    public PlayerRecord() {
        this(0, "", "", "", "", "", "", "", "");
    }

    public PlayerRecord(int Id, String FirstName, String LastName, String DoB, String PoB, String Height, String Weight, String Position, String Jersey) {
        super(Id, FirstName, LastName, DoB, PoB, Height, Weight, Position, Jersey);
    }

    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setFirstName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setLastName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setDoB(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setPoB(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setHeight(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setWeight(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setPosition(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setJersey(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        DatabaseManager.writeString(file, getFirstName(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getLastName(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getDoB(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getPoB(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getHeight(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getWeight(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getPosition(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getWeight(), STRING_ENTRY_LENGTH);
    }

    @Override
    public String toString() {
        return "PlayerRecord{" + "Id=" + getId() + ", FirstName=" + getFirstName() 
                + ", LastName=" + getLastName() + ", DoB=" + getDoB() + ", PoB=" 
                + getPoB() + ", Height=" + getHeight() + ", Weight=" + getWeight() 
                + ", Position=" + getPosition() + ", Jersey=" + getJersey() + '}';
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH));
    }

}

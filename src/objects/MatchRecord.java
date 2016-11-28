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
public class MatchRecord extends Match implements DatabaseRecord {

    private static final int STRING_ENTRY_LENGTH = 15;

    private static final int NUMBER_OF_STRING_FIELDS = 10;

    public MatchRecord() {
       this(0, "", 0, "", "", "", "", "", "", 0, "", "", "");
    }

    public MatchRecord(int Id, String Opponent, long Date, String FoulsCommited, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String PointsScored, String PointsConceded, String Location) {
        super(Id, Opponent, Date, FoulsCommited, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, PointsScored, PointsConceded, Location);
    }
    
    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setOpponent(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setDate(file.readLong());
        setFoulsCommited(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setFoulsConceded(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setAssists(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setRebounds(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setSteals(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setBlocks(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setHomeGame(file.readInt());
        setPointsScored(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setPointsConceded(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setLocation(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        DatabaseManager.writeString(file, getOpponent(), STRING_ENTRY_LENGTH);
        file.writeLong(getDate());
        DatabaseManager.writeString(file, getFoulsCommitted(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getFoulsConceded(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getAssists(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getRebounds(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getSteals(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getBlocks(), STRING_ENTRY_LENGTH);
        file.writeInt(getHomeGame());
        DatabaseManager.writeString(file, getPointsScored(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getPointsConceded(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getLocation(), STRING_ENTRY_LENGTH);
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH) + Long.BYTES + Integer.BYTES);
    }
    
}

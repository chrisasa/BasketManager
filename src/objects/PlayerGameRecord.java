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
public class PlayerGameRecord extends PlayerGame implements DatabaseRecord {

    private static final int STRING_ENTRY_LENGTH = 15;

    private static final int NUMBER_OF_STRING_FIELDS = 10;

    public PlayerGameRecord() {
    }

    public PlayerGameRecord(int Id, int PlayerId, String PlayerName, String FoulsCommitted, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String AwayTeamName, String PointsScored, String Location, long GameDate) {
        super(Id, PlayerId, PlayerName, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, AwayTeamName, PointsScored, Location, GameDate);
    }

    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setPlayerId(file.readInt());
        setPlayerName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setFoulsCommitted(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setFoulsConceded(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setAssists(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setRebounds(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setSteals(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setBlocks(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setHomeGame(file.readInt());
        setAwayTeamName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setPointsScored(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setLocation(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setGameDate(file.readLong());
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        file.writeInt(getPlayerId());
        DatabaseManager.writeString(file, getPlayerName(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getFoulsCommitted(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getFoulsConceded(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getAssists(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getRebounds(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getSteals(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getBlocks(), STRING_ENTRY_LENGTH);
        file.writeInt(getHomeGame());
        DatabaseManager.writeString(file, getAwayTeamName(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getPointsScored(), STRING_ENTRY_LENGTH);
        DatabaseManager.writeString(file, getLocation(), STRING_ENTRY_LENGTH);
        file.writeLong(getGameDate());
    }
    
    public void deleteItselfFromFile(RandomAccessFile file) throws IOException {
        
        int deletedRecordId = getId();
        
        
        
        
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH)) + Integer.BYTES + Long.BYTES;
    }

}

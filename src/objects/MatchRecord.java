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

    private static final int NUMBER_OF_STRING_FIELDS = 11;

    public MatchRecord() {
    }

    public MatchRecord(int Id, int SeasonId, String SeasonName, String Opponent, long Date, String FoulsCommitted, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String PointsScored, String PointsConceded, String Location, int IsDeleted) {
        super(Id, SeasonId, SeasonName, Opponent, Date, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, PointsScored, PointsConceded, Location, IsDeleted);
    }

    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setSeasonId(file.readInt());
        setSeasonName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setOpponent(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setDate(file.readLong());
        setFoulsCommitted(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setFoulsConceded(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setAssists(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setRebounds(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setSteals(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setBlocks(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setHomeGame(file.readInt());
        setPointsScored(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setPointsConceded(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setLocation(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
        setIsDeleted(file.readInt());
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        file.writeInt(getSeasonId());
        DatabaseManager.writeString(file, getSeasonName(), STRING_ENTRY_LENGTH);
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
        file.writeInt(getIsDeleted());
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH)) + Long.BYTES + Integer.BYTES + Integer.BYTES;
    }

    @Override
    public boolean isValidRecord() {
        
        boolean isValid = true;
        
        if (getSeasonId() == 0) {isValid = false;}
        if (getSeasonName() == null) {isValid = false;}
        if (getOpponent() == null) {isValid = false;}
        if (getDate() == 0) {isValid = false;}
        if (getFoulsCommitted()== null) {isValid = false;}
        if (getFoulsConceded()== null) {isValid = false;}
        if (getAssists()== null) {isValid = false;}
        if (getRebounds()== null) {isValid = false;}
        if (getSteals()== null) {isValid = false;}
        if (getBlocks()== null) {isValid = false;}
        if (getHomeGame() != 0 || getHomeGame() != 1) {isValid = false;} 
        if (getPointsScored()== null) {isValid = false;}
        if (getPointsConceded()== null) {isValid = false;}
        if (getLocation()== null) {isValid = false;}
        
        return isValid;
    }
    
    @Override
    public String toString() {
        return "PlayerGameRecord{"
                + "Id = " + getId()
                + ", SeasonId = " + getSeasonId()
                + ", SeasonName = " + getSeasonName()
                + ", Opponent = " + getOpponent()
                + ", GameDate = " + getDate()
                + ", FoulsCommitted = " + getFoulsCommitted()
                + ", FoulsConceded = " + getFoulsConceded()
                + ", Assists = " + getAssists()
                + ", Rebounds = " + getRebounds()
                + ", Steals = " + getSteals()
                + ", Blocks = " + getBlocks()
                + ", HomeGame = " + getHomeGame()
                + ", PointsScored = " + getPointsScored()
                + ", PointsConceded = " + getPointsConceded()
                + ", Location = " + getLocation()
                + ", IsDeleted" + getIsDeleted()
                + "}";
    }
    
}

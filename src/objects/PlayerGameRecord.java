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

    private static final int NUMBER_OF_STRING_FIELDS = 11;

    public PlayerGameRecord() {
    }

    public PlayerGameRecord(int Id, int SeasonId, String SeasonName, int PlayerId, String PlayerName, String FoulsCommitted, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String AwayTeamName, String PointsScored, String Location, long GameDate, int IsDeleted) {
        super(Id, SeasonId, SeasonName, PlayerId, PlayerName, FoulsCommitted, FoulsConceded, Assists, Rebounds, Steals, Blocks, HomeGame, AwayTeamName, PointsScored, Location, GameDate, IsDeleted);
    }

    @Override
    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setSeasonId(file.readInt());
        setSeasonName(DatabaseManager.readString(file, STRING_ENTRY_LENGTH));
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
        setIsDeleted(file.readInt());
    }

    @Override
    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        file.writeInt(getSeasonId());
        DatabaseManager.writeString(file, getSeasonName(), STRING_ENTRY_LENGTH);
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
        int t = this.getIsDeleted();
        file.writeInt(getIsDeleted());
    }

    @Override
    public int getRecordId() {
        return getId();
    }

    @Override
    public int getDatabaseEntrySize() {
        return Integer.BYTES + Integer.BYTES + Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH)) + Integer.BYTES + Long.BYTES + Integer.BYTES;
    }

    @Override
    public boolean isValidRecord() {
        
        boolean isValid = true;
        
        if (getSeasonName() == null) {isValid = false;}
        if (getPlayerName() == null) {isValid = false;}
        if (getFoulsCommitted()== null) {isValid = false;}
        if (getFoulsConceded()== null) {isValid = false;}
        if (getAssists()== null) {isValid = false;}
        if (getRebounds()== null) {isValid = false;}
        if (getSteals()== null) {isValid = false;}
        if (getBlocks()== null) {isValid = false;}
        if (getHomeGame() != 0 && getHomeGame() != 1) {isValid = false;} 
        if (getAwayTeamName()== null) {isValid = false;}
        if (getPointsScored()== null) {isValid = false;}
        if (getLocation()== null) {isValid = false;}
        if (getGameDate() == 0) {isValid = false;}
        
        return isValid;
    }
    
    @Override
    public String toString() {
        return "PlayerGameRecord{"
                + "Id = " + getId()
                + ", SeasonId = " + getSeasonId()
                + ", SeasonName = " + getSeasonName()
                + ", PlayerId = " + getPlayerId()
                + ", PlayerName = " + getPlayerName()
                + ", FoulsCommitted = " + getFoulsCommitted()
                + ", FoulsConceded = " + getFoulsConceded()
                + ", Assists = " + getAssists()
                + ", Rebounds = " + getRebounds()
                + ", Steals = " + getSteals()
                + ", Blocks = " + getBlocks()
                + ", HomeGame = " + getHomeGame()
                + ", AwayTeamName = " + getAwayTeamName()
                + ", PointsScored = " + getPointsScored()
                + ", Location = " + getLocation()
                + ", GameDate = " + getGameDate()
                + ", IsDeleted" + getIsDeleted()
                + "}";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author
 */
public class PlayerGame {
    
    private int Id;
    private int PlayerId;
    private String PlayerName;
    private String FoulsCommitted;
    private String FoulsConceded;
    private String Assists;
    private String Rebounds;
    private String Steals;
    private String Blocks;
    private int HomeGame; // 0 or 1
    private String AwayTeamName;
    private String PointsScored;
    private String Location;
    private long GameDate;

    public PlayerGame() {
    }

    public PlayerGame(int Id, int PlayerId, String PlayerName, String FoulsCommitted, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String AwayTeamName, String PointsScored, String Location, long GameDate) {
        this.Id = Id;
        this.PlayerId = PlayerId;
        this.PlayerName = PlayerName;
        this.FoulsCommitted = FoulsCommitted;
        this.FoulsConceded = FoulsConceded;
        this.Assists = Assists;
        this.Rebounds = Rebounds;
        this.Steals = Steals;
        this.Blocks = Blocks;
        this.HomeGame = HomeGame;
        this.AwayTeamName = AwayTeamName;
        this.PointsScored = PointsScored;
        this.Location = Location;
        this.GameDate = GameDate;
    }

    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public String getFoulsCommitted() {
        return FoulsCommitted;
    }

    public void setFoulsCommitted(String FoulsCommitted) {
        this.FoulsCommitted = FoulsCommitted;
    }

    public String getFoulsConceded() {
        return FoulsConceded;
    }

    public void setFoulsConceded(String FoulsConceded) {
        this.FoulsConceded = FoulsConceded;
    }

    public String getAssists() {
        return Assists;
    }

    public void setAssists(String Assists) {
        this.Assists = Assists;
    }

    public String getRebounds() {
        return Rebounds;
    }

    public void setRebounds(String Rebounds) {
        this.Rebounds = Rebounds;
    }

    public String getSteals() {
        return Steals;
    }

    public void setSteals(String Steals) {
        this.Steals = Steals;
    }

    public String getBlocks() {
        return Blocks;
    }

    public void setBlocks(String Blocks) {
        this.Blocks = Blocks;
    }

    public int getHomeGame() {
        return HomeGame;
    }

    public void setHomeGame(int HomeGame) {
        this.HomeGame = HomeGame;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String AwayTeamName) {
        this.AwayTeamName = AwayTeamName;
    }

    public String getPointsScored() {
        return PointsScored;
    }

    public void setPointsScored(String PointsScored) {
        this.PointsScored = PointsScored;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public long getGameDate() {
        return GameDate;
    }

    public void setGameDate(long GameDate) {
        this.GameDate = GameDate;
    }

    
    
    
    
    
    
}

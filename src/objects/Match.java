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
public class Match {
    private int Id;
    private String Opponent;
    private long Date;
    private String FoulsCommited;
    private String FoulsConceded;
    private String Assists;
    private String Rebounds;
    private String Steals;
    private String Blocks;
    private int HomeGame; // 0 or 1
    private String PointsScored;
    private String PointsConceded;
    private String Location;

    public Match() {
    }

    public Match(int Id, String Opponent, long Date, String FoulsCommited, String FoulsConceded, String Assists, String Rebounds, String Steals, String Blocks, int HomeGame, String PointsScored, String PointsConceded, String Location) {
        this.Id = Id;
        this.Opponent = Opponent;
        this.Date = Date;
        this.FoulsCommited = FoulsCommited;
        this.FoulsConceded = FoulsConceded;
        this.Assists = Assists;
        this.Rebounds = Rebounds;
        this.Steals = Steals;
        this.Blocks = Blocks;
        this.HomeGame = HomeGame;
        this.PointsScored = PointsScored;
        this.PointsConceded = PointsConceded;
        this.Location = Location;
    }

    
    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getOpponent() {
        return Opponent;
    }

    public void setOpponent(String Opponent) {
        this.Opponent = Opponent;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long Date) {
        this.Date = Date;
    }

    public String getFoulsCommited() {
        return FoulsCommited;
    }

    public void setFoulsCommited(String FoulsCommited) {
        this.FoulsCommited = FoulsCommited;
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

    public String getPointsScored() {
        return PointsScored;
    }

    public void setPointsScored(String PointsScored) {
        this.PointsScored = PointsScored;
    }

    public String getPointsConceded() {
        return PointsConceded;
    }

    public void setPointsConceded(String PointsConceded) {
        this.PointsConceded = PointsConceded;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

}

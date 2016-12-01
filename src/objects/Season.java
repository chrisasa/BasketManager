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
public class Season {
    private int Id;
    private String SeasonName;

    public Season() {
    }

    public Season(int Id, String SeasonName) {
        this.Id = Id;
        this.SeasonName = SeasonName;
    }

    
    // Getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSeasonName() {
        return SeasonName;
    }

    public void setSeasonName(String SeasonName) {
        this.SeasonName = SeasonName;
    }
    
    
    
}

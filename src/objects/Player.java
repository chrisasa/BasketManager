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
public class Player {
    
    private int Id;
    private String FirstName;
    private String LastName;
    private String DoB;
    private String PoB;
    private String Height;
    private String Weight;
    private String Position;
    private String Jersey;
    private int IsDeleted; // 0 or 1, delete flag for database

    public Player() {
    }

    public Player(int Id, String FirstName, String LastName, String DoB, String PoB, String Height, String Weight, String Position, String Jersey, int IsDeleted) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DoB = DoB;
        this.PoB = PoB;
        this.Height = Height;
        this.Weight = Weight;
        this.Position = Position;
        this.Jersey = Jersey;
        this.IsDeleted = IsDeleted;
    }

    // Getters and Setters

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String DoB) {
        this.DoB = DoB;
    }

    public String getPoB() {
        return PoB;
    }

    public void setPoB(String PoB) {
        this.PoB = PoB;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String Height) {
        this.Height = Height;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getJersey() {
        return Jersey;
    }

    public void setJersey(String Jersey) {
        this.Jersey = Jersey;
    }

    public int getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(int IsDeleted) {
        this.IsDeleted = IsDeleted;
    }
    
}

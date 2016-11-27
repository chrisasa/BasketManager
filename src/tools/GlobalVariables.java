/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;

/**
 *
 * @author
 */
public class GlobalVariables {
    
    private static String pathFilesFolderPath = "/Users/christos/Dropbox/PROJECTS/nick_java";
    
    //public static String filePath = "/Users/christos/Documents/Dev_Tools/GIT_Repos/BasketManager/src/files/players.store";
    
    
    public static final String pathPlayersExcel = pathFilesFolderPath + File.separator + "Players.xlsx";
    public static final String nameSpreadSheetPlayersInfo = "PlayersInfo";
    public static final String nameSpreadSheetPlayersMatchData = "PlayersMatchData";
    public static final String pathMatchesExcel = pathFilesFolderPath + File.separator + "Matches.xlsx";
    
    
    
    public static final String pathPlayersRaf = pathFilesFolderPath + File.separator + "Players.store";
    
    public static final String pathGamesRaf = pathFilesFolderPath + File.separator + "Games.store";
    
    public static final String pathMatchesRaf = pathFilesFolderPath + File.separator + "Matches.store";
    
}

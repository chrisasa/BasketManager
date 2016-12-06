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
    // Set a location for the main folder
    public static String pathFilesFolderPath = "C";
    
    public static final String pathPlayersRaf = pathFilesFolderPath + File.separator + "Players.store";
    
    public static final String pathPlayersGamesRaf = pathFilesFolderPath + File.separator + "Games.store";
    
    public static final String pathMatchesRaf = pathFilesFolderPath + File.separator + "Matches.store";
    
    public static final String pathSeasonsRaf = pathFilesFolderPath + File.separator + "Seasons.store";
}

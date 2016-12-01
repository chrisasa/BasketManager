/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import objects.DatabaseRecord;
import objects.SeasonRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class FileDatabaseManagerSeason extends AbstractFileDatabaseManager {

    public FileDatabaseManagerSeason() throws IOException {
        super(GlobalVariables.pathSeasonsRaf, new SeasonRecord());
    }

    @Override
    public void deleteRecord(DatabaseRecord record) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

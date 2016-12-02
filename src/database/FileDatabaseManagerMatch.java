/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import objects.DatabaseRecord;
import objects.MatchRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class FileDatabaseManagerMatch extends AbstractFileDatabaseManager {

    public FileDatabaseManagerMatch() throws IOException {
        super(GlobalVariables.pathMatchesRaf, new MatchRecord());
    }

    @Override
    public void deleteRecord(DatabaseRecord record) throws IOException {
        updateRecord(record);
    }
    
}

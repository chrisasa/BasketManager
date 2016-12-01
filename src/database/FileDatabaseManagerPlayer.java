/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import objects.DatabaseRecord;
import objects.PlayerRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class FileDatabaseManagerPlayer extends AbstractFileDatabaseManager {

    public FileDatabaseManagerPlayer() throws IOException {
        super(GlobalVariables.pathPlayersRaf, new PlayerRecord());
    }

    @Override
    public void deleteRecord(DatabaseRecord record) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

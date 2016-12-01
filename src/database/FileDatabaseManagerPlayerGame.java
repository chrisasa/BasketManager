/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import objects.DatabaseRecord;
import objects.PlayerGameRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class FileDatabaseManagerPlayerGame extends AbstractFileDatabaseManager {

    public FileDatabaseManagerPlayerGame() throws IOException {
        super(GlobalVariables.pathPlayersGamesRaf, new PlayerGameRecord());
    }

    @Override
    public void deleteRecord(DatabaseRecord record) throws IOException {

        updateRecord(record);
    }

}

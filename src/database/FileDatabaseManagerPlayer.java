/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.util.ArrayList;
import objects.DatabaseRecord;
import objects.PlayerGameRecord;
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
        int PlayerId = record.getRecordId();

        updateRecord(record);
        
        ArrayList<PlayerGameRecord> playerGameRecordsOfPlayer = DatabaseManager.getAllPlayerGamesEntriesOfPlayer(PlayerId);
        for (PlayerGameRecord playerGameRecord : playerGameRecordsOfPlayer) {
            playerGameRecord.setIsDeleted(1); // set flag to 1 
            
            FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();
            
            fileDatabaseManagerPlayerGame.deleteRecord(playerGameRecord);
        }
        
        
        
    }

}

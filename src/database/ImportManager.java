/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.MatchRecord;
import objects.Player;
import objects.PlayerGameRecord;
import objects.PlayerRecord;
import objects.Season;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class ImportManager {

    public enum ImportDialogType {
        PLAYERS, PLAYERS_GAMES, MATCHES
    }

    public enum PlayerExcellCellPointer {
        FIRSTNAME,
        LASTNAME,
        DOB,
        POB,
        HEIGHT,
        WEIGHT,
        POSITION,
        JERSEY
    }

    public enum PlayerGameExcellCellPointer {
        SEASONNAME,
        PLAYERNAME,
        FOULSCOMMITTED,
        FOULSCONCEDED,
        ASSISTS,
        REBOUNDS,
        STEALS,
        BLOCKS,
        HOMEGAME,
        AWAYTEAMNAME,
        POINTSSCORED,
        LOCATION,
        GAMEDATE
    }

    public enum MatchExcellCellPointer {
        SEASONNAME,
        OPPONENT,
        DATE,
        FOULSCOMMITTED,
        FOULSCONCEDED,
        ASSISTS,
        REBOUNDS,
        STEALS,
        BLOCKS,
        HOMEGAME,
        POINTSSCORED,
        POINTSCONCEDED,
        LOCATION,
    }

    public static void ImportEntries(ImportDialogType dialogType, String filePath) throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(new File(filePath));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = spreadsheet.iterator();
        XSSFRow rowHeader = (XSSFRow) rowIterator.next();

        while (rowIterator.hasNext()) {

            switch (dialogType) {
                case PLAYERS:
                    ImportPlayer(rowIterator);
                    break;
                case PLAYERS_GAMES:
                    ImportPlayerGame(rowIterator);
                    break;
                case MATCHES:
                    ImportMatch(rowIterator);
                    break;
            }

        } // end of row loop

        fis.close();
    }

    private static void ImportPlayer(Iterator<Row> rowIterator) throws IOException {

        PlayerRecord playerRecord = new PlayerRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        PlayerExcellCellPointer cellPointer = PlayerExcellCellPointer.FIRSTNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            switch (cellPointer) {
                case FIRSTNAME:
                    playerRecord.setFirstName(cell.getStringCellValue());
                    // Point to the next Player property for the next loop
                    cellPointer = PlayerExcellCellPointer.LASTNAME;
                    break;
                case LASTNAME:
                    playerRecord.setLastName(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.DOB;
                    break;
                case DOB:
                    playerRecord.setDoB(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.POB;
                    break;
                case POB:
                    playerRecord.setPoB(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.HEIGHT;
                    break;
                case HEIGHT:
                    playerRecord.setHeight(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.WEIGHT;
                    break;
                case WEIGHT:
                    playerRecord.setWeight(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.POSITION;
                    break;
                case POSITION:
                    playerRecord.setPosition(cell.getStringCellValue());
                    cellPointer = PlayerExcellCellPointer.JERSEY;
                    break;
                case JERSEY:
                    playerRecord.setJersey(cell.getStringCellValue());
                    allEntriesAreOkFlag = true;
                    break;
            }
        } // end of cell loop

        if (allEntriesAreOkFlag) {
            FileDatabaseManagerPlayer fileDatabaseManagerPlayer = new FileDatabaseManagerPlayer();

            playerRecord.setId(DatabaseManager.generateNewEntryId(GlobalVariables.pathPlayersRaf));
            playerRecord.setIsDeleted(0); // 0 = not deleted

            fileDatabaseManagerPlayer.insertRecord(playerRecord);
        } else {
            System.out.println("Import Failure: User has not correct data!");
        }
    }

    private static void ImportPlayerGame(Iterator<Row> rowIterator) throws IOException {

        PlayerGameRecord playerGameRecord = new PlayerGameRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        PlayerGameExcellCellPointer cellPointer = PlayerGameExcellCellPointer.SEASONNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            switch (cellPointer) {
                case SEASONNAME:
                    playerGameRecord.setSeasonName(cell.getStringCellValue());
                    // Point to the next Player property for the next loop
                    cellPointer = PlayerGameExcellCellPointer.PLAYERNAME;
                    break;
                case PLAYERNAME:
                    playerGameRecord.setPlayerName(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.FOULSCOMMITTED;
                    break;
                case FOULSCOMMITTED:
                    playerGameRecord.setFoulsCommitted(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.FOULSCONCEDED;
                    break;
                case FOULSCONCEDED:
                    playerGameRecord.setFoulsConceded(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.ASSISTS;
                    break;
                case ASSISTS:
                    playerGameRecord.setAssists(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.REBOUNDS;
                    break;
                case REBOUNDS:
                    playerGameRecord.setRebounds(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.STEALS;
                    break;
                case STEALS:
                    playerGameRecord.setSteals(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.BLOCKS;
                    break;
                case BLOCKS:
                    playerGameRecord.setBlocks(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.HOMEGAME;
                    break;
                case HOMEGAME:
                    playerGameRecord.setHomeGame(Integer.parseInt(cell.getStringCellValue()));
                    cellPointer = PlayerGameExcellCellPointer.AWAYTEAMNAME;
                    break;
                case AWAYTEAMNAME:
                    playerGameRecord.setAwayTeamName(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.POINTSSCORED;
                    break;
                case POINTSSCORED:
                    playerGameRecord.setPointsScored(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.LOCATION;
                    break;
                case LOCATION:
                    playerGameRecord.setLocation(cell.getStringCellValue());
                    cellPointer = PlayerGameExcellCellPointer.GAMEDATE;
                    break;
                case GAMEDATE:
                    long tmpDateTimestamp = convertStringDateToLong(cell.getStringCellValue());
                    playerGameRecord.setGameDate(tmpDateTimestamp);

                    allEntriesAreOkFlag = true;
                    break;
            }
        } // end of cell loop

        if (allEntriesAreOkFlag) {
            FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();

            playerGameRecord.setId(DatabaseManager.generateNewEntryId(GlobalVariables.pathPlayersGamesRaf));

            for (Season season : DatabaseManager.getAllSeasonEntries()) {
                // Use name to find season id from current seasons (convert to lowercase to avoid case false errors)
                if (playerGameRecord.getSeasonName().toLowerCase() == season.getSeasonName().toLowerCase()) {
                    // In case of a match set the season Id in PlayerGame object
                    playerGameRecord.setSeasonId(season.getId());
                    // Stop the loop
                    break;
                }
            }

            for (Player player : DatabaseManager.getAllPlayerEntries()) {
                // Use name to find name id from current players (convert to lowercase to avoid case false errors)
                String tmpPlayerName = player.getFirstName() + " " + player.getLastName();
                if (playerGameRecord.getPlayerName().toLowerCase() == tmpPlayerName.toLowerCase().toLowerCase()) {
                    // In case of a match set the season Id in PlayerGame object
                    playerGameRecord.setSeasonId(player.getId());
                    // Stop the loop
                    break;
                }
            }

            playerGameRecord.setIsDeleted(0); // 0 = not deleted

            if (playerGameRecord.isValidRecord()) {
                fileDatabaseManagerPlayerGame.insertRecord(playerGameRecord);
            } else {
                System.out.println("Import Failure: User has not correct data!");
            }
        } else {
            System.out.println("Import Failure: User has not correct data!");
        }
    }

    private static void ImportMatch(Iterator<Row> rowIterator) throws IOException {

        MatchRecord matchRecord = new MatchRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        MatchExcellCellPointer cellPointer = MatchExcellCellPointer.SEASONNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            switch (cellPointer) {
                case SEASONNAME:
                    matchRecord.setSeasonName(cell.getStringCellValue());
                    // Point to the next Player property for the next loop
                    cellPointer = MatchExcellCellPointer.OPPONENT;
                    break;
                case OPPONENT:
                    matchRecord.setOpponent(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.DATE;
                    break;
                case DATE:
                    long tmpDateTimestamp = convertStringDateToLong(cell.getStringCellValue());
                    matchRecord.setDate(tmpDateTimestamp);
                    cellPointer = MatchExcellCellPointer.FOULSCOMMITTED;
                    break;
                case FOULSCOMMITTED:
                    matchRecord.setFoulsCommitted(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.FOULSCONCEDED;
                    break;
                case FOULSCONCEDED:
                    matchRecord.setFoulsConceded(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.ASSISTS;
                    break;
                case ASSISTS:
                    matchRecord.setAssists(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.REBOUNDS;
                    break;
                case REBOUNDS:
                    matchRecord.setRebounds(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.STEALS;
                    break;
                case STEALS:
                    matchRecord.setSteals(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.BLOCKS;
                    break;
                case BLOCKS:
                    matchRecord.setBlocks(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.HOMEGAME;
                    break;
                case HOMEGAME:
                    matchRecord.setHomeGame(Integer.parseInt(cell.getStringCellValue()));
                    cellPointer = MatchExcellCellPointer.POINTSSCORED;
                    break;
                case POINTSSCORED:
                    matchRecord.setPointsScored(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.POINTSCONCEDED;
                    break;
                case POINTSCONCEDED:
                    matchRecord.setPointsConceded(cell.getStringCellValue());
                    cellPointer = MatchExcellCellPointer.LOCATION;
                    break;
                case LOCATION:
                    matchRecord.setLocation(cell.getStringCellValue());

                    allEntriesAreOkFlag = true;
                    break;
            }
        } // end of cell loop

        if (allEntriesAreOkFlag) {
            FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();

            matchRecord.setId(DatabaseManager.generateNewEntryId(GlobalVariables.pathMatchesRaf));

            for (Season season : DatabaseManager.getAllSeasonEntries()) {
                // Use name to find season id from current seasons (convert to lowercase to avoid case false errors)
                if (matchRecord.getSeasonName().toLowerCase() == season.getSeasonName().toLowerCase()) {
                    // In case of a match set the season Id in PlayerGame object
                    matchRecord.setSeasonId(season.getId());
                    // Stop the loop
                    break;
                }
            }

            matchRecord.setIsDeleted(0); // 0 = not deleted

            if (matchRecord.isValidRecord()) {
                fileDatabaseManagerMatch.insertRecord(matchRecord);
            } else {
                System.out.println("Import Failure: User has not correct data!");
            }
        } else {
            System.out.println("Import Failure: User has not correct data!");
        }
    }

    // Tools 
    private static long convertStringDateToLong(String dateString) {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate = null;

        try {
            startDate = df.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(ImportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return startDate.getTime();
    }

}

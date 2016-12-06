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

    public static String ImportEntries(ImportDialogType dialogType, String filePath) throws FileNotFoundException, IOException, ParseException {
        String responseMessage = "";

        FileInputStream fis = new FileInputStream(new File(filePath));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = spreadsheet.iterator();
        // Header row, not in use currently
        XSSFRow rowHeader = (XSSFRow) rowIterator.next();

        while (rowIterator.hasNext()) {

            switch (dialogType) {
                case PLAYERS:
                    responseMessage = ImportPlayer(rowIterator);
                    break;
                case PLAYERS_GAMES:
                    responseMessage = ImportPlayerGame(rowIterator);
                    break;
                case MATCHES:
                    responseMessage = ImportMatch(rowIterator);
                    break;
            }

        } // end of row loop

        fis.close();

        return responseMessage;
    }

    private static String ImportPlayer(Iterator<Row> rowIterator) throws IOException {
        String responseMessage = "Complete importing Players Games";

        PlayerRecord playerRecord = new PlayerRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        PlayerExcellCellPointer cellPointer = PlayerExcellCellPointer.FIRSTNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            String cellValue = getCellValue(cell);

            switch (cellPointer) {
                case FIRSTNAME:
                    playerRecord.setFirstName(cellValue);
                    // Point to the next Player property for the next loop
                    cellPointer = PlayerExcellCellPointer.LASTNAME;
                    break;
                case LASTNAME:
                    playerRecord.setLastName(cellValue);
                    cellPointer = PlayerExcellCellPointer.DOB;
                    break;
                case DOB:
                    playerRecord.setDoB(cellValue);
                    cellPointer = PlayerExcellCellPointer.POB;
                    break;
                case POB:
                    playerRecord.setPoB(cellValue);
                    cellPointer = PlayerExcellCellPointer.HEIGHT;
                    break;
                case HEIGHT:
                    playerRecord.setHeight(cellValue);
                    cellPointer = PlayerExcellCellPointer.WEIGHT;
                    break;
                case WEIGHT:
                    playerRecord.setWeight(cellValue);
                    cellPointer = PlayerExcellCellPointer.POSITION;
                    break;
                case POSITION:
                    playerRecord.setPosition(cellValue);
                    cellPointer = PlayerExcellCellPointer.JERSEY;
                    break;
                case JERSEY:
                    playerRecord.setJersey(cellValue);
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
            responseMessage = "Import Failure: User has not correct data!";
        }

        return responseMessage;
    }

    private static String ImportPlayerGame(Iterator<Row> rowIterator) throws IOException, ParseException {
        String responseMessage = "Complete importing Players Games";

        PlayerGameRecord playerGameRecord = new PlayerGameRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        PlayerGameExcellCellPointer cellPointer = PlayerGameExcellCellPointer.SEASONNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            String cellValue = getCellValue(cell);

            switch (cellPointer) {
                case SEASONNAME:
                    playerGameRecord.setSeasonName(cellValue);
                    // Point to the next Player property for the next loop
                    cellPointer = PlayerGameExcellCellPointer.PLAYERNAME;
                    break;
                case PLAYERNAME:
                    playerGameRecord.setPlayerName(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.FOULSCOMMITTED;
                    break;
                case FOULSCOMMITTED:
                    playerGameRecord.setFoulsCommitted(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.FOULSCONCEDED;
                    break;
                case FOULSCONCEDED:
                    playerGameRecord.setFoulsConceded(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.ASSISTS;
                    break;
                case ASSISTS:
                    playerGameRecord.setAssists(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.REBOUNDS;
                    break;
                case REBOUNDS:
                    playerGameRecord.setRebounds(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.STEALS;
                    break;
                case STEALS:
                    playerGameRecord.setSteals(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.BLOCKS;
                    break;
                case BLOCKS:
                    playerGameRecord.setBlocks(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.HOMEGAME;
                    break;
                case HOMEGAME:
                    // Due to there is always the change to have a double 
                    // instead of int parsed from Excel, we need to cast 
                    // to Integer to be sure. This is common when we are 
                    // using Numeric type cells in Excel file.
                    int tmpHomeGame = (int) Double.parseDouble(cellValue);
                    playerGameRecord.setHomeGame(tmpHomeGame);
                    cellPointer = PlayerGameExcellCellPointer.AWAYTEAMNAME;
                    break;
                case AWAYTEAMNAME:
                    playerGameRecord.setAwayTeamName(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.POINTSSCORED;
                    break;
                case POINTSSCORED:
                    playerGameRecord.setPointsScored(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.LOCATION;
                    break;
                case LOCATION:
                    playerGameRecord.setLocation(cellValue);
                    cellPointer = PlayerGameExcellCellPointer.GAMEDATE;
                    break;
                case GAMEDATE:
                    long tmpDateTimestamp = convertStringDateToLong(cellValue);
                    playerGameRecord.setGameDate(tmpDateTimestamp);

                    allEntriesAreOkFlag = true;
                    break;
            }
        } // end of cell loop

        if (allEntriesAreOkFlag) {
            FileDatabaseManagerPlayerGame fileDatabaseManagerPlayerGame = new FileDatabaseManagerPlayerGame();

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

                playerGameRecord.setId(DatabaseManager.generateNewEntryId(GlobalVariables.pathPlayersGamesRaf));

                fileDatabaseManagerPlayerGame.insertRecord(playerGameRecord);

            } else {
                responseMessage = "Import Failure: User has not correct data!";
            }
        } else {
            responseMessage = "Import Failure: User has not correct data!";
        }

        return responseMessage;
    }

    private static String ImportMatch(Iterator<Row> rowIterator) throws IOException, ParseException {
        String responseMessage = "Complete importing Matches";

        MatchRecord matchRecord = new MatchRecord();

        XSSFRow rowContent = (XSSFRow) rowIterator.next();

        Iterator< Cell> cellIterator = rowContent.cellIterator();

        MatchExcellCellPointer cellPointer = MatchExcellCellPointer.SEASONNAME;

        boolean allEntriesAreOkFlag = false;

        while (cellIterator.hasNext()) {

            Cell cell = cellIterator.next();

            String cellValue = getCellValue(cell);

            switch (cellPointer) {
                case SEASONNAME:
                    matchRecord.setSeasonName(cellValue);
                    // Point to the next Player property for the next loop
                    cellPointer = MatchExcellCellPointer.OPPONENT;
                    break;
                case OPPONENT:
                    matchRecord.setOpponent(cellValue);
                    cellPointer = MatchExcellCellPointer.DATE;
                    break;
                case DATE:
                    long tmpDateTimestamp = convertStringDateToLong(cellValue);
                    matchRecord.setDate(tmpDateTimestamp);
                    cellPointer = MatchExcellCellPointer.FOULSCOMMITTED;
                    break;
                case FOULSCOMMITTED:
                    matchRecord.setFoulsCommitted(cellValue);
                    cellPointer = MatchExcellCellPointer.FOULSCONCEDED;
                    break;
                case FOULSCONCEDED:
                    matchRecord.setFoulsConceded(cellValue);
                    cellPointer = MatchExcellCellPointer.ASSISTS;
                    break;
                case ASSISTS:
                    matchRecord.setAssists(cellValue);
                    cellPointer = MatchExcellCellPointer.REBOUNDS;
                    break;
                case REBOUNDS:
                    matchRecord.setRebounds(cellValue);
                    cellPointer = MatchExcellCellPointer.STEALS;
                    break;
                case STEALS:
                    matchRecord.setSteals(cellValue);
                    cellPointer = MatchExcellCellPointer.BLOCKS;
                    break;
                case BLOCKS:
                    matchRecord.setBlocks(cellValue);
                    cellPointer = MatchExcellCellPointer.HOMEGAME;
                    break;
                case HOMEGAME:
                    // Due to there is always the change to have a double 
                    // instead of int parsed from Excel, we need to cast 
                    // to Integer to be sure. This is common when we are 
                    // using Numeric type cells in Excel file.
                    int tmpHomeGame = (int) Double.parseDouble(cellValue);
                    matchRecord.setHomeGame(tmpHomeGame);
                    cellPointer = MatchExcellCellPointer.POINTSSCORED;
                    break;
                case POINTSSCORED:
                    matchRecord.setPointsScored(cellValue);
                    cellPointer = MatchExcellCellPointer.POINTSCONCEDED;
                    break;
                case POINTSCONCEDED:
                    matchRecord.setPointsConceded(cellValue);
                    cellPointer = MatchExcellCellPointer.LOCATION;
                    break;
                case LOCATION:
                    matchRecord.setLocation(cellValue);

                    allEntriesAreOkFlag = true;
                    break;
            }
        } // end of cell loop

        if (allEntriesAreOkFlag) {
            FileDatabaseManagerMatch fileDatabaseManagerMatch = new FileDatabaseManagerMatch();

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

                matchRecord.setId(DatabaseManager.generateNewEntryId(GlobalVariables.pathMatchesRaf));

                fileDatabaseManagerMatch.insertRecord(matchRecord);
            } else {
                responseMessage = "Import Failure: User has not correct data!";
            }
        } else {
            responseMessage = "Import Failure: User has not correct data!";
        }

        return responseMessage;
    }

    // Tools 
    private static long convertStringDateToLong(String dateString) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate = null;

        startDate = df.parse(dateString);

        return startDate.getTime();
    }

    private static String getCellValue(Cell cell) {
        String cellValue;

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = Double.toString(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                cellValue = "";
                break;
        }

        return cellValue;
    }

}

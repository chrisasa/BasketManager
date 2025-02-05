/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objects.MatchRecord;
import objects.PlayerGameRecord;
import objects.PlayerRecord;
import objects.SeasonRecord;
import tools.GlobalVariables;

/**
 *
 * @author
 */
public class DatabaseManager {

    private static final int ID_POINTER_LENGTH = Integer.BYTES;

    public static void createRafStoreFile(String filePath) {

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            // Instantiate database Id pointer
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

            randomAccessFile.writeInt(0);

            randomAccessFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int generateNewEntryId(String DatabaseFilePath) throws FileNotFoundException, IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(DatabaseFilePath, "rw");

        randomAccessFile.seek(0);

        int lastId = randomAccessFile.readInt();

        int newId = lastId + 1;

        // Get the pointer from the file
        randomAccessFile.seek(0);
        randomAccessFile.writeInt(newId);
        randomAccessFile.close();

        return newId;
    }

    public static String readString(RandomAccessFile file, int StringEntryLength) throws IOException {
        char[] tmpCharArray = new char[StringEntryLength];

        for (int i = 0; i < tmpCharArray.length; i++) {
            tmpCharArray[i] = file.readChar();
        }

        return new String(tmpCharArray).replace('\0', ' ');
    }

    public static void writeString(RandomAccessFile file, String inputString, int StringEntryLength) throws IOException {
        StringBuffer buffer = null;

        if (inputString != null) {
            buffer = new StringBuffer(inputString);
        } else {
            buffer = new StringBuffer(StringEntryLength);
        }

        buffer.setLength(StringEntryLength);

        file.writeChars(buffer.toString());
    }

    public static int getDatabaseEntrySize(int NumberOfStringFields, int StringEntryLength) {

        int databaseEntrySize = Integer.BYTES + (NumberOfStringFields * (Character.BYTES * StringEntryLength));

        return databaseEntrySize;
    }

    public static int getIdPointerLength() {
        return ID_POINTER_LENGTH;
    }

    private static long getDataEntriesStartPointerOffset() {
        return getIdPointerLength();
    }

    public static void showAllPlayerRecords(String playersRafPath) {

        ArrayList<PlayerRecord> tmpList = getAllPlayerEntries();

        for (Object record : tmpList) {
            System.out.println(record.toString());
        }
    }

    public static ArrayList<PlayerRecord> getAllPlayerEntries() {

        ArrayList<PlayerRecord> recordsArrayList = new ArrayList<>();

        try {
            String RafPath = GlobalVariables.pathPlayersRaf;

            RandomAccessFile randomAccessFile = new RandomAccessFile(RafPath, "rw");

            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                PlayerRecord playerRecord = new PlayerRecord();

                playerRecord.readFromFile(randomAccessFile);

                // Get only non deleted entries, IsDeleted = 0 
                if (playerRecord.getIsDeleted() == 0) {
                    recordsArrayList.add(playerRecord);
                }

                // Increase by one entry size the seek position to get the next entry
                seekPoint += playerRecord.getDatabaseEntrySize();
            }

        } catch (EOFException ex1) {
            return recordsArrayList;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }

        return recordsArrayList;
    }

    public static ArrayList<PlayerGameRecord> getAllPlayerGamesEntries() {

        ArrayList<PlayerGameRecord> recordsArrayList = new ArrayList<>();

        try {
            String RafPath = GlobalVariables.pathPlayersGamesRaf;

            RandomAccessFile randomAccessFile = new RandomAccessFile(RafPath, "rw");

            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                PlayerGameRecord playerGameRecord = new PlayerGameRecord();

                playerGameRecord.readFromFile(randomAccessFile);

                // Get only non deleted entries, IsDeleted = 0 
                if (playerGameRecord.getIsDeleted() == 0) {
                    recordsArrayList.add(playerGameRecord);
                }

                // Increase by one entry size the seek position to get the next entry
                seekPoint += playerGameRecord.getDatabaseEntrySize();
            }

        } catch (EOFException ex1) {
            return recordsArrayList;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }

        return recordsArrayList;
    }

    public static ArrayList<MatchRecord> getAllMatchesEntries() {

        ArrayList<MatchRecord> recordsArrayList = new ArrayList<>();

        try {
            String RafPath = GlobalVariables.pathMatchesRaf;

            RandomAccessFile randomAccessFile = new RandomAccessFile(RafPath, "rw");

            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                MatchRecord matchRecord = new MatchRecord();

                matchRecord.readFromFile(randomAccessFile);

                // Get only non deleted entries, IsDeleted = 0 
                if (matchRecord.getIsDeleted() == 0) {
                    recordsArrayList.add(matchRecord);
                }

                // Increase by one entry size the seek position to get the next entry
                seekPoint += matchRecord.getDatabaseEntrySize();
            }

        } catch (EOFException ex1) {
            return recordsArrayList;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }

        return recordsArrayList;
    }

    public static ArrayList<SeasonRecord> getAllSeasonEntries() throws FileNotFoundException {

        String RafPath = GlobalVariables.pathSeasonsRaf;

        RandomAccessFile randomAccessFile = new RandomAccessFile(RafPath, "rw");

        ArrayList<SeasonRecord> recordsArrayList = new ArrayList<>();

        try {
            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                SeasonRecord seasonRecord = new SeasonRecord();

                seasonRecord.readFromFile(randomAccessFile);

                recordsArrayList.add(seasonRecord);

                // Increase by one entry size the seek position to get the next entry
                seekPoint += seasonRecord.getDatabaseEntrySize();
            }

        } catch (EOFException ex1) {
            return recordsArrayList;
        } catch (IOException ex2) {
            System.err.println("Error reading file");
        }

        return recordsArrayList;
    }

    public static ArrayList<PlayerGameRecord> getAllPlayerGamesEntriesOfPlayer(int PlayerId) {
        ArrayList<PlayerGameRecord> playerGameRecords = new ArrayList<>();

        ArrayList<PlayerGameRecord> recordsArrayList = getAllPlayerGamesEntries();

        for (PlayerGameRecord playerGameRecord : recordsArrayList) {
            // Filter player's entries
            if (playerGameRecord.getPlayerId() == PlayerId) {
                playerGameRecords.add(playerGameRecord);
            }

        }

        return playerGameRecords;
    }

    public static ArrayList<PlayerGameRecord> getAllPlayerGamesEntriesOfPlayerSpecificSeason(int PlayerId, int SeasonId) {
        ArrayList<PlayerGameRecord> playerGameRecords = new ArrayList<>();

        ArrayList<PlayerGameRecord> recordsArrayList = getAllPlayerGamesEntries();

        for (PlayerGameRecord playerGameRecord : recordsArrayList) {
            // Filter player's entries
            if (playerGameRecord.getPlayerId() == PlayerId && playerGameRecord.getSeasonId() == SeasonId) {
                playerGameRecords.add(playerGameRecord);
            }

        }

        return playerGameRecords;
    }

    public static ArrayList<PlayerGameRecord> getAllPlayerGamesEntriesOfPlayerAllSelectedSeasons(int PlayerId, ArrayList<Integer> SeasonIdList) {
        ArrayList<PlayerGameRecord> playerGameRecords = new ArrayList<>();

        ArrayList<PlayerGameRecord> recordsArrayList = getAllPlayerGamesEntries();

        // Iterate the selected seasons
        for (Integer seasonId : SeasonIdList) {
            // Iterate all the palyer game entries
            for (PlayerGameRecord playerGameRecord : recordsArrayList) {
                // Filter player's entries
                if (playerGameRecord.getPlayerId() == PlayerId && playerGameRecord.getSeasonId() == seasonId) {
                    playerGameRecords.add(playerGameRecord);
                }
            }
        }
        return playerGameRecords;
    }

    public static ArrayList<MatchRecord> getAllMatchesEntriesSpecificSeason(int SeasonId) {
        ArrayList<MatchRecord> matchRecords = new ArrayList<>();

        ArrayList<MatchRecord> recordsArrayList = getAllMatchesEntries();

        for (MatchRecord matchRecord : recordsArrayList) {
            if (matchRecord.getSeasonId() == SeasonId) {
                matchRecords.add(matchRecord);
            }
        }
        return matchRecords;
    }

    public static ArrayList<MatchRecord> getAllMatchesEntriesOfAllSelectedSeasons(ArrayList<Integer> SeasonIdList) {
        ArrayList<MatchRecord> matchRecords = new ArrayList<>();

        ArrayList<MatchRecord> recordsArrayList = getAllMatchesEntries();

        // Iterate the selected seasons
        for (Integer seasonId : SeasonIdList) {
            // Iterate all match entries
            for (MatchRecord matchRecord : recordsArrayList) {
                if (matchRecord.getSeasonId() == seasonId) {
                    matchRecords.add(matchRecord);
                }
            }
        }
        return matchRecords;
    }

}

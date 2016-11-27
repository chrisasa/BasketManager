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
import objects.PlayerRecord;

/**
 *
 * @author
 */
public class DatabaseManager {

    private static final int ID_POINTER_LENGTH = Integer.BYTES;

    public static int generateNewPlayerEntryId(String DatabaseFilePath) throws FileNotFoundException, IOException {

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

    public static void showAllPlayerRecords(String playersRafPath) throws FileNotFoundException {

        ArrayList<PlayerRecord> tmpList = getAllPlayerEntries(playersRafPath);

        for (Object record : tmpList) {
            System.out.println(record.toString());
        }
    }

    public static ArrayList<PlayerRecord> getAllPlayerEntries(String playersRafPath) throws FileNotFoundException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(playersRafPath, "rw");

        ArrayList<PlayerRecord> recordsArrayList = new ArrayList<>();

        try {
            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                PlayerRecord playerRecord = new PlayerRecord();

                playerRecord.readFromFile(randomAccessFile);

                recordsArrayList.add(playerRecord);

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
    
    public static ArrayList<MatchRecord> getAllMatchesEntries(String playersRafPath) throws FileNotFoundException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(playersRafPath, "rw");

        ArrayList<MatchRecord> recordsArrayList = new ArrayList<>();

        try {
            long seekPoint = getDataEntriesStartPointerOffset();

            // Loop up to the end of the file (EOFException)
            while (true) {
                randomAccessFile.seek(seekPoint);

                MatchRecord matchRecord = new MatchRecord();

                matchRecord.readFromFile(randomAccessFile);

                recordsArrayList.add(matchRecord);

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

}

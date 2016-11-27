/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basketmanager;

import database.DatabaseManager;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import objects.PlayerRecord;
import database.FileDatabaseManagerPlayer;

/**
 *
 * @author
 */
public class TestMain {

    public static String filePath = "/Users/christos/Documents/Dev_Tools/GIT_Repos/BasketManager/src/files/testDB.txt";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        TestMain mn = new TestMain();

        mn.testPlayer();
    }

    public void test1() throws FileNotFoundException, IOException {

        File tmpFile = new File(filePath);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

        //randomAccessFile.seek(0);
        long pointer = randomAccessFile.getFilePointer();

//        System.out.println(randomAccessFile.readUTF();
//        randomAccessFile.write("test test test".getBytes());
        randomAccessFile.close();
    }

    public void initialize() throws IOException {
        File tmpFile = new File(filePath);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");

        FileDatabase1 database = new FileDatabase1(filePath);

//        PersonRecord record = new PersonRecord(1, "christos", "0909090909", "christos@mail.com");
//        record.writeToFile(randomAccessFile);
        PersonRecord personRecord = database.getRecord(1);
        System.out.println(personRecord.toString());

        PersonRecord record_2 = new PersonRecord(2, "christo2", "0909090909", "christos@mail.com");
        PersonRecord record_3 = new PersonRecord(3, "christo3", "0909090909", "christos@mail.com");
        PersonRecord record_4 = new PersonRecord(4, "christo4", "0909090909", "christos@mail.com");
        PersonRecord record_5 = new PersonRecord(5, "christo5", "0909090909", "christos@mail.com");

        database.insertRecord(record_2);
        database.insertRecord(record_3);
        database.insertRecord(record_4);
        database.insertRecord(record_5);
    }

    public void testPlayer() throws IOException {
        File tmpFile = new File(filePath);

        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
//        randomAccessFile.readLong();
//        randomAccessFile.writeInt(0);
//        System.out.println();
//        randomAccessFile.close();
        
        FileDatabaseManagerPlayer database = new FileDatabaseManagerPlayer(filePath);
//        PlayerRecord playerRecord1 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "1", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord2 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "2", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord3 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "3", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord4 = new PlayerRecord(DatabaseManager.generateNewPlayerEntryId(filePath), "4", "123", "123", "123", "123", "123", "123", "123");
//        
//        database.insertRecord(playerRecord1);
//        database.insertRecord(playerRecord2);
//        database.insertRecord(playerRecord3);
//        database.insertRecord(playerRecord4);
//        database.showAllRecords();
//        
//        PlayerRecord playerRecord1 = new PlayerRecord(1, "1up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord2 = new PlayerRecord(2, "2up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord3 = new PlayerRecord(3, "3up", "123", "123", "123", "123", "123", "123", "123");
//        PlayerRecord playerRecord4 = new PlayerRecord(4, "4up", "123", "123", "123", "123", "123", "123", "123");
//        
//        database.updateRecord(playerRecord1);
//        database.updateRecord(playerRecord2);
//        database.updateRecord(playerRecord3);
//        database.updateRecord(playerRecord4);
//
        database.showAllRecords();
        database.test();


    }

    public class FileDatabase1 {

        RandomAccessFile file;

        public FileDatabase1(String fileString) throws IOException {
            file = new RandomAccessFile(fileString, "rw");
        }

        public void close() throws IOException {
            if (file != null) {
                file.close();
            }
        }

        public PersonRecord getRecord(int id) throws IOException {
            PersonRecord record = new PersonRecord();

            if (id < 1) {
                throw new IllegalArgumentException("invalid ID!!");
            }

            file.seek((id - 1) * PersonRecord.SIZE);

            record.readFromFile(file);

            return record;
        }

        public void insertRecord(PersonRecord record) throws IllegalArgumentException, IOException {

            int recordId = record.getId();

//            if (getRecord(recordId).getId() != 0) {
//                System.out.println("Cannot add new.Record already exists.");
//            } else {
            file.seek((record.getId() - 1) * PersonRecord.SIZE);
            record.writeToFile(file);
//            }
        }

        public void updateRecord(PersonRecord record) throws IllegalArgumentException, IOException {
            if (getRecord(record.getId()).getId() == 0) {
                System.out.println("Cannot update.Record does not exist.");
            } else {
                file.seek((record.getId() - 1) * PersonRecord.SIZE);
                record.writeToFile(file);
            }
        }

        public void deleteRecord(PersonRecord record) throws IllegalArgumentException, IOException {
            if (getRecord(record.getId()).getId() == 0) {
                System.out.println("Cannot delete.Record does not exist.");
            } else {
                file.seek((record.getId() - 1) * PersonRecord.SIZE);
                record = new PersonRecord();
                record.writeToFile(file);
            }
        }

        public void showAllRecords() {
            PersonRecord record = new TestMain.PersonRecord();
            try {
                file.seek(0);
                while (true) {
                    do {
                        record.readFromFile(file);
                    } while (record.getId() == 0);
                    System.out.println(record.toString());
                }
            } catch (EOFException ex1) {
                return;
            } catch (IOException ex2) {
                System.err.println("error reading file");
            }
        }
    }

    public class PersonRecord extends Person {

        public static final int STRING_ENTRY_LENGTH = 15;

        public static final int SIZE = Integer.BYTES + (3 * (Character.BYTES * STRING_ENTRY_LENGTH));

        public PersonRecord() {
            this(0, "", "", "");
        }

        public PersonRecord(int id, String name, String phone, String email) {
            super(id, name, phone, email);
        }

        public void readFromFile(RandomAccessFile file) throws IOException {
            setId(file.readInt());
            setName(readString(file));
            setPhone(readString(file));
            setEmail(readString(file));
        }

        public void writeToFile(RandomAccessFile file) throws IOException {
            file.writeInt(getId());
            writeString(file, getName());
            writeString(file, getPhone());
            writeString(file, getEmail());
        }

        private String readString(RandomAccessFile file) throws IOException {
            char[] tmpCharArray = new char[STRING_ENTRY_LENGTH];

            for (int i = 0; i < tmpCharArray.length; i++) {
                tmpCharArray[i] = file.readChar();
            }

            return new String(tmpCharArray).replace('\0', ' ');
        }

        private void writeString(RandomAccessFile file, String inputString) throws IOException {
            StringBuffer buffer = null;

            if (inputString != null) {
                buffer = new StringBuffer(inputString);
            } else {
                buffer = new StringBuffer(STRING_ENTRY_LENGTH);
            }

            buffer.setLength(STRING_ENTRY_LENGTH);

            file.writeChars(buffer.toString());
        }

    }

    public class Person {

        private int id;
        private String name;
        private String phone;
        private String email;

        public Person(int id, String name, String phone, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Person [id=" + id + ", name="
                    + name + ", phone=" + phone
                    + ", email=" + email + "]";
        }
    }

}

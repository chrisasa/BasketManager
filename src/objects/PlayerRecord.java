/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author
 */
public class PlayerRecord extends Player {
    public static final int ID_POINTER_LENGTH = 15;
    
    public static final int STRING_ENTRY_LENGTH = 15;
    
    public static final int NUMBER_OF_STRING_FIELDS = 8;

    public static final int DATABASE_ENRTY_SIZE = Integer.BYTES + (NUMBER_OF_STRING_FIELDS * (Character.BYTES * STRING_ENTRY_LENGTH));

    public PlayerRecord() {
        this(0, "", "", "", "", "", "", "", "");
    }

    public PlayerRecord(int Id, String FirstName, String LastName, String DoB, String PoB, String Height, String Weight, String Position, String Jersey) {
        super(Id, FirstName, LastName, DoB, PoB, Height, Weight, Position, Jersey);
    }

    public void readFromFile(RandomAccessFile file) throws IOException {
        setId(file.readInt());
        setFirstName(readString(file));
        setLastName(readString(file));
        setDoB(readString(file));
        setPoB(readString(file));
        setHeight(readString(file));
        setWeight(readString(file));
        setPosition(readString(file));
        setJersey(readString(file));        
    }

    public void writeToFile(RandomAccessFile file) throws IOException {
        file.writeInt(getId());
        writeString(file, getFirstName());
        writeString(file, getLastName());
        writeString(file, getDoB());
        writeString(file, getPoB());
        writeString(file, getHeight());
        writeString(file, getWeight());
        writeString(file, getPosition());
        writeString(file, getWeight());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotInUse;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author
 */
@Deprecated
public abstract class Record {

    private int RecordId;

    // Size of the counter of current Id number 
    private int IdPointerLength;

    // String field length
    private int StringEntryLength;

    // Total amount of string fields 
    private int NumberOfStringFields;

    // Total size of an entry in RandomAccessFile
    private int DatabaseEntrySize;

    // Constructor
    public Record(int ID_POINTER_LENGTH, int STRING_ENTRY_LENGTH, int NUMBER_OF_STRING_FIELDS, int RecordId) {
        this.IdPointerLength = ID_POINTER_LENGTH;
        this.StringEntryLength = STRING_ENTRY_LENGTH;
        this.NumberOfStringFields = NUMBER_OF_STRING_FIELDS;
        this.RecordId = RecordId;
        
        DatabaseEntrySize = Integer.BYTES + (NumberOfStringFields * (Character.BYTES * StringEntryLength));
    }

    // Abstract methods
    public abstract void readFromFile(RandomAccessFile file) throws IOException;

    public abstract void writeToFile(RandomAccessFile file) throws IOException;

    public String readString(RandomAccessFile file) throws IOException {
        char[] tmpCharArray = new char[StringEntryLength];

        for (int i = 0; i < tmpCharArray.length; i++) {
            tmpCharArray[i] = file.readChar();
        }

        return new String(tmpCharArray).replace('\0', ' ');
    }

    public void writeString(RandomAccessFile file, String inputString) throws IOException {
        StringBuffer buffer = null;

        if (inputString != null) {
            buffer = new StringBuffer(inputString);
        } else {
            buffer = new StringBuffer(StringEntryLength);
        }

        buffer.setLength(StringEntryLength);

        file.writeChars(buffer.toString());
    }

    // Getters and Setters
    
    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int RecordId) {
        this.RecordId = RecordId;
    }

    public int getIdPointerLength() {
        return IdPointerLength;
    }

    public void setIdPointerLength(int IdPointerLength) {
        this.IdPointerLength = IdPointerLength;
    }

    public int getStringEntryLength() {
        return StringEntryLength;
    }

    public void setStringEntryLength(int StringEntryLength) {
        this.StringEntryLength = StringEntryLength;
    }

    public int getNumberOfStringFields() {
        return NumberOfStringFields;
    }

    public void setNumberOfStringFields(int NumberOfStringFields) {
        this.NumberOfStringFields = NumberOfStringFields;
    }

    public int getDatabaseEntrySize() {
        return DatabaseEntrySize;
    }
    
    
}

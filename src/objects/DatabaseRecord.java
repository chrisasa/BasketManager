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
public interface DatabaseRecord {
    
    public void readFromFile(RandomAccessFile file) throws IOException;
    
    public void writeToFile(RandomAccessFile file) throws IOException;
    
    public int getRecordId();
    
    public int getDatabaseEntrySize();
    
    @Override
    public String toString();
}

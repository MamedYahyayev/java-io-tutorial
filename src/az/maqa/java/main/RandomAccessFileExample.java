/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.main;

import az.maqa.java.enums.RndFileMode;
import az.maqa.java.util.Utility;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mamedyahyayev
 */
public class RandomAccessFileExample {

    private static final String FILE = "rndm-write-test.txt";

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(FILE, RndFileMode.RWS.getMode());) {
            readByteArrayFromGivenPosition(file, 100);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(RandomAccessFileExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccessFileExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readSpecificPosition(RandomAccessFile file, int pos) throws IOException {
        file.seek(pos);
        int value = file.read();
        System.out.println("Value:" + value);
    }

    public static void writeFromSpecificPosition(RandomAccessFile file, int pos) throws IOException {
        file.seek(pos);
        file.write("Salam necesiz".getBytes());
    }

    public static void getPosition(RandomAccessFile file) throws IOException {
        long position = file.getFilePointer();
        System.out.println("Pos: " + position);
    }

    public static void readByteArrayFromGivenPosition(RandomAccessFile file, int pos) throws IOException {
        file.seek(pos);
        byte[] read = new byte[1024];
        file.read(read);
        Utility.printActualValues(read);
    }

    public static void writeByteFromSpecificPosition(RandomAccessFile file, int pos) throws IOException {
        file.seek(pos);
        file.write(67);
    }
}

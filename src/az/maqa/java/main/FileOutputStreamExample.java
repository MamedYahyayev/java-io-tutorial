/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 *
 * @author mamedyahyayev
 */
public class FileOutputStreamExample {

    private final static String FILE_PATH = "C:\\Users\\Windows10\\Documents\\NetBeansProjects\\java-io\\write-test.txt";

    public static void main(String[] args) {
        try {
            FileOutputStream out = new FileOutputStream(FILE_PATH);
            byte[] arr = new byte[]{12, 33, 44, 67, 88, 99, 34, 44, 55};
            String str = "Hello, how are you doing?";
            writeWordsToFile(out, str.getBytes());
            out.flush();
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void writeByteToFile(OutputStream out, int value) throws IOException {
        out.write(value);
    }

    public static void writeFileWithByteArray(FileOutputStream out, byte[] value) throws IOException {
        out.write(value);
    }

    public static void writeWordsToFile(FileOutputStream out, byte[] value) throws IOException {
        out.write(value);
    }

    public static void appendFile(String msg) throws IOException {
        FileOutputStream out = new FileOutputStream(FILE_PATH, true);
        out.write(msg.getBytes());
        out.flush();
        out.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.main;

import az.maqa.java.util.Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mamedyahyayev
 */
public class FileInputStreamExample {

    private static final String FILE_PATH = "C:\\Users\\Windows10\\Documents\\NetBeansProjects\\java-io\\test.txt";

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_PATH);
            readAllBytesFromFile(fileInputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileInputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileInputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(FileInputStreamExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void readTextFromFile(InputStream inputStream) throws IOException {
        String message = "";
        int read = 0;
        while ((read = inputStream.read()) != -1) {
            char c = (char) read;
            message += c;
        }

        System.out.println("Message: " + message);
    }

    public static void readTextFromFileWithByteArray(InputStream inputStream) throws IOException {
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        Utility.printActualValues(b);
    }

    public static void readAllBytesFromFile(InputStream inputStream) throws IOException {
        byte[] b = inputStream.readAllBytes();
        Utility.printActualValues(b);
    }

}

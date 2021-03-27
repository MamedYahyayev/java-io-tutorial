package az.maqa.java.main;

import az.maqa.java.util.Utility;
import static az.maqa.java.util.Utility.printByteArray;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author mamedyahyayev
 */
public class InputStreamExample {

    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("test.txt")) {

            inputStreamPrintActualValues(inputStream);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found Exception!!!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IO exception occurs");
            ex.printStackTrace();
        }

    }

    // ----------------- read() --------------------- //
    public static void inputStreamRead(InputStream inputStream) throws IOException {
        int data;
        while ((data = inputStream.read()) != -1) {
            System.out.print(data + " ");
        }
    }

    // ----------------- read(byte[] b) --------------------- //
    public static void inputStreamReadWithByteArray(InputStream inputStream) throws IOException {
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        printByteArray(b);
    }

    // ----------------- read(byte[] b,int off, int len) --------------------- //
    public static void inputStreamReadWithByteArrayOffsetLength(InputStream inputStream) throws IOException {
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b, 2, 3);
        printByteArray(b);
    }

    // ----------------- readAllBytes() --------------------- //
    public static void inputStreamReadAllBytes(InputStream inputStream) throws IOException {
        byte[] b = null;
        b = inputStream.readAllBytes();
        printByteArray(b);
    }

    // ----------------- skip(int n) --------------------- //
    public static void inputStreamSkip(InputStream inputStream) throws IOException {
        byte[] b = null;
        long skippedBytes = inputStream.skip(3);
        b = inputStream.readAllBytes();
        System.out.println("Skipped Bytes: " + skippedBytes);
        printByteArray(b);
    }

    // ----------------- skipNBytes(int n) --------------------- //
    public static void inputStreamSkipNBytes(InputStream inputStream) throws IOException {
        byte[] b = null;
        inputStream.skipNBytes(3);
        b = inputStream.readAllBytes();
        printByteArray(b);
    }

    public static void inputStreamReadBytesConvertToActualValue(InputStream inputStream) throws IOException {
        int read = 0;
        String message = "";
        while ((read = inputStream.read()) != -1) {
            char element = (char) read;
            message += element;
        }

        System.out.println("Message from file: " + message);
    }
    
    public static void inputStreamPrintActualValues(InputStream inputStream) throws IOException {
        byte[] b = new byte[inputStream.available()];
        int read = inputStream.read(b);
        System.out.println("How many bytes to read: " + read);
        Utility.printActualValues(b);
    }
}

package az.maqa.java.main;

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

            inputStreamReadAllBytes(inputStream);

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

}

package az.maqa.java.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author mamedyahyayev
 */
public class OutputStreamExample {

    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("write-test.txt")) {

            byte[] b = {33, 44, 55, 66, 77, 88, 99, 33, 44, 55, 66, 77, 88, 99, 33, 44, 55, 66, 77, 88, 99};
            writeBytesArrayToFile(outputStream, b);
            outputStream.flush();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found Exception!!!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IO exception occurs");
            ex.printStackTrace();
        }
    }

    public static void writeBytesToFile(OutputStream outputStream, int value) throws IOException {
        outputStream.write(value);
    }

    public static void writeBytesToFileWithByteArray(OutputStream outputStream, byte[] b) throws IOException {
        for (int value : b) {
            outputStream.write(value);
        }
    }

    public static void writeBytesArrayToFile(OutputStream outputStream, byte[] b) throws IOException {
        outputStream.write(b);
    }

    public static void writeBytesArrayToFileWithOffAndLen(OutputStream outputStream, byte[] b) throws IOException {
        outputStream.write(b, 0, b.length);
    }
}

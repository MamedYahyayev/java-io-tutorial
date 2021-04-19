/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.main;

import az.maqa.java.util.Utility;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mamedyahyayev
 */
public class FileExample {

    public static void main(String[] args) {
        readListOfFilesFromDirectory("C:\\Users\\Windows10\\Documents\\NetBeansProjects\\java-io\\src\\az\\maqa\\java\\main");
    }

    public static void createFile(String filename) throws IOException {
        boolean isNotNull = Utility.checkValueIsNotNull(filename);
        if (isNotNull) {
            File file = new File(filename);
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("File created...");
            }
        } else {
            throw new NullPointerException("Filename can't be null");
        }
    }

    public static void checkFileExist(String filename) {
        boolean isNotNull = Utility.checkValueIsNotNull(filename);
        if (isNotNull) {
            File file = new File(filename);
            boolean isExist = file.exists();
            if (isExist) {
                System.out.println(filename + " - is exist.");
            } else {
                System.out.println("File isn't exist, therefore new file created with this name: " + filename);
            }
        } else {
            throw new NullPointerException("Filename can't be null");
        }
    }

    public static void createDirectory(String directoryName) {
        boolean isNotNull = Utility.checkValueIsNotNull(directoryName);
        if (isNotNull) {
            File file = new File(directoryName);
            boolean isCreated = file.mkdir();
            if (isCreated) {
                System.out.println(directoryName + " is created.");
            }
        }
    }

    public static void createMultipleDirectory(String directoryPath) {
        boolean isNotNull = Utility.checkValueIsNotNull(directoryPath);
        if (isNotNull) {
            File file = new File(directoryPath);
            boolean isCreated = file.mkdirs();
            if (isCreated) {
                System.out.println(directoryPath + " is created.");
            }
        }
    }

    public static void printFileLength(String filename) {
        boolean isNotNull = Utility.checkValueIsNotNull(filename);
        if (isNotNull) {
            File file = new File(filename);
            System.out.println("FIle length: " + file.length());
        } else {
            throw new NullPointerException("Filename can't be null");
        }
    }

    public static void renameOrMoveFile(String target, String destination) {
        boolean isNotTargetNull = Utility.checkValueIsNotNull(target);
        boolean isNotDestinationNull = Utility.checkValueIsNotNull(destination);

        if (isNotTargetNull && isNotDestinationNull) {
            File file = new File(target);
            boolean isMoved = file.renameTo(new File(destination));
            if (isMoved) {
                System.out.println("File moved from " + target + " to " + destination);
            }
        } else {
            throw new NullPointerException("Filename can't be null");
        }
    }

    public static void deleteFile(String filename) {
        boolean isNotNull = Utility.checkValueIsNotNull(filename);
        if (isNotNull) {
            File file = new File(filename);
            boolean isDelete = file.delete();
            if (isDelete) {
                System.out.println(filename + " was deleted.");
            }
        } else {
            throw new NullPointerException("Filename can't be null");
        }
    }

    public static File checkPathIsDirectory(String path) {
        boolean isNotNull = Utility.checkValueIsNotNull(path);
        if (isNotNull) {
            File file = new File(path);
            boolean isDirectory = file.isDirectory();
            if (isDirectory) {
                System.out.println(path + " is directory.");
                return file;
            }
        } else {
            throw new NullPointerException("Filename can't be null");
        }

        return null;
    }

    public static void readListOfFilesFromDirectory(String directoryName) {
        File directory = checkPathIsDirectory(directoryName);
        String[] fileNames = directory.list();

        // print all files that placed on current directory
        for (String filename : fileNames) {
            System.out.println(filename + " ");
        }
    }
}

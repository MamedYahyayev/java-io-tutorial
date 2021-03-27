/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.util;

/**
 *
 * @author mamedyahyayev
 */
public final class Utility {

    private Utility() {

    }

    public static void printByteArray(byte[] b) {
        for (byte value : b) {
            System.out.print(value + " ");
        }
    }

    public static void printActualValues(byte[] b) {
        for (byte value : b) {
            System.out.print((char) value + "");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.maqa.java.enums;

/**
 *
 * @author mamedyahyayev
 */
public enum RndFileMode {
    RW("rw"), R("r"), RWD("rwd"), RWS("rws");
    
    public String mode;

    private RndFileMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
    
    
    
}

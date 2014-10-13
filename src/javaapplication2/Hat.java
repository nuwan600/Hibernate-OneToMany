/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author nuwan600
 */
public class Hat {
    
    private int hatid;
    private String color;
    private String size;
    private int personid;
    

    public int getHatid() {
        return hatid;
    }

    public void setHatid(int hatid) {
        this.hatid = hatid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }
    
// Getters and Setters
    public String toString() {
    return "Hat: "+getHatid()+
    " Color: "+getColor()+
    " Size: "+getSize();
    }
    
}

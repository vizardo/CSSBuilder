/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.front.UI;

import java.util.ArrayList;

/**
 *
 * @author c0629263
 */
public class MainClass {
     private static ArrayList<String> classes;
    private static ArrayList<String> IDs;
    private static ArrayList<String> Elements;
    private static String PROGRAM_DIRECTORY="";

    public static ArrayList<String> getClasses() {
        return classes;
    }

    public static void setClasses(ArrayList<String> classes) {
        MainClass.classes = classes;
    }

    public static ArrayList<String> getIDs() {
        return IDs;
    }

    public static void setIDs(ArrayList<String> IDs) {
        MainClass.IDs = IDs;
    }

    public static ArrayList<String> getElements() {
        return Elements;
    }

    public static void setElements(ArrayList<String> Elements) {
        MainClass.Elements = Elements;
    }
      
    
    public static void main(String[] args){
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        });
    }
}

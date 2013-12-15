/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utility;

import com.front.UI.MainClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 *
 * @author Vishnuprasad
 */
public class PropertyLoader {

    private static ArrayList<String> categories;
    private static Hashtable properties;

    public PropertyLoader() {
        categories = new ArrayList();
        properties = new Hashtable<String, ArrayList<String>>();
    }

    public static ArrayList<String> getCategories() {
        return categories;
    }

    public static Hashtable getProperties() {
        return properties;
    }

    public static ArrayList<String> getPropertyList(String Key) {
        ArrayList<String> List = new ArrayList();
       return (ArrayList<String>) properties.get(Key);
       

    }

    public static void loadProperties() throws IOException {
        Properties prop = new Properties();
       
         prop.load(PropertyLoader.class.getResourceAsStream("/Resources/CSSproperties.properties"));
        
        Enumeration keys = prop.keys();
        while (keys.hasMoreElements()) {
            categories.add(keys.nextElement().toString().trim());
        }
        int length = categories.size();
        for (int i = 0; i < length; i++) {
            String key = categories.get(i);
            ArrayList<String> List = new ArrayList();
            String propertiesList = prop.getProperty(key).toString().trim();
            StringTokenizer tokens = new StringTokenizer(propertiesList, ",");
            while (tokens.hasMoreTokens()) {
                List.add(tokens.nextToken().trim());
            }
            properties.put(key, List);

        }
    }
     public static ArrayList<String> loadPropVals(String Key) throws IOException  {
        Properties prop = new Properties();
        
        prop.load(PropertyLoader.class.getResourceAsStream("/Resources/PropertyValues.properties"));
        
            ArrayList<String> List = new ArrayList();
            String propertiesList = prop.getProperty(Key).toString().trim();
            StringTokenizer tokens = new StringTokenizer(propertiesList, ",");
            while (tokens.hasMoreTokens()) {
                List.add(tokens.nextToken().trim());
            }
           

        return List;
    }
}

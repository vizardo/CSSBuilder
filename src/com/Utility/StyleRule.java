/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Vishnuprasad
 */
public class StyleRule {
    private Hashtable<String,String> ruleBody;
    private String ruleTitle;

    public StyleRule() {
        ruleBody = new Hashtable<String,String>();
        ruleTitle=new String();
    }

    public StyleRule(String ruleTitle) {
        this.ruleTitle = ruleTitle;
        ruleBody = new Hashtable<String,String>();
    }

    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle;
    }
    
    public void addProperty(String property, String value){
        if(ruleBody.containsKey(property)){
            String Largest=property;
            Enumeration keys=  ruleBody.keys();
       while(keys.hasMoreElements()){
           String key=keys.nextElement().toString();
           if(key.trim().equals(property)){
               if(key.length()>Largest.length())
                   Largest=key;
           }
       }
            ruleBody.put(Largest+" ",value);
        }else
        ruleBody.put(property,value);
    }

    public Hashtable<String, String> getRuleBody() {
        return ruleBody;
    }

    private void setRuleBody(Hashtable<String, String> ruleBody) {
        this.ruleBody = ruleBody;
    }

    public String getRuleTitle() {
        return ruleTitle;
    }
    
    public boolean printRule(String filename) throws IOException{
        FileWriter file=new FileWriter(new File(filename), true);
        String key, element;
        PrintWriter output=new PrintWriter(file);
        
        output.write(ruleTitle);
        output.write("{");
       Enumeration keys=  ruleBody.keys();
       while(keys.hasMoreElements()){
           key=keys.nextElement().toString();
           element=ruleBody.get(key);
           output.write(System.getProperty("line.separator"));
           output.write(key+": "+element+";");
       }
       output.write(System.getProperty("line.separator"));
       output.write("}");
       output.close();
       return true;
    }
    
    @Override
    public String toString(){
       StringBuffer buffer= new StringBuffer();
        String key, element;
        
        
       buffer.append(ruleTitle);
        buffer.append("{");
       Enumeration keys=  ruleBody.keys();
       while(keys.hasMoreElements()){
           key=keys.nextElement().toString();
           element=ruleBody.get(key);
           buffer.append(System.getProperty("line.separator"));
           buffer.append(key+": "+element+";");
       }
       buffer.append(System.getProperty("line.separator"));
       buffer.append("}");
       
       return buffer.toString();
    }
    
    public StyleRule clone(){
        StyleRule obj=new StyleRule(ruleTitle);
        obj.setRuleBody(ruleBody);
        return obj;
    }
}

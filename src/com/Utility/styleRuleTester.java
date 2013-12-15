/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utility;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author Vishnuprasad
 */
public class styleRuleTester {
  public static void main(String [] a) throws IOException{
      PropertyLoader ppt=new PropertyLoader();
      PropertyLoader.loadProperties();
      Enumeration n=PropertyLoader.getProperties().elements();
      FileWriter f=new FileWriter("Resources/PropertyValues.properties");
      while(n.hasMoreElements()){
          ArrayList list=(ArrayList) n.nextElement();
          for(int i=0;i<list.size();i++)
          f.write(list.get(i)+"=XXX;"+System.getProperty("line.separator"));
      }
      f.close();
  }  
}

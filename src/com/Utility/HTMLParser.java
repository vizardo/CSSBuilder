/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import javax.sound.midi.Soundbank;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/*
 * HTML Parser API courtesy: http://jsoup.org/
 * 
 */


/**
 *
 * @author c0629263
 */
public class HTMLParser {
   public static ArrayList<String> getElements(String fileName) throws IOException{
        ArrayList tags=new ArrayList();
       File file=new File(fileName);
       if(file.exists()){
          Document HTMLfile=Jsoup.parse(file,null); 
        Elements taglist=HTMLfile.body().select("*");
        
       
         for(int i=taglist.size()-1;i>0;i--){
             if(!tags.contains(taglist.get(i).nodeName()))
             tags.add(taglist.get(i).nodeName());
         }
         
         taglist=HTMLfile.head().select("*");
        
        
         for(int i=taglist.size()-1;i>0;i--){
             if(!tags.contains(taglist.get(i).nodeName()))
             tags.add(taglist.get(i).nodeName());
         }
           
       }
       System.out.println(tags.toString());
       Collections.sort(tags);
       return tags;
   } 
   
    public static ArrayList<String> getIDs(String fileName) throws IOException{
        ArrayList tags=new ArrayList();
       File file=new File(fileName);
       if(file.exists()){
          Document HTMLfile=Jsoup.parse(file,null); 
        Elements taglist=HTMLfile.body().select("*");
        
       
         for(int i=taglist.size()-1;i>0;i--){
             String ID=taglist.get(i).id();
             if(ID.length()!=0){
                 
             if(!tags.contains(ID))
             tags.add(ID);
             }
         }
         
         taglist=HTMLfile.head().select("*");
        
        
          for(int i=taglist.size()-1;i>0;i--){
             String ID=taglist.get(i).id();
             if(ID.length()!=0){
                 
             if(!tags.contains(ID))
             tags.add(ID);
             }
         }
           
       }
        System.out.println(tags.toString());
       Collections.sort(tags);
       return tags;
   } 
    
     public static ArrayList<String> getClasses(String fileName) throws IOException{
        ArrayList tags=new ArrayList();
       File file=new File(fileName);
       if(file.exists()){
          Document HTMLfile=Jsoup.parse(file,null); 
        Elements taglist=HTMLfile.body().select("*");
        StringTokenizer tokens;
       
         for(int i=taglist.size()-1;i>0;i--){
             String classes=taglist.get(i).className();
             if(classes.length()!=0){
             tokens=new StringTokenizer(classes," ");
             
                 
              while(tokens.hasMoreElements()){
                  String classValue=tokens.nextToken();
                  if(!tags.contains(classValue))
                          tags.add(classValue);
              }   
             }
            
         }
         
         taglist=HTMLfile.body().select("*");
       
       
         for(int i=taglist.size()-1;i>0;i--){
             String classes=taglist.get(i).className();
             if(classes.length()!=0){
             tokens=new StringTokenizer(classes," ");
             
                 
              while(tokens.hasMoreElements()){
                  String classValue=tokens.nextToken();
                  if(!tags.contains(classValue))
                          tags.add(classValue);
              }   
             }
            
         }
           
       }
         System.out.println(tags.toString());
        Collections.sort(tags);
       return tags;
   } 
   
}

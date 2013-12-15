/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utility;

/**
 *
 * @author Vishnuprasad
 */
public class InputValidator {
    public  String editWindowNumericValueValidator(String val){
        char nums[]="0123456789.".toCharArray();
        String newVal="";
                
        if(val.matches("^\\d+\\.*\\d*$"))
            return val;
        else{
            char arr[]=val.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int j=0;
            
                for ( j = 0; j < nums.length; j++) {
                    if(arr[i]==nums[j])
                    break;
                }
                if(j!=nums.length)
                    newVal+=arr[i];
        }
        
    }
        return newVal;
}
    
   
}

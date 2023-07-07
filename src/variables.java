
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 98902
 */
public class variables {
    String st;
    int i=0;
    HashMap<String, Integer> var = new HashMap<>();
    public  variables(File input) throws FileNotFoundException{
         try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
              
           while ((st = reader.readLine()) != null){
               st = st.replaceAll(" ", "");
               st = st.replaceAll("  ", "");
               if(st.substring(0, 3).equals("JMP") || st.substring(0, 3).equals("ADC")
                       || st.substring(0, 3).equals("XOR")
                       || st.substring(0, 3).equals("SBC")
                       || st.substring(0, 3).equals("ROR")
                       || st.substring(0, 3).equals("TAT")
                       || st.substring(0, 3).equals("AND")
                       || st.substring(0, 3).equals("LDC")
                       || st.substring(0, 3).equals("BCC")
                       || st.substring(0, 3).equals("BNE")
                       || st.substring(0, 3).equals("LDI")
                       || st.substring(0, 3).equals("STT")
                       || st.substring(0, 3).equals("LDA")
                       || st.substring(0, 3).equals("STA")
                       || st.substring(0, 2).equals("OR")){
                   System.out.println("we dont have labels");
               }else{
                   int endlabel = st.indexOf(":");
                   String label = st.substring(0, endlabel);
                   var.put(label, i);
                   System.out.println(label);
               }
               if(st.startsWith(".")){
                   
               }
               
               i++;
           }
        }   catch (IOException ex) {
            Logger.getLogger(variables.class.getName()).log(Level.SEVERE, null, ex);
            }
         var.values().forEach(value -> {
             System.out.println(value);
        });
        
    }
}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 98902
 */
public class assemble {
    
    private variables v;
    private String output;
    private File input; 
    
    public assemble(File input){
        this.input = input;
    }
    
    public void assembleCode() throws IOException{
        
      long lines = 0;
      try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
          while (reader.readLine() != null) lines++;
      } catch (IOException e) {
          e.printStackTrace();
      }
      System.out.println(lines);
      
      
      
        v=new variables(input);
        Set<String> keyss =  v.var.keySet();
        String[] keys = keyss.toArray(new String[0]);
       
       String path = input.getPath();
       String st;
       FileWriter fw = new FileWriter(path + "out.txt");
       int address = 0;
       String hexAddress;
        // Condition holds true till
        // there is character in a string
       try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
           while ((st = reader.readLine()) != null){
               
               st = st.replaceAll(" ", "");
               st = st.replaceAll("  ", "");
               
               for(String k : keys){
                   System.out.println(k);
                   if(st.contains(":")){
                       int endlabel = st.indexOf(":");
                       String label = st.substring(0, endlabel);
                       st = st.replaceFirst(label,"");
                   }
                  // st = st.replaceFirst(k,"");
                    System.out.println(st);
               }
                st = st.replaceAll(":", "");
            
               
               hexAddress = Integer.toHexString(address);
               while(hexAddress.length() < 4){
                   hexAddress = "0" + hexAddress;
               }
               
               fw.write(hexAddress+ "\t\t");
               
               if(st.length()>=3 && st.substring(0, 3).equals("JMP")){
                   output = "0000";
                   String sub = "JMP";
                   String modifier = st.replaceAll(sub, "");
                   modifier = modifier.replaceAll(" ", "");
                   modifier = modifier.replaceAll("  ", "");
                   
                   String binary = labelchek(modifier , v);
                  
                   output = output + binary;
                  System.out.println(output);
                  
                  try{
                      fw.write(output +"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException e){
                     e.getMessage();
                  }
               }
                  
                   if(st.length()>=3 && st.substring(0, 3).equals("ADC")){
                   output = "0001";
                   String ADC = "ADC";
                   String modifierADC = st.replaceAll(ADC, "");
                   modifierADC = modifierADC.replaceAll(" ", "");
                   modifierADC = modifierADC.replaceAll("  ", "");
                  String binaryADC = labelchek(modifierADC , v);
                   output = output + binaryADC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
               
               
                
                  if(st.length()>=3 && st.substring(0, 3).equals("SBC")){
                   output = "0011";
                   String SBC = "SBC";
                   String modifierSBC = st.replaceAll(SBC, "");
                   modifierSBC = modifierSBC.replaceAll(" ", "");
                   modifierSBC = modifierSBC.replaceAll("  ", "");
                  String binarySBC = labelchek(modifierSBC , v);
                   output = output + binarySBC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
               
                    
                       if(st.length()>=3 && st.substring(0, 3).equals("TAT")){
                   output = "0101";
                   
                   while(output.length()<16){
                     output = output+"0";
                   }
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
               if(st.length()>=3 && st.substring(0, 3).equals("ROR")){
                   output = "0100";
                   
                   while(output.length()<16){
                     output = output+"0";
                   }
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                       
                        if(st.length()>=3 && st.substring(0, 2).equals("OR")){
                   output = "0110";
                   String OR = "OR";
                   String modifierOR = st.replaceAll(OR, "");
                   modifierOR = modifierOR.replaceAll(" ", "");
                   modifierOR = modifierOR.replaceAll("  ", "");
                   String binaryOR = labelchek(modifierOR , v);
                   output = output + binaryOR;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                        
                if(st.length()>=3 && st.substring(0, 3).equals("XOR")){
                   output = "0010";
                   String XOR = "XOR";
                   String modifierXOR = st.replaceAll(XOR, "");
                   modifierXOR = modifierXOR.replaceAll(" ", "");
                   modifierXOR = modifierXOR.replaceAll("  ", "");
                   String binaryXOR = labelchek(modifierXOR , v);
                   output = output + binaryXOR;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                        
                    if(st.length()>=3 && st.substring(0, 3).equals("AND")){
                   output = "1000";
                   String AND = "AND";
                   String modifierAND = st.replaceAll(AND, "");
                   modifierAND = modifierAND.replaceAll(" ", "");
                   modifierAND = modifierAND.replaceAll("  ", "");
                   String binaryAND = labelchek(modifierAND , v);
                   output = output + binaryAND;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                         
                     if(st.length()>=3 && st.substring(0, 3).equals("LDC")){
                   output = "1001";
                   String LDC = "LDC";
                   String modifierLDC = st.replaceAll(LDC, "");
                   modifierLDC = modifierLDC.replaceAll(" ", "");
                   modifierLDC = modifierLDC.replaceAll("  ", "");
                  String binaryLDC = labelchek(modifierLDC , v);
                   output = output + binaryLDC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                          
                      if(st.length()>=3 && st.substring(0, 3).equals("BCC")){
                   output = "1010";
                   String BCC = "BCC";
                   String modifierBCC = st.replaceAll(BCC, "");
                   modifierBCC = modifierBCC.replaceAll(" ", "");
                   modifierBCC = modifierBCC.replaceAll("  ", "");
                  String binaryBCC = labelchek(modifierBCC , v);
                   output = output + binaryBCC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                           
                      if(st.length()>=3 && st.substring(0, 3).equals("BNE")){
                   output = "1011";
                   String BNE = "BNE";
                   String modifierBNE = st.replaceAll(BNE, "");
                   modifierBNE = modifierBNE.replaceAll(" ", "");
                   modifierBNE = modifierBNE.replaceAll("  ", "");
                  String binaryBNE = labelchek(modifierBNE , v);
                   output = output + binaryBNE;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                       if(st.length()>=3 && st.substring(0, 3).equals("LDI")){
                   output = "1100";
                   
                   while(output.length()<16){
                     output = output+"0";
                   }
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                               
                       if(st.length()>=3 && st.substring(0, 3).equals("STT")){
                   output = "1101";
                  
                   while(output.length()<16){
                     output = output+"0";
                   }
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                                  
                       if(st.length()>=3 && st.substring(0, 3).equals("LDA")){
                   output = "1110";
                   String LDA = "LDA";
                   String modifierLDA = st.replaceAll(LDA, "");
                   modifierLDA = modifierLDA.replaceAll(" ", "");
                   modifierLDA = modifierLDA.replaceAll("  ", "");
                   String binaryLDA = labelchek(modifierLDA , v);
                   output = output + binaryLDA;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                        address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                                  
                        if(st.length()>=3 && st.substring(0, 3).equals("STA")){
                   output = "1111";
                   String STA = "STA";
                   String modifierSTA = st.replaceAll(STA, "");
                   modifierSTA = modifierSTA.replaceAll(" ", "");
                   modifierSTA = modifierSTA.replaceAll("  ", "");
                   String binarySTA = labelchek(modifierSTA , v);
                   output = output + binarySTA;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      address = address+1;
                      continue;
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
                        else{
                            output = "????????????????";
                             fw.write(output+"\n");
                               address = address+1;
                      continue;
                        }
                      
          
          
  
           }
           fw.close();
        }
    }
    
    
    
    
    public String labelchek(String modifier,variables  v){
        
         Set<String> keyss =  v.var.keySet();
         String[] keys = keyss.toArray(new String[0]);
         
         for(String k : keys){
                  if(modifier.compareTo(k)==0){
                      int decimalint = v.var.get(k);
                      String binary = Integer.toBinaryString(decimalint);
                      while(binary.length()<12){
                        binary = "0" + binary;
                      }
                      return binary;
                  }
               }
          int decimalint = Integer.parseInt(modifier, 16);
          String binary = Integer.toBinaryString(decimalint);
                   while(binary.length()<12){
                     binary = "0" + binary;
                   }
                   return binary;
    }
}

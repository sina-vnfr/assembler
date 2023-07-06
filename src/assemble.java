
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
                   int decimalint = Integer.parseInt(modifier, 16);
                   String binary = Integer.toBinaryString(decimalint);
                   while(binary.length()<12){
                     binary = "0" + binary;
                   }
                   output = output + binary;
                  System.out.println(output);
                  
                  try{
                      fw.write(output +"\n");
                      
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
                   int decimalintADC = Integer.parseInt(modifierADC, 16);
                   String binaryADC = Integer.toBinaryString(decimalintADC);
                   while(binaryADC.length()<12){
                     binaryADC = "0" + binaryADC;
                   }
                   output = output + binaryADC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintSBC = Integer.parseInt(modifierSBC, 16);
                   String binarySBC = Integer.toBinaryString(decimalintSBC);
                   while(binarySBC.length()<12){
                     binarySBC = "0" + binarySBC;
                   }
                   output = output + binarySBC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintOR = Integer.parseInt(modifierOR, 16);
                   String binaryOR = Integer.toBinaryString(decimalintOR);
                   while(binaryOR.length()<12){
                     binaryOR = "0" + binaryOR;
                   }
                   output = output + binaryOR;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintXOR = Integer.parseInt(modifierXOR, 16);
                   String binaryXOR = Integer.toBinaryString(decimalintXOR);
                   while(binaryXOR.length()<12){
                     binaryXOR = "0" + binaryXOR;
                   }
                   output = output + binaryXOR;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintAND = Integer.parseInt(modifierAND, 16);
                   String binaryAND = Integer.toBinaryString(decimalintAND);
                   while(binaryAND.length()<12){
                     binaryAND = "0" + binaryAND;
                   }
                   output = output + binaryAND;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintLDC = Integer.parseInt(modifierLDC, 16);
                   String binaryLDC = Integer.toBinaryString(decimalintLDC);
                   while(binaryLDC.length()<12){
                     binaryLDC = "0" + binaryLDC;
                   }
                   output = output + binaryLDC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintBCC = Integer.parseInt(modifierBCC, 16);
                   String binaryBCC = Integer.toBinaryString(decimalintBCC);
                   while(binaryBCC.length()<12){
                     binaryBCC = "0" + binaryBCC;
                   }
                   output = output + binaryBCC;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintBNE = Integer.parseInt(modifierBNE, 16);
                   String binaryBNE = Integer.toBinaryString(decimalintBNE);
                   while(binaryBNE.length()<12){
                     binaryBNE = "0" + binaryBNE;
                   }
                   output = output + binaryBNE;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintLDA = Integer.parseInt(modifierLDA, 16);
                   String binaryLDA = Integer.toBinaryString(decimalintLDA);
                   while(binaryLDA.length()<12){
                     binaryLDA = "0" + binaryLDA;
                   }
                   output = output + binaryLDA;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
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
                   int decimalintSTA = Integer.parseInt(modifierSTA, 16);
                   String binarySTA = Integer.toBinaryString(decimalintSTA);
                   while(binarySTA.length()<12){
                     binarySTA = "0" + binarySTA;
                   }
                   output = output + binarySTA;
                  System.out.println(output);
                  
                  try{
                      fw.write(output+"\n");
                      
                  }catch(IOException es){
                     es.getMessage();
                  }
               }
          address = address+1;
  
           }
           fw.close();
        }
    }
}

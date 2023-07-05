
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
      
       String st;
        // Condition holds true till
        // there is character in a string
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
           while ((st = reader.readLine()) != null){
            System.out.println(st);
           }
        }
    }
}

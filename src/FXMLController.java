/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author 98902
 */


public class FXMLController implements Initializable {

  
   @FXML
   private Label output;

     
   @FXML
   private Label input;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnChoseFile(ActionEvent event) throws FileNotFoundException, IOException{
         JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
       
        int returnVal = chooser.showOpenDialog(null);
         File fileToSave = chooser.getSelectedFile();
         //String fileToSave = chooser.getSelectedFile().getAbsolutePath();
        // System.out.println(fileToSave);

        
//         long lines = 0;
//      try (BufferedReader reader = new BufferedReader(new FileReader(fileToSave))) {
//          while (reader.readLine() != null) lines++;
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//      System.out.println(lines);
        assemble as = new assemble(fileToSave);
        as.assembleCode();
    }

    @FXML
    private void btnGenerate(ActionEvent event) {
    }
    
}

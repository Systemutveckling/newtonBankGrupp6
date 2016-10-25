/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnewtonbank;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static testnewtonbank.FXMLDocumentController.customer;

/**
 *
 * @author skate
 */
public class checkAccountController implements Initializable {
  

    
    
@FXML
    private ListView cust;  
    @FXML
    private Label staticName;
    @FXML
    private Label changeName;
    @FXML
    private ObservableList customerList;
    
    @FXML
    private void goBack(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
    }
    
    @FXML
    private void seeAccountInfo(ActionEvent event) {
        
        
        if(cust.getSelectionModel().getSelectedItem() != null ){     
            
        staticName.setVisible(true);
        changeName.setVisible(true);
        for(Customer c : FXMLDocumentController.p.getCustomerList()){
           if(cust.getSelectionModel().getSelectedItem().equals(String.valueOf(c.getName()))){
            changeName.setText(c.getName());
            System.out.println(c.getName());
            
           } 
           
            
            
        }
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cust.setItems(FXMLDocumentController.customer);
        staticName.setVisible(false);
        changeName.setVisible(false);
        
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnewtonbank;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author skate
 */
public class FXMLDocumentController implements Initializable {
    
    public static Customer c = new Customer();
    
    @FXML
    private Label label;
    @FXML
    private Button registerCustomer;
    @FXML
    private Button account;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField saldo;
    
    
    @FXML
     public static ObservableList<String> customer = FXCollections.observableArrayList();
    @FXML
    private void checkAccount(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("checkAccount.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    
    
    @FXML
        private void registerAccount(ActionEvent event) {
            
         if(name.getText() == null || name.getText().isEmpty()){
        label.setText("Please you need to enter a name");
        } else{ 
           c.setName(name.getText());
        customer.add(c.getName());
        label.setText("the account has been registered!");
        }
          
            
            
   
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

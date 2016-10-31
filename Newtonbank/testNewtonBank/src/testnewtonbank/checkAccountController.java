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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static testnewtonbank.FXMLDocumentController.p;

/**
 *
 * @author skate
 */
public class checkAccountController implements Initializable {
  

    
    public static int addHardCodedCostumers = 0;
    
    @FXML
    public static ObservableList<String> customer = FXCollections.observableArrayList();
    @FXML
    private ListView cust;  
    @FXML
    private Label showSsn;
    @FXML
    private Label showName;
    @FXML
    private Label showAccount;
    @FXML
    public static ObservableList<String> accounts = FXCollections.observableArrayList();
    @FXML
    private Label showNr;
    @FXML
    private Label showBalance;
    @FXML
    private Label showInterest;
    
    @FXML
    private ObservableList customerList;
    
    @FXML
    private void addCustomer(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
    }
    
    @FXML
    private void seeAccountInfo(MouseEvent event) {
        
        if(cust.getSelectionModel().getSelectedItem() != null)
             
            
       
        for(Customer c : FXMLDocumentController.p.getCustomerList()){
            
        String str = (String)cust.getSelectionModel().getSelectedItem();
        
            if(str.substring(str.length()-12, str.length()).equals(String.valueOf(c.getSsn()))){
            showName.setText("Name: " +  c.getName());
            
            showSsn.setText("Ssn: " + c.getSsn());
            
            showAccount.setText("Accounts");
            for(SavingsAccount sa : c.getNumberOfAccount()){
            
            accounts.add(sa.getAccountNo() + " " + sa.getAccountType());
            }
            }
        
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(addHardCodedCostumers < 1){
        
        p.addCustomer("Hampus", 199112253519L);
        p.addSavingsAccount(199112253519L);
        p.addCustomer("Joel", 199112245401L);
        p.addSavingsAccount(199112245401L);
        p.addCustomer("Alexiz", 199112253192L);
        p.addSavingsAccount(199112253192L);
        ++addHardCodedCostumers;
        System.out.println(addHardCodedCostumers);
        }
        checkAccountController.customer = FXCollections.observableArrayList(p.getCustomers());
        cust.setItems(customer);
        
        
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnewtonbank;

import java.util.ArrayList;

/**
 *
 * @author skate
 */
public class BankLogic {
    
    
    private ArrayList <Customer> customerList = new ArrayList();
    
    public BankLogic(){
        
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public boolean addCustomer(String name,String ssn){
        Customer c = new Customer(name, ssn);
        customerList.add(c);
        
        return true;
        
    }
    
}

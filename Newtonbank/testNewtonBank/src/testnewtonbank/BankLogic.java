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
    
    public int addSavingsAccount(long ssn){
        boolean flag = false;
        SavingsAccount sa = new SavingsAccount();
        for(Customer c : customerList){
            if(c.getSsn().equals(ssn)){
                c.getNumberOfAccount().add(sa);
                flag = true;
            }
        }
        if(flag == false){
            return -1;
        } else {
            return sa.getAccountNo();
        }
    }
    
    public boolean deposit(String ssn, int accountNo, double amount){
        return true;
    }
    
}

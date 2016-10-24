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
public class Customer {
    private String name;
    private String ssn;
    
    private ArrayList <SavingsAccount> numberOfAccount = new ArrayList();
    
    public Customer(){
    }
    
    public Customer(String name,String ssn){
    setName(name);
    setSsn(ssn);
    }

    public ArrayList<SavingsAccount> getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(ArrayList<SavingsAccount> numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }
    
    

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
}

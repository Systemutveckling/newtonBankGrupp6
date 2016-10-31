/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnewtonbank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skate
 */
public class BankLogic {

    private ArrayList<Customer> customerList = new ArrayList();
    private Customer d;

    public BankLogic() {

    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean addCustomer(String name, Long ssn) {
        
        boolean flag = true;
        for(Customer c : customerList){
        
            
            
            if(c.getSsn() == ssn){
                
                flag = false;
            } 
        }
        
        if(flag){
        customerList.add(new Customer(name, ssn));
        }
        
        

        return flag;

    }
     
    public List<String> getCostumer(long ssn){

        List<String> cust = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getSsn() == ssn) {
                cust.add(c.getName() + " " + c.getSsn());
                for (SavingsAccount sa : c.getNumberOfAccount()) {
                    cust.add(sa.getAccountNo() + " " + sa.getAccountType() + " " + sa.getBalance());
                }
            }
        }

        return cust;
    }

    public int addSavingsAccount(long ssn) {
        boolean flag = false;
        SavingsAccount sa = new SavingsAccount();
        for (Customer c : customerList) {
            if (c.getSsn().equals(ssn)) {
                c.getNumberOfAccount().add(sa);
                flag = true;
            }
        }
        if (flag == false) {
            return -1;
        } else {
            return sa.getAccountNo();
        }
    }

    public boolean deposit(Long ssn, int accountNo, double amount) {
        for(Customer c : customerList){
            if(c.getSsn() == ssn){
            for(SavingsAccount sa : c.getNumberOfAccount()){
            sa.setBalance(sa.getBalance() + amount);
            return true;
            }
            }
        }
        return false;
    }

    public List<String> removeCustomer(long ssn) {
        List<String> rm = new ArrayList();
        Customer temp = new Customer();
        for (Customer c : customerList) {
            if (c.getSsn() == ssn) {
                temp = c;
                rm.add("We removed " + c.getName() + " ssn = " + c.getSsn());
                for (SavingsAccount sa : c.getNumberOfAccount()) {
                    rm.add(sa.getAccountNo() + " " + sa.getAccountType() + " " + sa.getBalance() + " " + sa.getClosingBalance());
                }
                
                
            }

        }
        customerList.remove(temp);
        
        return rm;

    }

    public boolean changeCustomerName(String name, long ssn) {

        for (Customer c : customerList) {
            if (c.getSsn() == ssn) {
                c.setName(name);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public String getAccount(long ssn, int accountNo) {
        ArrayList<SavingsAccount> ac;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSsn() == ssn) {
                ac = customerList.get(i).getNumberOfAccount();
                for (SavingsAccount account : ac) {
                    if (account.getAccountNo() == accountNo) {
                        return account.toString();
                    }
                }
            }
        }
        return null;
    }

    //----------------------------------------------------------------------
// Beskrivning: gör ett uttag på kontonummer med accountNo som
// tillhör kunden ssn
// Inparametrar: long ssn, int accountNo, double amount
// Returvärde: true om insättningen lyckades annars false
//----------------------------------------------------------------------
    public boolean withdraw(long ssn, int accountNo, double amount) {

        double balance = 0;
        boolean flag = false;

        for (Customer customer : customerList) {
            if (ssn == customer.getSsn()) { //Hämtar kunden person nr.           
                for (SavingsAccount account : customer.getNumberOfAccount()) {
                    if (accountNo == account.getAccountNo()) {
                        if (amount <= account.getBalance()) {
                            account.setBalance(account.getBalance() - amount);
                            flag = true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        return flag;
    }

//----------------------------------------------------------------------
// Beskrivning: stänger konto accountNo
// Inparametrar: long ssn, int accountNo - personnummer och 
// kontonummer kontrolleras
// Returvärde: String - returnerar saldo och ränta
//----------------------------------------------------------------------
    public String closeAccount(long ssn, int accountNo) { //stänger ett konto och returnerar saldo och ränta

        boolean flag = false;
        SavingsAccount s = new SavingsAccount();
        Customer ce = new Customer();
        for (Customer c : customerList) {
            if (ssn == c.getSsn()) {
                for (SavingsAccount sa : c.getNumberOfAccount()) {
                    if (accountNo == sa.getAccountNo()) {
                        s = sa;
                        ce = c;
                        flag = true;
                    }
                }
            }
        }
        if (flag) {
            String result = "" + s.getClosingBalance();
            ce.getNumberOfAccount().remove(s);
            return "Balance including interest: " + result;
        } else {
            return "Couldn't delete account.";
        }
    }
    
    public List<String> getCustomers(){
     List<String> customerInfo = new ArrayList();   
    for(Customer c : customerList){
        customerInfo.add("name = " +  c.getName() + " Social security = " + c.getSsn());
    }
    return customerInfo;
    }

}

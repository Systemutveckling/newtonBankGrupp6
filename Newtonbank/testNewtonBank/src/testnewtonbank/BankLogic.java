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
         
        customerList.add(new Customer(name, ssn));

        return true;

    }

    public List<String> getCostumer(long ssn) {
        List<String> cust = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getSsn() == ssn) {
                cust.add(c.getName() + " " + c.getSsn());
                for(SavingsAccount sa : c.getNumberOfAccount()){
                    cust.add(sa.getAccountNo() + " " + sa.getAccountType() + " " + sa.getBalance());
                }
            }
        }

        return cust;
    }

    public List<String> removeCustomer(long ssn) {
        List<String> rm = new ArrayList();
        for (Customer c : customerList) {
            if (c.getSsn() == ssn) {
                rm.add("We removed " + c.getName() + " ssn = " + c.getSsn());
                for (SavingsAccount sa : c.getNumberOfAccount()) {
                    rm.add(sa.getAccountNo() + " " + sa.getAccountType() + " " + sa.getBalance() + " " + sa.getInterest());
                    
                }
                customerList.remove(c);
            }

        }
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
    
    public String closeAccount(long ssn, int accountNo) {
        ArrayList<SavingsAccount> ac;
        for (Customer customer : customerList) {
            if (ssn == customer.getSsn()) {
                ac = customer.getNumberOfAccount();
                if (ac == null) {
                    return null;
                }
                customerList.remove(accountNo);
                return ac.toString();
            }
        }
        return null;
}
   
}

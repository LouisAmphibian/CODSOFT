/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

/**
 *
 * @author USER
 */
class AtmHandler {
    //field
    private BankAccount account;
    
    //contructor
    public AtmHandler(BankAccount account){
        this.account = account;
    }
    
    //methods to handle user amount
    public void withdraw(double amount){
        if(amount > 0 && amount <= account.getBalance()){
            account.withdraw(amount);
        }else{
            throw new IllegalArgumentException ("Insufficient funds or invalid amount");
        }
    }
    
    public void deposit(double amount){
        if(amount>0){
            account.deposit(amount);
        }else{
            throw new IllegalArgumentException ("Invalid amount");
        }
    }
    
    public double getBalance(){
        return account.getBalance();
    }
    
}

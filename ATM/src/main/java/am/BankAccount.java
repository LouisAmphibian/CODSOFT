/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

/**
 *
 * @author USER
 */
class BankAccount {
    
    private double balance;
    
    //Contructor 
    public BankAccount(double initialBalance){
      balance = initialBalance;  
    }
    
    //methods
    public double getBalance(){
        return balance;
    }
    
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
        }else{
            throw new IllegalArgumentException ("Insufficient funds or invalid amount.");
        }
    }
    
    public void deposit(double amount){
        if(amount>0){
            balance+= amount;
        }else{
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}

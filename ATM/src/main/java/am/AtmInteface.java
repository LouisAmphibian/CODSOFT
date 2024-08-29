/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class AtmInteface extends JFrame {

    //fields
    private JTextField inputField;
    private JTextArea outputArea;
    private AtmHandler atm;
    
    
    public AtmInteface() {
        this.setTitle("ATM");
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(new GridBagLayout());
        
        //GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        
        //defaults contraints
        gbc.fill = GridBagConstraints.HORIZONTAL; //streching the grid horizontal
        gbc.insets = new Insets(40,90,40,90); //adding padding
        
        //Buttons for each task
        JButton withdrawButton = new JButton("Withdraw");
        //withdrawButton.setSize(150 , 50);
        gbc.gridx = 1; //Column 2
        gbc.gridy = 0; // Row 1
        withdrawButton.setBackground(Color.BLUE);
        withdrawButton.setForeground(Color.WHITE);
        this.add(withdrawButton,gbc);
        
        
        JButton depositButton = new JButton("Deposit");
        //withdrawButton.setSize(150 , 50);
        gbc.gridx = 1; //Column 2
        gbc.gridy = 1; //Row 2
        depositButton.setBackground(Color.BLUE);
        depositButton.setForeground(Color.WHITE);
        this.add(depositButton,gbc);
        
        JButton balanceButton = new JButton("Balance");
        //withdrawButton.setSize(150 , 50);
        gbc.gridx = 1; //Column 2
        gbc.gridy = 2; //Row 3
        balanceButton.setBackground(Color.BLUE);
        balanceButton.setForeground(Color.WHITE);
        this.add(balanceButton,gbc);
        
        JButton cancelButton = new JButton("Cancel");
        gbc.gridx = 0;
        gbc.gridy = 3; //Row 4
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        this.add(cancelButton,gbc);
        
        //output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH; //allowing text area to area expand both direction
        gbc.weightx = 1.0; //stretch
        gbc.weighty = 1.0;
        this.add(scrollPane, gbc);
        
        
        //Action listeners
        withdrawButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                handleWithdraw();
            }
        });
        
        depositButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                handleDeposit();
            }
        });
        
        balanceButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                showBalance();
            }
        });
        
        withdrawButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
               System.exit(0);
            }
        });
        
        this.setVisible(true);
    }
    
    //methods to handle the tasks
    private void handleWithdraw(){
        try{
          double amount = Double.parseDouble(inputField.getText());
          atm.withdraw(amount);
          outputArea.setText("Withdrawal successful. New balance: " + atm.getBalance());
        }catch(NumberFormatException e){
           outputArea.setText("Invalid input. Please enter a numeric value."); 
        }
    }
    
    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            atm.deposit(amount);
            outputArea.setText("Deposit successful. New balance: " + atm.getBalance());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input. Please enter a numeric value.");
        }
    }
    
    private void showBalance() {
        outputArea.setText("Current balance: " + atm.getBalance());
    }
    
    
}

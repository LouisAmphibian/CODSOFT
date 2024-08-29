/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class AtmInteface extends JFrame {

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
        depositButton.setBackground(Color.BLUE);
        depositButton.setForeground(Color.WHITE);
        this.add(balanceButton,gbc);
        
        JButton cancelButton = new JButton("Cancel");
        gbc.gridx = 0;
        gbc.gridy = 3; //Row 4
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        this.add(cancelButton,gbc);
        
        this.setVisible(true);
    }
    
}

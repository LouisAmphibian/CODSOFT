/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import javax.swing.*;

import java.io.File;
import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
/**
 *
 * @author USER
 */
public class MyFrame extends JFrame implements ActionListener{
    
    //global
    JFrame frame;
    JPanel panelOne;
    JLabel game_speech;
     String labelText;
     JButton button1;
    
    //CREATING CONTRUCTOR FOR MY FRAME 
    MyFrame(){
       
       
        // Load the image using the class loader and check for null
       //   URL imageURL = getClass().getResource("thinking.png");

      // ImageIcon icon = new ImageIcon("thinking.png");
       
        
         labelText = "<html>I'm thinking of a number between 1 and 100.  " +
                    "<br><br><span style='color:blue;'>You have 6 attempts to guess the number.</span></html>";
       /*
        if (imageURL != null) {
            String imageUrlString = imageURL.toString();
            // Construct the HTML string with the image
            labelText = "<html>I'm thinking of a number between 1 and 100. " +
                    "<img src='" + imageUrlString + "' width='16' height='16'>" +
                    "<br><br>You have 6 attempts to guess the number.</html>";
        } else {
            // Fallback in case the image is not found
            System.out.println("Image not found");
            labelText = "<html>I'm thinking of a number between 1 and 100." +
                    "<br><br>You have 6 attempts to guess the number.</html>";
        }
*/
        //label
        game_speech = new JLabel();
        game_speech.setText(labelText);
        game_speech.setVerticalAlignment(JLabel.TOP);
        game_speech.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adding margin to the label
        game_speech.setBounds(10, 10, 250, 100); // Set bounds for the label

        // Button
        button1 = new JButton("OK");
        button1.setBounds(170,370, 150, 50); // Set specific bounds for button
        button1.addActionListener(this);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setFocusable(false);
        button1.setBackground(Color.CYAN);
        button1.setForeground(Color.BLACK);
        button1.setBorder(BorderFactory.createEtchedBorder());

        // The first panel
        panelOne = new JPanel();
        panelOne.setBounds(110, 40, 270, 300);
        panelOne.setLayout(null); // Use null layout for absolute positioning
        panelOne.setBackground(new Color(192, 192, 192));
        panelOne.add(game_speech);
        

        frame = new JFrame();
        
        frame.setTitle("Number Game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button1);
        frame.add(panelOne);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action listener for button1
        if (e.getSource() == button1) {
            // Handle button click event
            System.out.println("Button clicked!");
        }
    }
    
}
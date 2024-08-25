/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.io.File;
import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author USER
 */
public class MyFrame extends JFrame {
    
    //global
    JFrame frame;
    JPanel panelOne;
    JLabel game_speech;
     String labelText;
    
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
        //game_speech.setIcon(icon);
        game_speech.setText(labelText);
         game_speech.setVerticalAlignment(JLabel.TOP);
        game_speech.setBorder(new EmptyBorder(10,10,10,10)); //Adding marging to the lsbel
      
        //The first panel 
        panelOne = new JPanel();
        panelOne.setBounds(115,100,270,300);
        panelOne.setLayout(new BorderLayout());        
        panelOne.setBackground(new Color(192, 192, 192)); 
        panelOne.add(game_speech,BorderLayout.NORTH);
        
        
        frame = new JFrame();
        
        frame.setTitle("Number Game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(panelOne);
        
}
}
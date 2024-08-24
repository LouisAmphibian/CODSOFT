/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.awt.BorderLayout;
import java.awt.Color;
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
    
    //CREATING CONTRUCTOR FOR MY FRAME 
    MyFrame(){
        
        //label
        game_speech = new JLabel();
        game_speech.setText("""
                            <html>I'm thinking of a number between 1 and 100.
                            <br><br>You have 6 attempts to guess the number.</html>""");
        game_speech.setBorder(new EmptyBorder(10,10,10,10)); //Adding marging to the lsbel
        
        //The first panel 
        panelOne = new JPanel();
        panelOne.setBounds(115,100,250,300);
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

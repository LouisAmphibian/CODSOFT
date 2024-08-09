/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class MyFrame extends JFrame {
    
    //global
    JFrame frame;
    
    //CREATING CONTRUCTOR FOR MY FRAME 
    MyFrame(){
        
        frame = new JFrame();
        frame.setTitle("Number Game");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author USER
 */
public class CustomTextField extends JTextField {
    
    private String placeholder;
    
    //Constructor 
    public CustomTextField(String placeholder){
        this.placeholder = placeholder;
        
         setForeground(Color.BLACK);
        setCaretColor(Color.BLACK);
        
        //handle the placeholder logic
        addFocusListener(new FocusListener(){
        @Override public void  focusGained(FocusEvent e){
            if (getText().equals(placeholder)){
                setText("");
                setForeground(Color.BLACK);
            }
        }
        
        @Override public void focusLost(FocusEvent e){
            if (getText().isEmpty()){
                setText(placeholder);
                setForeground(Color.LIGHT_GRAY);
            }
        }
    });
        //set initail state placeholder
        setText(placeholder);
        setForeground(Color.LIGHT_GRAY);
    }
}

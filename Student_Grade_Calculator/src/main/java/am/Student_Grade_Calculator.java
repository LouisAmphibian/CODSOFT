/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package am;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author USER
 */
public class Student_Grade_Calculator {

    public static void main(String[] args) {
        
        //DECLARE
        int numberOfSubjects;
        
        //the exception hanlde 
        try{
            //prompting the usser to enter subjects
            String input = JOptionPane.showInputDialog(null, "Enter the number of subjects:");
            numberOfSubjects = Integer.parseInt(input);
            
            //Condition for number size must be above 0
            if(numberOfSubjects<= 0){
                JOptionPane.showMessageDialog(null, "Please enter a valid number of subjects.");
                return;
            }else{
              //For thread safety
              SwingUtilities.invokeLater(() -> {  
              GUI graadeCalculator = new GUI(numberOfSubjects);
              graadeCalculator.setVisible(true);
              });
            }
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please enter a valid number of subjects.");
            return;
        }
        
    }
}

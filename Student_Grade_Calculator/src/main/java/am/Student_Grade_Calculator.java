/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package am;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ayanda.m
 */
public class Student_Grade_Calculator {

    public static void main(String[] args) {
        
        //DECLARE
        
        int maxNumberOfSubject = 12;
        boolean validInput = false;
        
        
        while(!validInput){
            
        int numberOfSubjects;
        //the exception hanlde 
        try{
            
            //prompting the usser to enter subjects
            String input = JOptionPane.showInputDialog(null, "Enter the number of subjects (Max 12 Subjects):");
            
            if(input == null){
                 JOptionPane.showMessageDialog(null, "Operation cancelled.");
                 return;
            }
            
            numberOfSubjects = Integer.parseInt(input);
            
            //Condition for number size must be above 0
            if(numberOfSubjects<= 0){
                JOptionPane.showMessageDialog(null, "Please enter a valid number of subjects.");
            }else if(numberOfSubjects > maxNumberOfSubject){
                JOptionPane.showMessageDialog(null, "Please enter less than 12 Subjects");
            } 
            else{
              //For thread safety
              SwingUtilities.invokeLater(() -> {  
              GUI graadeCalculator = new GUI(numberOfSubjects);
              graadeCalculator.setVisible(true);
              });
              validInput = true;
            }
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Please enter a valid number of subjects.");
            return;
        }
        
    }
   }     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
class GUI extends JFrame{
    
    //declare 
    private JTextField[] marksFields;
    private JTextField totalField, averageField, gradeField;
    
    public GUI(int numberOfSubjects){
        
         //Frame
        this.setTitle("Grade Calculato");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(numberOfSubjects + 1, 2));
        marksFields = new JTextField[numberOfSubjects];
        
        //loop to create inputPanel and marksFields based on the number Of Subjects
        for(int i = 0;i<numberOfSubjects;i++){
            inputPanel.add(new JLabel("Marks for Subject " + (i + 1) + " (out of 100):"));
            marksFields[i] = new JTextField();
            inputPanel.add(marksFields[i]);
        }
        
        
     
        
        //Calculate button
        JButton calculateButton = new JButton("Calculate");
        
        //Reset button
        JButton resetButton = new JButton("New Entry");

        // Panel for buttons (Calculate and Reset)
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // GridLayout with 1 row, 2 columns
        buttonPanel.add(calculateButton);
        buttonPanel.add(resetButton);
        
        //Panel to display result
        JPanel resultsPanel = new JPanel();
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        resultsPanel.setLayout(new GridLayout(3, 2));
        
        //text field to display result only
        totalField= new JTextField();
        totalField.setEditable(false); // Make the text field non-editable
      
        averageField = new JTextField();
        averageField.setEditable(false); 
    
        gradeField = new JTextField();
        gradeField.setEditable(false); 
        

        //add to panel
        resultsPanel.add(new JLabel("Total Marks: "));
        resultsPanel.add(totalField);
        
        resultsPanel.add(new JLabel("Average Percentage: "));
        resultsPanel.add(averageField);
        
        resultsPanel.add(new JLabel("Grade: "));
        resultsPanel.add(gradeField);
        
         // Add button panel to input panel
        inputPanel.add(new JLabel()); // Empty label to align buttons correctly
        inputPanel.add(buttonPanel);
        
        //add to frame
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(resultsPanel, BorderLayout.CENTER);
        
    
        //Action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults(numberOfSubjects);
            }
        });
        
         resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields(); // Clear the fields for new input
            }
        });
        
        this.setVisible(true);
    }
    
    //calculting result
      private void calculateResults(int numberOfSubjects) {
        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            try {
                int marks = Integer.parseInt(marksFields[i].getText());
                if (marks < 0 || marks > 100) {
                    JOptionPane.showMessageDialog(this, "Please enter valid marks (0-100) for Subject " + (i + 1));
                    return;
                }
                totalMarks += marks;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid marks for Subject " + (i + 1));
                return;
            }
        }
        
        //Condition to check grading
         double averagePercentage = (double) totalMarks / numberOfSubjects;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        //adding the results to the field created
         totalField.setText(String.valueOf(totalMarks));
        averageField.setText(String.format("%.2f%%", averagePercentage));
        gradeField.setText(grade);
      }
      
       private void resetFields() {
        for (JTextField marksField : marksFields) {
            marksField.setText(""); // Clear each input field
        }
        totalField.setText("");
        averageField.setText("");
        gradeField.setText("");
    }
  
}
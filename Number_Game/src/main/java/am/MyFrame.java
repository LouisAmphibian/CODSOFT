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
   
    JPanel panelOne, panelTwo;
    JLabel game_speech;
    String labelText;
    JButton startButton, exitButton,submitButton, playAgainButton, continueButton;
    JTextField userField;
    
       private int minNumber = 1;
       private int maxNumber = 100;
       private int maxAttempts = 6;
       private int score = 0;
       private final int DEFAULT_MAX_ATTEMPTS = 6;
       private final int DEFAULT_SCORE = 0;
       private RandomGenerator randomGenerator; // Declare the RandomGenerator object
       private  int userGuess;
       String message;
   
    //CREATING CONTRUCTOR FOR MY FRAME 
    MyFrame(){
       
       
        // Load the image using the class loader and check for null
       //   URL imageURL = getClass().getResource("thinking.png");

      // ImageIcon icon = new ImageIcon("thinking.png");
       
        
         labelText = "<html>I'm thinking of a number between " + minNumber + " and"+ maxNumber +
                    "<br><br><span style='color:blue;'>You have "+ maxAttempts+ " attempts to guess the number.</span></html>";
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
        startButton = new JButton("Start");
        startButton.setBounds(170,370, 150, 50); // Set specific bounds for button
        startButton.addActionListener(this);
        startButton.setHorizontalTextPosition(JButton.CENTER);
        startButton.setFocusable(false);
        startButton.setBackground(Color.CYAN);
        startButton.setForeground(Color.BLACK);
        startButton.setBorder(BorderFactory.createEtchedBorder());
        
         //Exit Button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setHorizontalTextPosition(JButton.CENTER);
        exitButton.setFocusable(false);
        exitButton.setBounds(90,370, 150, 50);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.white);
            
            
        //Submit Button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setHorizontalTextPosition(JButton.CENTER);
        submitButton.setFocusable(false);
        submitButton.setBounds(250,370, 150, 50);
        submitButton.setBackground(Color.green);
        submitButton.setForeground(Color.white);
            
            
       //Play Again button
        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(170,370, 150, 50);
        playAgainButton.addActionListener(this);
        playAgainButton.setFocusable(false);
        playAgainButton.setBackground(Color.ORANGE);
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.setVisible(false); // Initially hidden     
            
        continueButton = new JButton("Continue");
        continueButton.setBounds(170, 370, 150 , 50);
        continueButton.addActionListener(this);
        continueButton.setFocusable(false);
        continueButton.setBackground(Color.YELLOW);
        continueButton.setForeground(Color.BLACK);
        continueButton.setVisible(false); // Initially hidden    

        // The first panel
        panelOne = new JPanel();
        panelOne.setBounds(110, 40, 270, 300);
        panelOne.setLayout(null); // Use null layout for absolute positioning
        panelOne.setBackground(new Color(192, 192, 192));
        panelOne.add(game_speech);
        
        //Second panel
        panelTwo = new JPanel();
        panelTwo .setBounds(110, 40, 270, 300);
        panelTwo .setLayout(null);
        panelTwo .setBackground(new Color(192, 192, 192));
        
        //TextField
        userField = new CustomTextField("Enter Number"); //cutom text field
        userField.setBounds(85, 150,100, 40); // Set bounds for the label
        userField.setFocusable(true);
       // userField.setHorizontalTextPosition(JButton.CENTER);

        // Initialize RandomGenerator
        randomGenerator = new RandomGenerator(this);

        // Start a new game when the frame is initialized
        randomGenerator.startNewGame(minNumber, maxNumber, maxAttempts);
        
          //startButton.addActionListener(this);
        //submitButton.addActionListener(this);
        //exitButton.addActionListener(this);
  
        this.setTitle("Number Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        
        this.add(startButton);
        this.add(panelOne);
        this.add(playAgainButton);  
        this.add(continueButton);    
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            randomGenerator.startNewGame(minNumber, maxNumber, maxAttempts);
            
        panelTwo.add(game_speech);
        panelTwo.add(userField);
        this.remove(panelOne);
        this.remove(startButton);
        this.add(exitButton);
        this.add(submitButton);
        this.add(panelTwo);
        this.revalidate();
        this.repaint();
            
            
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == submitButton) {
            String userInputStr = userField.getText();
            try {
                int userGuess = Integer.parseInt(userInputStr);
                if (userGuess >= minNumber && userGuess <= maxNumber) {
                    randomGenerator.processUserGuess(userGuess);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Please enter a valid number between " + minNumber + " and " + maxNumber + ".",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            }
        }   else if (e.getSource() == playAgainButton) {
           // Reset the game state
            score = DEFAULT_SCORE;
            maxAttempts = DEFAULT_MAX_ATTEMPTS;
            userField.setText(""); // Clear the text field
            submitButton.setEnabled(true); // Re-enable submit button
            userField.setEditable(true); // Make text field editable again
            randomGenerator.startNewGame(minNumber, maxNumber, maxAttempts); // Start a new game
            hidePlayAgainButton(); // Hide the play again button

            // Re-enable components for the new game
            panelTwo.add(game_speech);
            panelTwo.add(userField);
            this.remove(panelOne);
            this.remove(startButton);
            this.add(exitButton);
            this.add(submitButton);
            this.add(panelTwo);
            this.revalidate();
            this.repaint();
        }  else if (e.getSource() == continueButton) {
        // Proceed to the next level
        
        submitButton.setEnabled(true); // Re-enable submit button
        userField.setEditable(true); // Make text field editable again
        maxAttempts += 4; // Increasing the attempts for the next level
        randomGenerator.startNewGame(minNumber, maxNumber, maxAttempts); // Starts a new game with updated settings
        hideContinueButton(); // Hide the continue button

        // Re-enable components for the new game
        panelTwo.add(game_speech);
        panelTwo.add(userField);
        this.remove(panelOne);
        this.remove(startButton);
        this.add(exitButton);
        this.add(submitButton);
        this.add(panelTwo);
        this.revalidate();
        this.repaint();
    }
        
    }

    public void setGameSpeech(String message) {
        game_speech.setText(message);
    }

    public void endGame() {
        submitButton.setEnabled(false);
        userField.setEditable(false);
    }

    public void updateScore(int addScore) {
        score += addScore;
        String message = "<html>Your current score is: " + score + "</html>";
        game_speech.setText(message);
    }
    
    public void showPlayAgainButton() {
       
    playAgainButton.setVisible(true);
    exitButton.setVisible(false);
    submitButton.setVisible(false);
    this.revalidate();
    this.repaint();
    }

    public void hidePlayAgainButton() {
    playAgainButton.setVisible(false);
    exitButton.setVisible(true);
    submitButton.setVisible(true);
    this.revalidate();
    this.repaint();
    }

    public void showContinueButton() {
    continueButton.setVisible(true);
    exitButton.setVisible(false);
    submitButton.setVisible(false);
    this.revalidate();
    this.repaint();
    }

    public void hideContinueButton() {
    continueButton.setVisible(false);
    exitButton.setVisible(true);
    submitButton.setVisible(true);
    this.revalidate();
    this.repaint();
    }

}
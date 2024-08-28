/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package am;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
class RandomGenerator {
    
    private MyFrame frame; //reference to main frame
    private  int userGuess;
   
    public RandomGenerator(MyFrame frame){
       
        this.frame = frame;
        
    }
   
    
    public void generator (int minNumber, int maxNumber, int maxAttempts){
    
        //Random class,It can create random numbers
        Random random = new Random();
        String playAgain = "";
        int userResponse;
        
        do{
        int gameTargetNumber = random.nextInt(maxNumber-minNumber+1)+minNumber;
        int userAttemps = maxAttempts;
        boolean guessedCorrectly = false;
   
         
            do{
                
                String userText = JOptionPane.showInputDialog(null, "Enter your guess:"); // Pause for user input
                if (userText == null) { // Handle cancel or null input
                JOptionPane.showMessageDialog(null, "No input provided. Exiting.");
                return; // Exit the method if no input is provided
                }
            
                int userGuess = Integer.parseInt(userText); // Convert user input to an integer
            

                       
                   if(userGuess==gameTargetNumber){
                   guessedCorrectly = true; 
                   JOptionPane.showMessageDialog(null,"Congratulations! 😁 You guessed the correct number in " + maxAttempts + " attempts.");
                   frame.updateScore(10); //update the score
                   break;
               } else {
                   
                    userAttemps --;  // Correctly decrement attempts only if the guess is wrong
                   
                    if(userGuess < gameTargetNumber){
                    JOptionPane.showMessageDialog(null,"Too low! Try again ☹️. You have " + userAttemps + " attempts."); 
                    }else{
                    JOptionPane.showMessageDialog(null,"Too high! Try again ☹️. You have " + userAttemps + " attempts.");
                    }
               }
            if(userAttemps<= 0){
               JOptionPane.showMessageDialog(null,"You've used all " + maxAttempts + " attempts. The number was " + gameTargetNumber + "."); 
            }
              
            }while(userAttemps>0 && !guessedCorrectly);
     
          //playAgain = JOptionPane.showInputDialog("Do you want to play again? (yes/no)").toLowerCase();  
          
          userResponse = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
       }while(playAgain.equals(userResponse == JOptionPane.YES_OPTION));
    }
}

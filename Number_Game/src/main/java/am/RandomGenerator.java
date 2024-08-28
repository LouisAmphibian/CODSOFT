package am;

import java.util.Random;

/**
 *
 * @author USER
 */
class RandomGenerator {
    
    private MyFrame frame; // Reference to main frame
    private int gameTargetNumber; // The target number to guess
    private int userAttempts; // Number of attempts left
    private int maxAttempts; // Max attempts allowed
    private boolean guessedCorrectly; // To check if the number is guessed correctly

    public RandomGenerator(MyFrame frame) {
        this.frame = frame;
    }

  //start
  public void startNewGame(int minNumber, int maxNumber, int maxAttempts) {
        // Set up a new game
        this.maxAttempts = maxAttempts;
        this.userAttempts = maxAttempts;
        this.guessedCorrectly = false;
        
        // Create a new target number
        Random random = new Random();
        this.gameTargetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        
        // Update the initial message
        String message = "<html>I'm thinking of a number between " + minNumber + " and " + maxNumber + "." +
                         "<br><br><span style='color:blue;'>You have "+ maxAttempts+ " attempts to guess the number.</span></html>";
        setMessage(message);
    }
  
  //logoi
    public void processUserGuess(int userGuess) {
        if (userGuess == 10) {
            guessedCorrectly = true;
            String message = "<html><span style='color:green;'>Congratulations! 😁 You guessed the correct number!</span></html>";
            setMessage(message);
            frame.updateScore(10); // Update the score
            frame.showContinueButton(); // Show the Continue button
        } else {
            userAttempts--;  // Decrement attempts
            if (userAttempts <= 0) {
                String message = "<html><span style='color:red;'>You've used all " + maxAttempts + " attempts. The number was </span>" + gameTargetNumber + ".</html>";
                setMessage(message);
                frame.endGame();
                frame.showPlayAgainButton(); // Show Play Again button
            } else {
                String hint = userGuess < gameTargetNumber ? "Too low!" : "Too high!";
                String message = "<html>" + hint + " Try again ☹️. You have " + userAttempts + " attempts left.</html>";
                setMessage(message);
            }
        }
    }

    private void setMessage(String newMessage) {
        frame.setGameSpeech(newMessage);
    }
}

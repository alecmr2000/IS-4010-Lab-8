/*
IS 4010: Lab 8
Partners: Alec Rezelj, Kiley Hardcorn
Date: March 30, 2021
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
    JTextField userGuess;
    JButton guessButton;
    JButton playAgainButton;
    JLabel Prompt, Advice, Reminder;
    int r_RandomNum;
    // Above is declaring instance variables.

    GuessingGame() {
        Random r = new Random();
        r_RandomNum = r.nextInt(100) + 1;
        // Above is initalizing and storing the random number.

        JFrame frame = new JFrame("Guessing Game");
        frame.setLayout(new FlowLayout());
        frame.setSize(240, 120);
        // Above is creating UI Frame.

        userGuess = new JTextField(10);
        userGuess.setActionCommand("myTF");
        // Above is creating text field.

        guessButton = new JButton("Guess");
        playAgainButton = new JButton("Play Again");
        // Above is naming the buttons.

        userGuess.addActionListener(this);
        guessButton.addActionListener(this);
        playAgainButton.addActionListener(this);
        // Above is adding action ActionListeners.

        Prompt = new JLabel("Enter your Guess");
        Advice = new JLabel("");
        Reminder = new JLabel("");
        // Above is setting up the labels.

        frame.add(Prompt);
        frame.add(userGuess);
        frame.add(guessButton);
        frame.add(Advice);
        frame.add(Reminder);
        frame.add(playAgainButton);
        // Above is making all our items visible in the frame.

        frame.setVisible(true);
        // Above is making the frame itself visible.
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Guess")) {
            int guess = Integer.parseInt(userGuess.getText());
            // Above is converting and storing user input.

            if (guess < r_RandomNum) {
                Advice.setText("Too low!");
            } else if (guess > r_RandomNum) {
                Advice.setText("Too high!");
            } else if (guess == r_RandomNum) {
                Advice.setText("You got it!");
            }
            // Above if statemetns are giving advice.

            Reminder.setText("Last guess was " + guess);
            // Above is displaying the user's guess.
        }

        else if (ae.getActionCommand().equals("Play Again")) {
            Random r = new Random();
            r_RandomNum = r.nextInt(100) + 1;
            // Above is creating a new random number.

            Prompt.setText("Enter your Guess");
            Advice.setText("");
            Reminder.setText("");
            // Above is resetting the labels.

            userGuess.setText("");
            // Above is resetting user input box.
        }

        else {
            Advice.setText("You pressed Enter. Please press the Guess Button.");
        }
        // Above is what occurs if user presses enter.
    }
}
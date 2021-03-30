/*
IS 4010: Lab 8
Partners: Alec Rezelj, Kiley Hardcorn
Date: March 30, 2021
*/

import javax.swing.*;

class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessingGame();
            }
        });
    }
}
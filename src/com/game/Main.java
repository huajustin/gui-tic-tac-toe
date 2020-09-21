package com.game;

import com.game.Game.TicTacToeGame;
import com.game.Player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        Scanner userInputScanner = new Scanner(System.in);

        game.init();

        while (!game.hasEnded()) {
            Player currentPlayer;

            while (!game.hasWinnerOrTie()) {
                currentPlayer = game.getCurrentPlayer();
                currentPlayer.play();
                game.checkWinner();
            }

            if (game.getWinner() == null) {
                System.out.println("There was a tie! Play again? (y/n)");
            } else {
                System.out.println(game.getWinner().getName() + " has won! Play again? (y/n)");
            }
            String userInput = userInputScanner.nextLine();

            while (!userInput.toLowerCase().equals("y") && !userInput.toLowerCase().equals("n")) {
                System.out.println("Please enter a valid input. Play again? (y/n)");
                userInputScanner.nextLine();
            }

            if (userInput.toLowerCase().equals("y")) {
                game.restart();
            } else {
                System.out.println("Goodbye!");
                game.end();
            }
        }
    }
}

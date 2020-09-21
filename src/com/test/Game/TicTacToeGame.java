package com.test.Game;

import com.test.GUI.GUI;
import com.test.Player.CPU;
import com.test.Player.Player;
import com.test.Player.User;

public class TicTacToeGame {

    private final GUI gameWindow;
    private final Player[] players;
    private Player gameWinner;
    private volatile Player currentPlayer;
    private boolean hasEnded = false;
    private volatile boolean hasWinnerOrTie = false;

    public TicTacToeGame() {
        gameWindow = new GUI(this);
        players = new Player[2];
        players[0] = new User(this);
        players[1] = new CPU(this, gameWindow);

        currentPlayer = players[0];
    }

    public void init() {
        gameWindow.createWindow();
    }

    public boolean hasEnded() {
        return this.hasEnded;
    }

    public boolean hasWinnerOrTie() {
        return this.hasWinnerOrTie;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void endTurn() {
        if (this.players[0].equals(this.getCurrentPlayer())) {
            this.currentPlayer = players[1];
        } else {
            this.currentPlayer = players[0];
        }
    }

    public Player getWinner() {
        return gameWinner;
    }

    public void restart() {
        this.currentPlayer = players[0];
        this.hasWinnerOrTie = false;
        gameWindow.clear();
    }

    public void end() {
        hasEnded = true;
        gameWindow.destroy();
    }

    public void checkWinner() {
        if (gameWindow.checkWinner()) {
            gameWinner = currentPlayer;
            hasWinnerOrTie = true;
        } else if (gameWindow.checkFull()){
            hasWinnerOrTie = true;
            gameWinner = null;
        }
    }
}

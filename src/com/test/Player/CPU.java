package com.test.Player;

import com.test.GUI.GUI;
import com.test.Game.TicTacToeGame;

public class CPU implements Player {
    private final String name;
    private final TicTacToeGame game;

    // provide the CPU access to the underlying game board
    private final GUI gameBoard;

    public CPU(TicTacToeGame game, GUI gameBoard) {
        name = "X";
        this.game = game;
        this.gameBoard = gameBoard;
    }

    @Override
    public void play() {
        int randomSpot = (int) (Math.random() * 9);
        System.out.println(randomSpot);
        while (gameBoard.isMarked(randomSpot)) {
            randomSpot = (int) (Math.random() * 9);
            System.out.println(randomSpot);
        }

        gameBoard.markSpace(randomSpot, this);
    }

    @Override
    public String getName() {
        return name;
    }
}

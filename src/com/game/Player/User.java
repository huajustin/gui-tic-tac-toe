package com.game.Player;

import com.game.Game.TicTacToeGame;

public class User implements Player {
    private String name;
    private final TicTacToeGame game;

    public User(TicTacToeGame game) {
        name = "O";
        this.game = game;
    }

    @Override
    public void play() {
        while (game.getCurrentPlayer().equals(this)) {
            // wait until game state has changed to other player
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

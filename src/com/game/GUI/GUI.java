package com.game.GUI;

import com.game.Game.TicTacToeGame;
import com.game.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private final int GUI_WIDTH = 300;
    private final int GUI_HEIGHT = 300;
    private final Color DEFAULT_BUTTON_COLOR = new JButton().getBackground();

    private final JFrame frame;
    private final JPanel board;
    private final JButton[] gameSpaces;
    private final TicTacToeGame game;

    public GUI(TicTacToeGame game) {
        this.game = game;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GUI_WIDTH,GUI_HEIGHT);

        board = new JPanel();
        board.setLayout(new GridLayout(3,3));
        gameSpaces = new JButton[9];

        for (int i = 0; i < 9; i++) {
            gameSpaces[i] = new JButton();
            gameSpaces[i].addActionListener(new PlayerButtonClick());
            board.add(gameSpaces[i]);
        }

        frame.add(board);
    }

    public void createWindow() {
        frame.setVisible(true);
    }

    public void clear() {
        for (int i = 0; i < 9; i++) {
            gameSpaces[i].setText("");
            gameSpaces[i].setEnabled(true);
            gameSpaces[i].setBackground(DEFAULT_BUTTON_COLOR);
        }
    }

    public void destroy() {
        frame.setVisible(false);
        frame.dispose();
    }

    public void markSpace(int cell, Player player) {
        gameSpaces[cell].setText(player.getName());
        gameSpaces[cell].setEnabled(false);
        System.out.println("CPU made a move!");
        game.endTurn();
    }

    public boolean isMarked(int cell) {
        return !gameSpaces[cell].isEnabled();
    }

    public boolean checkWinner() {
        if (checkSpaceEquality(0, 1) && checkSpaceEquality(1, 2)) {
            markWinningLine(0, 1, 2);
            return true;
        } else if (checkSpaceEquality(3, 4) && checkSpaceEquality(4, 5)) {
            markWinningLine(3, 4, 5);
            return true;
        } else if (checkSpaceEquality(6, 7) && checkSpaceEquality(7, 8)) {
            markWinningLine(6, 7, 8);
            return true;
        } else if (checkSpaceEquality(0, 3) && checkSpaceEquality(3, 6)) {
            markWinningLine(0, 3, 6);
            return true;
        } else if (checkSpaceEquality(1, 4) && checkSpaceEquality(4, 7)) {
            markWinningLine(1, 4, 7);
            return true;
        } else if (checkSpaceEquality(2, 5) && checkSpaceEquality(5, 8)) {
            markWinningLine(2, 5, 8);
            return true;
        } else if (checkSpaceEquality(0, 4) && checkSpaceEquality(4, 8)) {
            markWinningLine(0, 4, 8);
            return true;
        } else if (checkSpaceEquality(2, 4) && checkSpaceEquality(4, 6)) {
            markWinningLine(2, 4, 6);
            return true;
        }

        return false;
    }

    public boolean checkFull() {
        return !gameSpaces[0].getText().equals("") &&
                !gameSpaces[1].getText().equals("") &&
                !gameSpaces[2].getText().equals("") &&
                !gameSpaces[3].getText().equals("") &&
                !gameSpaces[4].getText().equals("") &&
                !gameSpaces[5].getText().equals("") &&
                !gameSpaces[6].getText().equals("") &&
                !gameSpaces[7].getText().equals("") &&
                !gameSpaces[8].getText().equals("");
    }

    private boolean checkSpaceEquality(int space1, int space2) {
        return gameSpaces[space1].getText().equals(gameSpaces[space2].getText()) && !gameSpaces[space1].getText().equals("");
    }


    private void markWinningLine(int space1, int space2, int space3) {
        gameSpaces[space1].setBackground(Color.GREEN);
        gameSpaces[space2].setBackground(Color.GREEN);
        gameSpaces[space3].setBackground(Color.GREEN);
    }

    class PlayerButtonClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonSource = (JButton) e.getSource();
            buttonSource.setText(game.getCurrentPlayer().getName());
            buttonSource.setEnabled(false);
            System.out.println("Button clicked!");
            game.endTurn();
        }
    }

}





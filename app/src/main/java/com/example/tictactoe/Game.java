package com.example.tictactoe;

import android.util.Log;

import java.io.Serializable;

public class Game implements Serializable {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    public GameState gamestate;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    public Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        playerOneTurn = true;
        gameOver = false;
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;
    }

    public TileState choose(int row, int column) {

        if (board[row][column] == TileState.BLANK) {
            if (playerOneTurn) {
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                return TileState.CROSS;
            } else {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        } else {
            board[row][column] = TileState.INVALID;
            return TileState.INVALID;
        }
    }

    public GameState won() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Log.d("waw", "TileState eerste"+ i + board[i][0]);
            Log.d("waw", "TileState tweede"+ i + board[i][1]);
            Log.d("waw", "TileStates derde rij"+ i +board[i][2]);

            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                if (board[i][0] == TileState.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                } else if (board[i][0] == TileState.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            } else if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                if (board[0][i] == TileState.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                } else if (board[0][i] == TileState.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            } else if (board[0][i].equals(board[1][1]) && board[0][i].equals(board[2][BOARD_SIZE - 1 - i])) {
                if (board[0][i] == TileState.CROSS) {
                    gameOver = true;
                    return GameState.PLAYER_ONE;
                } else if (board[0][i] == TileState.CIRCLE) {
                    gameOver = true;
                    return GameState.PLAYER_TWO;
                }
            }
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == TileState.BLANK) {
                    return GameState.IN_PROGRESS;
                }
            }
        }
            gameOver = true;
            return GameState.DRAW;
    }
}
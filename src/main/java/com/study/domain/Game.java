package com.study.domain;

import java.util.Stack;

public class Game {
    private Board board;
    private Stack<SnapShot> history;

    public Game() {
        board = new Board();
        history = new Stack<>();
    }

    public boolean move(String fieldToSet, Integer figureToSet) {
        save();
        return board.setOneMove(fieldToSet, figureToSet);
    }

    public void save() {
        history.push(board
                .createSnapshot());
    }

    public boolean undo() {
        if (history.empty()){
            System.out.println("There is nothing to restore");
            return false;
        }
        history.pop()
                .restore();
        System.out.println("Values have been restored");
        return true;
    }
}

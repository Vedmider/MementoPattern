package com.study.domain;

import java.util.*;

public class SnapShot implements Memento {
    private Board board;
    private Map<Character, List<Integer>> originalBoardState = new HashMap<>();

    public SnapShot(Board board, Map<Character, List<Integer>> boardState) {
        this.board = board;
        originalBoardState.put('A', new ArrayList<>(boardState.get('A')));
        originalBoardState.put('B', new ArrayList<>(boardState.get('B')));
        originalBoardState.put('C', new ArrayList<>(boardState.get('C')));
    }

    @Override
    public void restore() {
        board.setBoardState(originalBoardState);
    }
}

package com.study.domain;

import java.util.*;

public class Board {
    private static final List<Integer> initialFieldsState = Arrays.asList(-1, -1, -1);
    private static final Map<Character, List<Integer>> initialBoard = new HashMap<>();
    private Map<Character, List<Integer>> boardState;

    public Board() {
        initialBoard.put('A', initialFieldsState);
        initialBoard.put('B', initialFieldsState);
        initialBoard.put('C', initialFieldsState);
        boardState = initialBoard;
    }

    public void setBoardState(Map<Character, List<Integer>> boardState) {
        this.boardState = boardState;
    }

    public boolean setOneMove(String fieldToSet, Integer figureToSet) {
        Character row = fieldToSet.charAt(0);
        int column = Character.getNumericValue(fieldToSet.charAt(1));

        if (column > 3 || boardState.get(row).get(column) != -1) {
            System.out.println("invalid column or field is not empty");
            return false;
        }

        ArrayList<Integer> tempArrayList = new ArrayList<>(boardState.get(row));
        tempArrayList.add(column, figureToSet);
        boardState.put(row, tempArrayList);
        System.out.println("Successfully set value");
        return true;
    }

    public SnapShot createSnapshot() {
        return new SnapShot(this, boardState);
    }

}

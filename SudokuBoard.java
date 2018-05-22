package com.leo.sudoku;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(){
        this.board = new int[9][9];
    }

    public void add(int num, int x, int y){
        board[x][y] = num;
    }

    public int check(int x, int y){
        return board[x][y];
    }
    
    public int[][] showBoard(){
    	return board;
    }
    
    public int[] showColumn(int row){
    	return board[row];
    }
}

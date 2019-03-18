package com.leo.sudoku;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard(){
        this.board = new int[9][9];
    }

    //Set the number at the given position
    public void add(int num, int x, int y){
        board[x][y] = num;
    }

    //Returns the number at the given position
    public int check(int x, int y){
        return board[x][y];
    }
   
    //Returns board as a 2d array
    public int[][] showBoard(){
    	return board;
    }
    
    //Show an entire column
    public int[] showColumn(int row){
    	return board[row];
    }
 
}
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

    public boolean checkAnswer(int[][] ans){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(ans[i][j] != board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] showBoard(){
    	return board;
    }
    
    public int[] showColumn(int row){
    	return board[row];
    }
    
    public void displayBoard(){
        coverInternal(0);
    }
    
    private void coverInternal(int lvl){
        int blanks = detBlanks(lvl);
        int spaces = 81;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(isBlank(blanks, spaces)){
                    System.out.print(" ");
                    blanks--;
                } else {
                    System.out.print(board[i][j]);
                }
                System.out.print("  ");
                spaces--;
            }
            System.out.println("\n");
        }
    }
    
    private boolean isBlank(int blanks, int spaces){
        double prob = ((double)(blanks)) / ((double)(spaces));
        if(prob >= Math.random()){
            return true;
        }
        return false;
    }
    
    private int detBlanks(int lvl){
        int blanks = 0;
        switch(lvl){
            case 1: blanks = 40;
                break;
            case 2: blanks = 33;
                break;
            case 3: blanks = 28;
                break;
        }
        return blanks;
    }
    
}

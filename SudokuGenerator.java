package com.leo.sudoku;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuGenerator {
    
  public boolean isSolved(SudokuBoard puzzle){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(!sudCheck(puzzle, puzzle.check(i, j), i, j)){
          return false;
        }
      }
    }
    return true;
  }
	
  public boolean populateBoard(SudokuBoard board){
    ArrayList<Integer> numList = createNumList();
    for(int row = 0; row < 9; row++){
      for(int column = 0; column < 9; column++){
        if(board.check(row, column) == 0){
          Collections.shuffle(numList);
          for(int i = 0; i < 9; i++){
            if(sudCheck(board, numList.get(i), row, column)){
              board.add(numList.get(i), row, column);
              if(populateBoard(board)){
                return true;
              } else {
                board.add(0, row, column);
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  
  private ArrayList<Integer> createNumList(){
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0; i < 9; i++){
      list.add(i + 1);
    }
    return list;
  }
	
  private boolean sudCheck(SudokuBoard board, int num, int row, int column){
    if(checkRow(board, num, row)){
      if(checkColumn(board, num, column)){
        if(checkQuadrant(board, num, row, column)){
          return true;
        }
      }
    }
    return false;
  }
	
  private boolean checkRow(SudokuBoard board, int num, int row){
    for(int i = 0; i < 9; i++){
      if(board.check(row, i) == num){
        return false;
      }
    }
    return true;		
  }
	
  private boolean checkColumn(SudokuBoard board, int num, int column){
    for(int i = 0; i < 9; i++){
      if(board.check(i, column) == num){
        return false;
      }
    }
    return true;
  }
	
  private boolean checkQuadrant(SudokuBoard board, int num, int row, int column){
    int rowQuad = row / 3;
    int colQuad = column / 3;
    for(int i = 0; i < 9; i++){
      if((i / 3) == rowQuad){
        for(int j = 0; j < 9; j++){
          if((j / 3) == colQuad){
            if(board.check(i, j) == num){
              return false;
            }
          }
        }
      }
    }
    return true;
  }
	
}

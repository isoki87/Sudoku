package com.leo.sudoku;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuGenerator {
	//Variables can be better named, board.set() instead of board.add()
	//board.get() instead of board.check();
    
  public boolean populateBoard(SudokuBoard board){
  	//List of numbers to choose from
    ArrayList<Integer> numList = createNumList();
    
    //For each square, we want to put in a random number.
    //Before we put the number in, we will first check if it is valid
    //If it is valid, we add the number to the square
    //Then, we want to move on the the next square.
    //If all 9 numbers are not valid, return false;
    //This "false" will reset the current square back to 0, and 
    //we will backtrack.
    for(int row = 0; row < 9; row++){
      for(int column = 0; column < 9; column++){
      	
      	//If current square is 0, that means it is a blank that we need to solve
        if(board.check(row, column) == 0){
        	//Randomly shuffles numbers list, this may not be necessary
          Collections.shuffle(numList);
          //Try to fit all 9 numbers to the current square
          for(int i = 0; i < 9; i++){
          	//If the current number is valid, add it to the square
            if(sudCheck(board, numList.get(i), row, column)){
              board.add(numList.get(i), row, column);
              //
              if(populateBoard(board)){
                return true;
              } else {
              	//Reset current square back to blank if a false is returned
              	//Which means the next square exhausted all 9 options
                board.add(0, row, column);
              }
            }
          }
          //This false happens when the all 9 numbers on the list do not work
          return false;
        }
      }
    }
    //This true happens when we are past the 81st square, which means all previous numbers worked out
    return true;
  }
  
  //Generates the numbers to add
  private ArrayList<Integer> createNumList(){
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 0; i < 9; i++){
      list.add(i + 1);
    }
    return list;
  }
	
  //Checks for row, column, and sector validity
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
	
  //Checks the row
  private boolean checkRow(SudokuBoard board, int num, int row){
    for(int i = 0; i < 9; i++){
      if(board.check(row, i) == num){
        return false;
      }
    }
    return true;		
  }
	
  //Checks the column
  private boolean checkColumn(SudokuBoard board, int num, int column){
    for(int i = 0; i < 9; i++){
      if(board.check(i, column) == num){
        return false;
      }
    }
    return true;
  }
	
  //Checks the sector, not quadrant(means four)
  //See comments for cleaner code
  private boolean checkQuadrant(SudokuBoard board, int num, int row, int column){
    /*
     *  int rowSection = row / 3;
     *  int rowSectionStart = rowSection * 3;
     *  int columnSection = column / 3;
     *  int columnSectionStart = columnSection * 3;
     *   
     *  for(int i = rowSectionStart; i <= rowSectionStart + 2; i++){
     *    for(int j = columnSectionStart; j <= columnSectionStart + 2; j++){
     *      if(board[i][j] == num){
     *        return false;
     *      }
     *    }            
     *  }        
     *  return true;        
     */
  	
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
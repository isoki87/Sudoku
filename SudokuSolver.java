public class SudokuSolver {
	
  public int[][] solvePuzzle(int[][] unsolved){
    int[][] board = new int[9][9];
    copyBoard(board, unsolved);
    solveInternal(board);
    return board;
  }
	
  public boolean isSolved(int[][] puzzle){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(!sudCheck(puzzle, puzzle[i][j], i, j)){
          return false;
        }
      }
    }
    return true;
  }
	
  private boolean solveInternal(int[][] board){
    ArrayList<Integer> numList = createNumList();
    for(int row = 0; row < 9; row++){
      for(int column = 0; column < 9; column++){
        if(board[row][column] == 0){
          Collections.shuffle(numList);
          for(int i = 0; i < 9; i++){
            if(sudCheck(board, numList.get(i), row, column)){
              board[row][column] = numList.get(i);
              if(solveInternal(board)){
                return true;
              } else {
                board[row][column] = 0;
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
    for(int i = 0; i < list.size(); i++){
      list.add(i + 1);
    }
    return list;
  }
	
  private boolean sudCheck(int[][] board, int num, int row, int column){
    if(checkRow(board, num, row)){
      if(checkColumn(board, num, column)){
        if(checkQuadrant(board, num, row, column)){
          return true;
        }
      }
    }
    return false;
  }
	
  private boolean checkRow(int[][] board, int num, int row){
    for(int i = 0; i < 9; i++){
      if(board[row][i] == num){
        return false;
      }
    }
    return true;		
  }
	
  private boolean checkColumn(int[][] board, int num, int column){
    for(int i = 0; i < 9; i++){
      if(board[i][column] == num){
        return false;
      }
    }
    return true;
  }
	
  private boolean checkQuadrant(int[][] board, int num, int row, int column){
    int rowQuad = row / 3;
    int colQuad = column / 3;
    for(int i = 0; i < 9; i++){
      if((i / 3) == rowQuad){
        for(int j = 0; j < 9; j++){
          if((j / 3) == colQuad){
            if(board[i][j] == num){
              return false;
            }
          }
        }
      }
    }
    return true;
  }
	
  private void copyBoard(int[][] board, int[][] puzzle){
    for(int i = 0; i < puzzle.length; i++){
      for(int j = 0; j < puzzle.length; j++){
        board[i][j] = puzzle[i][j];
      }
    }
  }
}

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

    public void displayBoard(){
        coverInternal(0);
    }

    public void cvr2Play(String diff){
        int diffLvl = 0;
        switch(diff.toLowerCase()){
            case("easy"): diffLvl = 1;
                break;
            case("medium"): diffLvl = 2;
                break;
            case("hard"): diffLvl = 3;
                break;
        }
        coverInternal(diffLvl);
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

    private boolean isBlank(int blanks, int spaces){
        double prob = ((double)(blanks)) / ((double)(spaces));
        if(prob >= Math.random() * 1){
            return true;
        }
        return false;
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
}
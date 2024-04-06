import java.util.Scanner;

// Tic-Tac-Toe Game
// @author: Frank King
// @date: 1/29/2024

public class TicTacToe {
  public final int ROWS = 3;
  public final int COLS = 3;
  public final char[] PLAYERS = { 'X', 'O' };

  private int currPlayer; // whose turn it is, either 1 or 2 (1-->X, 2-->O)
  private char[][] board; // represents the board

  private Scanner scan; // for user input

  // constructor
  // instantiate the Scanner object
  // instantiate the board and make it empty (ie, full of space chars)
  public TicTacToe() {
    scan = new Scanner(System.in);

    board = new char[ROWS][COLS];
    for (int i = 0; i < ROWS; i++)
      for (int j = 0; j < COLS; j++)
        board[i][j] = ' ';
  }

  // scan user input to see who goes first
 // set currPlayer to 1 or 2, Player 1-->X, Player 2-->O
  // ensure that input is valid
  public void getFirstPlayer() {
    boolean invalid = true;
    do {
      System.out.print("Choose a player to go first (1=X, 2=O): ");
      int firstPlayer = scan.nextInt();
      if (firstPlayer == 1){
        currPlayer = 1;
        invalid = false;
      }else if (firstPlayer == 2){
        currPlayer = 2;
        invalid = false;
      }else{
        System.out.println("Invalid player");
      }
    } while (invalid);
  }

  // switch whose turn it is, 1 or 2
  public void switchPlayer() {
    if (currPlayer == 2){
      currPlayer = 1;
    }else{
      currPlayer = 2;
    }
  }

  // get the next move
  // must validate that the move is in bounds and not already occupied
  // print the board again and re-prompt on invalid move
  public void getMove() {
    int row = 0;
    int column = 0;
    boolean invalid = true;
    do{
      System.out.print("Player #"+currPlayer+", which row would you like to move to? (0-2): ");
      row = scan.nextInt();
      
      System.out.print("Player #"+currPlayer+", which column would you like to move to? (0-2): ");
      column = scan.nextInt();
      if (row < 3 && row >= 0 && column < 3 && column >= 0){
        if (board[row][column] == ' '){
          if (currPlayer == 1){
            board[row][column] = 'X';
            invalid = false;
          }else if (currPlayer == 2){
            board[row][column] = 'O';
            invalid = false;
          }
        }else{
          System.out.println("This spot has already been taken. Please try again.");
        }
      }else{
        System.out.println("Invalid move! Please try again!");
      }
    }while(invalid);
    
  }

  // determine if there is a winner
  // @return true if there are three X's or three O's in any row, col, or diag
  public boolean isWinner() {
    return (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ')
        || (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ')
        || (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ')
        || (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ')
        || (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ')
        || (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ')
        || (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
        || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
  }

  // determine if the game is a draw
  // @return true if board is full and no winner
  public boolean isDraw() {
    boolean draw = true;
    if (isWinner()){
      draw = false;
    }
    for (int r = 0; r<board.length; r++){
      for (int c = 0; c<board[r].length; c++){
        if (board[r][c] == ' '){
          draw = false;
        }
      }
    }
    return draw;
  }

  // display the current state of the board
  public void printBoard() {
    // YOU NEED TO IMPLEMENT THIS METHOD
    System.out.println("\n    Column   \n");
    System.out.println("  0   1   2");
    System.out.println(" --- --- --- ");
    System.out.println("| "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" | 0");
    System.out.println(" --- --- --- ");
    System.out.println("| "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" | 1  Row");
    System.out.println(" --- --- --- ");
    System.out.println("| "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" | 2");
    System.out.println(" --- --- --- \n");
    
  }

  // display the result of the game
  // either X wins, O wins, or it's a draw
  public void printResult() {
    printBoard();

    if (isWinner())
      System.out.println("Player " + currPlayer + " (" + PLAYERS[currPlayer-1] + ") wins!");
    else
      System.out.println("The game was a draw!");
  }
}

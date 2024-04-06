public class Main {

  public static void main(String[] args) {
    boolean gameOver = false;

    // instantiate the game and decide who moves first
    TicTacToe ttt = new TicTacToe();
    ttt.getFirstPlayer();

    // as long as neither player wins and the game is not a draw
    // get the next move
    do {
      ttt.printBoard();
      ttt.getMove();
      if (ttt.isWinner() || ttt.isDraw())
        gameOver = true;
      else
        ttt.switchPlayer();
    } while (!gameOver);

    // show the result of the game
    ttt.printResult();

  }

}




# tictac_game_and_connect4_game
### Game:
boolean isValidMove(String move) // returns true if the move represented by the String is valid
void executeMove(String move) // executes the move represented by the String
boolean gameOver() // returns true if the game is over
String displayBoard() // returns a String representing the current state of the board
int determineWinner() // if there is a winner, returns the player number of the winner (either 1 or 2); if no winner, returns 0


### TicTacToeGame:
TicTacToeGame has a 3 x 3 board on which players can place either 'x' or 'o' in any blank spot
A "move" in TicTacToeGame is a string that contains the row number (0-2), column number (0-2), and the character to mark the space with (either 'x' or 'o'). For example, placing an 'x' in the top middle square (space 0, 1) would be done with the command: "01x".
A "move" in TicTacToeGame is valid if:
The row and column number represent a valid space on the board that has not yet been taken
The mark is 'x' if it is x's turn, or 'o' if it is y'o turn.
Whoever makes the first move is player 1. For instance, if 'x' makes the first move, then 'x' is player 1 (and 'o' is player 2), and vice-versa.
A player wins by getting 3 in a row, either horizontally, vertically, or diagonally
A game is over if there are no more moves, or a player has won.

### ConnectFourGame
ConnectFourGame has a 6 x 7 board on which players can place either a red or a yellow piece (represented by 'r' and 'y', respectively). However, in Connect Four, unlike tic-tac-toe, each column is a "chute" into which a player drops a piece to make a move. The pieces fill up the column one by one (up to 6 pieces in one column). If you are unfamiliar with the game, please see https://en.wikipedia.org/wiki/Connect_Four and/or look it up on youtube.
A "move" in ConnectFourGame is a string that contains the column number (0-6), and the character to mark the space with (either 'r' or 'y'). For example, placing a red piece down the last column would be done with the command: "6r".
A "move" in ConnectFourGame is valid if:
The column number represents a valid column on the board that is not already full
The mark is 'r' if it is r's turn, or 'y' if it is y's turn.
Whoever makes the first move is player 1. For instance, if 'r' makes the first move, then 'r' is player 1 (and 'y' is player 2), and vice-versa.
A player wins by getting 4 in a row, either horizontally, vertically, or diagonally
A game is over if there are no more moves, or a player has won.

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];

    String nowPlayer;

    public ChessBoard(String nowPlayer){
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor(){
        return  this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn){
        if (checkPos(startLine) && checkPos(startColumn)) {
            if (!nowPlayer.equals((board[startLine][startColumn].getColor())))
                return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn];

                board[startLine][startColumn] = null;

                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        }
        else return false;
            }

        public void printBoard() {
            System.out.println("Turn " + nowPlayer);
            System.out.println();
            System.out.println("Player 2(Black) ");
            System.out.println();
            System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

            for (int i = 7; i > -1; i--) {
                if (board[i][j] == null) {
                    System.out.println(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }

        public  boolean checkPos(int pos) {
    return pos >= 0 && pos <=7;
    }
}

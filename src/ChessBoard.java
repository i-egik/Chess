public class ChessBoard {

    public boolean castleing0() {
        if (board[0][0] == null || board[0][4] == null) return false;
        if (board[0][0].getSymbol().equals("R") && board[0][4].getSymbol().equals("K") && board[0][1] == null && board[0][2] == null && board[0][3] == null) {
            if (board[0][0].getColor().equals("White") && board[0][4].getColor().equals("White") && board[0][0].check && board[0][4].check && new
                    King().isUnderAttack(this, 0, 2)) {
                board[0][4] = null;
                board[0][2] = new King();
                board[0][2].check = false;
                board[0][0] = null;
                board[0][3] = new Rook();
                board[0][3].check = false;
                nowPlayer = "Black";
                return true;
            } else return false;
        } else return false;
    }else {
        if (board[7][0] == null || board[7][4] == null) return false;
        if (board[7][0].getSymbol().equals("R") && board[7][4].getSymbol().equals("K") && board[0][1] == null && board[0][2] == null && board[0][3] == null) {
            if (board[7][1].getColor().equals("White") && board[0][4].getColor().equals("White") && board[0][0].check && board[0][4].check && new
                    King().isUnderAttack(this, 0, 2)) {
                board[0][4] = null;
                board[0][2] = new King();
                board[0][2].check = false;
                board[0][0] = null;
                board[0][3] = new Rook();
                board[0][3].check = false;
                nowPlayer = "Black";
                return true;
            } else return false;
        } else return false;
        }


    }
    public final ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    public boolean castling0() {
        return true;
    }

    public boolean castling7() {
        return true;
    }
}



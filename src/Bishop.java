public final class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!validateBorders(line, column, toLine, toColumn)) {
            return false;
        }
        if (toLine == line && toColumn == column) {
            return false;
        }
        int dLine = Math.abs(toLine - line);
        int dColumn = Math.abs(toColumn - column);
        if (dLine != dColumn) {
            return false;
        }
        return diagonal(chessBoard, line, column, toLine, toColumn) == null;

    }


    @Override
    public String getSymbol() {
        return "B";
    }
}


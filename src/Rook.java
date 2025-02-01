public final class Rook extends ChessPiece {
    public Rook(String color) {
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
        if (dLine > 0 && dColumn > 0) {
            return false;
        }
        return horizontal(chessBoard, line, column, toLine, toColumn, dLine, dColumn) == null;
    }


    @Override
    public String getSymbol() {
        return "R";
    }
}


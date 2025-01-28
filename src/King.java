public final class King extends ChessPiece {
    public King(String color) {
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
        if (dLine > 1 || dColumn > 1) {
            return false;
        }
        return !isUnderAttack(chessBoard, toLine, toColumn);

    }



    @Override
    public String getSymbol() {
        return "K";
    }
}

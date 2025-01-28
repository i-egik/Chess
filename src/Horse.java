public final class Horse extends ChessPiece {
    public Horse(String color) {
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
        if (dLine == 3 && dColumn == 2 || dLine == 2 && dColumn == 3) {
            return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}

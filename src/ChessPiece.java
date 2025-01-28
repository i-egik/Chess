public abstract class ChessPiece {
    private final String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
    protected static boolean validateBorders(int line, int column, int toLine, int toColumn) {
        return line <= 7 && toLine <= 7 && line >= 0 && toLine >= 0 && column <= 7 && toColumn <= 7 && column >= 0 && toColumn >= 0;
    }
    protected static boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false; //TODO реализовать
    }
}





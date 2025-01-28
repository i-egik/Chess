public final class Pawn extends ChessPiece {
    private boolean isFirstStep = true;

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!validateBorders(line, column, toLine, toColumn)) {
            return false;
        }
        if (toColumn != column) {
            return false;
        }
        if ("White".equalsIgnoreCase(getColor())) {

            if (toLine <= line) {
                return false;
            }
            if (toLine - line > 1) {
                if (isFirstStep) {
                    isFirstStep = false;
                    return toLine - line == 2;
                }
                return false;
            }
        } else {
            if (toLine >= line) {
                return false;
            }
            if (line - toLine > 1) {
                if (isFirstStep) {
                    isFirstStep = false;
                    return line - toLine == 2;
                }
                return false;
            }
        }
        isFirstStep = false;
        return true;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}
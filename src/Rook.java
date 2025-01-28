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
        if (dLine > 0) {
            int dir = toLine - line;
            if (dir > 0) {
                for (int i = line + 1; i < toLine; ++i) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = toLine - 1; i > line; --i) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            if (dColumn > 0) {
                int dir = toLine - line;
                if (dir > 0) {
                    for (int j = line + 1; j < toColumn; ++j) {
                        if (chessBoard.board[j][toLine] != null) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    for (int j = toColumn - 1; j > column; --j) {
                        if (chessBoard.board[j][toLine] != null) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}


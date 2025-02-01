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
        String color = board.board[line][column].getColor();
        ChessPiece piece = horizontal(board, line, column, 7, column, Math.abs(7 - line), 0);
        if (piece != null && !color.equals(piece.getColor()) && ("R".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        piece = horizontal(board, line, column, line, 7, 0, Math.abs(7 - column));
        if (piece != null && !color.equals(piece.getColor()) && ("R".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        piece = horizontal(board, line, column, 0, column, Math.abs(0 - line), 0);
        if (piece != null && !color.equals(piece.getColor()) && ("R".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        piece = horizontal(board, line, column, line, 0, 0, Math.abs(0 - column));
        if (piece != null && !color.equals(piece.getColor()) && ("R".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        int d = Math.min(Math.abs(7 - line), Math.abs(0 - column));
        piece = diagonal(board, line, column, d, d);
        if (piece != null && !color.equals(piece.getColor()) && ("B".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        d = Math.min(Math.abs(7 - line), Math.abs(7 - column));
        piece = diagonal(board, line, column, d, d);
        if (piece != null && !color.equals(piece.getColor()) && ("B".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        d = Math.min(Math.abs(0 - line), Math.abs(0 - column));
        piece = diagonal(board, line, column, d, d);
        if (piece != null && !color.equals(piece.getColor()) && ("B".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        d = Math.min(Math.abs(0 - line), Math.abs(7 - column));
        piece = diagonal(board, line, column, d, d);
        if (piece != null && !color.equals(piece.getColor()) && ("B".equals(piece.getSymbol()) || "Q".equals(piece.getSymbol()) || "K".equals(piece.getSymbol()))) {
            return true;
        }
        if (line + 1 < 7 && column - 2 >= 0) {
            piece = board.board[line + 1][column - 2];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line + 2 < 7 && column - 1 >= 0) {
            piece = board.board[line + 2][column - 1];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line + 2 < 7 && column + 1 < 7) {
            piece = board.board[line + 2][column + 1];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line + 1 < 7 && column + 2 < 7) {
            piece = board.board[line + 1][column + 2];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line - 1 >= 0 && column + 2 < 7) {
            piece = board.board[line - 1][column + 2];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line - 2 >= 0 && column + 1 < 7) {
            piece = board.board[line - 2][column + 1];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line - 2 >= 0 && column - 1 >= 0) {
            piece = board.board[line - 2][column - 1];
            if (piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()))) {
                return true;
            }
        }
        if (line - 1 >= 0 && column - 2 >= 0) {
            piece = board.board[line - 1][column - 2];
            return piece != null && !color.equals(piece.getColor()) && ("H".equals(piece.getSymbol()));
        }
        return false; //TODO реализовать/ добавть возвращение координат вмето фигуры
    }

    protected static ChessPiece diagonal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dirLine = toLine - line;
        int dirColumn = toColumn - column;
        if (dirLine > 0 && dirColumn > 0) {
            for (int i = column + 1; i < toColumn; i++) {
                for (int j = line + 1; j < toLine; j++) {
                    if (chessBoard.board[j][i] != null) {
                        return chessBoard.board[j][i];
                    }
                }
            }
        } else if (dirLine > 0 && dirColumn < 0) {
            for (int i = column - 1; i > toColumn; i--) {
                for (int j = line + 1; j < toLine; j++) {
                    if (chessBoard.board[j][i] != null) {
                        return chessBoard.board[j][i];
                    }
                }
            }
        } else if (dirLine < 0 && dirColumn > 0) {
            for (int i = column + 1; i < toColumn; i++) {
                for (int j = line - 1; j > toLine; j--) {
                    if (chessBoard.board[j][i] != null) {
                        return chessBoard.board[j][i];
                    }
                }
            }
        } else if (dirLine < 0 && dirColumn < 0) {
            for (int i = column - 1; i > toColumn; i--) {
                for (int j = line - 1; j > toLine; j--) {
                    if (chessBoard.board[j][i] != null) {
                        return chessBoard.board[j][i];
                    }
                }
            }
        }
        return null;
    }

    private static boolean igogo(int line, int column, int toLine, int toColumn) {
        if (toLine == line && toColumn == column) {
            return false;
        }
        int dLine = Math.abs(toLine - line);
        int dColumn = Math.abs(toColumn - column);
        return (dColumn == 1 && dLine == 2) || (dColumn == 2 && dLine == 1);
    }

    protected static ChessPiece horizontal(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, int dLine, int dColumn) {
        if (dLine > 0) {
            int dir = toLine - line;
            if (dir > 0) {
                for (int i = line + 1; i < toLine; ++i) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return chessBoard.board[i][toColumn];
                    }
                }
                return null;
            } else {
                for (int i = toLine - 1; i > line; --i) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return chessBoard.board[i][toColumn];
                    }
                }
                return null;
            }
        } else {
            if (dColumn > 0) {
                int dir = toColumn - column;
                if (dir > 0) {
                    for (int j = column + 1; j < toColumn; ++j) {
                        if (chessBoard.board[toLine][j] != null) {
                            return chessBoard.board[toLine][j];
                        }
                    }
                    return null;
                } else {
                    for (int j = toColumn - 1; j > column; --j) {
                        if (chessBoard.board[toLine][j] != null) {
                            return chessBoard.board[toLine][j];
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }

}







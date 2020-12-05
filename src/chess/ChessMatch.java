package chess;

import boardgame.Board;
import boardgame.Position;
import chess.Pieces.King;
import chess.Pieces.Rook;


public class ChessMatch {
    private Board board;

    // Construtor
    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
    }

    // Getters & Setters

    // Outros métodos
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
        for (int i = 0; i < this.board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) this.board.piece(i,j);
            }
        }
        return mat;
    }

    private void initialSetup() {
        board.placePiece(new Rook(this.board, Color.WHITE), new Position(0, 0));
        board.placePiece(new King(this.board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(this.board, Color.WHITE), new Position(7, 4));

    }
}

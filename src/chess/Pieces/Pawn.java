package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    
    private ChessMatch chessMatch;

    // Construtor
    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    // Outros métodos
    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        int s1;
        int s2;
        int s3;
        
        if (getColor()==Color.WHITE) {
            s1 = -1;
            s2 = -2;
            s3 = 3;
        } else {
            s1 = 1;
            s2 = 2;
            s3 = 4;
        }

        p.setValues(position.getRow() + s1, position.getColumn());
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + s2, position.getColumn());
        Position p2 = new Position(position.getRow() + s1, position.getColumn());
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && !getBoard().thereIsAPiece(p) && Boolean.TRUE.equals(getBoard().positionExists(p2)) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(position.getRow() + s1, position.getColumn() - 1);
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }			
        p.setValues(position.getRow() + s1, position.getColumn() + 1);
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // En Passant
        if (position.getRow() == s3) {
            Position left = new Position(position.getRow(), position.getColumn()-1);
            Position right = new Position(position.getRow(), position.getColumn()+1);

            if (Boolean.TRUE.equals(getBoard().positionExists(left)) && isThereOpponentPiece(left) && getBoard().piece(left)==chessMatch.getEnPassantVunerable()) {
                mat[left.getRow()-1][left.getColumn()] = true;
            }
            if (Boolean.TRUE.equals(getBoard().positionExists(right)) && isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()) {
                mat[right.getRow()-1][right.getColumn()] = true;
            }
        } else {
            Position left = new Position(position.getRow(), position.getColumn()-1);
            Position right = new Position(position.getRow(), position.getColumn()+1);

            if (Boolean.TRUE.equals(getBoard().positionExists(left)) && isThereOpponentPiece(left) && getBoard().piece(left)==chessMatch.getEnPassantVunerable()) {
                mat[left.getRow()+1][left.getColumn()] = true;
            }
            if (Boolean.TRUE.equals(getBoard().positionExists(right)) && isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()) {
                mat[right.getRow()+1][right.getColumn()] = true;
            }            
        }

        return mat;
    }
    
}
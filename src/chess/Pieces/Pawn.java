package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    // Construtor
    public Pawn(Board board, Color color) {
        super(board, color);
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
        
        if (getColor()==Color.WHITE) {
            s1 = -1;
            s2 = -2;
        } else {
            s1 = 1;
            s2 = 2;
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
        return mat;
    }
    
}

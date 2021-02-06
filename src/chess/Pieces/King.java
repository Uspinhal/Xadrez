package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    
    private ChessMatch chessMatch;

    // Construtor
    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    // Outros métodos
    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }

    private boolean testRookCastle(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        // Movimentos possíveis do Rei
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        // above
        p.setValues(position.getRow()-1, position.getColumn());
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        // below
        p.setValues(position.getRow()+1, position.getColumn());
        if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
       // left
       p.setValues(position.getRow(), position.getColumn()-1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }
       // right
       p.setValues(position.getRow(), position.getColumn()+1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }
       // up-left
       p.setValues(position.getRow()-1, position.getColumn()-1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }
       // up-right
       p.setValues(position.getRow()-1, position.getColumn()+1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }
       // down-left
       p.setValues(position.getRow()+1, position.getColumn()-1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }
       // donw-right
       p.setValues(position.getRow()+1, position.getColumn()+1);
       if (Boolean.TRUE.equals(getBoard().positionExists(p)) && canMove(p)) {
           mat[p.getRow()][p.getColumn()] = true;
       }

       // Castling
       if (getMoveCount() == 0 && !chessMatch.getCheck()) {
           // Castling kingside Rook
           Position posT1 = new Position(position.getRow(), position.getColumn()+3);
           if (testRookCastle(posT1)) {
               Position p1 = new Position(position.getRow(), position.getColumn()+2);
               Position p2 = new Position(position.getRow(), position.getColumn()+1);
               if (getBoard().piece(p1)==null && getBoard().piece(p2)==null) {
                   mat[position.getRow()][position.getColumn()+2] = true;
               }
           }
          // Castling queenside Rook
            Position posT2 = new Position(position.getRow(), position.getColumn()-4);
            if (testRookCastle(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn()-2);
                Position p2 = new Position(position.getRow(), position.getColumn()-1);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);
                if (getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
                    mat[position.getRow()][position.getColumn()-2] = true;
                }
            }
           
       }

        return mat;
    }
    
}

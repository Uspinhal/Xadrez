package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    
    private Color color;
    private int moveCount;

    // Construtor
    protected ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Getters & Setters
    public Color getColor() {
        return this.color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    public int getMoveCount(){
        return moveCount;
    }

    // Outros métodos
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != this.color;
    }

    public void increaseMoveCount() {
        moveCount++;
    }
    public void decreaseMoveCount() {
        moveCount--;
    }

}

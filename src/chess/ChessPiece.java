package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {
    
    private Color color;

    // Construtor
    protected ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Getters & Setters
    public Color getColor() {
        return this.color;
    }

}

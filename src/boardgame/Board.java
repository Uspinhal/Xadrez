package boardgame;

public class Board {
/* 

*/
    // Atributos    
    private int rows;
    private int columns;
    private Piece[][] pieces;

    // Constructor
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
    
    // Getters & Setters
    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    // Outros métodos
    public Piece piece(int row, int column) {
       if (!Boolean.TRUE.equals(positionExists(row, column))) {
        System.out.println(Boolean.TRUE.equals(positionExists(row, column)));    
        //throw new BoardException("Position not on the board!");
        }
        return this.pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!Boolean.TRUE.equals(positionExists(position))) {
            throw new BoardException("Position not on the board!");
        }
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!Boolean.TRUE.equals(positionExists(position))) {
            throw new BoardException("Position not on the board!");
        }
        if (this.piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public Boolean positionExists(int row, int column) {
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }
    public Boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!Boolean.TRUE.equals(positionExists(position))) {
			throw new BoardException("Position not on the board");
		}    
        return piece(position) != null;
    }

}

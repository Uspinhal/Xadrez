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
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
    
    // Getters & Setters
    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    // Outros métodos
    public Piece piece(int row, int column) {
        return this.pieces[row][column];
    }

    public Piece piece(Position position) {
        return this.pieces[position.getRow()][position.getColumn()];
    }



}

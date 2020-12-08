package boardgame;

public class Position {
    private int row;
    private int column;

    // Construtor
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Getter & Setters
    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // Outros métodos
    @Override
    public String toString() {
        return getRow() + ", " + getColumn();
    }

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

package boardgame;

public class Position {

    private int row;
    private int colunm;

    public Position(int row, int colunm) {
        this.row = row;
        this.colunm = colunm;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColunm(int colunm) {
        this.colunm = colunm;
    }

    @Override
    public String toString() {
        return row + ", " + colunm;
    }
}

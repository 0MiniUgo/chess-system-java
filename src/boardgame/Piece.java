package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){

        return possibleMoves()[position.getRow()][position.getColunm()];
    }

    public boolean isThereAnyPossibleMove(){

        boolean[][] mat = possibleMoves();
        for (boolean[] booleans : mat) {
            for (boolean bool: booleans) {
                if(bool) return true;
            }
        }
        return false;
    }
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){

                // Rook moves
                moves(mat, p, i, j, "R");
                // Bishop moves
                moves(mat, p, i, j, "B");
            }
        }

        return mat;
    }

    private void moves(boolean[][] mat, Position p, int i, int j, String piece) {

        if(piece.equals("R")){
            if((i == 0 && j == 0) || (i != 0 && j != 0)) return;
        }
        if(piece.equals("B")){
            if((i == 0 || j == 0)) return;
        }

        p.setValues(position.getRow() + i, position.getColumn() + j);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + i, p.getColumn() + j);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}

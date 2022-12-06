package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){

        if (getBoard().positionExists(position)){
            return getBoard().piece(position) == null || isThereOpponentPiece(position);
        }
        return false;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){

                if(i == 0 && j == 0) continue;

                p.setValues(position.getRow() + i, position.getColumn() + j);

                if (canMove(p)){
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}

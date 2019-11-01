package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<Move>();

        List<Coordinates> possibleCoords = List.of(from.plus(1, 2),
                from.plus(1, -2),
                from.plus(-1, 2),
                from.plus(-1, -2),
                from.plus(2, 1),
                from.plus(2, -1),
                from.plus(-2, 1),
                from.plus(-2, -1));

        for (int i = 0; i < possibleCoords.size(); i++) {
            if (colour != board.get(possibleCoords.get(i)).getColour()
                    && !(board.outOfBounds(possibleCoords.get(i)))) {
                allowedMoves.add(new Move(from, possibleCoords.get(i)));
            }
//        if (!(board.outOfBounds(from.plus(1,2)))) {
//            allowedMoves.add(new Move(from, from.plus(1,2)));
//        }
//        if (!(board.outOfBounds(from.plus(1,-2)))) {
//            allowedMoves.add(new Move(from, from.plus(1,-2)));
//        }
//        if (!(board.outOfBounds(from.plus(-1,2)))) {
//            allowedMoves.add(new Move(from, from.plus(-1,2)));
//        }
//        if (!(board.outOfBounds(from.plus(-1,-2)))) {
//            allowedMoves.add(new Move(from, from.plus(-1,-2)));
//        }
//        if (!(board.outOfBounds(from.plus(2,1)))) {
//            allowedMoves.add(new Move(from, from.plus(2,1)));
//        }
//        if (!(board.outOfBounds(from.plus(2,-1)))) {
//            allowedMoves.add(new Move(from, from.plus(2,-1)));
//        }
//        if (!(board.outOfBounds(from.plus(-2,1)))) {
//            allowedMoves.add(new Move(from, from.plus(-2,1)));
//        }
//        if (!(board.outOfBounds(from.plus(-2,-1)))) {
//            allowedMoves.add(new Move(from, from.plus(-2,-1)));
//        }
        }
        return allowedMoves;
    }
}

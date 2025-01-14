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

        List<Move> allowedMoves = new ArrayList<>();

        List<Coordinates> possibleCoords = List.of(from.plus(1, 2),
                from.plus(1, -2),
                from.plus(-1, 2),
                from.plus(-1, -2),
                from.plus(2, 1),
                from.plus(2, -1),
                from.plus(-2, 1),
                from.plus(-2, -1));

        for (Coordinates coords : possibleCoords) {
            if (!(board.outOfBounds(coords))) {
                if ((board.isSpaceEmpty(coords, board))
                        || (colour != board.get(coords).getColour())) {
                    allowedMoves.add(new Move(from, coords));
                }
            }
        }

        return allowedMoves;
    }
}

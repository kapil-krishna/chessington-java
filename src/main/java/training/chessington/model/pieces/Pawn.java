package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {


        List<Move> array = new ArrayList();
        Move move1 = new Move(new Coordinates(6, 4), new Coordinates(5, 4));
        Move move2 = new Move(new Coordinates(1, 4), new Coordinates(2, 4));

        if (!hasMoved) {
            Move move3 = new Move(new Coordinates(1, 4), new Coordinates(3, 4));
            array.add(move3);
            Move move4 = new Move(new Coordinates(6, 4), new Coordinates(4, 4));
            array.add(move4);
        }

        array.add(move1);
        array.add(move2);

        return array;
    }
}

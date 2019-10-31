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

        if (from.getRow() >= 7 ||
            from.getRow() <= 0 ||
            from.getCol() >= 7 ||
            from.getCol() <= 0 ){
                return array;
        }

        Coordinates proposed = moveProposal(from, 1, 0);

        if (board.get(proposed) == null) {
            array.add(new Move(from, proposed));
        }

        if (openingMove(from) != from){

            proposed = moveProposal(from, 2, 0);

            List<Coordinates> proposals = new ArrayList<>();

            proposals.add(moveProposal(from, 1, 0));
            proposals.add(moveProposal(from, 2, 0));

            boolean canMove = true;

            for (Coordinates proposal : proposals) {
                if (board.get(proposal) != null) {
                    canMove = false;
                }
            }

            if (canMove) {
                Move move = new Move(from, proposed);
                array.add(move);
            }

        }
        return array;
    }

    public boolean inBounds (Coordinates proposedPos) {

        return true;

//        switch (colour) {
//            case WHITE:
//                return proposedPos.getRow() > 0;
//            case BLACK:
//                return proposedPos.getRow() < 8;
//            default:
//                return false;
//        }
    }


    public Coordinates moveProposal(Coordinates from, int rowDiff, int colDiff) {
        Coordinates proposedPos = from;

        if (colour == PlayerColour.WHITE) {
            proposedPos = from.plus(-rowDiff, colDiff);
        } else {
            proposedPos = from.plus(rowDiff, colDiff);
        }

        return proposedPos;
    }

    public Coordinates openingMove(Coordinates from) {
        Coordinates proposedPos = from;

        if (colour == PlayerColour.WHITE && from.getRow() == 6) {
            proposedPos = from.plus(-2, 0);
        }

        if (colour == PlayerColour.BLACK && from.getRow() == 1){
            proposedPos = from.plus(+2, 0);
        }

        return proposedPos;
    }

    public boolean inBounds (Coordinates from, int rowDiff, int colDiff) {
        boolean inBounds = false;

        int rowCheck = 0;



        if (colour == PlayerColour.WHITE) {
            rowCheck = (from.getRow() - rowDiff);
        } else {
            rowCheck = from.getRow() + rowDiff;
        }

        if (7 > rowCheck && rowCheck < 0 ) {

        }


        return inBounds;
    }

}


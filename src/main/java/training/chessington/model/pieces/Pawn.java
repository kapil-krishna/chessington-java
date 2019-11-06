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

        List<Move> allowedMoves = new ArrayList();

        final int range = onStartRow(from) ? 2 : 1;

        List<Coordinates> proposals = getHorizontalProposals(from, range);

        for (Coordinates proposal : proposals) {
            if (!(board.outOfBounds(proposal))) {
                if (board.isSpaceEmpty(proposal, board)) {
                    allowedMoves.add(new Move(from, proposal));
                }
            }
        }
        Coordinates captureRight = moveProposal(from, 1, 1);
        Coordinates captureLeft = moveProposal(from, 1, -1);

        if (!(board.outOfBounds(captureRight)))  {
            if (canCapture(captureRight, board)) {
                allowedMoves.add(new Move(from, captureRight));
            }
        }
        if (!(board.outOfBounds(captureLeft))) {
            if (canCapture(captureLeft, board)) {
                allowedMoves.add(new Move(from, captureLeft));
            }
        }

        return allowedMoves;
    }

    public boolean canCapture(Coordinates proposal, Board board) {
        boolean result = true;
        if (!(board.outOfBounds(proposal))) {
            result = (!board.isSpaceEmpty(proposal, board)
                    && board.get(proposal).getColour() != colour);
        }
        return result;
    }

    // TODO replace with direction setter
    public Coordinates moveProposal(Coordinates from, int rowDiff, int colDiff) {
        if (colour == PlayerColour.WHITE){ rowDiff *= -1; }
        return from.plus(rowDiff, colDiff);
    }

    public List<Coordinates> getHorizontalProposals(Coordinates from, int range){
        List<Coordinates> moveProposals = new ArrayList<>();
        for (int step = 1; step <= range; step++){
            moveProposals.add(moveProposal(from, step, 0));
        }

        return moveProposals;
    }


    public boolean onStartRow(Coordinates from){

        // TODO replace once hasMove flag is set up correctly
        switch (colour){
            case WHITE: if (from.getRow() == 6) {return true;}
            case BLACK: if (from.getRow() == 1) {return true;}
        }
        return false;
    }
}


package training.chessington.model.pieces;

import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;
    protected boolean movesHorizontally;
    protected boolean movesVertically;


    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    protected Boolean outOfBounds(Coordinates toCheck){
        return  toCheck.getRow() >= 7 ||
                toCheck.getRow() <= 0 ||
                toCheck.getCol() >= 7 ||
                toCheck.getCol() <= 0;
    }
}
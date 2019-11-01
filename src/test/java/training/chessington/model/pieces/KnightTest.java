package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void knightCanMoveInLShape() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 5);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves.size()).isEqualTo(8);
        assertThat(moves).contains(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
    }

    @Test
    public void knightCannotMoveOffBoard() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(7, 6);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves.size()).isEqualTo(3);
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
    }

    @Test
    public void knightCannotMoveToSquareWithSameColourPiece() {
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coordsKnight = new Coordinates(5, 5);
        board.placePiece(coordsKnight, knight);
        Piece pawn1 = new Pawn (PlayerColour.WHITE);
        Coordinates coordsPawn1 = new Coordinates(7,6);
        board.placePiece(coordsPawn1, pawn1);
        Piece pawn2 = new Pawn (PlayerColour.WHITE);
        Coordinates coordsPawn2 = new Coordinates(3,6);
        board.placePiece(coordsPawn2, pawn2);

        // Act
        List<Move> moves = knight.getAllowedMoves(coordsKnight, board);

        // Assert
        assertThat(moves.size()).isEqualTo(6);
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(1, -2)));
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(1, 2)));
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(-1, -2)));
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(-1, 2)));
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(2, -1)));
        assertThat(moves).contains(new Move(coordsKnight, coordsKnight.plus(-2, -1)));
    }




}

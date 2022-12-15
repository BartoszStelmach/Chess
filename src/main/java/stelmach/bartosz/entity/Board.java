package stelmach.bartosz.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import stelmach.bartosz.enums.File;
import stelmach.bartosz.enums.Piece;
import stelmach.bartosz.enums.Piece.PieceType;
import stelmach.bartosz.enums.Rank;

import java.util.Optional;

@Getter @Setter @ToString
public class Board {
    private Square[][] squares = new Square[8][8];

    public Board() {
        initializeSquaresWithNonPawnPieces(true);
        initializeSquaresWithPawns(true);
        initializeEmptySquares();
        initializeSquaresWithPawns(false);
        initializeSquaresWithNonPawnPieces(false);
    }

    private void initializeSquaresWithNonPawnPieces(boolean isWhite) {
        int rankNumber = isWhite ? 0 : 7;
        Rank rank = isWhite ? Rank.FIRST : Rank.EIGHTH;

        squares[rankNumber][0] = new Square(rank, File.A, new Piece(PieceType.ROOK, isWhite));
        squares[rankNumber][1] = new Square(rank, File.B, new Piece(PieceType.KNIGHT, isWhite));
        squares[rankNumber][2] = new Square(rank, File.C, new Piece(PieceType.BISHOP, isWhite));
        squares[rankNumber][3] = new Square(rank, File.D, new Piece(PieceType.QUEEN, isWhite));
        squares[rankNumber][4] = new Square(rank, File.E, new Piece(PieceType.KING, isWhite));
        squares[rankNumber][5] = new Square(rank, File.F, new Piece(PieceType.BISHOP, isWhite));
        squares[rankNumber][6] = new Square(rank, File.G, new Piece(PieceType.KNIGHT, isWhite));
        squares[rankNumber][7] = new Square(rank, File.H, new Piece(PieceType.ROOK, isWhite));
    }

    private void initializeSquaresWithPawns(boolean isWhite) {
        int rankNumber = isWhite ? 1 : 6;

        for (int j=0; j<=7; j++) {
            Optional<Rank> rank = Rank.get(rankNumber+1);
            Optional<File> file = File.get(j+1);
            if (file.isPresent() && rank.isPresent()) squares[rankNumber][j] = new Square(rank.get(), file.get(), new Piece(PieceType.PAWN, isWhite));
        }
    }

    private void initializeEmptySquares() {
        for (int i=2; i<=5; i++) {
            for (int j=0; j<=7; j++) {
                Optional<Rank> rank = Rank.get(i+1);
                Optional<File> file = File.get(j+1);
                if (file.isPresent() && rank.isPresent()) squares[i][j] = new Square(rank.get(), file.get(), null);
            }
        }
    }
}

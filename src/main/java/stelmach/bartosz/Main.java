package stelmach.bartosz;

import stelmach.bartosz.entity.Board;
import stelmach.bartosz.entity.Square;
import stelmach.bartosz.enums.Piece.PieceType;
import stelmach.bartosz.enums.Rank;
import stelmach.bartosz.service.MoveNotationValidator;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Rank rank = Rank.FIRST;
		System.out.println(rank);
		System.out.println(rank.getNumber());
		Rank rank2 = Rank.valueOf("FIRST");
		System.out.println(rank2);

		System.out.println(Rank.values()[0]);
		System.out.println(Rank.values()[7]);

		System.out.println(PieceType.PAWN.getSymbol());

		System.out.println(PieceType.valueOf("PAWN"));
		System.out.println(PieceType.get("Q"));
		System.out.println(PieceType.get("Q").get());
		System.out.println(PieceType.get("X"));
		Optional<PieceType> pieceType = PieceType.get("X");
		if (pieceType.isPresent())
			System.out.println(pieceType.get());
		else
			System.out.println("ERROR");

		Board board = new Board();
		System.out.println(board);

		Arrays.stream(board.getSquares()).forEach((i) -> {
			Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
			System.out.println();
		});

		MoveNotationValidator moveNotationValidator = new MoveNotationValidator();
		moveNotationValidator.test();

		System.out.println();
		System.out.println(moveNotationValidator.areAllCharactersAllowed("c"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("K"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("Kc"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("k"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("z"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("cz"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("C1"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("e4"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("Bxg5"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("O-O-O"));
		System.out.println(moveNotationValidator.areAllCharactersAllowed("Qa6+"));

		moveNotationValidator.isPawnMove("a");
		moveNotationValidator.isPawnMove("h");
		moveNotationValidator.isPawnMove("1");
		moveNotationValidator.isPawnMove("a1");
		moveNotationValidator.isPawnMove("axh5");
		moveNotationValidator.isPawnMove("=");

		moveNotationValidator.isPawnMoveTaking("ad");
		moveNotationValidator.isPawnMoveTaking("hh");
		moveNotationValidator.isPawnMoveTaking("11");
		moveNotationValidator.isPawnMoveTaking("a1");
		moveNotationValidator.isPawnMoveTaking("axh5");
		moveNotationValidator.isPawnMoveTaking("ahx5");
		moveNotationValidator.isPawnMoveTaking("=+");

		System.out.println("isLengthCorrect");
		System.out.println(moveNotationValidator.isLengthCorrect("a6"));
		System.out.println(moveNotationValidator.isLengthCorrect("a"));
		System.out.println(moveNotationValidator.isLengthCorrect("1"));
		System.out.println(moveNotationValidator.isLengthCorrect("axh6"));
		System.out.println(moveNotationValidator.isLengthCorrect("axh6=Q#"));
		System.out.println(moveNotationValidator.isLengthCorrect("axh6=Q+#"));

		moveNotationValidator.isMovePromoting("a6");
		moveNotationValidator.isMovePromoting("a");
		moveNotationValidator.isMovePromoting("1");
		moveNotationValidator.isMovePromoting("axh6");
		moveNotationValidator.isMovePromoting("axh6=Q#");
		moveNotationValidator.isMovePromoting("axh6=Q+#");

		moveNotationValidator.isMoveChecking("a6+");
		moveNotationValidator.isMoveChecking("a");
		moveNotationValidator.isMoveChecking("+1");
		moveNotationValidator.isMoveChecking("axh6");
		moveNotationValidator.isMoveChecking("axh6=Q#");
		moveNotationValidator.isMoveChecking("axh6=Q+#");

		moveNotationValidator.isMoveMating("a6+");
		moveNotationValidator.isMoveMating("a");
		moveNotationValidator.isMoveMating("#1");
		moveNotationValidator.isMoveMating("axh6");
		moveNotationValidator.isMoveMating("axh6=Q#");
		moveNotationValidator.isMoveMating("axh6=Q+#");

		String correctPawnMove = "axh6=Q#";
		String inCorrectPawnMove = "ah6=Q#";
		System.out.println("TEST THIS CORRECT PAWN MOVE: " + correctPawnMove);
		moveNotationValidator.isLengthCorrect(correctPawnMove);
		moveNotationValidator.areAllCharactersAllowed(correctPawnMove);
		moveNotationValidator.isPawnMove(correctPawnMove);
		boolean isTaking = moveNotationValidator.isPawnMoveTaking(correctPawnMove);
		boolean isPromoting = moveNotationValidator.isMovePromoting(correctPawnMove);
		boolean isChecking = moveNotationValidator.isMoveChecking(correctPawnMove);
		boolean isMating = moveNotationValidator.isMoveMating(correctPawnMove);
		moveNotationValidator.isLengthCorrect(correctPawnMove, isTaking, isPromoting, isChecking, isMating);

		System.out.println("TEST THIS INCORRECT PAWN MOVE: " + inCorrectPawnMove);
		moveNotationValidator.isLengthCorrect(inCorrectPawnMove);
		moveNotationValidator.areAllCharactersAllowed(inCorrectPawnMove);
		moveNotationValidator.isPawnMove(inCorrectPawnMove);
		boolean isTaking2 = moveNotationValidator.isPawnMoveTaking(inCorrectPawnMove);
		boolean isPromoting2 = moveNotationValidator.isMovePromoting(inCorrectPawnMove);
		boolean isChecking2 = moveNotationValidator.isMoveChecking(inCorrectPawnMove);
		boolean isMating2 = moveNotationValidator.isMoveMating(inCorrectPawnMove);
		moveNotationValidator.isLengthCorrect(inCorrectPawnMove, isTaking2, isPromoting2, isChecking2, isMating2);

		Square[][] squares = board.getSquares();
		System.out.println("num value of 'a': " + (Character.getNumericValue('a') - 9));
		System.out.println("num value of 'b': " + (Character.getNumericValue('b') - 9));
	}

}
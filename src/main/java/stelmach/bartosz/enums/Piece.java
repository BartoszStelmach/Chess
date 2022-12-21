package stelmach.bartosz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString
public class Piece {

	private PieceType pieceType;

	private boolean isWhite;

	@Getter
	public enum PieceType {

		KING("K"), QUEEN("Q"), BISHOP("B"), KNIGHT("N"), ROOK("R"), PAWN("P");

		private final String symbol;

		PieceType(String symbol) {
			this.symbol = symbol;
		}

		public static Optional<PieceType> get(String symbol) {
			return Arrays.stream(PieceType.values()).filter(pieceType -> pieceType.getSymbol().equals(symbol))
					.findFirst();
		}

	}

}

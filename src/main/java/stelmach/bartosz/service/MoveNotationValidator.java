package stelmach.bartosz.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveNotationValidator {

	public void test() {
		Pattern pattern = Pattern.compile("[abc]");
		Matcher matcher = pattern.matcher("a");
		boolean matchFound = matcher.find();

		Matcher matcher2 = pattern.matcher("ade");
		boolean matchFound2 = matcher2.find();

		Matcher matcher3 = pattern.matcher("def");
		boolean matchFound3 = matcher3.find();

		System.out.println(matchFound);
		System.out.println(matchFound2);
		System.out.println(matchFound3);
	}

	public boolean isLengthCorrect(String move) {
		System.out.println("isLengthCorrect move: " + move);
		System.out.println("move.length(): " + move.length());
		System.out.println(move.length() >= 2 && move.length() <= 7);
		return move.length() >= 2 && move.length() <= 7;
	}

	public boolean isLengthCorrect(String move, boolean isTaking, boolean isPromoting, boolean isChecking,
			boolean isMating) {
		System.out.println("isLengthCorrect move: " + move);
		System.out.println("move.length(): " + move.length());

		int correctLength = 2;
		if (isTaking)
			correctLength += 2;
		if (isPromoting)
			correctLength += 2;
		if (isChecking || isMating)
			correctLength += 1;

		System.out.println(move.length() == correctLength);
		return move.length() == correctLength;
	}

	public boolean areAllCharactersAllowed(String move) {
		System.out.println("areAllCharactersAllowed move: " + move);

		String pieceRegex = "KQBNRP";
		String rankRegex = "1-8";
		String fileRegex = "a-h";
		String othersRegex = "x+#O\\-=";
		String finalRegex = "[^" + pieceRegex + rankRegex + fileRegex + othersRegex + "]";
		System.out.println("finalRegex: " + finalRegex);

		Pattern pattern = Pattern.compile(finalRegex);
		Matcher matcher = pattern.matcher(move);
		boolean isAnyCharacterNotAllowed = matcher.find();
		System.out.println(!isAnyCharacterNotAllowed);
		return !isAnyCharacterNotAllowed;
	}

	public boolean isPawnMove(String move) {
		System.out.println("isPawnMove move: " + move);
		String firstChar = move.substring(0, 1);

		Pattern pattern = Pattern.compile("[a-h]");
		Matcher matcher = pattern.matcher(firstChar);
		boolean isPawnMove = matcher.find();
		System.out.println(isPawnMove);
		return isPawnMove;
	}

	public boolean isPawnMoveTaking(String move) {
		System.out.println("isPawnMoveTaking move: " + move);
		if (!move.contains("x"))
			return false;

		String secondChar = move.substring(1, 2);
		System.out.println(secondChar.equals("x"));
		return secondChar.equals("x");
	}

	public boolean isMoveTaking(String move) {
		System.out.println("isMoveTaking move: " + move);
		if (!move.contains("x"))
			return false;

		String secondAndThirdChar = move.substring(1, 3);
		System.out.println(secondAndThirdChar.contains("x"));
		return secondAndThirdChar.contains("x");
	}

	public boolean isMovePromoting(String move) {
		System.out.println("isMovePromoting move: " + move);
		if (!move.contains("="))
			return false;

		int moveLength = move.length();
		String secondLastChar = move.substring(moveLength - 2, moveLength - 1);
		String thirdLastChar = move.substring(moveLength - 3, moveLength - 2);

		System.out.println(secondLastChar.equals("=") || thirdLastChar.equals("="));
		return secondLastChar.equals("=") || thirdLastChar.equals("=");
	}

	public boolean isMoveChecking(String move) {
		System.out.println("isMoveChecking move: " + move);
		if (!move.contains("+"))
			return false;

		int moveLength = move.length();
		String lastChar = move.substring(moveLength - 1, moveLength);

		System.out.println(lastChar.equals("+"));
		return lastChar.equals("+");
	}

	public boolean isMoveMating(String move) {
		System.out.println("isMoveMating move: " + move);
		if (!move.contains("#"))
			return false;

		int moveLength = move.length();
		String lastChar = move.substring(moveLength - 1, moveLength);

		System.out.println(lastChar.equals("#"));
		return lastChar.equals("#");
	}

	public boolean isMoveAmbiguous(String move) {
		System.out.println("isMoveAmbiguous move: " + move);
		String firstChar = move.substring(0, 1);
		String secondChar = move.substring(1, 2);
		String thirdChar = move.substring(2, 3);

		Pattern pattern = Pattern.compile("KQBNRP");
		Matcher matcher = pattern.matcher(firstChar);
		boolean isFirstCharPiece = matcher.find();

		pattern = Pattern.compile("[a-h][1-8]");
		matcher = pattern.matcher(secondChar);
		boolean isSecondCharRankOrFile = matcher.find();

		matcher = pattern.matcher(thirdChar);
		boolean isThirdCharRankOrFile = matcher.find();

		System.out.println(isFirstCharPiece || isSecondCharRankOrFile || isThirdCharRankOrFile);
		return (isFirstCharPiece || isSecondCharRankOrFile || isThirdCharRankOrFile);
	}

	public boolean isMoveCastling(String move) {
		System.out.println("isMoveCastling move: " + move);
		if (!move.contains("-"))
			return false;

		System.out.println("O-O".equals(move) || "O-O-O".equals(move));
		return "O-O".equals(move) || "O-O-O".equals(move);
	}

}

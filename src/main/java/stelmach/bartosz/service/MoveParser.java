package stelmach.bartosz.service;

import stelmach.bartosz.entity.Move;

public class MoveParser {
    public Move parseMove(String move, boolean isWhite) {
        MoveNotationValidator moveNotationValidator = new MoveNotationValidator();
        boolean isPawnMove = moveNotationValidator.isPawnMove(move);
        boolean isMoveTaking = isPawnMove ? moveNotationValidator.isPawnMoveTaking(move) : moveNotationValidator.isMoveTaking(move);
        boolean isMoveChecking = moveNotationValidator.isMoveChecking(move);
        boolean isMoveMating = moveNotationValidator.isMoveMating(move);
        boolean isMovePromoting = moveNotationValidator.isMovePromoting(move);
        boolean isMoveCastling = moveNotationValidator.isMoveCastling(move);

        return null;
    }

    public String getEndSquare(String move, boolean isPawnMove, boolean isMoveAmbiguous, boolean isMoveTaking, boolean isMoveCastling) {
        int file = 0;

        if (!isPawnMove) file++;
        if (isMoveAmbiguous) file++;
        if (isMoveTaking) file++;

        return move.substring(file, file+2);
    }

//    public String getEndSquareForCastling (String move, boolean isWhite) {
//        boolean isShortCastle = move.length() == 3;
//
//        String endSquare;
//        if (isWhite && isShortCastle) endSquare =
//    }
}

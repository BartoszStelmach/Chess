package stelmach.bartosz.entity;

import stelmach.bartosz.enums.Piece;

public class Move {

	private int gameID;

	private String notation;

	private int sequenceNumber;

	private boolean isWhite;

	private boolean isTaking;

	private boolean isChecking;

	private boolean isMating;

	private boolean isPromoting;

	private boolean isCastling;

	private Square startSquare;

	private Square endSquare;

	private Piece piece;

}

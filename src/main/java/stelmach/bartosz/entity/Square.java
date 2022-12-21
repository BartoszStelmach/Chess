package stelmach.bartosz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import stelmach.bartosz.enums.File;
import stelmach.bartosz.enums.Piece;
import stelmach.bartosz.enums.Rank;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Square {

	private Rank rank;

	private File file;

	private Piece piece;

}

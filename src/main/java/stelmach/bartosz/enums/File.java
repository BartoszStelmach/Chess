package stelmach.bartosz.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum File {

	A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8);

	private final int number;

	File(int number) {
		this.number = number;
	}

	public static Optional<File> get(int number) {
		return Arrays.stream(File.values()).filter(file -> file.getNumber() == number).findFirst();
	}

}

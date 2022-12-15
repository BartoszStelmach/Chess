package stelmach.bartosz.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7),
    EIGHTH(8);

    private final int number;
    Rank(int number) {
        this.number = number;
    }

    public static Optional<Rank> get(int number) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getNumber() == number)
                .findFirst();
    }
}

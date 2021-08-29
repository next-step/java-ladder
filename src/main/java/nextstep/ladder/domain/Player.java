package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private static final String VALID_LENGTH = "입력값은 공백을 제외한 %s~%s글자 여야 합니다 -> %s";
    private static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        requireValidLength(name);
        this.name = name;
    }

    public PlayerDto toDto() {
        return new PlayerDto(name, MAX_LENGTH);
    }

    private void validateName(final String name) {
        InputUtils.requireNonNull(name);
        requireValidLength(name.trim());
    }

    private void requireValidLength(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(VALID_LENGTH, name));
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

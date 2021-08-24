package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayerDto;

import java.util.Objects;

public class Player {

    private static final String NON_NULL = "플레이어 이름은 null 일 수 없습니다";
    private static final String VALID_LENGTH = "플레이어 이름은 공백을 제외한 1~5글자 여야 합니다 -> %s";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
    }

    public PlayerDto toDto() {
        return new PlayerDto(name, MAX_LENGTH);
    }

    private void validateName(final String name) {
        requireNonNull(name);
        requireValidLength(name.trim());
    }

    private void requireValidLength(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(VALID_LENGTH, name));
        }
    }

    private void requireNonNull(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

package laddergame.utils;

import laddergame.domain.AbstractLadderGameValue;

public class AbstractLadderGameValueValidator {

    private AbstractLadderGameValueValidator() {
    }

    public static void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("문자열은 null이거나 공백일 수 없습니다.");
        }

        if (value.length() > AbstractLadderGameValue.MAX_LENGTH) {
            throw new IllegalArgumentException("문자열은 최대 5자까자 부여할 수 있습니다.");
        }
    }

}

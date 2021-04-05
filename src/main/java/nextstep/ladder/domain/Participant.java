package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

public class Participant {

    private static final String NAME_EMPTY_EXCEPTION = "이름으로 빈값이 올 수 없습니다.";
    private static final String NAME_LENGTH_MAX_FIVE = "이름의 길이는 5글자까지 허용됩니다.";
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    private Participant(final String name) {
        validation(name);
        this.name = name;
    }

    public static Participant of(final String name) {
        return new Participant(name);
    }

    private void validation(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new LadderException(NAME_EMPTY_EXCEPTION);
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new LadderException(NAME_LENGTH_MAX_FIVE);
        }
    }
}

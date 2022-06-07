package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfMaxNameLengthException;

public class Participant {
    private final String name;

    private static final int MAX_LENGTH = 5;

    public Participant(String name) {
        if (name.length() == 0
                || name.length() > MAX_LENGTH) {
            throw new OutOfMaxNameLengthException("참가자 이름의 길이는 1 이상 " + MAX_LENGTH + " 이하 이어야 합니다.");
        }

        this.name = name;
    }

    public String name() {
        return name;
    }
}

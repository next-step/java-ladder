package nextstep.ladder.domain;

import nextstep.ladder.exceptions.ExceededMaxLengthException;

public class Participant {
    private final String name;

    public Participant(String name) {
        if (name.length() > 5) {
            throw new ExceededMaxLengthException("참가자 이름의 길이가 5 이상이 될 수 없습니다.");
        }

        this.name = name;
    }
}

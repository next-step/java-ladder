package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfMaxNameLengthException;

public class LadderResult {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public LadderResult(String name) {
        if (name.length() == 0
                || name.length() > MAX_LENGTH) {
            throw new OutOfMaxNameLengthException("사다리 타기 결과의 길이는 1 이상 " + MAX_LENGTH + " 이하 이어야 합니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}

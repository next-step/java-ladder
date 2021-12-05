package nextstep.ladder;

import static nextstep.ladder.utils.StringUtils.rangeStringLength;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        this.name = rangeStringLength(name, MAX_NAME_LENGTH);
    }
}

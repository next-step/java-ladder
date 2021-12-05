package nextstep.ladder;

import static nextstep.ladder.utils.StringUtils.rangeStringLength;

import java.util.Objects;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        this.name = rangeStringLength(name, MAX_NAME_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package ladder.domain;

import java.util.Objects;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String ILLEGAL_NAME = "유효하지 않은 이름입니다.";
    private static final String NAME_FORMAT = "%-6s";
    private final String name;

    private Participant(String name) {
        this.name = name;
    }

    public static Participant of(String name) {
        return new Participant(checkName(name));
    }

    private static String checkName(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_NAME);
        }

        return name;
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
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format(NAME_FORMAT, name);
    }
}

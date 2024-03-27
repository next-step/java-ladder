package ladder.domain;

import java.util.Objects;

public class Participant {

    public static final int MAX_LENGTH = 5;
    private static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "이름은 null 또는 빈 문자열일 수 없습니다";
    private static final String EXCEED_MAX_LENGTH_EXCEPTION_MESSaGE =
        "이름은 " + MAX_LENGTH + "글자를 초과할 수 없습니다";

    private final String name;

    private Participant(String name) {
        this.name = name;
    }

    public static Participant from(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEED_MAX_LENGTH_EXCEPTION_MESSaGE);
        }
        return new Participant(value);
    }

    public String name() {
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
        Participant participant = (Participant) o;
        return Objects.equals(name, participant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Participant{" +
            "value='" + name + '\'' +
            '}';
    }
}

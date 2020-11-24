package step02.domain;

import exception.OutOfNameLengthException;

import java.util.Objects;
import java.util.Optional;

public class ParticipantName {
    private static final Integer MIN = 1;
    private static final Integer MAX = 5;
    private final String name;

    private ParticipantName(String name) {
        validate(name);
        this.name = name;
    }

    public static ParticipantName of(String name) {
        return new ParticipantName(name);
    }

    private static void validate(String name) {
        Optional.ofNullable(name)
                .filter(n -> n.length() >= MIN && n.length() <= MAX)
                .orElseThrow(OutOfNameLengthException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + "";
    }
}

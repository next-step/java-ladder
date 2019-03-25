package laddergame.domain;

import laddergame.util.StringUtils;
import laddergame.validator.Validatable;

import java.util.Objects;
import java.util.Optional;

public class Participant implements Validatable<String> {

    public static final int PARTICIPANT_MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toResultString() {
        return String.format("%5s", name);
    }

    @Override
    public boolean isValid(String target) {
        return Optional.ofNullable(target)
                        .filter(StringUtils::isNotEmpty)
                        .filter(name -> name.length() <= PARTICIPANT_MAXIMUM_NAME_LENGTH)
                        .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return "참가자 명은 5글자 이하이어야 합니다.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Participant{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
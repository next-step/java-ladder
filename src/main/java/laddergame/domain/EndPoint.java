package laddergame.domain;

import laddergame.util.StringUtils;
import laddergame.validator.Validatable;

import java.util.Objects;
import java.util.Optional;

public class EndPoint implements Validatable<String> {

    public static final int PARTICIPANT_MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private final int index;

    public EndPoint(String name, int index) {
        validate(name);
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
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
        return "잘못된 이름입니다.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndPoint endPoint = (EndPoint) o;
        return Objects.equals(name, endPoint.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%5s", name);
    }
}
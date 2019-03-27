package laddergame.domain;

import laddergame.util.StringUtils;
import laddergame.validator.Validatable;

import java.util.Objects;
import java.util.Optional;

import static java.lang.Boolean.FALSE;

public class EndPoint extends Point implements Validatable<String> {

    public static final int PARTICIPANT_MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public EndPoint(String name, int index) {
        super(index, Direction.of(FALSE, FALSE));
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
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
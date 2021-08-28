package nextstep.ladder.domain.participant;

import nextstep.ladder.exception.InvalidNameException;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String name) {
        if (Objects.isNull(name))
            throw new InvalidNameException("이름이 null이여서는 안됩니다");

        if (name.length() > 5) {
            throw new InvalidNameException("이름은 최대 5글자까지 가능합니다");
        }
    }

    public String getValue() {
        return value;
    }
}

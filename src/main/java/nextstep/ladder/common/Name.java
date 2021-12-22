package nextstep.ladder.common;

import nextstep.ladder.utils.StringUtils;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String EXCEPTION_NAME_MAX_LENGTH_OVER = "명칭은 5글자를 초과할 수 없습니다.";

    private final String name;

    public Name(String name) {
        this.name = validation(StringUtils.validationNotNullAndEmpty(name));
    }

    private String validation(String name) {
        return Optional.ofNullable(name)
                .filter(n -> n.length() <= NAME_MAX_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NAME_MAX_LENGTH_OVER));
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}

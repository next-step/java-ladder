package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

import java.util.Objects;

public class Reword {

    private final String name;

    private Reword(String name) {
        this.name = name;
    }

    public static Reword newInstance(String result) {
        validate(result);
        return new Reword(result);
    }

    private static void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InputValueException("이름이 존재하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reword reword = (Reword) o;
        return Objects.equals(name, reword.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

import java.util.Objects;

public class PlayerName {

    private final String name;

    private PlayerName(String name) {
        this.name = name;
    }

    public static PlayerName newInstance(String name) {
        validate(name);
        return new PlayerName(name);
    }

    private static void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InputValueException("이름이 존재하지 않습니다.");
        }

        if (name.length() > 5) {
            throw new InputValueException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName name1 = (PlayerName) o;
        return Objects.equals(name, name1.name);
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

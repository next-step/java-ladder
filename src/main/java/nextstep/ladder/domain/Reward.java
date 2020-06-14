package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

import java.util.Objects;

public class Reward {

    private final String name;

    private Reward(String name) {
        this.name = name;
    }

    public static Reward newInstance(String result) {
        validate(result);
        return new Reward(result);
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
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
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

package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import nextstep.ladder.util.StringUtils;

public class Player {

    private final String name;

    private Player(String name) {
        validate(name);
        this.name = name;
    }

    public static Player newInstance(String name) {
        return new Player(name);
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new InputValueException("이름이 존재하지 않습니다.");
        }

        if (name.length() > 5) {
            throw new InputValueException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}

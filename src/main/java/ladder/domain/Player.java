package ladder.domain;

import java.util.Objects;

public class Player {

    private final String name;

    public Player(String name) {
        nullCheck(name);
        validlength(name);
        this.name = name;
    }

    public String name() {
        return name;
    }

    private void nullCheck(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException(("참여자의 이름값은 null일 수 없습니다."));
        }
    }

    private void validlength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("참여자의 이름은 5글자를 넘을 수 없습니다. 에러이름 : " + name);
        }
    }
}

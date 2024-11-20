package nextstep.ladder.domain;

import nextstep.ladder.config.Const;

public class Participant {

    private final String name;

    public Participant(String name) {
        if (name.length() > Const.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + Const.MAX_NAME_LENGTH + "글자입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }

}

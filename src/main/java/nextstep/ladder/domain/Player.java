package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    private String prize;

    public Player(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력 가능합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPrize() {
        return this.prize;
    }

    public void receivePrize(String prize) {
        this.prize = prize;
    }

    public boolean isMatchedName(String name) {
        return Objects.equals(this.name, name);
    }
}

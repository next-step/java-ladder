package nextstep.ladder.domain;

public class Player {
    private final String name;

    public Player(final String name) {
        if (name == null || name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("플레이어 이름은 5글자까지만 허용합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

package nextstep.ladder.domain;

public class Player {
    static final int PLAYER_NAME_MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

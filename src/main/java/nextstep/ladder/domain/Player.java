package nextstep.ladder.domain;

public class Player {
    public static int MAX_PLAYER_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException("최대 5자까지 입력가능합니다." + name);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

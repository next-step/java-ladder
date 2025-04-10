package ladder.model.player;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

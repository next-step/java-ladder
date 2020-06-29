package domain;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    private Player(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + NAME_MAX_LENGTH + "보다 작아야합니다");
        }

        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getPlayerName() {
        return this.name;
    }
}

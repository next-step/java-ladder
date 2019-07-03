package ladder.domain;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String ALERT_EXCEED_OF_NAME_LENGTH = "이름은 최대 5글자까지 가능합니다.";
    private static final String ALERT_EMPTY_NAME = "이름은 최소 1글자 이상 입력하세요.";

    private final String name;

    private Player(String name) {
        validationPlayerName(name);
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private void validationPlayerName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ALERT_EXCEED_OF_NAME_LENGTH);
        }
        if ("".equals(name)) {
            throw new IllegalArgumentException(ALERT_EMPTY_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}

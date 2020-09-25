package nextstep.ladder.domain;

public class Player {

    public static final int LENGTH_LIMIT = 5;

    private String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        validateName(name);
        return new Player(name);
    }

    private static void validateName(String name) {
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 허용합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

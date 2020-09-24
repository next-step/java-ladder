package nextstep.ladder.domain;

public class Player {

    public static final int LENGTH_LIMIT = 5;

    private String name;
    private Lane lane;

    private Player(String name, Lane lane) {
        this.name = name;
        this.lane = lane;
    }

    public static Player of(String name, Lane lane) {
        validateName(name);
        return new Player(name, lane);
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

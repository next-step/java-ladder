package nextstep.ladder.domain;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package nextstep.ladder.domain.player;

public class Player {
    private final String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[" + name + "] 참가자의 이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}

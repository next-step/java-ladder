package ladder.domain;

import java.util.List;

public class Player {
    private static final int MAX_NAME = 5;
    private final List<String> name;

    public Player(List<String> playerName) {
        if (playerName.stream().anyMatch(name -> name.length() > MAX_NAME)) {
            throw new IllegalArgumentException("이름의 길이는 최대 5자입니다");
        }
        this.name = playerName;
    }

    public List<String> name() {
        return name;
    }

    public int count() {
        return name.size();
    }
}

package ladder.domain;

import java.util.List;

public class Players {
    private static final int MAX_NAME = 5;

    private final List<String> names;

    public Players(List<String> playerName) {
        if (playerName.stream().anyMatch(name -> name.length() > MAX_NAME)) {
            throw new IllegalArgumentException("이름의 길이는 최대 5자입니다");
        }
        this.names = playerName;
    }

    public List<String> names() {
        return names;
    }

    public int count() {
        return names.size();
    }
}

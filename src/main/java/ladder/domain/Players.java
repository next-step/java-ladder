package ladder.domain;

import java.util.List;

public class Players {
    private static final int MAX_NAME = 5;

    private final List<String> names;

    public Players(List<String> names) {
        verifyNames(names);
        this.names = names;
    }

    public List<String> names() {
        return names;
    }

    public int count() {
        return names.size();
    }

    private void verifyNames(List<String> playerName) {
        if (isOverLength(playerName)) {
            throw new IllegalArgumentException("이름의 길이는 최대 5자입니다");
        }
    }

    private boolean isOverLength(List<String> playerName) {
        return playerName.stream()
                .anyMatch(name -> name.length() > MAX_NAME);
    }

    public String name(int index) {
        return names().get(index);
    }
}

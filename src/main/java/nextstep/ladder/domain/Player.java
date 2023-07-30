package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player {

    private static final int NAME_MAX_LENGTH = 5;
    private static final Map<String, Player> playersMap = new HashMap<>();
    private final String name;

    public static Player of(String name) {
        Player player = playersMap.get(name);

        if (player == null) {
            playersMap.put(name, new Player(name));

            player = playersMap.get(name);
        }

        return player;
    }

    private Player(String name) {
        nullCheck(name);

        name = name.trim();

        lengthCheck(name);

        this.name = name;
    }

    private void nullCheck(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름을 입력해 주세요.");
        }
    }

    private void lengthCheck(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("참여자 이름은 1~5자로 설정 하세요.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

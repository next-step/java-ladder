package ladderstep4.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    public static final String CANNOT_FIND_PLAYER_MESSAGE = "해당 플레이어를 찾을 수 없습니다.";

    private static final String DELIMITER = ",";

    private final List<Player> values;

    public Players(String names) {
        this(Arrays.stream(names.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        this.values = players;
    }

    public Position findPositionOf(Player source) {
        return new Position(IntStream.range(0, values.size())
                .filter(index -> values.get(index).equals(source))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CANNOT_FIND_PLAYER_MESSAGE)));
    }
}

package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private final String name;

    public Player(String name) {
        this.name= name;
    }

    public static List<Player> parse(String line) {
        return Arrays.stream(line.split("\\s*,\\s*"))
                .map(Player::new)
                .collect(Collectors.toList());
    }
}

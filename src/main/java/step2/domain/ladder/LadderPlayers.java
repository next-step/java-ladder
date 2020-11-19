package step2.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderPlayers {
    public static final String WHITE_SPACE = " ";
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final List<Player> players;

    public LadderPlayers(List<Player> players) {
        this.players = players;
    }

    public static LadderPlayers of(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(collectingAndThen(Collectors.toList(), LadderPlayers::new));
    }

    public int count() {
        return players.size();
    }

    public String toString() {
        return players.stream()
                .map(Player::getName)
                .map(this::pad)
                .collect(Collectors.joining(WHITE_SPACE));
    }

    private String pad(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        IntStream.range(input.length(), MAXIMUM_NAME_LENGTH)
                .forEach(index -> inputBuilder.append(WHITE_SPACE));

        return inputBuilder.toString();
    }
}

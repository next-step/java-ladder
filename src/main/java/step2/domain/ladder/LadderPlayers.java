package step2.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderPlayers {
    public static final String WHITE_SPACE = " ";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final List<Player> players;

    public LadderPlayers(List<String> names) {
        players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

    public String toString() {
        return players.stream()
                .map(player-> pad(player.getName()))
                .collect(Collectors.joining(WHITE_SPACE));
    }

    private String pad(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        IntStream.range(input.length(), MAXIMUM_NAME_LENGTH)
                .forEach(index->inputBuilder.append(WHITE_SPACE));

        return inputBuilder.toString();
    }
}

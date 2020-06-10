package ladder.domain.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String input) {
        validate(input);
        return new Players(Arrays.stream(getNamesFrom(input))
                .map(Player::of)
                .collect(Collectors.toList()));
    }

    private static void validate(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("There is no input. Please check your input.");
        }
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] getNamesFrom(String input) {
        return input.trim().replaceAll(" ", "").split(",");
    }

    public Player get(int index) {
        return players.get(index);
    }

    public int getCountOfPerson() {
        return players.size();
    }

    public Stream<Player> stream() {
        return players.stream();
    }
}

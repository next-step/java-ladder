package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final String PRINT_SPACE = "  ";
    public static final int INITIAL_POSITION = 0;

    private final List<Player> players;

    public static Players from(String... players) {
        return fromStringList(Arrays.stream(players).collect(Collectors.toList()));
    }

    public static Players from(List<Player> players) {
        return new Players(players);
    }
    public static Players fromStringList(List<String> players) {
        List<Player> playerList = new ArrayList<>();
        for (int i = INITIAL_POSITION; i < players.size(); i++) {
            playerList.add(Player.of(players.get(i), i));
        }
        return new Players(playerList);
    }

    private Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining(PRINT_SPACE));
    }

    public LadderResult play(List<Line> lines, List<String> results) {
        return new LadderResult(players.stream()
                .collect(Collectors.toMap(
                        (player) -> player,
                        (player) -> results.get(player.getPlayedLastPosition(lines))
                ))
        );
    }
}

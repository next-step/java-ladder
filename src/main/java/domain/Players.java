package domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Players {
    public static final String PLAYER_NAME_SPACE = "  ";
    private final List<Player> players;

    public static Players from(String... players) {
        AtomicInteger position = new AtomicInteger();
        List<Player> playerList = Arrays.stream(players)
                .map(player -> Player.of(player, position.getAndIncrement()))
                .collect(Collectors.toList());
        return new Players(playerList);
    }

    public static Players from(List<Player> players) {
        return new Players(players);
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
                .collect(Collectors.joining(PLAYER_NAME_SPACE));
    }

    public int play(List<Line> lines) {

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int lastPoint = i;
            for (Line line : lines) {
                PointDirection pointDirection = line.checkPointDirection(i);
                lastPoint += pointDirection.operate(i);
            }
        }

        return 0;
    }
}

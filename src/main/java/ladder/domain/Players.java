package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;
    private final Map<String, Player> playersByName;

    public Players(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Players list cannot be null or empty");
        }

        this.players = players;
        this.playersByName = players.stream()
                .collect(Collectors.toMap(Player::name, player -> player));
    }

    public int count() {
        return players.size();
    }

    public Player getPlayerAtIndex(int i) {
        return players.get(i);
    }

    public Players traverse(Ladder ladder) {
        validateLadder(ladder);

        List<Player> traversedPlayers = players.stream()
                .map(player -> createTraversedPlayer(player, ladder))
                .collect(Collectors.toList());

        return new Players(traversedPlayers);
    }

    public static Players createWithNames(List<String> playerStrings) {
        List<Player> players = IntStream.range(0, playerStrings.size())
                .mapToObj(i -> initializePlayer(playerStrings.get(i), i))
                .collect(Collectors.toList());

        return new Players(players);
    }

    public Player findPlayer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }

        if (!playersByName.containsKey(name)) {
            throw new IllegalArgumentException("Player not found");
        }

        return playersByName.get(name);
    }

    private void validateLadder(Ladder ladder) {
        if (ladder == null) {
            throw new IllegalArgumentException("Ladder cannot be null");
        }
        if (ladder.width() != players.size()) {
            throw new IllegalArgumentException("Ladder width must match the number of players");
        }
    }

    private Player createTraversedPlayer(Player player, Ladder ladder) {
        Position traversedPosition = ladder.traverse(player.getPosition());
        return new Player(player.name(), traversedPosition);
    }

    private static Player initializePlayer(String name, int i) {
        Position position = new Position(i);
        return new Player(name, position);
    }
}

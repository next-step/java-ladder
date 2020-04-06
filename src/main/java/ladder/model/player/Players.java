package ladder.model.player;

import ladder.model.row.Position;
import ladder.model.row.Rows;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.Messages.WARNING_NOT_ALLOWED_DUPLICATION_NAME;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        validateDuplicationName(players);
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map<PlayerName, Position> findFinalLocationByName(Rows rows, String name) {
        Map<PlayerName, Position> finalLocation = new HashMap<>();

        if (isValidPlayerName(name)) {
            players.stream()
                    .filter(it -> name.equals(it.getName().getName()))
                    .forEach(it -> finalLocation.put(it.getName(), it.findFinalLocation(rows)));
            return finalLocation;

        }
        return findAllFinalLocations(rows);
    }

    private Map<PlayerName, Position> findAllFinalLocations(Rows rows) {
        Map<PlayerName, Position> finalLocation = new HashMap<>();
        players.stream()
                .forEach(it -> finalLocation.put(it.getName(), it.findFinalLocation(rows)));
        return finalLocation;
    }

    private void validateDuplicationName(List<Player> players) {
        if (hasDuplicationName(players)) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_DUPLICATION_NAME);
        }
    }

    private boolean hasDuplicationName(List<Player> players) {
        return players.stream()
                .map(it -> it.getName())
                .filter(it -> Collections.frequency(findNames(players), it) > 1)
                .findAny()
                .isPresent();
    }

    private List<PlayerName> findNames(List<Player> players) {
        return players.stream()
                .map(it -> it.getName())
                .collect(Collectors.toList());
    }

    private boolean isValidPlayerName(String name) {
        return players.stream()
                .map(it -> it.getName())
                .map(it -> it.getName())
                .filter(it -> name.equals(it))
                .findAny()
                .isPresent();
    }
}
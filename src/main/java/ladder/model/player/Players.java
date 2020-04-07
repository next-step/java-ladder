package ladder.model.player;

import ladder.model.result.PositionResult;
import ladder.model.row.Rows;

import java.util.*;

import static java.util.stream.Collectors.toList;
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

    public PositionResult findFinalLocationByName(Rows rows, String name) {
        Optional<Player> optionalPlayer = players.stream()
                .filter(player -> name.equals(player.getName().getName()))
                .findFirst();

        if (optionalPlayer.isPresent()) {
            Map<PlayerName, Position> finalLocation = new HashMap<>();
            optionalPlayer.map(player -> finalLocation.put(player.getName(), player.findFinalLocation(rows)));
            return new PositionResult(finalLocation);
        }

        return new PositionResult(findAllFinalLocations(rows));
    }

    private Map<PlayerName, Position> findAllFinalLocations(Rows rows) {
        Map<PlayerName, Position> finalLocation = new HashMap<>();
        players.stream()
                .forEach(player -> finalLocation.put(player.getName(), player.findFinalLocation(rows)));
        return finalLocation;
    }

    private void validateDuplicationName(List<Player> players) {
        if (hasDuplicationName(players)) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_DUPLICATION_NAME);
        }
    }

    private boolean hasDuplicationName(List<Player> players) {
        return players.stream()
                .map(player -> player.getName())
                .filter(playerName -> Collections.frequency(findNames(players), playerName) > 1)
                .findAny()
                .isPresent();
    }

    private List<PlayerName> findNames(List<Player> players) {
        return players.stream()
                .map(player -> player.getName())
                .collect(toList());
    }
}
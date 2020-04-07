package ladder.model.player;

import ladder.model.result.PositionResult;
import ladder.model.row.Row;
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

    public Players findFinalLocationByName(Rows rows, String name) {
        moveAllPlayers(rows);

        List<Player> collect = players.stream()
                .filter(player -> name.equals(player.getName().getName()))
                .collect(toList());

        if (collect.isEmpty()) {
            return Players.create(players);
        }

        return Players.create(collect);
    }

    private void moveAllPlayers(Rows rows){
        players.stream()
                .forEach(player -> player.findFinalLocation(rows));
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
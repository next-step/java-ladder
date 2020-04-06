package ladder.model.player;

import ladder.model.row.Rows;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
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

    public Map<String, Integer> findFinalLocationByName(Rows rows, String name) {
        Map<String, Integer> finalLocation = new HashMap<>();

        if(isValidPlayerName(name)){
            players.stream()
                    .filter(it -> name.equals(it.getName()))
                    .forEach(it -> finalLocation.put(name, it.findFinalLocation(rows)));
            return finalLocation;

        }
        players.stream()
                .forEach(it -> finalLocation.put(it.getName(), it.findFinalLocation(rows)));
        return finalLocation;
    }

    private boolean isValidPlayerName(String name){
        return players.stream()
                .filter(it -> name.equals(it.getName()))
                .findAny()
                .isPresent();
    }
}

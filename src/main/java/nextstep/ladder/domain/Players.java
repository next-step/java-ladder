package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> playerNames) {
        this.players = generatePlayers(playerNames);
    }

    private List<Player> generatePlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0 ; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }
        return Collections.unmodifiableList(players);
    }

    public Player findPlayer(String playerName) {
        return this.players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not found player"));
    }

    public List<String> findAllPlayerNames() {
        return this.players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());
    }
}

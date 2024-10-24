package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String names) {
        this(initializePlayers(names));
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    private static List<Player> initializePlayers(String inputNames) {
        String[] names = inputNames.split(",");
        return Arrays.stream(names)
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        return getPlayerNames().toString()
                .equals(((Players)obj).getPlayerNames().toString());
    }

    public int size() {
        return players.size();
    }

}

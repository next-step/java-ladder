package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players of(List<String> namesOfPeople) {
        return new Players(generatePlayerList(namesOfPeople));
    }

    private static List<Player> generatePlayerList(List<String> namesOfPeople) {
        return namesOfPeople.stream()
                .map(Player::of)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public String getPlayerName(int index) {
        return players.get(index).getPlayerName();
    }

    public int size() {
        return players.size();
    }
}

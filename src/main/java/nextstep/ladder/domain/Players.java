package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Person> players;

    public Players(List<Person> players) {
        this.players = players;
    }

    private static List<Person> createPlayers(String players) {
        return Arrays.stream(players.split(","))
            .map(String::trim)
            .map(Person::new)
            .collect(Collectors.toList());
    }

    public List<Person> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int size() {
        return players.size();
    }

    public static Players of(String players) {
        return new Players(createPlayers(players));
    }

    public int findPlayerIndex(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name().equals(name)) {
                return i;
            }
        }
        return -1;
    }

}

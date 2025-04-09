package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Person> players;

    public Players(List<Person> players) {
        this.players = players;
    }

    private static List<Person> createPlayers(String players) {
        String[] names = players.split(",");
        return IntStream.range(0, names.length)
            .mapToObj(i -> new Person(names[i].trim(), i))
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

    public Optional<Person> findPlayerByName(String name) {
        return players.stream()
            .filter(person -> person.matchByName(name)) // person에게 물어보는 구조
            .findFirst();
    }
}

package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Players {

    public static final int MIN_PERSON_SIZE = 2;
    private final Map<String, Player> players;

    private Players(Map<String, Player> players) {
        this.players = players;
    }

    public static Players from(List<Person> persons) {
        if (persons.size() < MIN_PERSON_SIZE) {
            throw new IllegalArgumentException("참가자는 최소 두명 이상이여야 합니다.");
        }

        Map<String, Player> players = new HashMap<>();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            players.put(person.name(), Player.of(person, Position.from(i)));
        }

        return new Players(players);
    }

    public Player findIndexByName(String name) {
        if (players.containsKey(name)) {
            return players.get(name);
        }

        throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
    }

    public int size() {
        return players.size();
    }

    public void forEach(Consumer<String> action) {
        players.keySet().forEach(action);
    }


}

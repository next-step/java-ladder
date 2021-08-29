package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Position;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Players {

    public static final int MIN_PLAYER_SIZE = 2;
    private final Map<String, Player> players;

    private Players(Map<String, Player> players) {
        this.players = players;
    }

    public static Players from(List<Name> names) {
        if (names.size() < MIN_PLAYER_SIZE) {
            throw new IllegalArgumentException("참가자는 최소 두명 이상이여야 합니다.");
        }

        Map<String, Player> players = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(i);
            players.put(name.name(), Player.of(name, Position.from(i)));
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

    public void values(Consumer<Player> action) {
        players.values().forEach(action);
    }

    public void foreach(Consumer<String> action) {
        players.keySet().forEach(action);
    }
}

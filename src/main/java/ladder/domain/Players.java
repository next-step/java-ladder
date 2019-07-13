package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players register(String nameOfPlayers) {
        int initPosition = 0;

        List<Player> players = new ArrayList<>();
        for (String player : nameOfPlayers.split(",")) {
            players.add(new Player(player.trim(), new Position(initPosition++)));
        }
        return new Players(players);
    }

    public int size() {
        return players.size();
    }

    public int lengthOfLongestName() {
        return players.stream()
                .map(player -> player.lengthOfName())
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("가장 긴 플레이어의 이름을 가져오는데 실패하였습니다."));
    }

    public Position getPosition(Player player) {
        return new Position(players.indexOf(player));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Stream<Player> getStream() {
        return players.stream();
    }
}

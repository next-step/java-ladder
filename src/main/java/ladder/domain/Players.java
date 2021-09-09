package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private static final int MIN_COUNT = 2;

    private final List<Player> players;

    public Players(final String[] players) {
        this(toPlayers(players));
    }

    private static List<Player> toPlayers(final String[] players) {
        return Stream.of(players)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private Players(final List<Player> players) {
        validateSize(players);
        this.players = players;
    }

    private void validateSize(final List<Player> players) {
        if (players.size() < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + " 명 이상입니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player find(final Position position) {
        if (position.getValue() >= players.size()) {
            throw new IllegalArgumentException("Position 값이 플레이어 수보다 큽니다.");
        }
        return players.get(position.getValue());
    }

    public Player find(final Name name) {
        return players.stream()
                .filter(player -> player.isSame(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으려는 플레이어가 없습니다. 이름을 확인해주세요."));
    }
}
